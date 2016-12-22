/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.signer.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * The core of this module. It contains all operations related to security
 * (keystores creation, signing process, etc.)
 *
 * @author elcocolio
 */
public final class SecurityManager {

  // It can't be instantiated.
  private SecurityManager() {
  }

  /**
   * Validates a NB module directory.
   *
   * @param modulePath Selected path which the module is contained.
   * @return true if the module path contains a NB module.
   */
  public static boolean isNetbeansModule(String modulePath) {
    boolean isModule = false;
    Keystore.getDefault().setPathToModule(modulePath);
    String moduleDir = Keystore.getDefault().getPathToModule();
    File modulePrivateDir = new File(moduleDir + "nbproject/private/");
    if (modulePrivateDir.exists()) {
      File manifestFile = new File(moduleDir + "manifest.mf");
      if (manifestFile.exists()) {
        BufferedReader reader = null;
        try {
          String line;
          boolean validManifest = false;
          reader = new BufferedReader(new FileReader(manifestFile));
          while ((line = reader.readLine()) != null) {
            if (line.startsWith("OpenIDE-Module")) {
              validManifest = true;
              break;
            }
          }
          if (validManifest) {
            String platPrivateFileName = moduleDir + "nbproject/private/platform-private.properties";
            File platPrivateFile = new File(platPrivateFileName);
            if (platPrivateFile.exists()) {
              String genFilesPropertiesName = moduleDir
                      + "nbproject/genfiles.properties";
              File genFilesPropertiesFile = new File(genFilesPropertiesName);
              if (genFilesPropertiesFile.exists()) {

                String projectPropertiesName = moduleDir
                        + "nbproject/project.properties";
                File projectPropertiesFile = new File(projectPropertiesName);
                if (projectPropertiesFile.exists()) {

                  String projectXmlName = moduleDir + "nbproject/project.xml";
                  File projectXmlFile = new File(projectXmlName);
                  isModule = projectXmlFile.exists();
                }
              }
            }
          }
        } catch (Exception e) {
        } finally {
          if (reader != null) {
            try {
              reader.close();
            } catch (Exception e) {
            }
          }
        }
      }
    }
    if (!isModule) {
      Keystore.getDefault().setPathToModule(null);
    }
    return isModule;
  }

  /**
   * Creates a keystore by using
   * <a href="http://docs.oracle.com/javase/8/docs/technotes/tools/unix/keytool.html">
   * jdk's "keytool" command.</a>
   *
   * <pre>
   * keytool -genkey -storepass mypassword -alias myself -keystore /path/to/keystore/&lt;keystore-name&gt;
   * ¿Cuáles son su nombre y su apellido?
   * [Unknown]:  ELCOCOLIO
   * ¿Cuál es el nombre de su unidad de organización?
   * [Unknown]:  ELCOCOLIO
   * ¿Cuál es el nombre de su organización?
   * [Unknown]:  ELCOCOLIO
   * ¿Cuál es el nombre de su ciudad o localidad?
   * [Unknown]:  NA
   * ¿Cuál es el nombre de su estado o provincia?
   * [Unknown]:  NA
   * ¿Cuál es el código de país de dos letras de la unidad?
   * [Unknown]:  NA
   * ¿Es correcto CN=ELCOCOLIO, OU=ELCOCOLIO, O=ELCOCOLIO, L=NA, ST=NA, C=NA?
   * [no]:  si
   * Introduzca la contraseña de clave para &lt;myself&gt;
   * (INTRO si es la misma contraseña que la del almacén de claves):
   * </pre>
   *
   * @param data Keystore data.
   * @throws NBSignerOperationException If an error occurs.
   */
  public static void createKeystore(Keystore data) throws NBSignerOperationException {
    int exitVal;
    String line;
    try {
      BufferedReader input = null;
      int validity = data.getValidity();
      String keytool = System.getProperty("java.home")
              + System.getProperty("file.separator") + "bin"
              + System.getProperty("file.separator") + "keytool";
      String[] keytoolCommand = validity > 0
              ? new String[]{keytool, "-genkey",
                "-dname", data.getDistinguishedName().toString(),
                "-alias", data.getAlias(),
                "-keypass", data.getPassword(),
                "-keystore", data.getPathToModule() + "nbproject/private/" + data.getName(),
                "-storepass", data.getPassword(),
                "-validity", Integer.toString(validity)}
              : new String[]{keytool, "-genkey",
                "-dname", data.getDistinguishedName().toString(),
                "-alias", data.getAlias(),
                "-keypass", data.getPassword(),
                "-keystore", data.getPathToModule() + "nbproject/private/" + data.getName(),
                "-storepass", data.getPassword()
              };
      try {
        final Process pr = Runtime.getRuntime().exec(keytoolCommand);
        input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        while ((line = input.readLine()) != null) {
          System.out.println(line);
        }
        try {
          exitVal = pr.waitFor();
          System.out.println("Exited with code " + exitVal);
        } catch (InterruptedException e) {
          throw new IOException(e.getMessage());
        }
      } finally {
        if (input != null) {
          try {
            input.close();
          } catch (Exception e) {
          }
        }
      }
    } catch (Exception e) {
      throw new NBSignerOperationException(e);
    }
  }

  /**
   * Signs the module.
   *
   * @param moduleDirectory Root directory.
   * @param keystoreName Name of the keystore file.
   * @param alias Keystore alias
   * @param password Keystore password.
   * @throws NBSignerOperationException if an error occurs.
   */
  public static void signModule(
          String moduleDirectory, String keystoreName, String alias, String password)
          throws NBSignerOperationException {
    BufferedReader reader = null;
    BufferedWriter writer = null;

    String moduleDir = moduleDirectory.replace(File.separator, "/")
            + (moduleDirectory.endsWith("/") ? "" : "/");
    if (isNetbeansModule(moduleDir)) {
      // Writing "storepass" property in nbproject/private/platform-private.properties file...
      String platformPrivatePropertiesFileName = moduleDir
              + "nbproject/private/platform-private.properties";
      Properties platformPrivateProperties = new Properties();
      try {
        reader = new BufferedReader(new FileReader(platformPrivatePropertiesFileName));
        platformPrivateProperties.load(reader);
        try {
          reader.close();
          reader = null;
        } catch (Exception e) {
          // Leave silently...
        }
        platformPrivateProperties.setProperty("storepass", password);
        writer = new BufferedWriter(new FileWriter(platformPrivatePropertiesFileName));
        platformPrivateProperties.store(writer, "");
      } catch (Exception e) {
        throw new NBSignerOperationException(e);
      } finally {
        if (reader != null) {
          try {
            reader.close();
          } catch (Exception e) {
            // Leave silently...
          }
        }
        if (writer != null) {
          try {
            writer.flush();
            writer.close();
          } catch (Exception e) {
            // Leave silently...
          }
        }
      }

      // Writing "keystore" and "nbm_alias" in "project.properties" file.
      String nbprojectPropertiesFileName = moduleDir + "nbproject/project.properties";
      Properties nbprojectProperties = new Properties();
      try {
        reader = new BufferedReader(new FileReader(nbprojectPropertiesFileName));
        nbprojectProperties.load(reader);
        try {
          reader.close();
          reader = null;
        } catch (Exception e) {
        }
        nbprojectProperties.setProperty("keystore", "nbproject/private/" + keystoreName);
        nbprojectProperties.setProperty("nbm_alias", alias);
        writer = new BufferedWriter(new FileWriter(nbprojectPropertiesFileName));
        nbprojectProperties.store(writer, "");
      } catch (Exception e) {
        throw new NBSignerOperationException(e);
      } finally {
        if (reader != null) {
          try {
            reader.close();
          } catch (Exception e) {
            // Leave silently...
          }
        }
        if (writer != null) {
          try {
            writer.flush();
            writer.close();
          } catch (Exception e) {
            // Leave silently...
          }
        }
      }
    }
  }
}

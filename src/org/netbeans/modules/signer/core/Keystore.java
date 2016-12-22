/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.signer.core;

import java.io.File;

/**
 * It contains all needed data to generate a keystore by invoking jdk's
 * "keytool" programmatically (createKeystore(Keystore) method do that).
 *
 * @author elcocolio
 */
public final class Keystore {

  public static class DistinguishedName {

    private DistinguishedName() {
    }

    /*
     keytool -genkey -storepass <password> -alias <alias> -keystore <pathToModule>/nbproject/private/<keystore-name>
     ¿Cuáles son su nombre y su apellido?
     [Unknown]:  <fullName>
     ¿Cuál es el nombre de su unidad de organización?
     [Unknown]:  <organizationUnit>
     ¿Cuál es el nombre de su organización?
     [Unknown]:  <organization>
     ¿Cuál es el nombre de su ciudad o localidad?
     [Unknown]:  <location>
     ¿Cuál es el nombre de su estado o provincia?
     [Unknown]:  <state>
     ¿Cuál es el código de país de dos letras de la unidad?
     [Unknown]:  <countryCode>
     ¿Es correcto CN=<fullName>, OU=<organizationUnit>, O=<organization>, L=<location>, ST=<state>, C=<countryCode>?
     [no]:  si

     Introduzca la contraseña de clave para <myself>
     (INTRO si es la misma contraseña que la del almacén de claves):
     */
    //////////////////////////////////////////////////////////////////////////////
    // -dname <CN=fullName, OU=organizationUnit, O=organization, L=location, ST=state, C=countryCode>
    //////////////////////////////////////////////////////////////////////////////
    private String fullName;
    private String organizationUnit;
    private String organization;
    private String location;
    private String state;
    private String countryCode;
    //////////////////////////////////////////////////////////////////////////////
    
    public void copy(DistinguishedName dn) {
      this.fullName = dn.fullName;
      this.organizationUnit = dn.organizationUnit;
      this.organization = dn.organization;
      this.location = dn.location;
      this.state = dn.state;
      this.countryCode = dn.countryCode;
    }

    /**
     * Set the value of countryCode
     *
     * @param countryCode new value of countryCode
     */
    public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(String state) {
      this.state = state;
    }

    /**
     * Set the value of location
     *
     * @param location new value of location
     */
    public void setLocation(String location) {
      this.location = location;
    }

    /**
     * Set the value of organization
     *
     * @param organization new value of organization
     */
    public void setOrganization(String organization) {
      this.organization = organization;
    }

    /**
     * Set the value of organizationUnit
     *
     * @param organizationUnit new value of organizationUnit
     */
    public void setOrganizationUnit(String organizationUnit) {
      this.organizationUnit = organizationUnit;
    }

    /**
     * Set the value of fullName
     *
     * @param fullName new value of fullName
     */
    public void setFullName(String fullName) {
      this.fullName = fullName;
    }

    @Override
    public String toString() {
      return "CN=" + (this.fullName != null && !this.fullName.equals("") ? this.fullName : "Unknown") +
              ", OU=" + (this.organizationUnit != null && !this.organizationUnit.equals("") ? this.organizationUnit : "Unknown") +
              ", O=" + (this.organization != null && !this.organization.equals("") ? this.organization : "Unknown") +
              ", L=" + (this.location != null && !this.location.equals("") ? this.location : "Unknown") +
              ", ST=" + (this.state != null && !this.state.equals("") ? this.state : "Unknown") +
              ", C=" + (this.countryCode != null && !this.countryCode.equals("") ? this.countryCode : "Unknown");
    }
  }

  private static Keystore ks;

  // -dname <this.getDistinguishedName()>
  private DistinguishedName dname;

  // Module to sign.
  private String pathToModule;

  // -keypass <password> -storepass <password> // Same for both parameters.
  private String password;

  // -alias <alias>
  private String alias;

  // -keystore <pathToModule + name>
  private String name;

  // -validity <number-of-days>
  private int validity;

  // It can't be instantiated.
  private Keystore() {
    dname = new DistinguishedName();
  }

  public static Keystore getDefault() {
    if (ks == null) {
      ks = new Keystore();
    }
    return ks;
  }

  public static void setDefault(Keystore newDefault) {
    ks = newDefault;
  }

  public static Keystore createKeystore() {
    return new Keystore();
  }

  /**
   * Get the 
   *
   * @return the value of distinguishedName
   */
  public DistinguishedName getDistinguishedName() {
    return this.dname;
  }

  /**
   * Get the value of validity (number of days the keystore is valid)
   *
   * @return the value of validity
   */
  public int getValidity() {
    return validity;
  }

  /**
   * Set the value of validity
   *
   * @param validity new value of validity
   */
  public void setValidity(int validity) {
    this.validity = validity;
  }

  /**
   * Get the value of name
   *
   * @return the value of name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the value of name
   *
   * @param name new value of name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the value of pathToModule
   *
   * @return the value of pathToModule
   */
  public String getPathToModule() {
    return pathToModule;
  }

  /**
   * Set the value of pathToModule
   *
   * @param pathToModule new value of pathToModule
   */
  public void setPathToModule(String pathToModule) {
    this.pathToModule = pathToModule != null ? pathToModule.replace(File.separator, "/")
            + (pathToModule.endsWith("/") ? "" : "/") : null;
  }

  /**
   * Get the value of password
   *
   * @return the value of password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the value of password
   *
   * @param password new value of password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get the value of alias
   *
   * @return the value of alias
   */
  public String getAlias() {
    return alias;
  }

  /**
   * Set the value of alias
   *
   * @param alias new value of alias
   */
  public void setAlias(String alias) {
    this.alias = alias;
  }
}

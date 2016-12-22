/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.signer.gui;

import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.netbeans.modules.signer.core.Keystore;
import org.netbeans.modules.signer.core.SecurityManager;
import org.netbeans.modules.signer.core.NBSignerOperationException;

/**
 * Signer main window.
 *
 * @author elcocolio
 */
public class NBSignerDialog extends javax.swing.JDialog {

  private File keystoreFile;
  private File moduleDirectory;

  /**
   * Creates new form NBSignerDialog
   *
   * @param parent
   */
  public NBSignerDialog(java.awt.Frame parent) {
    super(parent, false);
    initComponents();
    this.setResizable(true);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jFchKeystoreFileAndModuleDirectory = new javax.swing.JFileChooser();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTxtModuleDirectory = new javax.swing.JTextField();
    jBtnModuleDirectory = new javax.swing.JButton();
    jPanel7 = new javax.swing.JPanel();
    jTxtKsName = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jBtnSelectKeystore = new javax.swing.JButton();
    jPanel6 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jTxtKsAlias = new javax.swing.JTextField();
    jPanel2 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    jPwdKsPassword = new javax.swing.JPasswordField();
    jPanel3 = new javax.swing.JPanel();
    jBtnCreateKeystore = new javax.swing.JButton();
    jBtnSignModule = new javax.swing.JButton();

    jFchKeystoreFileAndModuleDirectory.setAcceptAllFileFilterUsed(false);
    jFchKeystoreFileAndModuleDirectory.setApproveButtonText(org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jFchKeystoreFileAndModuleDirectory.approveButtonText")); // NOI18N
    jFchKeystoreFileAndModuleDirectory.setCurrentDirectory(null);
    jFchKeystoreFileAndModuleDirectory.setDialogTitle(org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jFchKeystoreFileAndModuleDirectory.dialogTitle")); // NOI18N
    jFchKeystoreFileAndModuleDirectory.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle(org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.title")); // NOI18N
    getContentPane().setLayout(new java.awt.GridLayout(5, 2, 0, 2));

    jPanel1.setLayout(new java.awt.BorderLayout());

    org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jLabel1.text")); // NOI18N
    jPanel1.add(jLabel1, java.awt.BorderLayout.LINE_START);

    jTxtModuleDirectory.setEditable(false);
    jTxtModuleDirectory.setText(org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jTxtModuleDirectory.text")); // NOI18N
    jPanel1.add(jTxtModuleDirectory, java.awt.BorderLayout.CENTER);

    org.openide.awt.Mnemonics.setLocalizedText(jBtnModuleDirectory, org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jBtnModuleDirectory.text")); // NOI18N
    jBtnModuleDirectory.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBtnModuleDirectoryActionPerformed(evt);
      }
    });
    jPanel1.add(jBtnModuleDirectory, java.awt.BorderLayout.LINE_END);

    getContentPane().add(jPanel1);

    jPanel7.setLayout(new java.awt.BorderLayout());

    jTxtKsName.setEditable(false);
    jTxtKsName.setText(org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jTxtKsName.text")); // NOI18N
    jPanel7.add(jTxtKsName, java.awt.BorderLayout.CENTER);

    org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jLabel4.text")); // NOI18N
    jLabel4.setPreferredSize(new java.awt.Dimension(124, 14));
    jLabel4.setRequestFocusEnabled(false);
    jPanel7.add(jLabel4, java.awt.BorderLayout.LINE_START);

    org.openide.awt.Mnemonics.setLocalizedText(jBtnSelectKeystore, org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jBtnSelectKeystore.text")); // NOI18N
    jBtnSelectKeystore.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBtnSelectKeystoreActionPerformed(evt);
      }
    });
    jPanel7.add(jBtnSelectKeystore, java.awt.BorderLayout.LINE_END);

    getContentPane().add(jPanel7);

    jPanel6.setLayout(new java.awt.BorderLayout());

    org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jLabel2.text")); // NOI18N
    jLabel2.setPreferredSize(new java.awt.Dimension(124, 14));
    jPanel6.add(jLabel2, java.awt.BorderLayout.LINE_START);

    jTxtKsAlias.setText(org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jTxtKsAlias.text")); // NOI18N
    jPanel6.add(jTxtKsAlias, java.awt.BorderLayout.CENTER);

    getContentPane().add(jPanel6);

    jPanel2.setLayout(new java.awt.BorderLayout());

    org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jLabel3.text")); // NOI18N
    jLabel3.setPreferredSize(new java.awt.Dimension(124, 14));
    jPanel2.add(jLabel3, java.awt.BorderLayout.LINE_START);

    jPwdKsPassword.setText(org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jPwdKsPassword.text")); // NOI18N
    jPanel2.add(jPwdKsPassword, java.awt.BorderLayout.CENTER);

    getContentPane().add(jPanel2);

    org.openide.awt.Mnemonics.setLocalizedText(jBtnCreateKeystore, org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jBtnCreateKeystore.text")); // NOI18N
    jBtnCreateKeystore.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBtnCreateKeystoreActionPerformed(evt);
      }
    });
    jPanel3.add(jBtnCreateKeystore);

    org.openide.awt.Mnemonics.setLocalizedText(jBtnSignModule, org.openide.util.NbBundle.getMessage(NBSignerDialog.class, "NBSignerDialog.jBtnSignModule.text")); // NOI18N
    jBtnSignModule.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBtnSignModuleActionPerformed(evt);
      }
    });
    jPanel3.add(jBtnSignModule);

    getContentPane().add(jPanel3);

    setSize(new java.awt.Dimension(414, 200));
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void copyKeystoreInModuleDir(File ksFile) {
    // Copying the selected keystore file into the module directory...
    File ks = new File(
            Keystore.getDefault().getPathToModule()
            + "nbproject/private/" + ksFile.getName());
    if (ks.exists()) {
      this.jTxtKsName.setText(ks.getName());
      this.jTxtKsName.setToolTipText(
              "<html>Selected keystore file: " + ksFile.getAbsolutePath()
              + "<br/>Target directory: " + ks.getParentFile().getAbsolutePath() + "</html>");
    } else {
      FileInputStream fis = null;
      FileOutputStream fos = null;
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try {
        int ch;
        fis = new FileInputStream(ksFile);
        while ((ch = fis.read()) != -1) {
          baos.write(ch);
        }
        fos = new FileOutputStream(ks);
        fos.write(baos.toByteArray());
        if (this.keystoreFile != null && this.keystoreFile.exists()) {
          this.keystoreFile.delete();
        }
        this.keystoreFile = ks;
        this.jTxtKsName.setText(ks.getName());
        this.jTxtKsName.setToolTipText(
                "<html>Selected keystore file: " + ksFile.getAbsolutePath()
                + "<br/>Target directory: " + ks.getParentFile().getAbsolutePath() + "</html>");
      } catch (Exception e) {
        JOptionPane.showMessageDialog(
                null, e.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
      } finally {
        if (fis != null) {
          try {
            fis.close();
          } catch (Exception e) {
          }
        }
        if (fos != null) {
          try {
            fos.flush();
            fos.close();
          } catch (Exception e) {
          }
        }
      }
    }
  }

  private void jBtnModuleDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModuleDirectoryActionPerformed
    this.jFchKeystoreFileAndModuleDirectory.setDialogTitle("Select module directory...");
    this.jFchKeystoreFileAndModuleDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int result = this.jFchKeystoreFileAndModuleDirectory.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      String modulePath = this.jFchKeystoreFileAndModuleDirectory.getSelectedFile().getAbsolutePath();
      if (SecurityManager.isNetbeansModule(modulePath)) {
        this.moduleDirectory = new File(modulePath);
        this.jTxtModuleDirectory.setText(this.moduleDirectory.getName());
        this.jTxtModuleDirectory.setToolTipText("Module directory: " + this.moduleDirectory.getAbsolutePath());
        if (!this.jTxtKsName.getText().equals("")) {
          // Copy a previously selected keystore.
          this.copyKeystoreInModuleDir(this.keystoreFile);
        }
      } else {
        JOptionPane.showMessageDialog(
                null, "\"" + modulePath + "\" does NOT contain a Netbeans module.\n\nValidated files:"
                + "\n${module.dir}/manifest.mf"
                + "\n${module.dir}/nbproject/project.xml"
                + "\n${module.dir}/nbproject/genfiles.properties"
                + "\n${module.dir}/nbproject/project.properties"
                + "\n${module.dir}/nbproject/private/platform-private.properties"
                + "\n\n${module.dir} = \"" + modulePath.replace(File.separator, "/") + "\"",
                "ERROR!", JOptionPane.ERROR_MESSAGE);
      }
    }
  }//GEN-LAST:event_jBtnModuleDirectoryActionPerformed

  private void jBtnSelectKeystoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelectKeystoreActionPerformed
    if (this.jTxtModuleDirectory.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Please select the module directory!",
              "ERROR!", JOptionPane.ERROR_MESSAGE);
    } else {
      this.jFchKeystoreFileAndModuleDirectory.setDialogTitle("Select keystore file...");
      this.jFchKeystoreFileAndModuleDirectory.setFileSelectionMode(JFileChooser.FILES_ONLY);
      int result = this.jFchKeystoreFileAndModuleDirectory.showOpenDialog(this);
      if (result == JFileChooser.APPROVE_OPTION) {
        this.copyKeystoreInModuleDir(this.jFchKeystoreFileAndModuleDirectory.getSelectedFile());
      }
    }
  }//GEN-LAST:event_jBtnSelectKeystoreActionPerformed

  private void jBtnCreateKeystoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCreateKeystoreActionPerformed
    if (Keystore.getDefault().getPathToModule() != null) {
      WindowManager.showKeystoreCreator(this, new WindowClosingEventListener() {
        @Override
        public void handle(WindowEvent e) {
          Keystore ksData = Keystore.getDefault();
          if (ksData.getName() != null) {
            jTxtKsName.setText(ksData.getName());
            jTxtKsAlias.setText(ksData.getAlias());
            jPwdKsPassword.setText(ksData.getPassword());
            if (keystoreFile != null && keystoreFile.exists()) {
              keystoreFile.delete();
            }
            keystoreFile = new File(ksData.getPathToModule()
                    + "nbproject/private/" + ksData.getName());
            jTxtKsName.setToolTipText("Keystore file: " + keystoreFile.getAbsolutePath());
          }
        }
      });
    } else {
      JOptionPane.showMessageDialog(null, "Please select the module directory!",
              "ERROR!", JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_jBtnCreateKeystoreActionPerformed

  private void jBtnSignModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSignModuleActionPerformed
    try {
      String moduleDir = Keystore.getDefault().getPathToModule();
      String keystore = this.jTxtKsName.getText().trim();
      String alias = this.jTxtKsAlias.getText().trim();
      char[] pwd = this.jPwdKsPassword.getPassword();
      String password = pwd != null && pwd.length > 0 ? new String(pwd) : "";
      if (moduleDir == null || keystore.equals("") || alias.equals("") || password.equals("")) {
        throw new NBSignerOperationException("There are missing fields. Please verify.");
      } else {
        SecurityManager.signModule(moduleDir, keystore, alias, password);
        JOptionPane.showMessageDialog(
                null, "Netbeans module has been signed successfully."
                + "\nNow build the module project and watch the magic!",
                "Netbeans Signer", JOptionPane.INFORMATION_MESSAGE);
      }
    } catch (NBSignerOperationException ex) {
      JOptionPane.showMessageDialog(
              null, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_jBtnSignModuleActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(NBSignerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(NBSignerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(NBSignerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(NBSignerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        NBSignerDialog dialog = new NBSignerDialog(new javax.swing.JFrame());
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
          @Override
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jBtnCreateKeystore;
  private javax.swing.JButton jBtnModuleDirectory;
  private javax.swing.JButton jBtnSelectKeystore;
  private javax.swing.JButton jBtnSignModule;
  private javax.swing.JFileChooser jFchKeystoreFileAndModuleDirectory;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPasswordField jPwdKsPassword;
  private javax.swing.JTextField jTxtKsAlias;
  private javax.swing.JTextField jTxtKsName;
  private javax.swing.JTextField jTxtModuleDirectory;
  // End of variables declaration//GEN-END:variables
}

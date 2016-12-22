/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.signer.gui;

import java.awt.Window;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;

/**
 * Window manager.
 *
 * @author elcocolio
 */
final class WindowManager {
  private static KeystoreCreatorDialog keystoreCreatorGui;
  private static DistinguishedNameBuilderDialog distinguishedNameBuilderGui;

  // It can't be instantiated.
  private WindowManager() {
  }

  /**
   * Displays keystore creator dialog.
   *
   * @param parent parent dialog.
   * @param listener a window listener which implements "windowClosing" event to
   * handle the output of the dialog.
   */
  public static void showKeystoreCreator(
          JDialog parent, WindowClosingEventListener listener) {
    if (keystoreCreatorGui == null) {
      keystoreCreatorGui = new KeystoreCreatorDialog(parent);
      keystoreCreatorGui.addWindowListener(listener);
    }
    keystoreCreatorGui.setVisible(true);
  }

  /**
   * Displays Distinguished Name builder dialog.
   *
   * @param parent parent dialog.
   * @param listener a window listener which implements "windowClosing" event to
   * handle the output of the dialog.
   */
  public static void showDistinguishedNameBuilder(
          JDialog parent, WindowClosingEventListener listener) {
    if (distinguishedNameBuilderGui == null) {
      distinguishedNameBuilderGui = new DistinguishedNameBuilderDialog(parent);
      distinguishedNameBuilderGui.addWindowListener(listener);
    }
    distinguishedNameBuilderGui.setVisible(true);
  }

  /**
   * Closes a window.
   *
   * @param w the window to close.
   */
  public static void closeWindow(Window w) {
    w.dispatchEvent(new WindowEvent(w, WindowEvent.WINDOW_CLOSING));
    w.dispose();
  }
}

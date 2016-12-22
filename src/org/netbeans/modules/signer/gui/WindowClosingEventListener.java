/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.signer.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Class specifically designed to handle "WINDOW_CLOSING" event.
 * All other events are unsupported.
 *
 * @author elcocolio.
 */
abstract class WindowClosingEventListener implements WindowListener {

  @Override
  public final void windowClosing(WindowEvent e) {
    this.handle(e);
  }

  abstract void handle(WindowEvent e);

  @Override
  public final void windowOpened(WindowEvent e) {
    /*
     throw new UnsupportedOperationException(
     "This listener class only handles \"WINDOW_CLOSING\" event. " +
     "This exception is not thrown because the AWT Event Queue invokes this " +
     "method to handle this event (this class is a window listener after all...) " +
     "However, it's defined as a comment to emphasize that this listener " +
     "class is NOT supposed to handle this event.");
     */
  }

  @Override
  public final void windowClosed(WindowEvent e) {
    /*
     throw new UnsupportedOperationException(
     "This listener class only handles \"WINDOW_CLOSING\" event. " +
     "This exception is not thrown because the AWT Event Queue invokes this " +
     "method to handle this event (this class is a window listener after all...) " +
     "However, it's defined as a comment to emphasize that this listener " +
     "class is NOT supposed to handle this event.");
     */
  }

  @Override
  public final void windowIconified(WindowEvent e) {
    /*
     throw new UnsupportedOperationException(
     "This listener class only handles \"WINDOW_CLOSING\" event. " +
     "This exception is not thrown because the AWT Event Queue invokes this " +
     "method to handle this event (this class is a window listener after all...) " +
     "However, it's defined as a comment to emphasize that this listener " +
     "class is NOT supposed to handle this event.");
     */
  }

  @Override
  public final void windowDeiconified(WindowEvent e) {
    /*
     throw new UnsupportedOperationException(
     "This listener class only handles \"WINDOW_CLOSING\" event. " +
     "This exception is not thrown because the AWT Event Queue invokes this " +
     "method to handle this event (this class is a window listener after all...) " +
     "However, it's defined as a comment to emphasize that this listener " +
     "class is NOT supposed to handle this event.");
     */
  }

  @Override
  public final void windowActivated(WindowEvent e) {
    /*
     throw new UnsupportedOperationException(
     "This listener class only handles \"WINDOW_CLOSING\" event. " +
     "This exception is not thrown because the AWT Event Queue invokes this " +
     "method to handle this event (this class is a window listener after all...) " +
     "However, it's defined as a comment to emphasize that this listener " +
     "class is NOT supposed to handle this event.");
     */
  }

  @Override
  public final void windowDeactivated(WindowEvent e) {
    /*
     throw new UnsupportedOperationException(
     "This listener class only handles \"WINDOW_CLOSING\" event. " +
     "This exception is not thrown because the AWT Event Queue invokes this " +
     "method to handle this event (this class is a window listener after all...) " +
     "However, it's defined as a comment to emphasize that this listener " +
     "class is NOT supposed to handle this event.");
     */
  }
}

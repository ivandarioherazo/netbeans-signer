/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.signer.core;

import java.io.IOException;

/**
 * Exception that occured if the signer fails.
 * 
 * @author elcocolio.
 */
public class NBSignerOperationException extends IOException {

  public NBSignerOperationException() {
  }

  public NBSignerOperationException(String s) {
    super(s);
  }

  public NBSignerOperationException(String message, Throwable cause) {
    super(message, cause);
  }

  public NBSignerOperationException(Throwable cause) {
    super(cause);
  }
}

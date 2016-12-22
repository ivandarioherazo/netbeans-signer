/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.signer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.modules.signer.gui.NBSignerDialog;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(category = "Tools", id = "org.netbeans.modules.signer.NetbeansSignerAction")
@ActionRegistration(
        iconBase = "org/netbeans/modules/signer/resources/icon.gif",
        displayName = "#CTL_NetbeansSignerAction"
)
@ActionReferences({
  @ActionReference(path = "Menu/Tools", position = 1450),
  @ActionReference(path = "Shortcuts", name = "DOS-S")
})
@Messages("CTL_NetbeansSignerAction=Sign Module...")
public final class NetbeansSignerAction implements ActionListener {

  private static NBSignerDialog nbSigner;
  
  static {
    nbSigner = new NBSignerDialog(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    nbSigner.setVisible(true);
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ld_si
 */
public class ComboBoxComponent extends javax.swing.JComboBox{
   public BorderColorComponent border;
    
    
    public ComboBoxComponent(DefaultComboBoxModel model) {
       this.border = new BorderColorComponent();
        
        this.setBorder(border.black);
        
        this.setModel(model);
    }
    
}

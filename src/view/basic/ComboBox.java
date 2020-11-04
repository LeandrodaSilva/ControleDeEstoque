/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ld_si
 */
public class ComboBox extends javax.swing.JComboBox{
   public BorderColor border;
    
    
    public ComboBox(DefaultComboBoxModel model) {
       this.border = new BorderColor();
        
        this.setBorder(border.black);
        
        this.setModel(model);
    }
    
}

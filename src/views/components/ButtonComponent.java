/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import java.awt.Color;

/**
 *
 * @author ld_si
 */
public class ButtonComponent extends javax.swing.JButton{
    public BorderColorComponent border;
    
    public ButtonComponent(String tittle) {
        this.setText(tittle);
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        
        this.border = new BorderColorComponent();
        
        this.setBorder(border.black);
        this.setFocusable(false);
    }
}

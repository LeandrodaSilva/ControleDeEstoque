/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import java.awt.Color;

/**
 *
 * @author ld_si
 */
public class Button extends javax.swing.JButton{
    public BorderColor border;
    
    public Button(String tittle) {
        this.setText(tittle);
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        
        this.border = new BorderColor();
        
        this.setBorder(border.black);
        this.setFocusable(false);
    }
}

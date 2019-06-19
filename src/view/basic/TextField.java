/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import javax.swing.border.LineBorder;

/**
 *
 * @author ld_si
 */
public class TextField extends javax.swing.JTextField{
    public  LineBorder borderBlack;
    public  LineBorder borderBlue;
    public  LineBorder borderRed;
    public TextField() {
        this.borderBlack = new javax.swing.border.LineBorder(
                new java.awt.Color(0, 0, 0), 2, true);
        this.borderBlue = new javax.swing.border.LineBorder(
                new java.awt.Color(51, 153, 255), 2, true);
        this.borderRed = new javax.swing.border.LineBorder(
                new java.awt.Color(255, 0, 0), 2, true);
        setBorder(borderBlack);
    }
    
}

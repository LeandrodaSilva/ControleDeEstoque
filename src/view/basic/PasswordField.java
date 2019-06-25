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
public class PasswordField extends javax.swing.JPasswordField{
    public BorderColor border;
    
    public PasswordField() {
        this.border = new BorderColor();
        setBorder(border.black);
    }
}

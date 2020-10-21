/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

/**
 *
 * @author ld_si
 */
public class PasswordFieldComponent extends javax.swing.JPasswordField{
    public BorderColorComponent border;
    
    public PasswordFieldComponent() {
        this.border = new BorderColorComponent();
        setBorder(border.black);
    }

    public PasswordFieldComponent(String admin) {
        this.setText(admin);
        this.border = new BorderColorComponent();
        setBorder(border.black);
    }
}

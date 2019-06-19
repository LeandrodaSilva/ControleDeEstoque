/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.basic.PasswordField;
import view.basic.TextField;

/**
 *
 * @author ld_si
 */
public class ControllerTextPasswordField implements FocusListener{
    private TextField tf;
    private PasswordField pf;
    
    public ControllerTextPasswordField(TextField tf) {
        this.tf = tf;
        
        this.tf.addFocusListener(this);
    }
    
    public ControllerTextPasswordField(PasswordField pf) {
        this.pf = pf;
        
        this.pf.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == this.tf) {
            this.tf.setBorder(this.tf.borderBlue);
        }
        if (e.getSource() == this.pf) {
            this.pf.setBorder(this.pf.borderBlue);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == this.tf) {
            this.tf.setBorder(this.tf.borderBlack);
        }
        if (e.getSource() == this.pf) {
            this.pf.setBorder(this.pf.borderBlack);
        }
    }
    
    
    
    
    
}

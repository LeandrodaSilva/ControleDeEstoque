/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.basic.TextField;

/**
 *
 * @author ld_si
 */
public class ControllerTextField implements FocusListener{
    private TextField tf;
    public ControllerTextField(TextField tf) {
        this.tf = tf;
        
        this.tf.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
       this.tf.setBorder(this.tf.borderBlue);
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.tf.setBorder(this.tf.borderBlack);
    }
    
    
    
    
    
}

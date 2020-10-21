/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import views.components.ButtonComponent;
import views.components.ComboBoxComponent;
import views.components.PasswordFieldComponent;
import views.components.TextFieldComponent;

/**
 *
 * @author ld_si
 */
public class EffectController extends BaseController {

    private ButtonComponent button;
    private TextFieldComponent tf;
    private PasswordFieldComponent pf;
    private ComboBoxComponent comboBox;
    
    /**
     * 
     */
    public EffectController() {
    }
    
    /**
     * 
     * @param textField 
     */
    public EffectController(TextFieldComponent textField) {
        this.tf = textField;
        this.tf.addFocusListener(this);
    }
    
    /**
     * 
     * @param pf 
     */
    public EffectController(PasswordFieldComponent pf) {
        this.pf = pf;
        this.pf.addFocusListener(this);
    }
    
    /**
     * 
     * @param button 
     */
    public EffectController(ButtonComponent button) {
        this.button = button;
        this.button.addMouseListener(this); 
    }
    
    /**
     * 
     * @param comboBox 
     */
    public EffectController(ComboBoxComponent comboBox) {
        this.comboBox = comboBox;
        this.comboBox.addFocusListener(this);
    }
    
    /**
     * 
     * @param button 
     */
    protected void add(ButtonComponent button){
        new EffectController(button);
    }
    
    /**
     * 
     * @param pf 
     */
    protected void add(PasswordFieldComponent pf){
        new EffectController(pf);
    }
    
    /**
     * 
     * @param tf 
     */
    protected void add(TextFieldComponent tf){
        new EffectController(tf);
    }
    
    /**
     * 
     * @param comboBox 
     */
    protected void add(ComboBoxComponent comboBox){
        new EffectController(comboBox);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == this.tf) {
            this.tf.setBorder(this.tf.border.blue);
        }
        if (e.getSource() == this.pf) {
            this.pf.setBorder(this.pf.border.blue);
        }
        if (e.getSource() == this.comboBox) {
            this.comboBox.setBorder(this.comboBox.border.blue);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == this.tf) {
            this.tf.setBorder(this.tf.border.black);
        }
        if (e.getSource() == this.pf) {
            this.pf.setBorder(this.pf.border.black);
        }
        if (e.getSource() == this.comboBox) {
            this.comboBox.setBorder(this.comboBox.border.black);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.button) {
            this.button.setBorder(this.button.border.blue);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.button) {
            this.button.setBorder(this.button.border.black);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.basic.Button;
import view.basic.ComboBox;
import view.basic.PasswordField;
import view.basic.TextField;

/**
 *
 * @author ld_si
 */
public class ControllerEfect implements FocusListener, MouseListener {

    private Button button;
    private TextField tf;
    private PasswordField pf;
    private ComboBox comboBox;

    public ControllerEfect(TextField textField) {
        this.tf = textField;
        this.tf.addFocusListener(this);
    }

    public ControllerEfect(PasswordField pf) {
        this.pf = pf;
        this.pf.addFocusListener(this);
    }

    public ControllerEfect(Button button) {
        this.button = button;
        this.button.addMouseListener(this); 
    }

    public ControllerEfect(ComboBox comboBox) {
        this.comboBox = comboBox;
        this.comboBox.addFocusListener(this);
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
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.basic.Button;

/**
 *
 * @author ld_si
 */
public class ControllerButton implements MouseListener{
    private Button button;
    public ControllerButton(Button button) {
        this.button = button;
        this.button.addMouseListener(this);
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
        this.button.setBorder(this.button.getBorderBlue());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.button.setBorder(this.button.getBorderBlack());
    }
    
}

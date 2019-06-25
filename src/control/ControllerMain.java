/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Main;

/**
 *
 * @author ld_si
 */
public class ControllerMain implements ActionListener{
    private Main main;
    public ControllerMain(Main main) {
        this.main = main;
        
        new ControllerHead(this.main.getHead(),this.main);
        new ControllerEfect(this.main.getjButtonInsert());
        new ControllerEfect(this.main.getjButtonEdit());
        new ControllerEfect(this.main.getjTextFieldSearch());
        new ControllerEfect(this.main.getjComboBoxType());
        
        this.main.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}

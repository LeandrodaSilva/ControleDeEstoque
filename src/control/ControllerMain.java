/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
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
        
        this.main.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

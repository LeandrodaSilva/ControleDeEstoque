/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Login;

/**
 *
 * @author Aluno
 */
public class ControllerLogin implements ActionListener{
    private Login login;
    public ControllerLogin(Login login) {
        this.login = login;
        
        this.login.getbEnter().addActionListener(this);
        this.login.getbRegister().addActionListener(this);
        this.login.getTfUser().addActionListener(this);
        
        new ControllerHead(this.login.getTbHead(), this.login);
        new ControllerButton(this.login.getbEnter());
        new ControllerButton(this.login.getbRegister());
        new ControllerTextField(this.login.getTfUser());
        new ControllerTextField(this.login.getTfPasswd());
        
        this.login.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.getbEnter()) {
            
        }
    }
    
}

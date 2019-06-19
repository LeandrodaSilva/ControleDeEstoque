/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Login;
import view.SettingsUI;

/**
 *
 * @author Aluno
 */
public class ControllerLogin implements ActionListener{
    private final Login login;
    public ControllerLogin(Login login) {
        this.login = login;
        
        this.login.getbEnter().addActionListener(this);
        this.login.getbRegister().addActionListener(this);
        this.login.getTfUser().addActionListener(this);
        this.login.getbConfig().addActionListener(this);
        
        new ControllerHead(this.login.getTbHead(), this.login);
        new ControllerButton(this.login.getbEnter());
        new ControllerButton(this.login.getbRegister());
        new ControllerTextPasswordField(this.login.getTfUser());
        new ControllerTextPasswordField(this.login.getPfPasswd());
        
        this.login.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.getbEnter()) {
            
        }
        if (e.getSource() == this.login.getbConfig()) {
            SettingsUI settingsUI = new SettingsUI();
            new ControllerSettings(settingsUI, /*SettingsDAO.readSettings().getMode()*/0);
            settingsUI.setVisible(true);
        }
    }
    
}

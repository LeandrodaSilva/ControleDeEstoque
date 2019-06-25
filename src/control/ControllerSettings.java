/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.dataAcessObject.SettingsDAO;
import model.valueObject.Settings;
import view.SettingsUI;

/**
 *
 * @author ld_si
 */
public class ControllerSettings implements ActionListener, ChangeListener{
    private SettingsUI settingsUI;
    private JFrame mainframe;

    public ControllerSettings(SettingsUI settingsUI, int mode) {
        this.settingsUI = settingsUI;
        setMode(mode);
        
        this.settingsUI.getJbSave().addActionListener(this);
        this.settingsUI.getJrText().addActionListener(this);
        this.settingsUI.getJrBinary().addActionListener(this);
        this.settingsUI.getJrCloud().addActionListener(this);
        
        new ControllerEfect(this.settingsUI.getJbSave());
        new ControllerHead(this.settingsUI.getHead(), settingsUI,1);
        
        this.settingsUI.getJrText().addChangeListener(this);
        this.settingsUI.getJrBinary().addChangeListener(this);
        this.settingsUI.getJrCloud().addChangeListener(this);
    }
    
    public ControllerSettings(SettingsUI settingsUI, JFrame mainFrame, int mode) {
        this.settingsUI = settingsUI;
        this.mainframe = mainFrame;
        setMode(mode);
        
        this.settingsUI.getJbSave().addActionListener(this);
        this.settingsUI.getJrText().addActionListener(this);
        this.settingsUI.getJrBinary().addActionListener(this);
        this.settingsUI.getJrCloud().addActionListener(this);
        
        new ControllerEfect(this.settingsUI.getJbSave());
        
        new ControllerHead(this.settingsUI.getHead(), this.settingsUI, this.mainframe, 1, false);
        
        this.settingsUI.getJrText().addChangeListener(this);
        this.settingsUI.getJrBinary().addChangeListener(this);
        this.settingsUI.getJrCloud().addChangeListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.settingsUI.getJbSave()) {
            SettingsDAO.writeSettings(new Settings(getMode()));
            this.mainframe.setEnabled(true);
            this.settingsUI.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (getMode() == -1) {
            settingsUI.getJbSave().setEnabled(false);
            settingsUI.getJbSave().setBorder(settingsUI.getJbSave().border.grey);
        }else{
            settingsUI.getJbSave().setEnabled(true);
            settingsUI.getJbSave().setBorder(settingsUI.getJbSave().border.black);
        }
        if (e.getSource() == settingsUI.getJrText()) {
            if (settingsUI.getJrText().isSelected()) {
                settingsUI.getJrText().setIcon(settingsUI.iconBlue);
                settingsUI.getJrBinary().setSelected(false);
                settingsUI.getJrCloud().setSelected(false);
            }else{
                settingsUI.getJrText().setIcon(settingsUI.iconBlack);
            }
        }
        if (e.getSource() == settingsUI.getJrBinary()) {
            if (settingsUI.getJrBinary().isSelected()) {
                settingsUI.getJrBinary().setIcon(settingsUI.iconBlue);
                settingsUI.getJrText().setSelected(false);
                settingsUI.getJrCloud().setSelected(false);
            }else{
                settingsUI.getJrBinary().setIcon(settingsUI.iconBlack);
            }
        }
        if (e.getSource() == settingsUI.getJrCloud()) {
            if (settingsUI.getJrCloud().isSelected()) {
                settingsUI.getJrCloud().setIcon(settingsUI.iconBlue);
                settingsUI.getJrText().setSelected(false);
                settingsUI.getJrBinary().setSelected(false);
            }else{
                settingsUI.getJrCloud().setIcon(settingsUI.iconBlack);
            }
        }

    }
    
    private void setMode(int mode){
        switch(mode){
            case 0:
                this.settingsUI.getJrText().setSelected(true);
                settingsUI.getJrText().setIcon(settingsUI.iconBlue);
                break;
            case 1:
                this.settingsUI.getJrBinary().setSelected(true);
                settingsUI.getJrBinary().setIcon(settingsUI.iconBlue);
                break;
            case 2:
                this.settingsUI.getJrCloud().setSelected(true);
                settingsUI.getJrCloud().setIcon(settingsUI.iconBlue);
                break;
            default: 
        }
    }
    
    private int getMode(){
        int mode = -1;
        if (this.settingsUI.getJrText().isSelected()) {
            mode = 0;
        }
        if (this.settingsUI.getJrBinary().isSelected()) {
            mode = 1;
        }
        if (this.settingsUI.getJrCloud().isSelected()) {
            mode = 2;
        }
        return mode;
    }
    
}

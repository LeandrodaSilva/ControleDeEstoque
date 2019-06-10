/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public ControllerSettings(SettingsUI settingsUI, int mode) {
        this.settingsUI = settingsUI;
        setMode(mode);
        
        this.settingsUI.getJbSave().addActionListener(this);
        this.settingsUI.getJcText().addActionListener(this);
        this.settingsUI.getJcBinary().addActionListener(this);
        this.settingsUI.getJcCloud().addActionListener(this);
        
        this.settingsUI.getJcText().addChangeListener(this);
        this.settingsUI.getJcBinary().addChangeListener(this);
        this.settingsUI.getJcCloud().addChangeListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == settingsUI.getJbSave()) {
            SettingsDAO.writeSettings(new Settings(getMode()));
            settingsUI.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == settingsUI.getJcText()) {
            if (settingsUI.getJcText().isSelected()) {
                settingsUI.getJcBinary().setSelected(false);
                settingsUI.getJcCloud().setSelected(false);
            }
        }
        if (e.getSource() == settingsUI.getJcBinary()) {
            if (settingsUI.getJcBinary().isSelected()) {
                settingsUI.getJcText().setSelected(false);
                settingsUI.getJcCloud().setSelected(false);
            }
        }
        if (e.getSource() == settingsUI.getJcCloud()) {
            if (settingsUI.getJcCloud().isSelected()) {
                settingsUI.getJcText().setSelected(false);
                settingsUI.getJcBinary().setSelected(false);
            }
        }

    }
    
    private void setMode(int mode){
        switch(mode){
            case 0:
                this.settingsUI.getJcText().setSelected(true);
                break;
            case 1:
                this.settingsUI.getJcBinary().setSelected(true);
                break;
            case 2:
                this.settingsUI.getJcCloud().setSelected(true);
                break;
            default: 
        }
    }
    
    private int getMode(){
        int mode = 0;
        if (this.settingsUI.getJcText().isSelected()) {
            mode = 0;
        }
        if (this.settingsUI.getJcBinary().isSelected()) {
            mode = 1;
        }
        if (this.settingsUI.getJcCloud().isSelected()) {
            mode = 2;
        }
        return mode;
    }
    
}

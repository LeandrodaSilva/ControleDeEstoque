/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import models.dataAcessObject.SettingsDAO;
import models.valueObject.SettingsVO;
import views.SettingsView;

/**
 *
 * @author ld_si
 */
public class SettingsController extends EffectController {
    private SettingsView settingsUI;
    private JFrame mainframe;

    public SettingsController(SettingsView settingsUI, int mode) {
        this.settingsUI = settingsUI;
        setMode(mode);
        
        this.settingsUI.getJbSave().addActionListener(this);
        this.settingsUI.getJrText().addActionListener(this);
        this.settingsUI.getJrBinary().addActionListener(this);
        this.settingsUI.getJrCloud().addActionListener(this);
        
        add(settingsUI.getJbSave());
        
        HeadController.add(this.settingsUI.getHead(), settingsUI,1);
        
        this.settingsUI.getJrText().addChangeListener(this);
        this.settingsUI.getJrBinary().addChangeListener(this);
        this.settingsUI.getJrCloud().addChangeListener(this);
    }
    
    public SettingsController(SettingsView settingsUI, JFrame mainFrame, int mode) {
        this.settingsUI = settingsUI;
        this.mainframe = mainFrame;
        setMode(mode);
        
        this.settingsUI.getJbSave().addActionListener(this);
        this.settingsUI.getJrText().addActionListener(this);
        this.settingsUI.getJrBinary().addActionListener(this);
        this.settingsUI.getJrCloud().addActionListener(this);
        
        add(this.settingsUI.getJbSave());
        
        HeadController.add(this.settingsUI.getHead(), this.settingsUI, this.mainframe, 1, false);
        
        this.settingsUI.getJrText().addChangeListener(this);
        this.settingsUI.getJrBinary().addChangeListener(this);
        this.settingsUI.getJrCloud().addChangeListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.settingsUI.getJbSave()) {
            SettingsDAO.writeSettings(new SettingsVO(getMode()));
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

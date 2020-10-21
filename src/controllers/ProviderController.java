/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

import models.dataAcessObject.ProviderDAO;
import models.valueObject.ProviderVO;
import views.ProviderView;

/**
 *
 * @author ld_si
 */
public class ProviderController extends EffectController {
    private ProviderView insertProvider;
    private JFrame root;
    private static ArrayList<ProviderVO> providers;
    public ProviderVO provider;
    public static final int NEW = 0;
    public static final int EDIT = 1;

    public ProviderController(ProviderView insertProvider, JFrame root, HomeController controllerMain, int option) {
        this.insertProvider = insertProvider;
        this.root = root;

        insertProvider.getHead().getbMinimize().setEnabled(false);
        HeadController.add(insertProvider.getHead(), insertProvider, root, 1, true);
        add(insertProvider.getjButtonClear());
        add(insertProvider.getjButtonDelete());
        add(insertProvider.getjButtonSave());
        add(insertProvider.getjTextFieldCnpj());
        add(insertProvider.getjTextFieldName());

        if (option == EDIT) {
            add(insertProvider.getjButtonDelete());
            this.providers = ProviderDAO.readProvider();
            this.provider = providers.get(controllerMain.selected);
            setFrameElements();
        }

    }

    public void setFrameElements() {
        this.insertProvider.getjTextAreaAdress().setText(provider.getAdress());
        this.insertProvider.getjTextFieldCnpj().setText(provider.getCnpj());
        this.insertProvider.getjTextFieldName().setText(provider.getName());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
    
}

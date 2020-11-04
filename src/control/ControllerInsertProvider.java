/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

import model.dataAcessObject.ItemDAO;
import model.dataAcessObject.ProviderDAO;
import model.interfaces.Operations;
import model.valueObject.Item;
import model.valueObject.Provider;
import view.InsertProvider;

/**
 *
 * @author ld_si
 */
public class ControllerInsertProvider extends Controller {
    private InsertProvider insertProvider;
    private JFrame root;
    private static ArrayList<Provider> providers;
    public Provider provider;
    public static final int NEW = 0;
    public static final int EDIT = 1;

    public ControllerInsertProvider(InsertProvider insertProvider, JFrame root, ControllerMain controllerMain, int option) {
        this.insertProvider = insertProvider;
        this.root = root;

        insertProvider.getHead().getbMinimize().setEnabled(false);
        ControllerHead.add(insertProvider.getHead(), insertProvider, root, 1, true);
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

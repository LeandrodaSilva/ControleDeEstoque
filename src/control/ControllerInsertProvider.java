/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import view.InsertProvider;

/**
 *
 * @author ld_si
 */
public class ControllerInsertProvider extends Controller{
    private InsertProvider insertProvider;
    private JFrame root;
    

    public ControllerInsertProvider(InsertProvider insertProvider, JFrame root) {
        this.insertProvider = insertProvider;
        this.root = root;
        
        insertProvider.getHead().getbMinimize().setEnabled(false);
        ControllerHead.add(insertProvider.getHead(), insertProvider, root, 1, true);
        add(insertProvider.getjButtonClear());
        add(insertProvider.getjButtonDelete());
        add(insertProvider.getjButtonSave());
        add(insertProvider.getjTextFieldCnpj());
        add(insertProvider.getjTextFieldName());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
    
}

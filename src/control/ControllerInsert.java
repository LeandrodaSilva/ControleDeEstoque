/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.InsertItem;

/**
 *
 * @author ld_si
 */
public class ControllerInsert implements ActionListener{
    
    private InsertItem insert;
    private JFrame root;
    public ControllerInsert(InsertItem insert, JFrame root) {
        this.insert = insert;
        this.root = root;
        
        new ControllerHead(insert.getHead(), insert, root, 1, true);
        new ControllerEfect(insert.getjButtonClear());
        new ControllerEfect(insert.getjButtonDelete());
        new ControllerEfect(insert.getjButtonSave());
        new ControllerEfect(insert.getjTextFieldName());
        new ControllerEfect(insert.getjTextFieldPrice());
        new ControllerEfect(insert.getjTextFieldQuantity());
        
        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}

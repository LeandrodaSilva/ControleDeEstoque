/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import view.InsertItem;

/**
 *
 * @author ld_si
 */
public class ControllerInsertItem extends Controller{
    
    private InsertItem insert;
    private JFrame root;
    
    public ControllerInsertItem(InsertItem insert, JFrame root) {
        this.insert = insert;
        this.root = root;
        
        insert.getHead().getbMinimize().setEnabled(false);
        ControllerHead.add(insert.getHead(), insert, root, 1, true);
        add(insert.getjButtonClear());
        add(insert.getjButtonDelete());
        add(insert.getjButtonSave());
        add(insert.getjTextFieldName());
        add(insert.getjTextFieldPrice());
        add(insert.getjTextFieldQuantity());
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}

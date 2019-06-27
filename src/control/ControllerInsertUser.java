/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.businessObject.Hash;
import model.businessObject.RandomValue;
import model.dataAcessObject.UserDAO;
import model.interfaces.InsertUserOperation;
import model.valueObject.User;
import view.InsertUser;

/**
 *
 * @author ld_si
 */
public class ControllerInsertUser extends Controller implements InsertUserOperation{
    private InsertUser insertUser;
    private JFrame root;
    

    public ControllerInsertUser(InsertUser insertUser, JFrame root) {
        this.insertUser = insertUser;
        this.root = root;
        
        insertUser.getjButtonSave().addActionListener(this);
        insertUser.getjButtonClear().addActionListener(this);
        
        insertUser.getHead().getbMinimize().setEnabled(false);
        ControllerHead.add(insertUser.getHead(), insertUser, root, 1, false);
        add(insertUser.getjButtonSave());
        add(insertUser.getjButtonClear());
        add(insertUser.getjTextFieldName());
        add(insertUser.getjPasswordField());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.insertUser.getjButtonSave()) {
            create();
        }
        
        if (e.getSource() == this.insertUser.getjButtonClear()) {
            clean();
        }
    }

    @Override
    public void create() {
        RandomValue rv = new RandomValue();
        String salt = rv.getRandomSalt();
        try {
            UserDAO.writeUser(new User(
                    this.insertUser.getjTextFieldName().getText(),
                    salt,
                    Hash.getHash(new String(this.insertUser.getjPasswordField().getPassword()) + salt)
            ));
            System.out.println("Criado novo usuário");
            JOptionPane.showMessageDialog(this.insertUser, "Usuário criado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            root.setEnabled(true);
            this.insertUser.dispose();
        } catch (IOException ex) {
            System.out.println("Erro na criação do usuário");
            JOptionPane.showMessageDialog(this.insertUser, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void clean() {
        this.insertUser.getjTextFieldName().setText("");
        this.insertUser.getjPasswordField().setText("");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.businessObject.HashBO;
import models.businessObject.RandomValueBO;
import models.dataAcessObject.UserDAO;
import models.interfaces.InsertUserOperationInterface;
import models.valueObject.UserVO;
import views.UserView;

/**
 *
 * @author ld_si
 */
public class UserController extends EffectController implements InsertUserOperationInterface {
    private UserView insertUser;
    private JFrame root;
    

    public UserController(UserView insertUser, JFrame root) {
        this.insertUser = insertUser;
        this.root = root;
        
        insertUser.getjButtonSave().addActionListener(this);
        insertUser.getjButtonClear().addActionListener(this);
        
        insertUser.getHead().getbMinimize().setEnabled(false);
        HeadController.add(insertUser.getHead(), insertUser, root, 1, false);
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
        RandomValueBO rv = new RandomValueBO();
        String salt = rv.getRandomSalt();
        try {
            UserDAO.writeUser(new UserVO(
                    this.insertUser.getjTextFieldName().getText(),
                    salt,
                    HashBO.getHash(new String(this.insertUser.getjPasswordField().getPassword()) + salt)
            ));
            System.out.println("Criado novo usuário");
            JOptionPane.showMessageDialog(this.insertUser, "Usuário criado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            root.setEnabled(true);
            this.insertUser.dispose();
        } catch (Exception ex) {
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

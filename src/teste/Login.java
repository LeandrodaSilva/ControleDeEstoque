/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.businessObject.Hash;
import model.businessObject.RandomValue;
import model.businessObject.Security;
import model.dataAcessObject.SettingsDAO;
import model.dataAcessObject.UserDAO;
import model.interfaces.Operations;
import model.valueObject.User;

/**
 *
 * @author ld_si
 */
public class Login implements Operations{
    private User user;
    private String username;
    private String passwd;
    private int mode = SettingsDAO.readSettings().getMode();
    
    
    public static void main(String[] args) {
        
    }

    @Override
    public boolean verifyFrameElements() {
        return true;
    }

    @Override
    public void getFrameElements() {
        if (verifyFrameElements()) {
           this.username = "admin";
           this.passwd = "admin";
        }else{
            System.out.println("Há campos não preenchidos");
        }
    }

    @Override
    public void setFrameElements() {
        
    }

    @Override
    public void removeFrameElements() {
        
    }

    @Override
    public void save() {
        try {
            User userOnStorage = (User) UserDAO.readUser(this.username);
            if (Security.loginCheck(username, passwd, user)) {
                System.out.println("Login autorizado");
            }else{
                System.out.println("Cadastre um usuário");
            }
        } catch (IOException ex) {
            System.out.println("Usuário não encontrado");
        }
    }

    @Override
    public void delete() {
       
    }

    @Override
    public void edit() {
       
    }

    @Override
    public void read() {
        
    }

    @Override
    public void setDataCode() {
        
    }
    
    
    
}

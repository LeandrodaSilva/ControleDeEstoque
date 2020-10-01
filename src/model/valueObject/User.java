/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.valueObject;

import java.io.Serializable;

/**
 *
 * @author ld_si
 */
public class User implements Serializable{
    private String userName;
    private String salt;
    private String hash;

    public User(String userName, String salt, String hash) throws Exception {
        this.setUserName(userName);
        this.salt = salt;
        this.hash = hash;
    }
    
    public User() {
        this.userName = "";
        this.salt = "";
        this.hash = "";
    }
    
    @Override
    public String toString() {
        if (this != null) {
            return (userName +"  "+salt+" "+hash);
        } else {
            return (null);
        }
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws Exception {
        if (!(this.userName = userName.replaceAll("[^a-zA-Z0-9]", "")).equals(userName)) {
            throw new Exception("caracteres especiais não permitidos no nome de usuário.");
        }
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    
}

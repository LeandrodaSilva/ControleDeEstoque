/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ld_si
 */
public class Login implements Serializable{
    private String userName;
    private String salt;
    private String hash;

    public Login(String userName, String salt, String hash) {
        this.userName = userName;
        this.salt = salt;
        this.hash = hash;
    }
    
    public Login() {
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

    public void setUserName(String userName) {
        this.userName = userName;
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

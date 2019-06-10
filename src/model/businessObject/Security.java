/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.businessObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;
import model.valueObject.User;

/**
 *
 * @author ld_si
 */
public class Security {
    /**
     * Método verifica se um determinado usuário possui o login válido
     * @param userName - Passar o nome de usuário para verificar
     * @param passwd - Passar a senha de usuário para verificar
     * @param user - Passar o usuário lido do arquivo ou banco de dados
     * @return Boolean - Retorna true caso passe na verificação ou false caso falhe
     */
    public static Boolean loginCheck(String userName, String passwd, User user) {
        if (Hash.getHash(passwd+user.getSalt()).equals(user.getHash()) && userName.equals(user.getUserName()))
            return true;
        return false;
    }
    
}

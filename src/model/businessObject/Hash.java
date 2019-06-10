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
import javax.swing.JOptionPane;

/**
 *
 * @author ld_si
 */
public class Hash {
    /**
     * Método recebe a senha concatenada com o salt para gerar um hash em string
     * @param passwd - Informar a senha + salt para gerar o hash
     * @return String - Com o hash gerado com base na senha recebida
     */
    public static String getHash(String passwd){
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            String hash = Base64.getEncoder().encodeToString(algorithm.digest(passwd.getBytes("UTF-8")));

            System.out.println("Hash: "+hash);
            return hash;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;
import model.Login;

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
    public static Boolean loginCheck(String userName, String passwd, Login user) {
        if (hashGerator(passwd+user.getSalt()).equals(user.getHash()) && userName.equals(user.getUserName()))
            return true;
        return false;
    }
    
    /**
     * Método recebe a senha concatenada com o salt para gerar um hash em string
     * @param passwd - Informar a senha + salt para gerar o hash
     * @return String - Com o hash gerado com base na senha recebida
     */
    public static String hashGerator(String passwd){
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
    /** 
     * Método utilizado para geral um salt aleatório com base no relógio da máquina
     * @return String - Com o salt gerado
     */
    public static String saltGerator(){
        Calendar data = Calendar.getInstance();
        String time = Integer.toString(data.get(Calendar.HOUR_OF_DAY))+
                Integer.toString(data.get(Calendar.MINUTE))+
                Integer.toString(data.get(Calendar.SECOND)); 
        System.out.println("saltGerator()");
        System.out.println("Time: "+time);
        Random gerador = new Random(Long.parseLong(time));
        int salt;
        salt = Math.abs(gerador.nextInt());
        System.out.println("Salt: "+salt);
        System.out.println("end");
        return Integer.toString(salt);
    }
}

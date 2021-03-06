/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.businessObject;

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
        if (user == null) return false;

        String hash = Hash.getHash(passwd+user.getSalt());
        
        System.out.println("Security - "+hash+" = "+user.getHash());
        System.out.println(userName+" = "+user.getUserName());
        
        if (hash.equals(user.getHash()) && 
                userName.equals(user.getUserName()))
            return true;
        return false;
    }
    
    
}

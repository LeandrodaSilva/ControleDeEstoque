/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAcessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author ld_si
 */
public class ConnectionDAO {
    public static Connection connection = null;
    private static Statement stDados = null;
    private static ResultSet rsDados = null;
    
    
    
    /**
     * 
     * @return boolean
     */
    public boolean createConection() {
  
        try {
            String usuario = "postgres";
            String senha = "utfpr";
            
            Class.forName("org.postgresql.Driver");  
            String urlconexao = "jdbc:postgresql://192.168.0.168/controle";


            connection = DriverManager.getConnection(urlconexao, usuario, senha);
            connection.setAutoCommit(false);

        } catch (ClassNotFoundException | SQLException erro) {
            System.out.println("createConection - Erro:" + erro);
            return false;
        }
        return true;
    }
    
    /**
     * 
     * @param sql 
     */
    public void writeCloud(String sql) {
        try {

            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            stDados = connection.createStatement(tipo, concorrencia);
            
            stDados.executeUpdate(sql);
            connection.commit();
            System.out.println("Inserido em Cloud com sucesso");
        } catch (SQLException erro) {
            System.out.println("writeCloud - Erro:" + erro);
        }
    }
    
    /**
     * 
     * @param sql
     * @return ResultSet
     */
    public static ResultSet readCloud(String sql){
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_READ_ONLY;
            
            stDados = connection.createStatement(tipo, concorrencia);
            
            rsDados = stDados.executeQuery(sql);
            if (!rsDados.first()) {
                return null;
            }
           
            return rsDados;
        } catch (SQLException erro) {
            System.out.println("readCloud - Erro: "+ erro.getMessage());
            return null;
        }
    }
    
    /**
     * 
     */
    public void closeConection() {
        try {
            if (rsDados != null) {
                rsDados.close();
                stDados.close();
                connection.close();
            }
        } catch (SQLException erro) {
            System.out.println("closeConection - Erro:" + erro);
        }
    }
}

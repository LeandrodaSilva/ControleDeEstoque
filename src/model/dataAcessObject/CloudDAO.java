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
public class CloudDAO {
    
    private static Connection connection = null;
    private static Statement stdados = null;
    private static ResultSet rsdados = null;
    
    public boolean createConection() {
  
        try {
            String usuario = "postgres";
            String senha = "utfpr";
            
            Class.forName("org.postgresql.Driver");  
            String urlconexao = "jdbc:postgresql://localhost/controle"; 


            connection = DriverManager.getConnection(urlconexao, usuario, senha);
            connection.setAutoCommit(false);

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC/ODBC." + erro);
            return false;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return false;
        }
        return true;
    }
    
    public void writeCloud(String sql) {
        try {

            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
           
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
           

            stdados = connection.createStatement(tipo, concorrencia);
            
            int resposta = stdados.executeUpdate(sql);
            connection.commit();
           
            System.out.println("Resposta do Update = " + resposta);
        } catch (SQLException erro) {
            System.out.println("Erro Executa Update = " + erro);
        }
    }
    
    public static ResultSet readCloud(String sql){
        try {
           
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
           
            int concorrencia = ResultSet.CONCUR_READ_ONLY;
            
            stdados = connection.createStatement(tipo, concorrencia);
            
            rsdados = stdados.executeQuery(sql);
            if (!rsdados.first()) {
                return null;
            }
           
            return rsdados;
        } catch (SQLException erro) {
            System.out.println("readCloud - Erro: "+ erro.getMessage());
            return null;
        }
    }
    
    
     public void closeConection() {
        try {
            if (rsdados != null) {
                rsdados.close();
                stdados.close();
                connection.close();
            }
        } catch (SQLException erro) {
            System.out.println("Nao foi possivel a desconexao." + erro);
        }
    }
}

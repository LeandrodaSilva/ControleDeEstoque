/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.businessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ld_si
 */
public class Conect {
    private Connection connection = null;
    private Statement stdados = null;
    private ResultSet rsdados = null;
    
    public boolean AcessaBD() {
  
        try {
            String usuario = "postgres";
            String senha = "utfpr";
            
            Class.forName("org.postgresql.Driver");  //para acesso ao banco de dados Postgre
            String urlconexao = "jdbc:postgresql://localhost/controle"; //para acesso ao banco de dados fabricio, usando o banco de dados Postgre.

            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//ODBC DRIVER
            //String urlconexao = "jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ="+arquivo.getAbsolutePath(); //para criar o DSN em tempo de execucao do Access
            //ou
            //String urlconexao = "jdbc:odbc:aulajava"; //para acessar usando um DSN j� existente no ODBC

            //Class.forName("org.hsqldb.jdbcDriver");//hypersonicSQL DRIVER
            //String urlconexao = "jdbc:hsqldb:C:/dados/dbexper";//para acesso ao banco dbexper usando o banco HypersonicSQL (http://www.hsqldb.org/)

            connection = DriverManager.getConnection(urlconexao, usuario, senha);
            connection.setAutoCommit(false);//configuracao necessaria para confirmacao ou nao de alteracoes no banco de dados.

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC/ODBC." + erro);
            return false;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return false;
        }
        return true;
    }
    
    public void ExecutaUpdade() {
        try {
            ///String querydados = textArea1.getText();
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
            //a) ResultSet.TYPE_FORWARD_ONLY = O conjunto de dados nao eh rolavel, isto e, soh anda para frente uma unica vez.
            //b) ResultSet.TYPE_SCROLL_INSENSITIVE = O conjunto de dados eh rolavel, mas nao eh sensivel as alteracoes do banco de dados.
            //c) ResultSet.TYPE_SCROLL_SENSITIVE = O conjunto de dados eh rolavel sendo sensivel as alteracoes do banco de dados.

            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            //ResultSet.CONCUR_READ_ONLY => O conjunto de resultados nao pode ser usado para atualizar o banco de dados.
            //ResultSet.CONCUR_UPDATABLE tabela => O conjunto de resultados pode ser usado para atualizar o banco de dados.

            //stdados.execute("SET SEARCH_PATH TO nome_esquema");//necessario para selecionar o esquema no banco de dados Postgre.
            //ou se utiliza o nome do esquema.nomedatabela

            stdados = connection.createStatement(tipo, concorrencia);
            //connection.prepareStatement(sql)
            //int resposta = stdados.executeUpdate(querydados);//DML
            //boolean resposta = stdados.execute(querydados);//DDL
            //rsdados = stdados.executeQuery(querydados);//DQL
            //System.out.println("Resposta do Update = " + resposta);
        } catch (SQLException erro) {
            System.out.println("Erro Executa Update = " + erro);
        }
    }
    
    public String executeQuery(String sql) {
        try {
           // String querydados = textArea1.getText();
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            //ResultSet.TYPE_FORWARD_ONLY = O conjunto de dados nao � rol�vel, isto �, s� anda para frente uma �nica vez.
            //ResultSet.TYPE_SCROLL_INSENSITIVE = O conjunto de dados � rol�vel, mas nao � sens�vel �s altera�oes do banco de dados.
            //ResultSet.TYPE_SCROLL_SENSITIVE = O conjunto de dados � rol�vel e � sens�vel �s altera�oes do banco de dados.
            int concorrencia = ResultSet.CONCUR_READ_ONLY;
            //ResultSet.CONCUR_READ_ONLY = O conjunto de resultados nao pode ser usado para atualizar o banco de dados.
            //ResultSet.CONCUR_UPDATABLE = O conjunto de resultados pode ser usado para atualizar o banco de dados.
            stdados = connection.createStatement(tipo, concorrencia);
            //stdados.execute("public.login");//necessario para selecionar o esquema no banco de dados Postgre.
            //ou se utiliza o nome do esquema.nomedatabela
            rsdados = stdados.executeQuery(sql);
            rsdados.first();
            //stdados.executeQuery = retorna um resultSet
            System.out.println("DAdos: "+rsdados.getString("username"));
            return "ok";
        } catch (SQLException erro) {
            return erro.getMessage();
        }
    }
    
    public void Sair() {
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

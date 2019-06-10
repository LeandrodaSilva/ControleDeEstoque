/*
 * AcessaBD2.java
 * Created on 30 de Maio de 2005
 * @author  fabricio@utfpr.edu.br
 */
package control;

import java.sql.*;
import javax.swing.*;

public class AcessaBD extends java.awt.Frame {

    private Connection connection = null;
    private Statement stdados = null;
    private ResultSet rsdados = null;
    private JTable tabela = null;
    private JScrollPane scroller = null;
    private PreparedStatement pstdados = null;
    private CallableStatement cstdados = null;

    public boolean AcessaBD() {
        try {
            String usuario = "postgres";
            String senha = "utfpr";

            Class.forName("org.postgresql.Driver");  //para acesso ao banco de dados Postgre
            String urlconexao = "jdbc:postgresql://localhost/controle"; //para acesso ao banco de dados fabricio, usando o banco de dados Postgre.
            connection = DriverManager.getConnection(urlconexao, usuario, senha);
            connection.setAutoCommit(true);//configuracao necessaria para confirmacao ou nao de alteracoes no banco de dados
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC/ODBC." + erro);
            return false;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return false;
        }
        return true;
    }

    public void ExecutaUpdate(String sql) {
        try {
            //String sqldml = textArea2.getText();
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            stdados = connection.createStatement(tipo, concorrencia);
            int resposta = stdados.executeUpdate(sql);
            stdados.execute(sql);
            System.out.println("Resposta do Update = " + resposta);
            JOptionPane.showMessageDialog(this, "Resposta do Update = " + resposta);
        } catch (SQLException erro) {
            System.out.println("Erro Executa Update = " + erro);
        }
    }

    public void executeQuery(String sql) {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            stdados = connection.createStatement(tipo, concorrencia);

            rsdados = stdados.executeQuery(sql);
        } catch (SQLException sqlE) {
            System.out.println("Erro" + sqlE);
        }
    }

    public void ExecutaPUpdate() {
        try {
            String sqldml = "Insert into clientes (nome,fone,email,idade) "
                    + "values (?,?,?,?)";
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);
            String nome = JOptionPane.showInputDialog("Entre com o nome: ");
            pstdados.setString(1, nome);
            String fone = JOptionPane.showInputDialog("Entre com o fone: ");
            pstdados.setString(2, fone);
            String email = JOptionPane.showInputDialog("Entre com o e-mail: ");
            pstdados.setString(3, email);
            int idade = Integer.valueOf(JOptionPane.showInputDialog("Entre com a idade: "));
            pstdados.setInt(4, idade);
            int resposta = pstdados.executeUpdate();
            System.out.println("Resposta do P-Update = " + resposta);
            JOptionPane.showMessageDialog(this, "Resposta do P-Update = " + resposta);
        } catch (SQLException erro) {
            System.out.println("Erro Executa P-Update = " + erro);
        }
    }

    public void ExecutaStoredProcedure1() {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            cstdados = connection.prepareCall("{call consultaclientes()}", tipo, concorrencia);
            rsdados = cstdados.executeQuery();
        } catch (SQLException erro) {
            System.out.println("Erro Executa StoredProcedure = " + erro);
        }
    }

    public void ExecutaStoredProcedure2() {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            cstdados = connection.prepareCall("{call consultaidade(?)}", tipo, concorrencia);
            int idademinima = Integer.valueOf(JOptionPane.showInputDialog("Entre com a idade minima: ", 18));
            cstdados.setInt(1, idademinima);
            rsdados = cstdados.executeQuery();
        } catch (SQLException erro) {
            System.out.println("Erro Executa StoredProcedure2 = " + erro);
        } catch (NumberFormatException erro) {
            //usuario clicou no cancelar...
        }
    }

    public void ExecutaStoredProcedure3() {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            cstdados = connection.prepareCall("{call inserecliente(?,?,?,?)}", tipo, concorrencia);
            String nome = JOptionPane.showInputDialog("Entre com o nome: ");
            cstdados.setString(1, nome);
            int idade = Integer.valueOf(JOptionPane.showInputDialog("Entre com a idade: "));
            cstdados.setInt(2, idade);
            String fone = JOptionPane.showInputDialog("Entre com o fone: ");
            cstdados.setString(3, fone);
            String email = JOptionPane.showInputDialog("Entre com o e-mail: ");
            cstdados.setString(4, email);
            cstdados.executeUpdate();
        } catch (SQLException erro) {
            System.out.println("Erro Executa StoredProcedure2 = " + erro);
        }
    }

    public void closeConection() {

        if (rsdados != null) {
            try {
                rsdados.close();
                stdados.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Erro na desconexão");
            }
        }

    }

}

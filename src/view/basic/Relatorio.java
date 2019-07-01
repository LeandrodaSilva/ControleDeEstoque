/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ld_si
 */
public class Relatorio extends JFrame{
    private Button jButtonFornecedor;
    private Button jButtonFornecedorPdf;
    private Button jButtonProduto;
    private Button jButtonProdutoPdf;
    private Button jButtonUsuario;
    private Button jButtonUsuarioPdf;
    private Head head;
    private JLabel lbackground;
    

    public Relatorio() {
        setResizable(false);
        setSize(600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        
        lbackground = new JLabel("back");
        lbackground.setIcon(new ImageIcon(getClass().getResource("/view/images/back.png")));
        
        head = new Head("Relatórios");
        
        
        jButtonUsuario = new Button("Relatório usuários");
        jButtonProduto = new Button("Relatório produtos");
        jButtonFornecedor = new Button("Relatório fornecedor");
        jButtonUsuarioPdf = new Button("PDF");
        jButtonProdutoPdf = new Button("PDF");
        jButtonFornecedorPdf = new Button("PDF");
        
        jButtonUsuario.setBounds(173, 127, 170, 32);
        jButtonProduto.setBounds(173, 177, 170, 32);
        jButtonFornecedor.setBounds(173, 227, 170, 32);
        jButtonUsuarioPdf.setBounds(371, 177, 52, 32);
        jButtonProdutoPdf.setBounds(371, 227, 52, 32);
        jButtonFornecedorPdf.setBounds(371, 127, 52, 32);
        
        lbackground.setBounds(0, 50, 800, 550);
        
        head.setBounds(0, 0, 600, 50);
        
        add(jButtonUsuario);
        add(jButtonProduto);
        add(jButtonFornecedor);
        add(jButtonUsuarioPdf);
        add(jButtonProdutoPdf);
        add(jButtonFornecedorPdf);
        add(head);
        add(lbackground);
    }

    public Button getjButtonFornecedor() {
        return jButtonFornecedor;
    }

    public void setjButtonFornecedor(Button jButtonFornecedor) {
        this.jButtonFornecedor = jButtonFornecedor;
    }

    public Button getjButtonFornecedorPdf() {
        return jButtonFornecedorPdf;
    }

    public void setjButtonFornecedorPdf(Button jButtonFornecedorPdf) {
        this.jButtonFornecedorPdf = jButtonFornecedorPdf;
    }

    public Button getjButtonProduto() {
        return jButtonProduto;
    }

    public void setjButtonProduto(Button jButtonProduto) {
        this.jButtonProduto = jButtonProduto;
    }

    public Button getjButtonProdutoPdf() {
        return jButtonProdutoPdf;
    }

    public void setjButtonProdutoPdf(Button jButtonProdutoPdf) {
        this.jButtonProdutoPdf = jButtonProdutoPdf;
    }

    public Button getjButtonUsuario() {
        return jButtonUsuario;
    }

    public void setjButtonUsuario(Button jButtonUsuario) {
        this.jButtonUsuario = jButtonUsuario;
    }

    public Button getjButtonUsuarioPdf() {
        return jButtonUsuarioPdf;
    }

    public void setjButtonUsuarioPdf(Button jButtonUsuarioPdf) {
        this.jButtonUsuarioPdf = jButtonUsuarioPdf;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public JLabel getLbackground() {
        return lbackground;
    }

    public void setLbackground(JLabel lbackground) {
        this.lbackground = lbackground;
    }

    
    
    
}

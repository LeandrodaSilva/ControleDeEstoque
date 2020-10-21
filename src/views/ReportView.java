/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import views.components.ButtonComponent;
import views.components.HeadComponent;

import javax.swing.*;

/**
 *
 * @author ld_si
 */
public class ReportView extends JFrame{
    private ButtonComponent jButtonFornecedor;
    private ButtonComponent jButtonFornecedorPdf;
    private ButtonComponent jButtonProduto;
    private ButtonComponent jButtonProdutoPdf;
    private ButtonComponent jButtonUsuario;
    private ButtonComponent jButtonUsuarioPdf;
    private HeadComponent head;
    private JLabel lbackground;
    

    public ReportView() {
        setResizable(false);
        setSize(600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        
        lbackground = new JLabel("back");
        lbackground.setIcon(new ImageIcon(getClass().getResource("/views/images/back.png")));
        
        head = new HeadComponent("Relatórios");
        
        
        jButtonUsuario = new ButtonComponent("Relatório usuários");
        jButtonProduto = new ButtonComponent("Relatório produtos");
        jButtonFornecedor = new ButtonComponent("Relatório fornecedor");
        jButtonUsuarioPdf = new ButtonComponent("PDF");
        jButtonProdutoPdf = new ButtonComponent("PDF");
        jButtonFornecedorPdf = new ButtonComponent("PDF");
        
        jButtonUsuario.setBounds(173, 127, 170, 32);
        jButtonProduto.setBounds(173, 177, 170, 32);
        jButtonFornecedor.setBounds(173, 227, 170, 32);

        jButtonUsuarioPdf.setBounds(371, 177, 52, 32);
        jButtonUsuarioPdf.setEnabled(false);

        jButtonProdutoPdf.setBounds(371, 227, 52, 32);
        jButtonProdutoPdf.setEnabled(false);

        jButtonFornecedorPdf.setBounds(371, 127, 52, 32);
        jButtonFornecedorPdf.setEnabled(false);

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

    public ButtonComponent getjButtonFornecedor() {
        return jButtonFornecedor;
    }

    public void setjButtonFornecedor(ButtonComponent jButtonFornecedor) {
        this.jButtonFornecedor = jButtonFornecedor;
    }

    public ButtonComponent getjButtonFornecedorPdf() {
        return jButtonFornecedorPdf;
    }

    public void setjButtonFornecedorPdf(ButtonComponent jButtonFornecedorPdf) {
        this.jButtonFornecedorPdf = jButtonFornecedorPdf;
    }

    public ButtonComponent getjButtonProduto() {
        return jButtonProduto;
    }

    public void setjButtonProduto(ButtonComponent jButtonProduto) {
        this.jButtonProduto = jButtonProduto;
    }

    public ButtonComponent getjButtonProdutoPdf() {
        return jButtonProdutoPdf;
    }

    public void setjButtonProdutoPdf(ButtonComponent jButtonProdutoPdf) {
        this.jButtonProdutoPdf = jButtonProdutoPdf;
    }

    public ButtonComponent getjButtonUsuario() {
        return jButtonUsuario;
    }

    public void setjButtonUsuario(ButtonComponent jButtonUsuario) {
        this.jButtonUsuario = jButtonUsuario;
    }

    public ButtonComponent getjButtonUsuarioPdf() {
        return jButtonUsuarioPdf;
    }

    public void setjButtonUsuarioPdf(ButtonComponent jButtonUsuarioPdf) {
        this.jButtonUsuarioPdf = jButtonUsuarioPdf;
    }

    public HeadComponent getHead() {
        return head;
    }

    public void setHead(HeadComponent head) {
        this.head = head;
    }

    public JLabel getLbackground() {
        return lbackground;
    }

    public void setLbackground(JLabel lbackground) {
        this.lbackground = lbackground;
    }

    
    
    
}

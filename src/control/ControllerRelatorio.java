/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import model.dataAcessObject.CloudDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import view.basic.Relatorio;

/**
 *
 * @author ld_si
 */
public class ControllerRelatorio extends Controller {

    private Relatorio frame;
    public static final String relatorioUsuario = System.getProperty("user.dir") + "/src/view/Usuarios.jasper";
    public static final String relatorioProduto = System.getProperty("user.dir") + "/src/view/Produtos.jasper";
    public static final String relatorioFornecedores = System.getProperty("user.dir") + "/src/view/Produtos.jasper";

    public ControllerRelatorio(Relatorio frame) {
        this.frame = frame;

        frame.getHead().getbMinimize().setEnabled(false);
        //ControllerHead.add(frame.getHead(), frame, null, 1, true);
        ControllerHead.add(frame.getHead(), frame);
        add(frame.getjButtonUsuario());
        add(frame.getjButtonUsuarioPdf());
        add(frame.getjButtonProduto());
        add(frame.getjButtonProdutoPdf());
        add(frame.getjButtonFornecedor());
        add(frame.getjButtonFornecedorPdf());

        frame.getjButtonUsuario().addActionListener(this);
        frame.getjButtonUsuarioPdf().addActionListener(this);
        frame.getjButtonProduto().addActionListener(this);
        frame.getjButtonProdutoPdf().addActionListener(this);
        frame.getjButtonFornecedor().addActionListener(this);
        frame.getjButtonFornecedorPdf().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frame.getjButtonUsuario()) {
            JasperPrint impressao;
            try {
                CloudDAO cdao = new CloudDAO();
                cdao.createConection();

                impressao = JasperFillManager.fillReport(
                        relatorioUsuario,
                        constroiParametros(),
                        cdao.connection);

                JasperViewer.viewReport(impressao);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == this.frame.getjButtonProduto()) {
            JasperPrint impressao;
            try {
                CloudDAO cdao = new CloudDAO();
                cdao.createConection();

                impressao = JasperFillManager.fillReport(
                        relatorioProduto,
                        constroiParametros(),
                        cdao.connection);

                JasperViewer.viewReport(impressao);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }
        
        if (e.getSource() == this.frame.getjButtonFornecedor()) {
             JasperPrint impressao;
            try {
                CloudDAO cdao = new CloudDAO();
                cdao.createConection();

                impressao = JasperFillManager.fillReport(
                        relatorioFornecedores,
                        constroiParametros(),
                        cdao.connection);

                JasperViewer.viewReport(impressao);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }
    }

    private Map constroiParametros() {
        Map params = new HashMap();
        params.put("", new Integer(10));
        params.put("", new Integer(75));
        return params;
    }

}

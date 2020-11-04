/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import model.dataAcessObject.ConnectionDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import view.Main;
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

    public ControllerRelatorio(Relatorio frame, Main main) {
        this.frame = frame;

        frame.getHead().getbMinimize().setEnabled(false);
        ControllerHead.add(frame.getHead(), frame, main, 1, true);
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
        try {
            JasperPrint impressao = null;
            ConnectionDAO cdao = new ConnectionDAO();
            cdao.createConection();

            if (e.getSource() == this.frame.getjButtonUsuario()) {
                impressao = JasperFillManager.fillReport(
                        relatorioUsuario,
                        constroiParametros(),
                        cdao.connection);

            }
            if (e.getSource() == this.frame.getjButtonProduto()) {
                impressao = JasperFillManager.fillReport(
                        relatorioProduto,
                        constroiParametros(),
                        cdao.connection);
            }

            if (e.getSource() == this.frame.getjButtonFornecedor()) {
                impressao = JasperFillManager.fillReport(
                        relatorioFornecedores,
                        constroiParametros(),
                        cdao.connection);
            }

            if (impressao != null) JasperViewer.viewReport(impressao, false);

        } catch (JRException ex) {
            ex.printStackTrace();
        }

    }

    private Map constroiParametros() {
        Map params = new HashMap();
        params.put("", new Integer(10));
        params.put("", new Integer(75));
        return params;
    }

}

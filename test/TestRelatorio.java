
import control.ControllerRelatorio;
import view.basic.Relatorio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ld_si
 */
public class TestRelatorio {
    public static void main(String[] args) {
        Relatorio frame = new Relatorio();
        frame.setVisible(true);
        new ControllerRelatorio(frame, null);
    }
}

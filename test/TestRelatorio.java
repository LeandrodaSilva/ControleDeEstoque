
import controllers.ReportController;
import views.ReportView;

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
        ReportView frame = new ReportView();
        frame.setVisible(true);
        new ReportController(frame, null);
    }
}

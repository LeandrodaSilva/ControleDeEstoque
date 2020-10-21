
import controllers.ProviderController;
import views.ProviderView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ld_si
 */
public class TestInsertProvider {
    public static void main(String[] args) {
        ProviderView insert = new ProviderView();
        insert.setVisible(true);
        new ProviderController(insert, null, null, 0);
    }
}

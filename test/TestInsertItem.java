
import controllers.ItemController;
import views.ItemView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ld_si
 */
public class TestInsertItem {
    public static void main(String[] args) {
        ItemView insert = new ItemView();
        insert.setVisible(true);
        new ItemController(insert, null,null,0);
    }
}

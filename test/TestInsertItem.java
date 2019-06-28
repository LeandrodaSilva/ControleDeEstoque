
import control.ControllerInsertItem;
import view.InsertItem;

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
        InsertItem insert = new InsertItem();
        insert.setVisible(true);
        new ControllerInsertItem(insert, null,null);
    }
}


import control.ControllerInsertProvider;
import view.InsertProvider;

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
        InsertProvider insert = new InsertProvider();
        insert.setVisible(true);
        new ControllerInsertProvider(insert, null);
    }
}

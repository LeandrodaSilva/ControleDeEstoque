
import control.ControllerInsertUser;
import javax.swing.JFrame;
import view.InsertUser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ld_si
 */
public class TestInsertUser {
    public static void main(String[] args) {
        InsertUser insert = new InsertUser();
        insert.setVisible(true);
        new ControllerInsertUser(insert, null);
        
    }
}

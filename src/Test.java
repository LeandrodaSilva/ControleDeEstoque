
import model.businessObject.AcessaBD;
import model.businessObject.Conect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ld_si
 */
public class Test {
    public static void main(String[] args) {
        Conect bd = new Conect();
        bd.AcessaBD();
        
        System.out.println(bd.executeQuery("select * from login;").toString());
    }
}

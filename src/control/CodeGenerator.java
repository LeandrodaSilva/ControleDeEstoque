/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Aluno
 */
public class CodeGenerator {
    private static final Calendar data = Calendar.getInstance();
    
    public static int getRandomCode(){
        String time = Integer.toString(data.get(Calendar.HOUR_OF_DAY))
                + Integer.toString(data.get(Calendar.MINUTE))
                + Integer.toString(data.get(Calendar.SECOND));
        Random gerador = new Random(Long.parseLong(time));
        return Math.abs(gerador.nextInt());
    }
}

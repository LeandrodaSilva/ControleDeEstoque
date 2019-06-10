/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.businessObject;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Aluno
 */
public class RandomValue {
    private static final Calendar data = Calendar.getInstance();
    
    public static int getRandomCode(){
        String time = Integer.toString(data.get(Calendar.HOUR_OF_DAY))
                + Integer.toString(data.get(Calendar.MINUTE))
                + Integer.toString(data.get(Calendar.SECOND));
        Random gerador = new Random(Long.parseLong(time));
        return Math.abs(gerador.nextInt());
    }
    
    /** 
     * Método utilizado para geral um salt aleatório com base no relógio da máquina
     * @return String - Com o salt gerado
     */
    public static String getRandomSalt(){
        Calendar data = Calendar.getInstance();
        String time = Integer.toString(data.get(Calendar.HOUR_OF_DAY))+
                Integer.toString(data.get(Calendar.MINUTE))+
                Integer.toString(data.get(Calendar.SECOND)); 
        System.out.println("saltGerator()");
        System.out.println("Time: "+time);
        Random gerador = new Random(Long.parseLong(time));
        int salt;
        salt = Math.abs(gerador.nextInt());
        System.out.println("Salt: "+salt);
        System.out.println("end");
        return Integer.toString(salt);
    }
}

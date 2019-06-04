/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe contendo métodos para leitura e
 * gravação de arquivos de Texto ou Binário
 * @author ld_si
 */
public class Archive {
    
    
   /**
    * 
    * @param content
    * @param dir
    * @param file
    * @param option
    * @throws IOException 
    */
    public static void writeText(String content, String dir, String file, Boolean option) throws IOException {
        File arq = new File(dir, file);
        FileWriter wr = new FileWriter(arq, option);
        BufferedWriter bw = new BufferedWriter(wr);
        wr.flush();
        bw.write(content);
        bw.close();
        wr.close();
        bw.close();
    }
    
    public static void writeBinary(){
        
    }
    
    public static ArrayList readText(){
     
        return null;
    }
    
    public static Object readBinary(){
        return null;
    }
    
}

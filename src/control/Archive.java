/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Classe contendo métodos para leitura e gravação de arquivos de Texto ou
 * Binário
 *
 * @author ld_si
 */
public class Archive {

    /**
     *
     * @param content
     * @param dir
     * @param file
     * @param append
     * @throws IOException
     */
    public static void writeText(
            String content,
            String dir,
            String file,
            Boolean append)
            throws IOException {
        File arq = new File(dir, file);
        FileWriter wr = new FileWriter(arq, append);
        BufferedWriter bw = new BufferedWriter(wr);
        wr.flush();
        bw.write(content);
        bw.close();
        wr.close();
        bw.close();
    }

    /**
     *
     * @param dirFile
     * @return ArrayList
     * @throws FileNotFoundException
     */
    public static ArrayList<String> readText(
            String dirFile)
            throws FileNotFoundException, IOException {
        ArrayList<String> al = new ArrayList();
        FileReader fr = new FileReader(dirFile);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while (line != null) {
            al.add(line);
            line = br.readLine();
        }

        fr.close();
        br.close();
        return al;
    }

    public static void writeBinary(
            String dir, 
            Object obj,
            boolean append) {
        File arquivo = new File(dir);
         ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(arquivo, append);
            oos = new ObjectOutputStream(fos);
            
            if (arquivo.exists()) {
                
                oos = new ObjectOutputStream(fos) {
                    @Override
                    protected void writeStreamHeader() {
                        // do not write a header
                    }
                };
            } else {
        
                oos = new ObjectOutputStream(fos);
            }
             oos.writeObject(obj);
          
            oos.flush();
            
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
  
        
    }
    
    
    
     public static ObjectInputStream CriaLeitorBinario(String dir) {
        File arquivo = new File(dir);
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            ois = new ObjectInputStream(fis);
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo. " + erro);
        }
        return ois;
    }

    public static Object LeObjeto(ObjectInputStream ois) {
        Object objlido = null;
        try {
            objlido = ois.readObject();
        } catch (ClassNotFoundException erro) {
            System.out.println("Classe nao encontrada. " + erro);
        } catch (java.io.EOFException erro) {
            System.out.println("Final de arquivo. " + erro);
        } catch (IOException erro) {
            System.out.println("Erro na leitura do objeto. " + erro);
        } finally {
            return objlido;
        }
    }

    /**
     *
     * @param dir
     * @return Object
     */
    public static Object readBinary(String dir) {
        try {
            
            File arq = new File(dir);
            FileInputStream fis = new FileInputStream(arq);
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            
            Object obj = ois.readObject();
            System.out.println("Binário lido: "+obj.toString());
            ois.close();
            fis.close();
            return obj;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("readBinary NUll");
        return null;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dataAcessObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author ld_si
 */
public class BinaryDAO {
    /**
     * 
     * @param dir
     * @param obj
     * @param append 
     */
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
                    protected void writeStreamHeader() {}
                };
            } else {

                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(obj);

            oos.flush();

        } catch (IOException erro) {
            System.out.println("writeBinary - Erro ao criar arquivo. " + erro);
        }
    }

    /**
     *
     * @param dir
     * @return Object
     */
    public static Object readBinary(String dir) 
            throws FileNotFoundException, 
            IOException, ClassNotFoundException 
    {

        File arq = new File(dir);
        if (!arq.exists()) {
            return new ArrayList();
        }
        FileInputStream fis = new FileInputStream(arq);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object obj = ois.readObject();
        System.out.println("Binário lido: " + obj.toString());
        ois.close();
        fis.close();
        return obj;
    }
}

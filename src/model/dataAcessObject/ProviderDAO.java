/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAcessObject;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.valueObject.Dir;
import model.valueObject.Provider;

/**
 *
 * @author ld_si
 */
public class ProviderDAO extends DirDAO{

    public ProviderDAO(Dir dir) {
        super(dir);
    }

    
    /**
     *
     * @param provider
     * @throws IOException
     */
    public static void writeProvider(Provider provider) throws IOException {
        TextDAO.writeText(provider.getName() + ","
                + provider.getCnpj() + ","
                + provider.getAdress() + ";" + System.getProperty("line.separator"),
                dir.getDir(), dir.getDirProvider(), true);
    }
    
    
    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList readProvider()
            throws FileNotFoundException, IOException {
        ArrayList<String> lido = TextDAO.readText(dir.getDir() + dir.getDirProvider());
        ArrayList<Provider> providers = new ArrayList<>();

        String name, cnpj, adress;
        int v1, v2;

        for (String line : lido) {
            v1 = line.indexOf(",");
            v2 = line.indexOf(",", v1 + 1);

            name = line.substring(0, v1);
            cnpj = line.substring(v1 + 1, v2);
            adress = line.substring(v2 + 1, line.indexOf(";"));

            providers.add(new Provider(name, cnpj, adress));
        }

        return providers;
    }
}

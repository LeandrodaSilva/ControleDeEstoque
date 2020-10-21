/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dataAcessObject;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.valueObject.DirectoryVO;
import models.valueObject.ProviderVO;


/**
 *
 * @author ld_si
 */
public class ProviderDAO extends DirectoryDAO {
    
    public ProviderDAO(DirectoryVO dir) {
        super(dir);
    }

    /**
     *
     * @param provider
     * @throws IOException
     */
    public static void writeProvider(ProviderVO provider) throws IOException {
        switch (SettingsDAO.readSettings().getMode()) {
            case 0:
                TextDAO.writeText(provider.getName() + ","
                        + provider.getCnpj() + ","
                        + provider.getAdress() + ";" + System.getProperty("line.separator"),
                        dir.getDir(), dir.getDirProvider(), true);
                break;
            case 1:
                BinaryDAO.writeBinary(dir.getDir() + dir.getDirProviderBinary(),
                        provider, false);
                break;
            case 2:
                ConnectionDAO cdao = new ConnectionDAO();
                cdao.createConection();
                cdao.writeCloud("INSERT INTO public.\"provider\"(\n"
                        + " name, cnpj, adress)\n"
                        + " VALUES ("
                        + "'" + provider.getName() + "', "
                        + "'" + provider.getCnpj() + "', "
                        + "'" + provider.getAdress() + "');");
                cdao.closeConection();
                break;
        }
        
    }


    public static ArrayList readProvider(){        
        try {
            ArrayList<ProviderVO> providers = new ArrayList<ProviderVO>();
            switch (SettingsDAO.readSettings().getMode()) {
                case 0:
                    ArrayList<String> lido = TextDAO.readText(dir.getDir() + dir.getDirProvider());
                    
                    String name,
                            cnpj,
                            adress;
                    int v1,
                            v2;
                    
                    for (String line : lido) {
                        v1 = line.indexOf(",");
                        v2 = line.indexOf(",", v1 + 1);
                        
                        name = line.substring(0, v1);
                        cnpj = line.substring(v1 + 1, v2);
                        adress = line.substring(v2 + 1, line.indexOf(";"));
                        
                        providers.add(new ProviderVO(name, cnpj, adress));
                    }
                    return providers;
                case 1:
                    try {
                        return (ArrayList) BinaryDAO.readBinary(dir.getDir() + dir.getDirProviderBinary());
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                    }
                case 2:
                    ConnectionDAO cdao = new ConnectionDAO();
                    cdao.createConection();
                    
                    ResultSet rs = cdao.readCloud("SELECT name, cnpj, adress FROM public.provider;");
                    if (rs == null) {
                        return null;
                    }
                    try {
                        
                        System.out.println("ResultSet provider: " + rs.getObject(1).toString());
                        while (rs.next()) {
                            providers.add(new ProviderVO(rs.getString(1),
                                    rs.getString(2),
                                    rs.getString(3)));
                        }
                        System.out.println("Cloud - provider recuperado: ");
                        return providers;
                    } catch (SQLException ex) {
                        System.out.println("ResultSet Erro - provider: " + ex.getMessage());
                    }
            }
        } catch (IOException ex) {
            System.out.println("readProvider - Erro: "+ex.getMessage());
            return null;
        }
        return null;
    }    
}

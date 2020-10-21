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
import models.valueObject.UserVO;

/**
 *
 * @author ld_si
 */
public class UserDAO extends DirectoryDAO {

    public UserDAO(DirectoryVO dir) {
        super(dir);
    }

    /**
     *
     * @param user
     * @throws IOException
     */
    public static void writeUser(UserVO user) throws IOException {
        switch (SettingsDAO.readSettings().getMode()) {
            case 0:
                TextDAO.writeText(user.getUserName() + ","
                        + user.getSalt() + ","
                        + user.getHash() + ";" + System.getProperty("line.separator"),
                        dir.getDir(), dir.getDirUser(), false);
                break;
            case 1:
                BinaryDAO.writeBinary(dir.getDir() + dir.getDirUserBinary(), user, false);
                break;
            case 2:
                ConnectionDAO cdao = new ConnectionDAO();
                cdao.createConection();
                cdao.writeCloud("INSERT INTO public.\"user\"(\n"
                        + " username, salt, hash)\n"
                        + " VALUES ("
                        + "'" + user.getUserName() + "', "
                        + "'" + user.getSalt() + "', "
                        + "'" + user.getHash() + "');");
                cdao.closeConection();
                break;
        }
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    public static UserVO readUser(String username) throws Exception {
        UserVO userOnStorage;
        switch (SettingsDAO.readSettings().getMode()) {
            case 0:
                ArrayList<String> lido = TextDAO.readText(dir.getDir() + dir.getDirUser());
                int v1,
                 v2;
                String line = lido.get(0);

                v1 = line.indexOf(",");
                v2 = line.indexOf(",", v1 + 1);

                userOnStorage = new UserVO(line.substring(0, v1),
                        line.substring(v1 + 1, v2),
                        line.substring(v2 + 1, line.indexOf(";")));
                System.out.println("Texto - usuário recuperado: "+userOnStorage.getUserName());
                return userOnStorage;
            case 1: {
                try {
                    userOnStorage = (UserVO) BinaryDAO.readBinary(dir.getDir() + dir.getDirUserBinary());
                    System.out.println("Binário - usuário recuperado: "+userOnStorage.getUserName());
                    return  userOnStorage;
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
            case 2:
                ConnectionDAO cdao = new ConnectionDAO();
                cdao.createConection();

                ResultSet rs = cdao.readCloud("SELECT * FROM public.\"user\" "
                        + "where username like '" + username + "';");
                if (rs == null) {
                    return null;
                }
                try {
                    System.out.println("ResultSet usuario: " + rs.getObject(1).toString());
                    userOnStorage = new UserVO(
                            rs.getObject(1).toString(),
                            rs.getObject(2).toString(),
                            rs.getObject(3).toString());
                    System.out.println("Cloud - usuário recuperado: "+userOnStorage.getUserName());
                    return userOnStorage;
                } catch (SQLException ex) {
                    System.out.println("ResultSet Erro - usuário: "+ex.getMessage());
                }
            default:
                return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAcessObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.valueObject.Dir;
import model.valueObject.User;

/**
 *
 * @author ld_si
 */
public class UserDAO extends DirDAO {

    public UserDAO(Dir dir) {
        super(dir);
    }

    /**
     *
     * @param user
     * @throws IOException
     */
    public static void writeUser(User user) throws IOException {
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
                CloudDAO cdao = new CloudDAO();
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
    public static User readUser(String username) throws FileNotFoundException, IOException {
        switch (SettingsDAO.readSettings().getMode()) {
            case 0:
                ArrayList<String> lido = TextDAO.readText(dir.getDir() + dir.getDirUser());
                int v1,
                 v2;
                String line = lido.get(0);

                v1 = line.indexOf(",");
                v2 = line.indexOf(",", v1 + 1);

                User user = new User(line.substring(0, v1),
                        line.substring(v1 + 1, v2),
                        line.substring(v2 + 1, line.indexOf(";")));
                return user;
            case 1: {
                try {
                    return (User) BinaryDAO.readBinary(dir.getDir() + dir.getDirUserBinary());
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
            case 2:
                CloudDAO cdao = new CloudDAO();
                cdao.createConection();

                ResultSet rs = cdao.readCloud("SELECT * FROM public.\"user\" "
                        + "where username like '" + username + "';");

                try {
                    System.out.println("RS: " + rs.getObject(1).toString());
                    User userlido = new User(
                            rs.getObject(1).toString(),
                            rs.getObject(2).toString(),
                            rs.getObject(3).toString());
                    System.out.println("UserDAO: " + userlido.getUserName());
                    return userlido;
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            default:
                return null;
        }
    }
}

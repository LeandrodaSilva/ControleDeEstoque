/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.valueObject;

/**
 *
 * @author ld_si
 */
public class DirectoryVO {
    private String dir;
    private String dirUser = "/user.txt";
    private String dirItem = "/item.txt";
    private String dirProvider = "/provider.txt";
    private String dirSettings = "/conf.txt";
    private String dirUserBinary = "/user.obj";
    private String dirItemBinary = "/item.obj";
    private String dirProviderBinary = "/provider.obj";
    private String dirSettingsBinary = "/conf.obj";

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDirUser() {
        return dirUser;
    }

    public void setDirUser(String dirUser) {
        this.dirUser = dirUser;
    }

    public String getDirItem() {
        return dirItem;
    }

    public void setDirItem(String dirItem) {
        this.dirItem = dirItem;
    }

    public String getDirProvider() {
        return dirProvider;
    }

    public void setDirProvider(String dirProvider) {
        this.dirProvider = dirProvider;
    }

    public String getDirSettings() {
        return dirSettings;
    }

    public void setDirSettings(String dirSettings) {
        this.dirSettings = dirSettings;
    }

    public String getDirUserBinary() {
        return dirUserBinary;
    }

    public void setDirUserBinary(String dirUserBinary) {
        this.dirUserBinary = dirUserBinary;
    }

    public String getDirItemBinary() {
        return dirItemBinary;
    }

    public void setDirItemBinary(String dirItemBinary) {
        this.dirItemBinary = dirItemBinary;
    }

    public String getDirProviderBinary() {
        return dirProviderBinary;
    }

    public void setDirProviderBinary(String dirProviderBinary) {
        this.dirProviderBinary = dirProviderBinary;
    }

    public String getDirSettingsBinary() {
        return dirSettingsBinary;
    }

    public void setDirSettingsBinary(String dirSettingsBinary) {
        this.dirSettingsBinary = dirSettingsBinary;
    }
    
    

}

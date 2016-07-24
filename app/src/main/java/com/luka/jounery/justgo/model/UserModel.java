package com.luka.jounery.justgo.model;

/**
 * Created by Luka on 2016/7/22.
 * 397308937@qq.com
 */
public class UserModel implements IUser{

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;

    @Override
    public int checkUserValidity(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            return 1;
        } else {
            return 0;
        }
    }
}

package com.luka.jounery.justgo.model;

/**
 * Created by Luka on 2016/7/22.
 * 397308937@qq.com
 */
public interface IUser {
    /**
     * 检查登录的方法
     * @param username
     * @param password
     * @return 1.成功 0.失败
     */
    public int checkUserValidity(String username,String password);
}

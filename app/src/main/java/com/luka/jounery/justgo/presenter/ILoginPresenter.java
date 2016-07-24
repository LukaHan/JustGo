package com.luka.jounery.justgo.presenter;

/**
 * Created by Luka on 2016/7/22.
 * 397308937@qq.com
 *
 * presenter层的操作
 */
public interface ILoginPresenter {
    public void doLogin(String username, String password);

    public void clear();

    public void setProgressBarVisibility(int visibility);
}

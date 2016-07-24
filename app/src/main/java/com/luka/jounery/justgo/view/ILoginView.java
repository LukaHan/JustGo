package com.luka.jounery.justgo.view;

/**
 * Created by Luka on 2016/7/22.
 * 397308937@qq.com
 *
 * view层的显示
 */
public interface ILoginView {
    public void onClearText();

    public void onLoginResult(boolean result,int code);

    public void onSetProgressBarVisibility(int visibility);
}

package com.luka.jounery.justgo.presenter;

import android.os.Handler;
import android.os.Looper;

import com.luka.jounery.justgo.model.IUser;
import com.luka.jounery.justgo.model.UserModel;
import com.luka.jounery.justgo.view.ILoginView;


/**
 * Created by Luka on 2016/7/22.
 * 397308937@qq.com
 *
 * 逻辑判断的实现类，必须传入 v
 */
public class LoginPresenterCompl implements ILoginPresenter {

    ILoginView iLoginView;
    Handler handler;
    IUser user;

    public LoginPresenterCompl(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        user = new UserModel("luka","123");
    }

    @Override
    public void doLogin(String username, String password) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(username,password);
        if (code == 0) {
            isLoginSuccess = false;
        }
        final boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
              iLoginView.onLoginResult(result,code);
            }
        },3000);
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }
}

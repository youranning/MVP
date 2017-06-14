package bwie.com.mvp.presenter;

import android.text.TextUtils;

import bwie.com.mvp.moudle.MoudleLogin;
import bwie.com.mvp.moudle.MyMoudle;
import bwie.com.mvp.view.MyView;

/**
 * Created by $USER_NAME on 2017/6/13.
 */

public class MyPresenter implements MoudleLogin.MainActivityModelListener {
    MoudleLogin moudleLogin;
    MyView myView;

    public MyPresenter(MyView myView) {
        this.myView = myView;
        moudleLogin = new MoudleLogin(this);
    }

    public void login(String user, String pwd) {

        if (TextUtils.isEmpty(user)) {
            myView.userEmpty();
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            myView.pwdEmpty();
        }
        moudleLogin.login(user, pwd);
    }

    @Override
    public void onSuccess(String result) {
        myView.loginSuccess(result);
    }

    @Override
    public void onFailed() {
        myView.loginFaild();
    }
}

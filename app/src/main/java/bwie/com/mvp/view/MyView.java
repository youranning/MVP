package bwie.com.mvp.view;

/**
 * Created by $USER_NAME on 2017/6/13.
 */

public interface MyView {
    void userEmpty();
    void pwdEmpty();
    void loginSuccess(String result);
    void loginFaild();
}

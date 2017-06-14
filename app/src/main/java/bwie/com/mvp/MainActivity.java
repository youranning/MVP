package bwie.com.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwie.com.mvp.presenter.MyPresenter;
import bwie.com.mvp.view.MyView;

public class MainActivity extends AppCompatActivity implements MyView {
    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.login)
    Button login;
    private MyPresenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myPresenter = new MyPresenter(this);
    }


    @OnClick(R.id.login)
    public void setLogin(View view) {
        myPresenter.login(user.getText().toString().trim(), pwd.getText().toString().trim());
    }

    @Override
    public void userEmpty() {
        Toast.makeText(this, "用户名为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdEmpty() {
        Toast.makeText(this, "密码为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void loginFaild() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

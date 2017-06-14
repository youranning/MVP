package bwie.com.mvp.moudle;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by $USER_NAME on 2017/6/13.
 */

public class MoudleLogin implements MyMoudle {
    MainActivityModelListener mainActivityModelListener;

    public MoudleLogin(MainActivityModelListener mainActivityModelListener) {
        this.mainActivityModelListener = mainActivityModelListener;
    }

    public static String url = "http://qhb.2dyt.com/Bwei/login";

    @Override
    public void login(String user, String pwd) {
        StringBuilder builder = new StringBuilder();

        builder.append(url);
        builder.append("?").append("username=").append(user).append("&").append("password=").append(pwd).append("&")
                .append("postkey=1503d");


        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder().url(builder.toString()).build();


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                mainActivityModelListener.onFailed();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();


                mainActivityModelListener.onSuccess(result);

                // 数据持久化

            }
        });

    }


    public interface MainActivityModelListener {

        public void onSuccess(String result);

        public void onFailed();

    }
}

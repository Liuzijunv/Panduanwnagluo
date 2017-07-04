package bwie.com.panduanwnagluo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isNetworkAvailable(MainActivity.this);
    }


    /**
     * 检测当的网络（WLAN、3G/2G）状态
     * @param context Context
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected())
            {
                Toast.makeText(context, "当前网络是连接的！", Toast.LENGTH_LONG).show();
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED)
                {
                    Toast.makeText(context, "当前有可用网络！", Toast.LENGTH_LONG).show();
                    // 当前所连接的网络可用
                    return true;
                }
            }else {
                Toast.makeText(context, "当前没有有可用网络！", Toast.LENGTH_LONG).show();
            }
        }
        return false;
        }
}



















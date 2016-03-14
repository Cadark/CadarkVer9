package cadark.korean.hey.cadarkver9.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import cadark.korean.hey.cadarkver9.R;
import cadark.korean.hey.cadarkver9.dialog.NoNetworkDialog;


/**
 * Created by Hey!TheAnh on 1/22/2016.
 */
public class SplashActivity extends Activity {
    private static final String TAG = "SplashActivity";
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    private NoNetworkDialog noNetworkDialog;
    private Thread th;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
        noNetworkDialog = new NoNetworkDialog(this, this);
        displaySplash();
    }

    private void displaySplash() {
        th = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(SPLASH_DISPLAY_LENGTH);
                    runMainActivity();
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        if (isNetworkAvailable() == false) {
            noNetworkDialog.show();
        } else {
            th.start();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    private void runMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}

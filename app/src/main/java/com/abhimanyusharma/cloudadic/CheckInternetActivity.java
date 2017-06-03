package com.abhimanyusharma.cloudadic;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.abhimanyusharma.cloudadic.Weather.WeatherActivity.dialog;

public class CheckInternetActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_internet);

        haveNetworkConnection();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                {
                    haveConnectedWifi = true;
                    Dialog dialog = new Dialog(getApplicationContext());
                    //dialog.setIcon(R.drawable.i_snow);
                    dialog.setCancelable(true);
                    //dialog.setOnCancelListener(null);
                    dialog.show();

                }
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;

        }
        dialog.hide();
        return haveConnectedWifi || haveConnectedMobile;

    }
}

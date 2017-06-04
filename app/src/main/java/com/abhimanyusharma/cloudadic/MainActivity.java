package com.abhimanyusharma.cloudadic;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.abhimanyusharma.cloudadic.Location.LocationMapActivity;
import com.abhimanyusharma.cloudadic.MyDevice.MyDeviceActivity;
import com.abhimanyusharma.cloudadic.Weather.WeatherActivity;

public class MainActivity extends AppCompatActivity {
Button camera, notification, mydevice, location, weather, checkinternet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = (Button) findViewById(R.id.camera);
        notification = (Button) findViewById(R.id.notification);
        mydevice = (Button) findViewById(R.id.mydevice);
        location = (Button) findViewById(R.id.location);
        weather = (Button) findViewById(R.id.weather);
        checkinternet = (Button) findViewById(R.id.checkinternet);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(i);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(i);
                finish();
            }
        });

        mydevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MyDeviceActivity.class);
                startActivity(i);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LocationMapActivity.class);
                startActivity(i);
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(i);
            }
        });

        checkinternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                checkConnection(getApplicationContext());

            }
        });
    }
    public boolean checkConnection(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

        if (activeNetworkInfo != null) { // connected to the internet
            //Toast.makeText(context, activeNetworkInfo.getTypeName(), Toast.LENGTH_SHORT).show();

            if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                Toast.makeText(context, "Wifi", Toast.LENGTH_SHORT).show();

                showDialog("WIFI CONNECTED !!");

                return true;

            } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                Toast.makeText(context, "Mobile data", Toast.LENGTH_SHORT).show();

                showDialog("MOBILE DATA CONNECTED !!");

                return true;
            }
        } else //NO INTERNET CONNECTION
        {
            Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
            showDialog("NO INTERNET FOUND !!");
        }
        return true;
    }

    public void showDialog(String conditionMessage) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.my_dialog);
        dialog.setTitle("STATUS...");

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText(conditionMessage);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}

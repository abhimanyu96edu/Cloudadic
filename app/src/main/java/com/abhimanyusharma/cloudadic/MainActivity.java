package com.abhimanyusharma.cloudadic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CheckInternetActivity.class);
                startActivity(i);
            }
        });
    }
}

package com.abhimanyusharma.cloudadic.Weather;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abhimanyusharma.cloudadic.R;

/**
 * Created by Abhimanyu Sharma on 03-06-2017.
 */
public class WeatherActivity extends Activity {

    static ImageView cloudImageView, ImageView1;
    static TextView placeTextView;
    static TextView dateTextView;
    static TextView temperatureTextView;
    static TextView pressureTextView;
    static TextView humidityTextView;
    static TextView conditionTextView;
    static TextView visibilityTextView;
    static TextView windTextView;
    static TextView sunriseTextView;
    static TextView sunsetTextView;
    public static ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_weather);

        cloudImageView = (ImageView) findViewById(R.id.cloudImageView);
        placeTextView = (TextView) findViewById(R.id.placeTextView);
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        pressureTextView = (TextView) findViewById(R.id.pressureTextView);
        humidityTextView = (TextView) findViewById(R.id.humidityTextView);
        visibilityTextView = (TextView) findViewById(R.id.visibilityTextView);
        conditionTextView = (TextView) findViewById(R.id.conditionTextView);
        windTextView = (TextView) findViewById(R.id.windTextView);
        sunriseTextView = (TextView) findViewById(R.id.sunriseTextView);
        sunsetTextView = (TextView) findViewById(R.id.sunsetTextView);


        WeatherActivity.dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage("Loading...");
        dialog.show();
        refresh();
    }

    public void refresh() {
        Toast.makeText(this, "Fetching Data", Toast.LENGTH_SHORT).show();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocListener loc = new LocListener();

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, loc);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        DownloadTask task = new DownloadTask();
        //task.execute("http://api.openweathermap.org/data/2.5/weather?lat=51&lon=0&appid=aabd7edd6ed65a8eb1c5cfd90fbec64d");
        //task.execute("http://api.openweathermap.org/data/2.5/weather?lat=28.54&lon=77.20&appid=78ae06131c470ee9928e4f1eb87ffe43");
        task.execute("http://api.openweathermap.org/data/2.5/weather?lat=" + String.valueOf(LocListener.lat) + "&lon=" + String.valueOf(LocListener.lon) + "&appid=78ae06131c470ee9928e4f1eb87ffe43");

    }

}



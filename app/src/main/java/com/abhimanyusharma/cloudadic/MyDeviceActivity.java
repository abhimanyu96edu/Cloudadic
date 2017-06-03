package com.abhimanyusharma.cloudadic;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.pm.PackageInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyDeviceActivity extends AppCompatActivity{
    private String mReport = "Empty";
    private LinearLayout mLayout;
    private String mAppName = "Device info";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_device);
        mLayout = (LinearLayout) findViewById(R.id.layout);
        mReport = "Device Information Report \n";
        try {

            PackageInfo info = super.getApplication().getPackageManager().getPackageInfo(getApplication().getPackageName(), 0);
            mAppName = "\n\nDevice Version Info v" + info.versionName + "(" + info.versionCode + ")";
            setTextOfLabel(true, mAppName);
            setTextOfLabel(true, "\nLocale: " + getResources().getConfiguration().locale.toString());

            setTextOfLabel(true, "\nDevice Configuration Details:");
            setTextOfLabel(false, "Board: " + android.os.Build.BOARD);
            setTextOfLabel(false, "Brand: " + android.os.Build.BRAND);
            setTextOfLabel(false, "Device: " + android.os.Build.DEVICE);
            setTextOfLabel(false, "Model: " + android.os.Build.MODEL);
            setTextOfLabel(false, "Product: " + android.os.Build.PRODUCT);
            setTextOfLabel(false, "TAGS: " + android.os.Build.TAGS);
            ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
            activityManager.getMemoryInfo(mi);
            long availableMegs = mi.totalMem / 1048576L;
            setTextOfLabel(false, "RAM: " + availableMegs+" MB");

            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            setTextOfLabel(true, "\nDevice Screen Information:");
            setTextOfLabel(false, "heightPixels: " + metrics.heightPixels);
            setTextOfLabel(false, "widthPixels: " + metrics.widthPixels);

            setTextOfLabel(true, "\nOperating System:");
            setTextOfLabel(false, "Build release " + android.os.Build.VERSION.RELEASE + ", Inc: '" + android.os.Build.VERSION.INCREMENTAL + "'");
            setTextOfLabel(false, "Display build: " + android.os.Build.DISPLAY);
            setTextOfLabel(false, "Finger print: " + android.os.Build.FINGERPRINT);
            setTextOfLabel(false, "Build ID: " + android.os.Build.ID);
            setTextOfLabel(false, "Type: " + android.os.Build.TYPE);
            setTextOfLabel(false, "User: " + android.os.Build.USER);
            setTextOfLabel(true, "\nDensity:");

            //metrics = new DisplayMetrics();
            //getWindowManager().getDefaultDisplay().getMetrics(metrics);
            setTextOfLabel(false, "density: " + metrics.density);
            setTextOfLabel(false, "densityDpi: " + metrics.densityDpi);
            setTextOfLabel(false, "scaledDensity: " + metrics.scaledDensity);
            setTextOfLabel(false, "xdpi: " + metrics.xdpi);
            setTextOfLabel(false, "ydpi: " + metrics.ydpi);
            setTextOfLabel(true, "\nDensity reference:");
            setTextOfLabel(false, "DENSITY_DEFAULT: " + DisplayMetrics.DENSITY_DEFAULT);
            setTextOfLabel(false, "DENSITY_LOW: " + DisplayMetrics.DENSITY_LOW);
            setTextOfLabel(false, "DENSITY_MEDIUM: " + DisplayMetrics.DENSITY_MEDIUM);
            setTextOfLabel(false, "DENSITY_HIGH: " + DisplayMetrics.DENSITY_HIGH);

            setTextOfLabel(true, "\nDevice Screen Information:");
            setTextOfLabel(false, "heightPixels: " + metrics.heightPixels);
            setTextOfLabel(false, "widthPixels: " + metrics.widthPixels);
            setTextOfLabel(true, "\n\n\n\n");

        } catch (Exception e) {
            e.printStackTrace();
            setTextOfLabel(true, "Exception: " + e.toString());
        }
    }

    private void setTextOfLabel(boolean bold, String text) {
        TextView label = new TextView(this);
        label.setText(text);
        label.setTypeface(Typeface.DEFAULT, bold ? Typeface.BOLD : Typeface.NORMAL);
        mLayout.addView(label);
        mReport = mReport + "\n" + text;
    }
}
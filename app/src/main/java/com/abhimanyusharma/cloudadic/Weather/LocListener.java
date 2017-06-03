package com.abhimanyusharma.cloudadic.Weather;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by Abhimanyu Sharma on 03-06-2017.
 */

public class LocListener implements LocationListener {
    public static double lat;
    public static double lon;

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            LocListener.lat = location.getLatitude();

            LocListener.lon = location.getLongitude();

        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
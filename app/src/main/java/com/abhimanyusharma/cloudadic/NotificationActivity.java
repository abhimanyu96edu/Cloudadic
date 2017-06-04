package com.abhimanyusharma.cloudadic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {

    EditText inputField;
    Button launchNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        inputField = (EditText) findViewById(R.id.inputField);
        launchNotif = (Button) findViewById(R.id.notify);
        launchNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NotificationActivity.this);
                        mBuilder.setSmallIcon(R.drawable.icon_1d);
                        mBuilder.setContentTitle("Cloudadic Notification");
                        mBuilder.setContentText(inputField.getText().toString());
                        Notification notifcation = mBuilder.build();
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                        nm.notify(2, notifcation);

                    }
                }, 60000);

                Toast.makeText(NotificationActivity.this, "Notification SET", Toast.LENGTH_LONG).show();
                Toast.makeText(NotificationActivity.this, "Notification will Appear after 1 min", Toast.LENGTH_LONG).show();
                Intent i = new Intent(NotificationActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(NotificationActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }

}
package com.abhimanyusharma.cloudadic;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FacebookActivity extends AppCompatActivity {
    Button skip;
    CallbackManager callbackManager;

    AccessToken token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        skip = (Button) findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FacebookActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        token  = AccessToken.getCurrentAccessToken();
        if(token == null) {


            callbackManager = CallbackManager.Factory.create();

            LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    Intent i = new Intent(FacebookActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

                @Override
                public void onCancel() {

                    //RETRY SHOULD BE IMPLEMENTED HERE BUT FOR NOW LETS TAKE YOU TO MAIN ACTIVITY
                    Intent i = new Intent(FacebookActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

                @Override
                public void onError(FacebookException exception) {
                    //ERROR HANDLING SHOULD BE IMPLEMENTED HERE BUT FOR NOW LETS TAKE YOU TO MAIN ACTIVITY
                    Intent i = new Intent(FacebookActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }else
        {
            Intent i = new Intent(FacebookActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

package com.gabe.android.aca.snoozecamp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static com.gabe.android.aca.snoozecamp.R.id.logobutton;

public class LauncherScreen extends Activity  {
    Button mlogobutton;
    CallbackManager mcallbackManager;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());////////Added for Facebook SDK
        setContentView(R.layout.activity_launcher_screen);
        startButton();
        AppEventsLogger.activateApp(getApplicationContext());///////
        mcallbackManager = CallbackManager.Factory.create();
        LoginButton SCloginButton = (LoginButton) findViewById(R.id.login_button);
        SCloginButton.registerCallback(mcallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }

        });
    }



    public void startButton() {

        final Context context = this;

        mlogobutton = (Button) findViewById(logobutton);

        mlogobutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mcallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}


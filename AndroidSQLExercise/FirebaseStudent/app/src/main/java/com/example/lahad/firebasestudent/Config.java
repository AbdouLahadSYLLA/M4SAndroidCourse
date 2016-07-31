package com.example.lahad.firebasestudent;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by lahad on 31/07/2016.
 */
public class Config extends Application {

@Override
    public void onCreate(){
        super.onCreate();
        FirebaseAnalytics.getInstance(this);
    }
}

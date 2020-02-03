package com.example.softspacedesmond.androidfcm_version2.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService
{
//    @Override
//    public void onTokenRefresh()
//    {
//        super.onTokenRefresh();
//        sendNewTokenToServer(FirebaseInstanceId.getInstance().getToken());
//    }
//
//    private void sendNewTokenToServer(String token)
//    {
//        Log.d("Token", String.valueOf(token));
//    }

    private static final String TAG = "MyFirebaseInstanceIDService";

    @Override
    public void onTokenRefresh()
    {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token)
    {
        try
        {
            Log.d("Token", String.valueOf(token));
            Log.i("TOKEN: ", String.valueOf(token));
        }
        catch (Error error)
        {

        }
    }
}

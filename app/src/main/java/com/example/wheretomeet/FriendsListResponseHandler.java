package com.example.wheretomeet;

import android.content.Intent;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by 선희 on 2017-05-31.
 */

public class FriendsListResponseHandler extends AsyncHttpResponseHandler {

    private String value;
    LoginActivity activity;
    String appToken;

    public FriendsListResponseHandler(LoginActivity activity,String appToken) {
        this.activity=activity;
        this.appToken=appToken;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        value=new String(responseBody);

        Toast.makeText(activity, "Signed in", Toast.LENGTH_SHORT).show();

        Intent friends=new Intent(activity.getApplicationContext(),FriendsActivity.class);
        friends.putExtra("friends",value);
        friends.putExtra("appToken",appToken);
        activity.startActivity(friends);
        activity.finish();
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity, "Failed to get Friends List", Toast.LENGTH_SHORT).show();
    }

}

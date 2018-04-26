package com.abhisheksingh.ifbservices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginPage extends AppCompatActivity {
    DatabaseHelper login_credential;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        login_credential = new DatabaseHelper(this);
    }
}

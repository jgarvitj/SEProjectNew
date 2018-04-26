package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GuestPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button contact_us_btn,rate_us_btn;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_page);

        contact_us_btn = (Button)findViewById(R.id.contact_us_btn);
        rate_us_btn = (Button)findViewById(R.id.rate_us_btn);

        contact_us_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuestPage.this,ContactUsPage.class));
            }
        });
    }
}

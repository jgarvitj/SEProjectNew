package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdministratorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_page);
        Button assignCalls=findViewById(R.id.assignCalls_btn);
        Button billing=findViewById(R.id.billing_btn);
        Button logout=findViewById(R.id.logout_btn);
        assignCalls.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent( AdministratorPage.this, AssignCallsPage.class));
            }
        });
        billing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //startActivity(new Intent(FirstPage.this, AdministratorPage.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent( AdministratorPage.this, FirstPage.class));
            }
        });


    }
}

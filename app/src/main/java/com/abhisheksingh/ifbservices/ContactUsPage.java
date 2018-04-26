package com.abhisheksingh.ifbservices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class ContactUsPage extends AppCompatActivity {



    DatabaseHelperTask myDb;
    Spinner spinner;
    EditText editText;
    Button submit;
    int st;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_page);
        myDb = new DatabaseHelperTask(this);

        editText = (EditText)findViewById(R.id.editText);
        submit = (Button)findViewById(R.id.submit_btn);
        spinner = (Spinner)findViewById(R.id.spinner);
        String text=(String)spinner.getSelectedItem().toString();
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);
        addTask();
    }



        public void addTask()
        {
            submit.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Calendar rightNow = Calendar.getInstance();
                            st = rightNow.get(Calendar.HOUR_OF_DAY);
                            boolean isInserted = myDb.insertData(editText.getText().toString(), spinner.getTag().toString(), st, 0, 20);
                            if (isInserted)
                                Toast.makeText(ContactUsPage.this, "data inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(ContactUsPage.this, "data not inserted", Toast.LENGTH_LONG).show();
                        }
                    }
            );
        }
}

package com.example.ravi.cityassist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class dbactivity extends AppCompatActivity {

    TextView mytext;
    mydbhandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mytext = (TextView) findViewById(R.id.textView2);

    }

    public void printdatabase() {
        ArrayList<dbaccess> data = dbhandler.dbtostring();
        if (data != null) {
           // for (int i=0)
        dbaccess registration = data.get(data.size() - 1);
            StringBuilder build = new StringBuilder();
            for (int i=0;i<data.size();i++){
                build.append(data.get(i));
            }
        mytext.setText(build.toString());
        //Toast.makeText(Signuppage.this, registration.get_name(), Toast.LENGTH_LONG).show();
        // name.setText("");
        }
    }

}

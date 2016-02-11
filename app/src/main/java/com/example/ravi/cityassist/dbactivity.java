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

        dbhandler= new mydbhandler(this,null,null,1);
       // printdatabase();
    }
    public void clickme(View view){
        printdatabase();
    }

    public void printdatabase() {
        ArrayList<dbaccess> data;
       try{
      //  dbhandler = new mydbhandler();
          //  Toast.makeText(dbactivity.this,"yahan tak aaya",Toast.LENGTH_SHORT).show();
        data = dbhandler.dbtostring();
        //Toast.makeText(dbactivity.this, "fghh", Toast.LENGTH_LONG).show();
       // try{
        if (data != null) {
            // for (int i=0)
           dbaccess registration = data.get(data.size() - 1);
            StringBuilder build = new StringBuilder();
                build.append(registration.get_id());
            build.append(" ");
            build.append(registration.get_username());
            build.append(" ");
            build.append(registration.get_name());
            build.append(" ");
            build.append(registration.get_password());
            build.append(" ");
            build.append(registration.get_email());

            mytext.setText(build.toString());
        }
        }catch(Exception e){
           // Toast.makeText(dbactivity.this, "Mark idhar hain", Toast.LENGTH_LONG).show();
            }
        //Toast.makeText(Signuppage.this, registration.get_name(), Toast.LENGTH_LONG).show();
        // name.setText("");
      //  }
    }

}

package com.example.ravi.cityassist;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class signup_page extends AppCompatActivity {

    EditText username;
    EditText name;
    EditText age;
    EditText password;
    EditText email;
    mydbhandler handle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sign Up");

        username = (EditText)findViewById(R.id.editText3);
        name = (EditText)findViewById(R.id.editText4);
        age = (EditText)findViewById(R.id.editText5);
        password = (EditText)findViewById(R.id.editText6);
        email = (EditText)findViewById((R.id.editText7));
        handle= new mydbhandler(this,null,null,1);
    }

    public void signup(View view){
        dbaccess register = new dbaccess(username.getText().toString(),name.getText().toString(),Integer.parseInt(age.getText().toString()),password.getText().toString(),email.getText().toString());
      //handle.check();
          handle.dbadd(register);
       // Intent i = new Intent(this,MainActivity.class);
        //startActivity(i);
    }
    public void gotodbactivity(){
        Intent i = new Intent(this,dbactivity.class);
        startActivity(i);
    }

}

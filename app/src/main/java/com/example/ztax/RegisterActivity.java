package com.example.ztax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    SqlHelper sqlHelper;

    ArrayList<String> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View v){
        EditText unametxt = (EditText) findViewById(R.id.unamereg);
        EditText emailtxt = (EditText) findViewById(R.id.emailreg);
        EditText passtxt = (EditText) findViewById(R.id.passreg);
        EditText passtxt1 = (EditText) findViewById(R.id.pass1reg);
        String uname = unametxt.getText().toString();
        String email = emailtxt.getText().toString();
        String pass = passtxt.getText().toString();
        String pass1 = passtxt1.getText().toString();
        if(pass.equals(pass1)) {
            if (uname.equals("") || email.equals("") || pass.equals("")) {
                Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();

            } else {
                sqlHelper = new SqlHelper(this);
                if (sqlHelper.insertUsers(email, uname, pass)) {
                    Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Redirecting...", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(this, "Failed to register.", Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Redirecting...", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, RegisterActivity.class);
                    startActivity(i);
                }
            }
        }
        else {
            Toast.makeText(this,"The Two passwords do not match", Toast.LENGTH_LONG).show();
        }


    }
    public void loginRedirect(View v){
        Toast.makeText(this,"Redirecting...", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);

    }
}
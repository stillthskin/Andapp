package com.example.ztax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SqlHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void regRedirect(View v){
        Toast.makeText(this,"Redirecting...", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);

    }
    public void login(View v){
        EditText unametxt = (EditText) findViewById(R.id.uname);
        EditText passtxt = (EditText) findViewById(R.id.pass);
        String uname = unametxt.getText().toString();
        String pass = passtxt.getText().toString();
        if(uname.equals("") || pass.equals("")){
            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();
        }
        else {
            sqlHelper = new SqlHelper(this);

            if (sqlHelper.checkunamepassword(uname, pass)){
                if(uname.equalsIgnoreCase("admin")){
                    Toast.makeText(this,"Welcome Admin!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, Listviw.class);
                    i.putExtra("uname",uname);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(this, "Login success!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, MainActivity.class);
                    i.putExtra("uname", uname);
                    startActivity(i);
                    finish();
                }

            }
            else {

                Toast.makeText(this, "Username or password incorrect",Toast.LENGTH_LONG).show();
            }


        }




    }
}
package com.example.ztax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void loginRedirect(View v){
        Toast.makeText(this,"Redirecting...", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);

    }
}
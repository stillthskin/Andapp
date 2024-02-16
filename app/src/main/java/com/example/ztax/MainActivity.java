package com.example.ztax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent j = getIntent();
        String user = j.getStringExtra("uname");
        Toast.makeText(this,user, Toast.LENGTH_LONG).show();

        TextView welcome = findViewById(R.id.welcome);
        welcome.setText(user);
    }
    public void logoutAct(View v){
        Toast.makeText(this,"Redirecting...", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();

    }
    public void  genredirect(View v){
        if(v.getId()== R.id.drawerred){
            Toast.makeText(this,"Redirecting...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Drawenavi.class);
            startActivity(i);


        }
        if(v.getId()== R.id.tabred){
            Toast.makeText(this,"Redirecting...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Tabnavi.class);
            startActivity(i);


        }
        if(v.getId()== R.id.toolred){
            Toast.makeText(this,"Redirecting...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Tooltab.class);
            startActivity(i);


        }
        if(v.getId()== R.id.qrred){
            Toast.makeText(this,"Redirecting...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Qrread.class);
            startActivity(i);


        }
        if(v.getId()== R.id.listviw){
            Toast.makeText(this,"Redirecting...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Listviw.class);
            startActivity(i);


        }

    }
}
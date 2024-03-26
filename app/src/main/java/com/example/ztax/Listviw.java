package com.example.ztax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Listviw extends AppCompatActivity {
RecyclerView recyclerView;
SqlHelper sqlHelper;
List<User> db_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviw);
        List<MyUser> users = new ArrayList<>();
try {

    sqlHelper = new SqlHelper(this);
    db_user = sqlHelper.getUsers();
    System.out.println(db_user);
    for (User i : db_user){
        users.add(new MyUser(i.ussername+" Password~: "+i.password, i.email, R.drawable.account));
    }

    Toast.makeText(this, "Users: "+db_user.size(),Toast.LENGTH_LONG).show();
}
catch (Exception e){
    Toast.makeText(this,"Unknown Error!"+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
    System.out.println("Unknown error!"+e.getLocalizedMessage());
}
        recyclerView = findViewById(R.id.userlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserViewAdapter(getApplicationContext(),users));
    }
}
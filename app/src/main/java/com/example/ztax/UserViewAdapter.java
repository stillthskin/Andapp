package com.example.ztax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewHolder> {


    Context context;
    List<MyUser> users;

    public UserViewAdapter(Context context, List<MyUser> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.user_template,parent,false);
        UserViewHolder userViewHolder = new UserViewHolder(v);
        context = parent.getContext();
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        SqlHelper sqlHelper = new SqlHelper(context);
        holder.utextview.setText(users.get(position).getName());
        holder.etextview.setText(users.get(position).getEmail());
        holder.imageView.setImageResource(users.get(position).getImage());
        holder.rmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = holder.utextview.getText().toString();
                sqlHelper.removeUser(value);
                Toast.makeText(context, "Removed"+value,Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

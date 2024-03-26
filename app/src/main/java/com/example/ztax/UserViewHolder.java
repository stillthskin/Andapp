package com.example.ztax;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView utextview, etextview;
    Button rmButton;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.profileImg);
        utextview = itemView.findViewById(R.id.username);
        etextview = itemView.findViewById(R.id.useremail);
        rmButton = itemView.findViewById(R.id.userRmButton);

    }
}

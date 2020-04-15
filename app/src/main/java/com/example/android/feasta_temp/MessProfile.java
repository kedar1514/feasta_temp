package com.example.android.feasta_temp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MessProfile extends AppCompatActivity {
    TextView mMessName;
    ImageView mMessImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mess_profile);

        mMessName =(TextView) findViewById(R.id.mess_name);
        mMessImage = (ImageView) findViewById(R.id.mess_profile);

        Intent i = getIntent();
        String messName = i.getStringExtra("mess_name");
        String messIamge = i.getStringExtra("mess_image");
        mMessName.setText(messName);
        Glide.with(this).load(messIamge).into(mMessImage);

    }
}

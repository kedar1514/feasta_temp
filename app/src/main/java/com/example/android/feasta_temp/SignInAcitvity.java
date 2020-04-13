package com.example.android.feasta_temp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignInAcitvity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        Button btnSignInEnter;
        btnSignInEnter = findViewById(R.id.btnSignInEnter);
        btnSignInEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInEnter = new Intent(SignInAcitvity.this,MainActivity.class);
                startActivity(signInEnter);
            }
        });
    }
}

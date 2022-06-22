package com.example.chatapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class NewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        RelativeLayout page = findViewById(R.id.pageLogin);
        TextView sigh = findViewById(R.id.login_txt);
        TextView username= findViewById(R.id.username);
        TextView password= findViewById(R.id.password);
        MaterialButton login_btn = (MaterialButton) findViewById(R.id.login_btn);
        TextView reg = (TextView) findViewById(R.id.sigh_up);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewUser.this, MainActivity.class);
                startActivity(intent);
            }
        });


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                Toast.makeText(NewUser.this, "Great!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NewUser.this, ContactList.class);
                startActivity(intent);
            }
        });
    }
}

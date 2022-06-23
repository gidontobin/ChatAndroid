package com.example.chatapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class AddContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        RelativeLayout page = findViewById(R.id.pageLogin);
        TextView sigh = findViewById(R.id.login_txt);
        TextView username= findViewById(R.id.username);
        TextView server= findViewById(R.id.server);
        MaterialButton login_btn = (MaterialButton) findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddContact.this, "Great!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddContact.this, ContactList.class);
                intent.putExtra("contact_name", username.getText().toString());
                startActivity(intent);
            }
        });
    }
}
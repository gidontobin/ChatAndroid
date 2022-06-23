package com.example.chatapp4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalTime;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contact_Chat extends AppCompatActivity { //implements RoomListener {

    private EditText editText;
    private MessageAdapter messageAdapter;
    private ListView messagesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_chat);
        Intent intent=getIntent();
        String contact_name = intent.getStringExtra("contact_name");
        Integer contact_img = intent.getIntExtra("contact_img",0);

        ImageView imageView = (ImageView) findViewById(R.id.img);
        imageView.setImageResource(contact_img);
        TextView textNameView = (TextView) findViewById(R.id.char_cur);
        textNameView.setText(contact_name);

        editText = (EditText) findViewById(R.id.editText);
        messageAdapter = new MessageAdapter(this);
        messagesView = (ListView) findViewById(R.id.messages_view);
        messagesView.setAdapter(messageAdapter);
        messageAdapter.add(new Message("How Are You?", "2:05:52", false));

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void sendMessage(View view) {
        String message = editText.getText().toString();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();


        if (message.length() > 0) {
            messageAdapter.add(new Message(message, dtf.format(localTime), true));
            editText.getText().clear();
        }
    }
}

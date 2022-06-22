package com.example.chatapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {
    //private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    ListView list;
    String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    } ;
    Integer[] imageId = {
            R.drawable.wa,
            R.drawable.wa,
            R.drawable.wa,
            R.drawable.wa,
            R.drawable.wa,
            R.drawable.wa,
            R.drawable.wa
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        CustomList adapter = new
                CustomList(ContactList.this, web, imageId);
        list=(ListView)findViewById(R.id.contact_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ContactList.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ContactList.this, Contact_Chat.class);
                intent.putExtra("contact_name", web[+ position]);
                intent.putExtra("contact_img", imageId[+ position]);
                startActivity(intent);

            }
        });
    }
}
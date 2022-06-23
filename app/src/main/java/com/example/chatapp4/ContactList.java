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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {
    //private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    ListView list;
    ArrayList<String> web = new ArrayList<String>();
    ArrayList<Integer> imageId = new ArrayList<Integer>();

    /*
    Integer[] imageId = {
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24
    };
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        web.add("Aaron");
        web.add("Aaron");
        web.add("Aaron");
        web.add("Aaron");
        web.add("Aaron");
        web.add("Aaron");
        web.add("Aaron");
        web.add("Aaron");
        web.add("Aaron");
        web.add("Aaron");
        web.add("Aaron");
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        imageId.add(R.drawable.ic_baseline_person_24);
        Intent intentF=getIntent();
        String contact_name = intentF.getStringExtra("contact_name");
        if (contact_name!=null){
            web.add(contact_name);
            imageId.add(R.drawable.ic_baseline_person_24);
        }
        CustomList adapter = new
                CustomList(ContactList.this, web, imageId);
        list=(ListView)findViewById(R.id.contact_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ContactList.this, "You Clicked at " + web.get(+position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ContactList.this, Contact_Chat.class);
                intent.putExtra("contact_name", web.get(+position));
                intent.putExtra("contact_img", imageId.get(+position));
                startActivity(intent);

            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactList.this, AddContact.class);
                startActivity(intent);
            }
        });
    }

}
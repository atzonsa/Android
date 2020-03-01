package com.example.sandbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.LinkedList;

public class ContextMenu extends AppCompatActivity {

    ListView lvContacts;

    LinkedList<String> ll = new LinkedList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        androidx.appcompat.widget.Toolbar toolbar =  findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        ll.add("Ajay");
        ll.add("Amit");
        ll.add("Nishant");
        ll.add("Dipal");
        ll.add("Amar");
        ll.add("Paul");
        ll.add("Tim");
        ll.add("Tom");
        ll.add("Lion");
        ll.add("Parakh");

        lvContacts = findViewById(R.id.lvContacts);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ll);
        lvContacts.setAdapter(adapter);
        registerForContextMenu(lvContacts);
    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenuresourse, menu);
        menu.setHeaderTitle("Select The Action");
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.cmCall)
        {
            Intent callNow = new Intent(Intent.ACTION_CALL);
            callNow.setData(Uri.parse("tel:9968229099"));
            //startActivity(callNow);
            return true;
        }
        else
            return super.onContextItemSelected(item);

    }
}

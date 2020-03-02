package com.example.sandbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class OptionMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        androidx.appcompat.widget.Toolbar toolbar =  findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.mnuSetting) {
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.mnuContact) {
            Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.mnuLogin) {
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.mnuRegister) {
            Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.mnuMore) {
            Toast.makeText(this, "More", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.m1) {
            Toast.makeText(this, "More 1", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.m2) {
            Toast.makeText(this, "More 2", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.m3) {
            Toast.makeText(this, "More 3", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}
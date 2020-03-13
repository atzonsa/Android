package com.example.sandbox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

import android.content.ContentValues;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;

public class RingtoneBasic extends AppCompatActivity {

    Button btnChangeRingtone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringtone_basic);

        btnChangeRingtone = findViewById(R.id.btnChangeRingtone);
        btnChangeRingtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/*,video/*");
                startActivityForResult(Intent.createChooser(intent, "Select Ringtone"), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                RingtoneManager.setActualDefaultRingtoneUri(
                        this,
                        RingtoneManager.TYPE_RINGTONE,
                        data.getData()
                );

                //Snackbar.make((View)RingtoneBasic.this.getApplicationContext(), "Ringtone changed successfully", Snackbar.LENGTH_SHORT).show();
                Toast.makeText(RingtoneBasic.this, "Ringtone changed successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
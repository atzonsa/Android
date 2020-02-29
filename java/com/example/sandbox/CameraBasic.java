package com.example.sandbox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraBasic extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;

    Button btnTakePhoto;
    ImageView imgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_basic);

        btnTakePhoto = findViewById(R.id.btnTakePhoto);
        imgV = findViewById(R.id.imgV);

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST)
        {
            Bitmap photo = (Bitmap)data.getExtras().get("data");
            imgV.setImageBitmap(photo);

            File f=new File("myphoto.jpg");
            try {
                f.createNewFile();
                FileOutputStream out=new FileOutputStream(f);
                out.write(photo.getRowBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
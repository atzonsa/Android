package com.example.sandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ShareDataAnotherApp extends AppCompatActivity {
    EditText txtSubject, txtShareData, txtShareTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_data_another_app);

        txtSubject = findViewById(R.id.txtSubject);
        txtShareData = findViewById(R.id.txtShareData);
        txtShareTitle = findViewById(R.id.txtShareTitle);
    }

    public void shareApp(View v)
    {
        String subject = txtSubject.getText().toString();
        String shareData = txtShareData.getText().toString();
        String shareTitle = txtShareTitle.getText().toString();

        if (subject.equals(""))
        {
            Toast.makeText(ShareDataAnotherApp.this, "Please enter subject", Toast.LENGTH_SHORT).show();
            txtSubject.requestFocus();
        }
        else if (shareData.equals(""))
        {
            Toast.makeText(ShareDataAnotherApp.this, "Please enter what to share", Toast.LENGTH_SHORT).show();
            txtShareData.requestFocus();
        }
        else if (shareTitle.equals(""))
        {
            Toast.makeText(ShareDataAnotherApp.this, "Please enter share title", Toast.LENGTH_SHORT).show();
            txtShareTitle.requestFocus();
        }
        else
        {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            String appURL = shareData;
            shareIntent.putExtra(Intent.EXTRA_TEXT, appURL);
            startActivity(Intent.createChooser(shareIntent, shareTitle));
        }
    }
}

package com.example.sandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    EditText txtTitle, txtMessage, txtPositive, txtNegative;
    RadioButton rbCancelable, rbNonCancelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        txtTitle = findViewById(R.id.txtTitle);
        txtMessage = findViewById(R.id.txtMessage);
        txtPositive = findViewById(R.id.txtPositive);
        txtNegative = findViewById(R.id.txtNegative);
        rbCancelable = findViewById(R.id.rbCancelable);
        rbNonCancelable = findViewById(R.id.rbNonCancelable);
    }

    public void showAlertDialog(View v)
    {
        String title = txtTitle.getText().toString();
        String message = txtMessage.getText().toString();
        String positive = txtPositive.getText().toString();
        String negative = txtNegative.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (title.equals(""))
        {
            Toast.makeText(AlertDialogActivity.this, R.string.TitleIsRequired, Toast.LENGTH_SHORT).show();
            txtTitle.requestFocus();
        }
        else if (message.equals(""))
        {
            Toast.makeText(AlertDialogActivity.this, R.string.MessageIsRequired, Toast.LENGTH_SHORT).show();
            txtMessage.requestFocus();
        }
        else if (positive.equals(""))
        {
            Toast.makeText(AlertDialogActivity.this, R.string.PositiveButtonTitleIsRequired, Toast.LENGTH_SHORT).show();
            txtPositive.requestFocus();
        }
        else if (negative.equals(""))
        {
            Toast.makeText(AlertDialogActivity.this, R.string.NegativeButtonTitleIsRequired, Toast.LENGTH_SHORT).show();
            txtNegative.requestFocus();
        }
        else
        {
            builder.setTitle(title);
            builder.setMessage(message);
            builder.setCancelable(rbCancelable.isChecked());

            builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    System.out.println(id);
                }
            });

            builder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    System.out.println(id);
                }
            });

            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
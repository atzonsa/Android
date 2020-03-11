package com.example.sandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleCalculation extends AppCompatActivity {
    Button btnPlus,btnMinus,btnMultiply,btnDivide;
    TextView lblResult;
    EditText txtValue1,txtValue2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculation);



        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        txtValue1 = findViewById(R.id.txtValue1);
        txtValue2 = findViewById(R.id.txtValue2);

        Bundle values = getIntent().getExtras();

        txtValue1.setText(values.getString("val1"));
        txtValue2.setText(values.getString("val2"));

        lblResult = findViewById(R.id.lblResult);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i1=Integer.parseInt(txtValue1.getText().toString());

                int i2=Integer.parseInt(txtValue2.getText().toString());
                Toast.makeText(SimpleCalculation.this, ""+(i1+i2), Toast.LENGTH_SHORT).show();
                lblResult.setText(""+(i1+i2));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i1=Integer.parseInt(txtValue1.getText().toString());

                int i2=Integer.parseInt(txtValue2.getText().toString());
                Toast.makeText(SimpleCalculation.this, ""+(i1-i2), Toast.LENGTH_SHORT).show();
                lblResult.setText(""+(i1-i2));
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i1=Integer.parseInt(txtValue1.getText().toString());

                int i2=Integer.parseInt(txtValue2.getText().toString());
                Toast.makeText(SimpleCalculation.this, ""+(i1*i2), Toast.LENGTH_SHORT).show();
                lblResult.setText(""+(i1*i2));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i1=Integer.parseInt(txtValue1.getText().toString());

                int i2=Integer.parseInt(txtValue2.getText().toString());
                Toast.makeText(SimpleCalculation.this, ""+(i1/i2), Toast.LENGTH_SHORT).show();
                lblResult.setText(""+(i1/i2));
            }
        });
    }
}

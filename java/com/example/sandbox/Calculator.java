package com.example.sandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    TextView lblValue, lblEquations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        lblValue = findViewById(R.id.lblValue);
        lblEquations = findViewById(R.id.lblEquations);
    }

    public void btnPercentage_clicked(View v)
    {
        DigitPressed("%");
    }

    public void btnOne_clicked(View v)
    {
        DigitPressed("1");
    }

    public void btnTwo_clicked(View v)
    {
        DigitPressed("2");
    }

    public void btnThree_clicked(View v)
    {
        DigitPressed("3");
    }

    public void btnFour_clicked(View v)
    {
        DigitPressed("4");
    }

    public void btnFive_clicked(View v)
    {
        DigitPressed("5");
    }

    public void btnSix_clicked(View v)
    {
        DigitPressed("6");
    }

    public void btnSeven_clicked(View v)
    {
        DigitPressed("7");
    }

    public void btnEight_clicked(View v)
    {
        DigitPressed("8");
    }

    public void btnNine_clicked(View v)
    {
        DigitPressed("9");
    }

    public void btnZero_clicked(View v)
    {
        DigitPressed("0");
    }

    public void btnDecimal_clicked(View v)
    {
        DigitPressed(".");
    }

    public void btnPlus_clicked(View v)
    {
        DigitPressed("+");
    }

    public void btnMinus_clicked(View v)
    {
        DigitPressed("-");
    }

    public void btnMultiply_clicked(View v)
    {
        DigitPressed("*");
    }

    public void btnDivide_clicked(View v)
    {
        DigitPressed("/");
    }

    public void btnEqual_clicked(View v)
    {
        DigitPressed("Enter");
    }

    public void btnDelete_clicked(View v)
    {
        DigitPressed("BackSpace");
    }

    public void btnMR_clicked(View v)
    {
        DigitPressed("MR");
    }

    public void btnMC_clicked(View v)
    {
        DigitPressed("MC");
    }

    public void btnMPlus_clicked(View v)
    {
        DigitPressed("M+");
    }

    public void btnMMinus_clicked(View v)
    {
        DigitPressed("M-");
    }

    public void btnMS_clicked(View v)
    {
        DigitPressed("MS");
    }

    public void btnM_clicked(View v)
    {
        DigitPressed("M");
    }

    public void btnCE_clicked(View v)
    {
        Clear();
    }

    public void btnC_clicked(View v)
    {
        Clear();
    }

    public void btnX2_clicked(View v)
    {
        DigitPressed("X2");
    }

    public void btnOneX_clicked(View v)
    {
        DigitPressed("OneX");
    }

    public void btnRoot_clicked(View v)
    {
        DigitPressed("Root");
    }

    ArrayList<String> listValues = new ArrayList();
    ArrayList<String> listOperators = new ArrayList();

    void DigitPressed(String digit)
    {
        if (digit == "." && lblValue.getText().toString().contains("."))
        {
            return;
        }
        else if (digit == "+" && lblValue.getText().length() > 0)
        {
            if (lblValue.getText() != "0")
            {
                listValues.add(lblValue.getText().toString());
                listOperators.add("+");
                lblValue.setText("0");
            }
        }
        else if (digit == "-" && lblValue.getText().length() > 0)
        {
            if (lblValue.getText() != "0")
            {
                listValues.add(lblValue.getText().toString());
                listOperators.add("-");
                lblValue.setText("0");
            }
        }
        else if (digit == "*" && lblValue.getText().length() > 0)
        {
            if (lblValue.getText() != "0")
            {
                listValues.add(lblValue.getText().toString());
                listOperators.add("*");
                lblValue.setText("0");
            }
        }
        else if (digit == "/" && lblValue.getText().length() > 0)
        {
            if (lblValue.getText() != "0")
            {
                listValues.add(lblValue.getText().toString());
                listOperators.add("/");
                lblValue.setText("0");
            }
        }
        else if (digit == "Enter")
        {
            Calculate();
        }
        else if (digit == "BackSpace")
        {
            if (lblValue.getText().length() == 1)
            {
                lblValue.setText("0");
            }
            else if (lblValue.getText().length() > 0)
            {
                lblValue.setText(lblValue.getText().toString().substring(0, lblValue.getText().length()-1));
            }
        }
        else if (lblValue.getText() == "0" && digit != "BackSpace")
        {
            lblValue.setText(digit);
        }
        else
        {
            lblValue.setText(lblValue.getText()+digit);
        }

        if (lblValue.getText().length() <= 12)
            lblValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 48);
            //lblValue.setFont(new Font("Arial", Font.BOLD, 48));
        else if (lblValue.getText().length() > 12 && lblValue.getText().length() <= 18)
            lblValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 36);
            //lblValue.setFont(new Font("Arial", Font.BOLD, 36));
        else if (lblValue.getText().length() > 18 && lblValue.getText().length() <= 30)
            lblValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
            //lblValue.setFont(new Font("Arial", Font.BOLD, 24));
        else if (lblValue.getText().length() > 30 && lblValue.getText().length() <= 50)
            lblValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            //lblValue.setFont(new Font("Arial", Font.BOLD, 18));
        else if (lblValue.getText().length() > 30)
            lblValue.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            //lblValue.setFont(new Font("Arial", Font.BOLD, 12));

        SetEquations();
    }

    void SetEquations()
    {
        String equation = "";
        for (int i=0;i<listValues.size();i++)
            equation = equation + listValues.get(i) + " " + listOperators.get(i) + " ";

        lblEquations.setText(equation);
    }

    void Calculate()
    {
        double result = 0;

        for (int i=0;i<listValues.size();i++)
        {
            if (listOperators.get(i) == "+")
                result += Float.parseFloat(listValues.get(i));
            else if (listOperators.get(i) == "-")
                result -= Float.parseFloat(listValues.get(i));
            else if (listOperators.get(i) == "*")
                result *= Float.parseFloat(listValues.get(i));
            else if (listOperators.get(i) == "/")
                result /= Float.parseFloat(listValues.get(i));
        }

        listValues.clear();
        listOperators.clear();

        lblValue.setText(""+ Math.round(result));
        lblEquations.setText("");
    }

    void Clear()
    {
        lblValue.setText("0");
        lblEquations.setText("");

        listValues.clear();
        listOperators.clear();
    }
}
package com.example.sandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class BluetoothBasic extends AppCompatActivity {

    TextView lblPaired;
    Button btnEnable, btnDisable, btnDiscoverable;
    BluetoothAdapter mBluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_basic);

        btnEnable = findViewById(R.id.btnEnable);
        btnDiscoverable = findViewById(R.id.btnDiscoverable);
        btnDisable = findViewById(R.id.btnDisable);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter == null) {
            System.out.append("device not supported");
        }

        btnEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBluetoothAdapter.isEnabled())
                {
                    Toast.makeText(getApplicationContext(), "Enabling blueTooth", Toast.LENGTH_SHORT).show();

                    Intent enableBlueTooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBlueTooth, 0);
                }
            }
        });

        btnDiscoverable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBluetoothAdapter.isDiscovering())
                {
                    Toast.makeText(getApplicationContext(), "Making blueTooth discoverable", Toast.LENGTH_SHORT).show();

                    Intent discoverBlueTooth = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(discoverBlueTooth, 0);
                }
            }
        });

        btnDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBluetoothAdapter.disable();
                Toast.makeText(getApplicationContext(), "BlueTooth disabled", Toast.LENGTH_SHORT).show();
            }
        });

        lblPaired = findViewById(R.id.lblPaired);

        Intent enableBlueTooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableBlueTooth, 0);

        Set<BluetoothDevice> devices = mBluetoothAdapter.getBondedDevices();

        if (devices.size() > 0)
        {
            for (BluetoothDevice d : devices) {
                lblPaired.setText(d.getName() + " device /n");
            }
        }
        else
        {
            Toast.makeText(this, "No devices paired", Toast.LENGTH_SHORT).show();
        }
    }
}

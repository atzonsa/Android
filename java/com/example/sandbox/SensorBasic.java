package com.example.sandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SensorBasic extends AppCompatActivity {
    SensorManager sm = null;

    ListView listView;

    TextView lblAccelerometer = null;
    List listAccelerometer;

    TextView lblGravity = null;
    List listGravity;

    TextView lblGyroscope = null;
    List listGyroscope;

    TextView lblRotationVector = null;
    List listRotationVector;

    TextView lblStepCounter = null;
    List listStepCounter;

    List<Sensor> sensorList;

    SensorEventListener selAccelerometer = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            lblAccelerometer.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
        }
    };

    SensorEventListener selGravity = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            lblGravity.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
        }
    };

    SensorEventListener selGyroscope = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            lblGyroscope.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
        }
    };

    SensorEventListener selRotationVector = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            lblRotationVector.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]+"\n((cos(θ/2)): "+values[3]);
        }
    };

    SensorEventListener selStepCounter = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            lblStepCounter.setText("Steps: "+values[0]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_basic);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        listView = findViewById(R.id.listView);

        lblAccelerometer = (TextView)findViewById(R.id.lblAccelerometer);
        listAccelerometer = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if(listAccelerometer.size()>0){
            sm.registerListener(selAccelerometer, (Sensor) listAccelerometer.get(0), SensorManager.SENSOR_DELAY_UI);
        }else{
            lblAccelerometer.setText("Error: No Accelerometer.");
        }

        lblGravity = (TextView)findViewById(R.id.lblGravity);
        listGravity = sm.getSensorList(Sensor.TYPE_GRAVITY);
        if(listGravity.size()>0){
            sm.registerListener(selGravity, (Sensor) listGravity.get(0), SensorManager.SENSOR_DELAY_UI);
        }else{
            lblGravity.setText("Error: No Gravity Sensor.");
        }

        lblGyroscope = (TextView)findViewById(R.id.lblGyroscope);
        listGyroscope = sm.getSensorList(Sensor.TYPE_GYROSCOPE);
        if(listGyroscope.size()>0){
            sm.registerListener(selGyroscope, (Sensor) listGyroscope.get(0), SensorManager.SENSOR_DELAY_UI);
        }else{
            lblGyroscope.setText("Error: No Gyroscope.");
        }

        lblRotationVector = (TextView)findViewById(R.id.lblRotationVector);
        listRotationVector = sm.getSensorList(Sensor.TYPE_ROTATION_VECTOR);
        if(listRotationVector.size()>0){
            sm.registerListener(selRotationVector, (Sensor) listRotationVector.get(0), SensorManager.SENSOR_DELAY_UI);
        }else{
            lblGyroscope.setText("Error: No Rotation Vector.");
        }

        lblStepCounter = (TextView)findViewById(R.id.lblStepCounter);
        listStepCounter = sm.getSensorList(Sensor.TYPE_STEP_COUNTER);
        if(listStepCounter.size()>0){
            sm.registerListener(selStepCounter, (Sensor) listStepCounter.get(0), SensorManager.SENSOR_DELAY_UI);
        }else{
            lblStepCounter.setText("Error: No Step Counter.");
        }

        sensorList = sm.getSensorList(Sensor.TYPE_ALL);
        ArrayAdapter<Sensor> arrayAdapter= new ArrayAdapter<Sensor>(this,android.R.layout.simple_list_item_1, sensorList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(listAccelerometer.size()>0){
            sm.unregisterListener(selAccelerometer);
        }

        if(listGravity.size()>0){
            sm.unregisterListener(selGravity);
        }

        if(listGyroscope.size()>0){
            sm.unregisterListener(selGyroscope);
        }

        if(listRotationVector.size()>0){
            sm.unregisterListener(selRotationVector);
        }

        if(listStepCounter.size()>0){
            sm.unregisterListener(selStepCounter);
        }
    }
}
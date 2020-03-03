package com.example.sandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class TextToSpeechBasic extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech tts;
    Spinner spLanguage, spSpeed;
    EditText txtText;
    Button btnSpeak;

    String[] languages;
    String speed="Normal";

    String[] speedOptions = {"Very Slow", "Slow", "Normal", "Fast", "Very Fast"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech_basic);

        tts = new TextToSpeech(this, this);

        spLanguage = findViewById(R.id.spLanguage);
        spSpeed = findViewById(R.id.spSpeed);
        txtText = findViewById(R.id.txtText);
        btnSpeak = findViewById(R.id.btnSpeak);

        Locale[] locales = Locale.getAvailableLocales();

        Set<String> localcountries=new HashSet<String>();
        for(Locale l:locales)
            localcountries.add(l.getDisplayLanguage().toString());

        languages=(String[]) localcountries.toArray(new String[localcountries.size()]);

        /*StringBuilder sb = new StringBuilder();

        for (String st: languages)
        {
            sb.append(st);
        }

        Toast.makeText(this, ""+sb.toString(), Toast.LENGTH_LONG).show();*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spLanguage.setAdapter(adapter);

        spLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Locale l = new Locale(languages[position]);
                tts.setLanguage(l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapterSpeed = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, speedOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpeed.setAdapter(adapterSpeed);

        spSpeed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                speed = speedOptions[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSpeed();
                speak();
            }
        });
    }

    void setSpeed()
    {
        if (speed.equals("Very Slow"))
            tts.setSpeechRate(0.1f);
        else if (speed.equals("Slow"))
            tts.setSpeechRate(0.5f);
        else if (speed.equals("Normal"))
            tts.setSpeechRate(1.0f);
        else if (speed.equals("Fast"))
            tts.setSpeechRate(1.5f);
        else if (speed.equals("Very Fast"))
            tts.setSpeechRate(2.0f);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS)
        {
            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA ||
                result == TextToSpeech.LANG_NOT_SUPPORTED)
            {
                btnSpeak.setEnabled(false);
                Log.e("TTS", "Language is not Supported");
            }
            else
            {
                btnSpeak.setEnabled(true);
            }
        }
    }

    /*@Override
    protected void onDestroy() {
        *//*if (tts != null)
        {
            tts.stop();
            tts.shutdown();
        }*//*

        //super.onDestroy();
    }*/

    void speak(){
        String text = txtText.getText().toString();

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}

package com.example.mapscanactuallygodye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WildLifeSubmissions extends AppCompatActivity {
    public static void appendStrToFile(String fileName, String str)
    {
        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }
    String fullLat;
    String fullLng;
    String animal;
    String detect;
    String stringanimals;
    String stringlatitudes;
    String stringlongitudes;
    String stringdates;


    List animalTypes = new ArrayList();
    private String file = "animalTypes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild_life_submissions);





    Intent intent = getIntent();

        fullLat = intent.getStringExtra("LAT");
        fullLng = intent.getStringExtra("LNG");
        stringanimals = intent.getStringExtra("ANIMALS");
        stringlatitudes = intent.getStringExtra("LATITUDES");
        stringlongitudes = intent.getStringExtra("LONGITUDES");
        stringdates = intent.getStringExtra("DATES");


        final EditText animalInput = (EditText) findViewById(R.id.animalInput);



        TextView latInput = (TextView) findViewById(R.id.latInput);
        latInput.setText(fullLat);

        TextView lngInput = (TextView) findViewById(R.id.lngInput);
        lngInput.setText(fullLng);

        Button submitSighting = (Button) findViewById(R.id.submitSighting);
        submitSighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MapsActivity.class);
                java.util.Date date = new java.util.Date();
                detect = "1";
                animal = animalInput.getText().toString();
                startIntent.putExtra("ANIMAL", animal);
                startIntent.putExtra("TIME", date.toString());
                startIntent.putExtra("DETECT", detect);
                startIntent.putExtra("LAT", fullLat);
                startIntent.putExtra("LNG", fullLng);
                //show how to pass information to another activity
                startActivity(startIntent);

            }
        });








    }
}

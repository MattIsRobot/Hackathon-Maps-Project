package com.example.mapscanactuallygodye;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InfoScreen extends AppCompatActivity {

    public String park;
    public double rating;
    public String parkId;
    public double reviewInput;

    public List fleuryReviews = new ArrayList();
    public List machellReviews = new ArrayList();
    public List townReviews = new ArrayList();
    public List confederationReviews = new ArrayList();
    public List coplandReviews = new ArrayList();
    public List summitReviews = new ArrayList();
    public List hicksonReviews = new ArrayList();
    public List vandorfReviews = new ArrayList();
    public List sheppardsReviews = new ArrayList();
    public List adaReviews = new ArrayList();
    public List atkinsonReviews = new ArrayList();
    public List woodlotReviews = new ArrayList();
    public List craddockReviews = new ArrayList();
    public List elizabethReviews = new ArrayList();
    public List highlandReviews = new ArrayList();
    public List jamesReviews = new ArrayList();
    public List lambertReviews = new ArrayList();
    public List normReviews = new ArrayList();
    public List stewartReviews = new ArrayList();
    public List thomasReviews = new ArrayList();
    public double total;
    public String file;
    public List vals = new ArrayList();
    public String result_;
    public String placeholder;
    public String temp;
    public double original;
    public double modified;
    public File currfile = new File("FleuryPark");
    public String updatedFile;
    public String finaloutput;
    public int convertdouble;
    public int numbers;
    public String desc;



    public void saveFile(String file, int entries, double average){
        try {
            FileOutputStream out = openFileOutput(file, Context.MODE_PRIVATE);
            finaloutput = entries + " " + average;
            System.out.println("THIS IS THE FINAL OUTPUT: " + finaloutput);
            out.write(finaloutput.getBytes());
            out.close();
        }
        catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
    }

    public String readFile(String file) {
        try {
            FileInputStream fIn = openFileInput(file);
            int c;
            temp = "";

            while ((c = fIn.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            //Make stuff equal output here

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);

        Intent intent = getIntent();
        park = intent.getStringExtra("PARK");
        desc = intent.getStringExtra("DESC");

        vals.clear();

        final TextView parkName = (TextView) findViewById(R.id.parkName);
        parkName.setText(park);
        final TextView description = (TextView) findViewById(R.id.DsecBox);
        description.setText(desc);



        final TextView reviewText = (TextView) findViewById(R.id.reviewText);
        final EditText reviewEditText = (EditText) findViewById(R.id.reviewEditText);
        Button submitReviewButton = (Button) findViewById(R.id.submitReviewButton);

        Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream out = openFileOutput("FleuryPark", Context.MODE_PRIVATE);
                    finaloutput = "";
                    out.write(finaloutput.getBytes());
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception Occurred" + e);
                }


            }
        });

        submitReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reviewEditText.getText().toString().equals("")){
                    reviewText.setText("Please enter a number");
                }
                else {
                    reviewInput = Double.parseDouble(reviewEditText.getText().toString());
                    parkId = parkName.getText().toString();
                    if (reviewInput <= 5) {
                        if (parkId.equals("Fleury Park")) {
                                try {
                                    if (currfile.createNewFile())
                                    {
                                        System.out.println("File is created!");
                                        try {
                                            FileOutputStream out = openFileOutput("FleuryPark", Context.MODE_PRIVATE);
                                            String printer = "";
                                            System.out.println("PRINTER =" + printer);
                                            out.write(printer.getBytes());
                                            out.close();
                                        }
                                        catch (IOException e) {
                                            System.out.println("Exception Occurred" + e);
                                        }
                                    } else {
                                        System.out.println("File already exists.");
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            updatedFile = readFile("FleuryPark");
                                System.out.println("THIS IS THE UPDATES FILE: " + updatedFile);
                                System.out.println(vals);
                            vals = new ArrayList(Arrays.asList(updatedFile.split(" ")));
                            System.out.println("CURRENT VALS ARRAY" + vals);
                            if(vals.size() == 1){
                                vals.add(reviewInput);
                            }
                            if(vals.get(0) == ""){
                                System.out.println("IN HERE");
                                vals.set(0, 1);
                                reviewText.setText(Double.toString(reviewInput));
                                saveFile("FleuryPark", 1, reviewInput);
                            }
                            else{
                                original = Integer.parseInt((String)vals.get(0)) * Double.parseDouble((String)vals.get(1));
                                System.out.println("ORIGINAL: " + original);
                                modified = original + reviewInput;
                                System.out.println("MODIFIED: " + modified);
                                numbers = (int) Math.round(Double.parseDouble((String)vals.get(0)));
                                numbers = numbers + 1;
                                vals.set(1, modified/numbers);
                                System.out.println("VALS MEAN: "+ vals.get(1));
                                vals.set(0, (Double.parseDouble((String)vals.get(0) + 1)));
                                System.out.println("VALS NUMBER OF NUMBERS: " + vals.get(0));
                                reviewText.setText(Double.toString((double)vals.get(1)));
                                convertdouble = (int) Math.round((double)vals.get(0));
                                saveFile("FleuryPark", convertdouble, (double)vals.get(1));
                            }
                        }

                        else if (parkId.equals("Machell Park")) {
                            try {
                                if (currfile.createNewFile())
                                {
                                    System.out.println("File is created!");
                                    try {
                                        FileOutputStream out = openFileOutput("MachellPark", Context.MODE_PRIVATE);
                                        String printer = "";
                                        System.out.println("PRINTER =" + printer);
                                        out.write(printer.getBytes());
                                        out.close();
                                    }
                                    catch (IOException e) {
                                        System.out.println("Exception Occurred" + e);
                                    }
                                } else {
                                    System.out.println("File already exists.");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            updatedFile = readFile("MachellPark");
                            System.out.println("THIS IS THE UPDATES FILE: " + updatedFile);
                            System.out.println(vals);
                            vals = new ArrayList(Arrays.asList(updatedFile.split(" ")));
                            System.out.println("CURRENT VALS ARRAY" + vals);
                            if(vals.size() == 1){
                                vals.add(reviewInput);
                            }
                            if(vals.get(0) == ""){
                                System.out.println("IN HERE");
                                vals.set(0, 1);
                                reviewText.setText(Double.toString(reviewInput));
                                saveFile("MachellPark", 1, reviewInput);
                            }
                            else{
                                original = Integer.parseInt((String)vals.get(0)) * Double.parseDouble((String)vals.get(1));
                                System.out.println("ORIGINAL: " + original);
                                modified = original + reviewInput;
                                System.out.println("MODIFIED: " + modified);
                                numbers = (int) Math.round(Double.parseDouble((String)vals.get(0)));
                                numbers = numbers + 1;
                                vals.set(1, modified/numbers);
                                System.out.println("VALS MEAN: "+ vals.get(1));
                                vals.set(0, (Double.parseDouble((String)vals.get(0) + 1)));
                                System.out.println("VALS NUMBER OF NUMBERS: " + vals.get(0));
                                reviewText.setText(Double.toString((double)vals.get(1)));
                                convertdouble = (int) Math.round((double)vals.get(0));
                                saveFile("MachellPark", convertdouble, (double)vals.get(1));
                            }
                        }

                        else if (parkId.equals("TownPark")) {
                            try {
                                if (currfile.createNewFile())
                                {
                                    System.out.println("File is created!");
                                    try {
                                        FileOutputStream out = openFileOutput("TownPark", Context.MODE_PRIVATE);
                                        String printer = "";
                                        System.out.println("PRINTER =" + printer);
                                        out.write(printer.getBytes());
                                        out.close();
                                    }
                                    catch (IOException e) {
                                        System.out.println("Exception Occurred" + e);
                                    }
                                } else {
                                    System.out.println("File already exists.");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            updatedFile = readFile("TownPark");
                            System.out.println("THIS IS THE UPDATES FILE: " + updatedFile);
                            System.out.println(vals);
                            vals = new ArrayList(Arrays.asList(updatedFile.split(" ")));
                            System.out.println("CURRENT VALS ARRAY" + vals);
                            if(vals.size() == 1){
                                vals.add(reviewInput);
                            }
                            if(vals.get(0) == ""){
                                System.out.println("IN HERE");
                                vals.set(0, 1);
                                reviewText.setText(Double.toString(reviewInput));
                                saveFile("TownPark", 1, reviewInput);
                            }
                            else{
                                original = Integer.parseInt((String)vals.get(0)) * Double.parseDouble((String)vals.get(1));
                                System.out.println("ORIGINAL: " + original);
                                modified = original + reviewInput;
                                System.out.println("MODIFIED: " + modified);
                                numbers = (int) Math.round(Double.parseDouble((String)vals.get(0)));
                                numbers = numbers + 1;
                                vals.set(1, modified/numbers);
                                System.out.println("VALS MEAN: "+ vals.get(1));
                                vals.set(0, (Double.parseDouble((String)vals.get(0) + 1)));
                                System.out.println("VALS NUMBER OF NUMBERS: " + vals.get(0));
                                reviewText.setText(Double.toString((double)vals.get(1)));
                                convertdouble = (int) Math.round((double)vals.get(0));
                                saveFile("TownPark", convertdouble, (double)vals.get(1));
                            }
                        }
                        else if (parkId.equals("Machell Park")) {
                            try {
                                if (currfile.createNewFile())
                                {
                                    System.out.println("File is created!");
                                    try {
                                        FileOutputStream out = openFileOutput("MachellPark", Context.MODE_PRIVATE);
                                        String printer = "";
                                        System.out.println("PRINTER =" + printer);
                                        out.write(printer.getBytes());
                                        out.close();
                                    }
                                    catch (IOException e) {
                                        System.out.println("Exception Occurred" + e);
                                    }
                                } else {
                                    System.out.println("File already exists.");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            updatedFile = readFile("MachellPark");
                            System.out.println("THIS IS THE UPDATES FILE: " + updatedFile);
                            System.out.println(vals);
                            vals = new ArrayList(Arrays.asList(updatedFile.split(" ")));
                            System.out.println("CURRENT VALS ARRAY" + vals);
                            if(vals.size() == 1){
                                vals.add(reviewInput);
                            }
                            if(vals.get(0) == ""){
                                System.out.println("IN HERE");
                                vals.set(0, 1);
                                reviewText.setText(Double.toString(reviewInput));
                                saveFile("MachellPark", 1, reviewInput);
                            }
                            else{
                                original = Integer.parseInt((String)vals.get(0)) * Double.parseDouble((String)vals.get(1));
                                System.out.println("ORIGINAL: " + original);
                                modified = original + reviewInput;
                                System.out.println("MODIFIED: " + modified);
                                numbers = (int) Math.round(Double.parseDouble((String)vals.get(0)));
                                numbers = numbers + 1;
                                vals.set(1, modified/numbers);
                                System.out.println("VALS MEAN: "+ vals.get(1));
                                vals.set(0, (Double.parseDouble((String)vals.get(0) + 1)));
                                System.out.println("VALS NUMBER OF NUMBERS: " + vals.get(0));
                                reviewText.setText(Double.toString((double)vals.get(1)));
                                convertdouble = (int) Math.round((double)vals.get(0));
                                saveFile("MachellPark", convertdouble, (double)vals.get(1));
                            }
                        }

                        total = total / thomasReviews.size();
                        reviewText.setText(Double.toString(total));
                        total = 0;

                    } else {
                        reviewText.setText("Please enter number under 5");

                    }
                }

            }
        });




}}




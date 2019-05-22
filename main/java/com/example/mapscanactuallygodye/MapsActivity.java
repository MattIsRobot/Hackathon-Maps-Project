package com.example.mapscanactuallygodye;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public double libraryLat = 43.998104;
    public double fullLng = -79.456040;
    public String detect;
    public String animal;
    public String date = "";
    public int toggler = 0;
    public int toggler1 = 0;
    List animalTypes = new ArrayList();
    List latitudes = new ArrayList();
    List longitudes = new ArrayList();
    List dates = new ArrayList();
    public String stringanimals = "";
    public String stringlatitudes = "";
    public String stringlongitudes = "";
    public String stringdates = "";
    public List rawDates = new ArrayList();
    private GoogleMap mMap;
    public boolean identifier;
    HashMap<String, String> markerMap = new HashMap<String, String>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        identifier = true;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(identifier = true){
            try{
                FileInputStream fIn = openFileInput("animalTypes");
                int c;
                String temp = "";

                while ((c = fIn.read()) != -1)
                {
                    temp = temp + Character.toString((char) c);
                }
                //Make stuff equal output here
                stringanimals = temp;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            //Updating latitudes
            try{
                FileInputStream fIn = openFileInput("latitudes");
                int c;
                String temp = "";

                while ((c = fIn.read()) != -1)
                {
                    temp = temp + Character.toString((char) c);
                }
                //Make stuff equal output here
                stringlatitudes = temp;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            //Updating longitudes
            try{
                FileInputStream fIn = openFileInput("longitudes");
                int c;
                String temp = "";

                while ((c = fIn.read()) != -1)
                {
                    temp = temp + Character.toString((char) c);
                }
                //Make stuff equal output here
                stringlongitudes = temp;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            //Updating dates
            try{
                FileInputStream fIn = openFileInput("dates");
                int c;
                String temp = "";

                while ((c = fIn.read()) != -1)
                {
                    temp = temp + Character.toString((char) c);
                }
                //Make stuff equal output here
                stringdates = temp;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            System.out.println("ANIMAL TYPES BEFORE CONVERSION: " + stringanimals);

            animalTypes = new ArrayList(Arrays.asList(stringanimals.split(" ")));
            latitudes = new ArrayList(Arrays.asList(stringlatitudes.split(" ")));
            longitudes = new ArrayList(Arrays.asList(stringlongitudes.split(" ")));
            dates = new ArrayList(Arrays.asList(stringdates.split(" ")));

            // KK22
            date = date.replaceAll(" ", "-");
            System.out.println(date);

            animalTypes.add(animal);
            latitudes.add(libraryLat);
            longitudes.add(fullLng);
            dates.add(date);

            animalTypes.removeAll(Arrays.asList("", null));
            latitudes.removeAll(Arrays.asList("", null));
            longitudes.removeAll(Arrays.asList("", null));
            dates.removeAll(Arrays.asList("", null));

            System.out.println("ANIMAL TYPES AFTER: " + animalTypes);




                            for (int i = 0; i < animalTypes.size(); i++) {
                                LatLng wildlifeCurrPos = new LatLng(Double.parseDouble((String) latitudes.get(i)), Double.parseDouble((String) longitudes.get(i)));
                                Marker what = mMap.addMarker(new MarkerOptions().position(wildlifeCurrPos).title((String) animalTypes.get(i)).icon(BitmapDescriptorFactory.fromResource(R.drawable.magnifyingglassicon)).snippet(dates.get(i) + ""));
                                String drag = what.getId();
                                markerMap.put(drag, "action_a");
                                System.out.println("One iteration");

                            }




        }

        System.out.println("ANIMAL TYPES before evevevevevrything: " + animalTypes);



        Intent intent = getIntent();
        detect = intent.getStringExtra("DETECT");
        if(detect != null) {
            if (detect.equals("1")) {
                detect = "0";
                libraryLat = Double.parseDouble(intent.getStringExtra("LAT"));
                fullLng = Double.parseDouble(intent.getStringExtra("LNG"));
                animal = intent.getStringExtra("ANIMAL");
                date = intent.getStringExtra("TIME");
                //Write to text files
                System.out.println("ANIMAL TYPES BEFORE EVERYTHING: " + animalTypes);



                //Reading and updating Files
                //Updating animalType
                try{
                    FileInputStream fIn = openFileInput("animalTypes");
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1)
                    {
                        temp = temp + Character.toString((char) c);
                    }
                    //Make stuff equal output here
                    stringanimals = temp;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                //Updating latitudes
                try{
                    FileInputStream fIn = openFileInput("latitudes");
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1)
                    {
                        temp = temp + Character.toString((char) c);
                    }
                    //Make stuff equal output here
                    stringlatitudes = temp;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                //Updating longitudes
                try{
                    FileInputStream fIn = openFileInput("longitudes");
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1)
                    {
                        temp = temp + Character.toString((char) c);
                    }
                    //Make stuff equal output here
                    stringlongitudes = temp;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                //Updating dates
                try{
                    FileInputStream fIn = openFileInput("dates");
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1)
                    {
                        temp = temp + Character.toString((char) c);
                    }
                    //Make stuff equal output here
                    stringdates = temp;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                System.out.println("ANIMAL TYPES BEFORE CONVERSION: " + stringanimals);

                animalTypes = new ArrayList(Arrays.asList(stringanimals.split(" ")));
                latitudes = new ArrayList(Arrays.asList(stringlatitudes.split(" ")));
                longitudes = new ArrayList(Arrays.asList(stringlongitudes.split(" ")));
                dates = new ArrayList(Arrays.asList(stringdates.split(" ")));

                // KK22
                date = date.replaceAll(" ", "-");
                animal = animal.replaceAll(" ", "-");
                System.out.println(date);

                animalTypes.add(animal);
                latitudes.add(libraryLat);
                longitudes.add(fullLng);
                dates.add(date);

                System.out.println("ANIMAL TYPES AFTER: " + animalTypes);

                //Convert animal list to string and write it
                String convstring = "";
                for(int i = 0; i < animalTypes.size(); i++){
                    convstring = convstring + " " + animalTypes.get(i);
                }
                try {
                    System.out.println("CURRENT CONVSTRING: " + convstring);
                    FileOutputStream out = openFileOutput("animalTypes", Context.MODE_PRIVATE);
                    out.write(convstring.getBytes());
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception Occurred" + e);
                }

                stringanimals = convstring;

                //Convert latitude to string and write it
                convstring = "";
                for(int i = 0; i < latitudes.size(); i++){
                    convstring = convstring + " " + latitudes.get(i);
                }
                try {
                    FileOutputStream out = openFileOutput("latitudes", Context.MODE_PRIVATE);
                    out.write(convstring.getBytes());
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception Occurred" + e);
                }

                stringlatitudes = convstring;

                //Convert longitude to string and write it
                convstring = "";
                for(int i = 0; i < longitudes.size(); i++){
                    convstring = convstring + " " + longitudes.get(i);
                }
                try {
                    FileOutputStream out = openFileOutput("longitudes", Context.MODE_PRIVATE);
                    out.write(convstring.getBytes());
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception Occurred" + e);
                }

                stringlongitudes = convstring;

                //Convert date to string and write it
                System.out.println("Date before: " + date);
                System.out.println("Date after: " + date);
                convstring = "";
                for(int i = 0; i < dates.size(); i++){
                    convstring = convstring + " " + dates.get(i);
                }
                try {
                    FileOutputStream out = openFileOutput("dates", Context.MODE_PRIVATE);
                    out.write(convstring.getBytes());
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception Occurred" + e);
                }
                stringdates = convstring;

                System.out.println("String versions: " + stringanimals);
                System.out.println(stringlatitudes);
                System.out.println(stringlongitudes);
                System.out.println(stringdates);



                animalTypes = new ArrayList(Arrays.asList(stringanimals.split(" ")));
                latitudes = new ArrayList(Arrays.asList(stringlatitudes.split(" ")));
                longitudes = new ArrayList(Arrays.asList(stringlongitudes.split(" ")));
                dates = new ArrayList(Arrays.asList(stringdates.split(" ")));

                System.out.println("Array versions: " + animalTypes);
                System.out.println(latitudes);
                System.out.println(longitudes);
                System.out.println(dates);

                animalTypes.removeAll(Arrays.asList("", null));
                latitudes.removeAll(Arrays.asList("", null));
                longitudes.removeAll(Arrays.asList("", null));
                dates.removeAll(Arrays.asList("", null));



                System.out.println("Array versions: " + animalTypes);
                System.out.println(latitudes);
                System.out.println(longitudes);
                System.out.println(dates);
                System.out.println("Array size: " + animalTypes.size());

                for(int i = 0; i < animalTypes.size();i++){
                    LatLng wildlifeCurrPos = new LatLng(Double.parseDouble((String)latitudes.get(i)), Double.parseDouble((String)longitudes.get(i)));
                    Marker boi = mMap.addMarker(new MarkerOptions().position(wildlifeCurrPos).title((String)animalTypes.get(i)).icon(BitmapDescriptorFactory.fromResource(R.drawable.magnifyingglassicon)).snippet(dates.get(i) + ""));
                    String drag = boi.getId();
                    markerMap.put(drag, "action_a");
                    System.out.println("One iteration");


                }
            System.out.println("AFTER ENTIRE PROCESS: " + animalTypes);
            }
        }



        Button debugButton = (Button) findViewById(R.id.debugButton);
        debugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
            FileOutputStream out = openFileOutput("animalTypes", Context.MODE_PRIVATE);
            out.write("".getBytes());
            out.close();
            }
            catch (IOException e) {
                System.out.println("Exception Occurred" + e);
            }

            try {
                FileOutputStream out = openFileOutput("latitudes", Context.MODE_PRIVATE);
                out.write("".getBytes());
                out.close();
            }
            catch (IOException e) {
                System.out.println("Exception Occurred" + e);
            }

            try {
                FileOutputStream out = openFileOutput("longitudes", Context.MODE_PRIVATE);
                out.write("".getBytes());
                out.close();
            }
            catch (IOException e) {
                System.out.println("Exception Occurred" + e);
            }

            try {
                FileOutputStream out = openFileOutput("dates", Context.MODE_PRIVATE);
                out.write("".getBytes());
                out.close();
            }
            catch (IOException e) {
                System.out.println("Exception Occurred" + e);
            }

            }
        });





        // Add markers to the map and do other map setup.
        // Set a listener for info window events.

        LatLng Aurora = new LatLng(44.0065, 79.4504);

        float zoomLevel = 13.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Aurora, zoomLevel));


            //Fleury Park
            LatLng Fleury_Park = new LatLng(44.001293, -79.471154);
            final Marker park1 = mMap.addMarker(new MarkerOptions().position(Fleury_Park).title("Fleury Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Fleury_Park));
            String fleury = park1.getId();
            markerMap.put(fleury, "action_one");

            //Machell Park Playground
            LatLng Machell_Park_Playground = new LatLng(44.005714, -79.470758);
            final Marker park2 = mMap.addMarker(new MarkerOptions().position(Machell_Park_Playground).title("Machell Park Playground").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Machell_Park_Playground));
            String machell = park2.getId();
            markerMap.put(machell, "action_two");

            //Town Park Aurora
            LatLng Town_Park_Aurora = new LatLng(43.998316, -79.462680);
            final Marker park3 = mMap.addMarker(new MarkerOptions().position(Town_Park_Aurora).title("Town Park Aurora").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Town_Park_Aurora));
            String townpark = park3.getId();
            markerMap.put(townpark, "action_three");

            //Confederation Park
            LatLng Confederation_Park = new LatLng(43.983341, -79.478111);
            final Marker park4 = mMap.addMarker(new MarkerOptions().position(Confederation_Park).title("Confederation Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String confederation = park4.getId();
            markerMap.put(confederation, "action_four");

            //Copland Park
            LatLng Copland_Park = new LatLng(43.998755, -79.488263);
            final Marker park5 = mMap.addMarker(new MarkerOptions().position(Copland_Park).title("Copland Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String copland = park5.getId();
            markerMap.put(copland, "action_five");

            //Summit Park
            LatLng Summit_Park = new LatLng(44.003271, -79.490168);
            final Marker park6 = mMap.addMarker(new MarkerOptions().position(Summit_Park).title("Summit Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String summit = park6.getId();
            markerMap.put(summit, "action_six");

            //Hickson Park
            LatLng Hickson_Park = new LatLng(0000000,000000000);
            final Marker park7 = mMap.addMarker(new MarkerOptions().position(Hickson_Park).title("Hickson Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String hickson = park7.getId();
            markerMap.put(hickson, "action_seven");

            //Vandorf Woodlot Park
            LatLng valhallaTrail = new LatLng(000000,000000);
            final Marker park8 = mMap.addMarker(new MarkerOptions().position(valhallaTrail).title("Vandorf Woodlot Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String valhalla = park8.getId();
            markerMap.put(valhalla, "action_eight");

            //Parks End
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            //Trails Begin

            //Sheppard's Bush Trail
            LatLng Sheppards_Bush = new LatLng(43.998104, -79.456040);
            final Marker park9 = mMap.addMarker(new MarkerOptions().position(Sheppards_Bush).title("Sheppards Bush Trail").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String sheppard = park9.getId();
            markerMap.put(sheppard, "action_nine");

            LatLng Ada = new LatLng(44.020347, -79.444129);
            final Marker park10 = mMap.addMarker(new MarkerOptions().position(Ada).title("Ada Johnson Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String AdaJohnsonPark = park10.getId();
            markerMap.put(AdaJohnsonPark, "action_ten");

            LatLng Atkinson = new LatLng(44.017126, -79.467408);
            final Marker park11 = mMap.addMarker(new MarkerOptions().position(Atkinson).title("Atkinson Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String AtkinsonPark = park11.getId();
            markerMap.put(AtkinsonPark, "action_eleven");

            LatLng Wood = new LatLng(43.974314, -79.483598);
            final Marker park12 = mMap.addMarker(new MarkerOptions().position(Wood).title("Case Woodlot").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String CaseWoodlot = park12.getId();
            markerMap.put(CaseWoodlot, "action_twelve");

            LatLng Craddock = new LatLng(44.008661, -79.468159);
            final Marker park13 = mMap.addMarker(new MarkerOptions().position(Craddock).title("Craddock Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String CraddockPark = park13.getId();
            markerMap.put(CraddockPark, "action_thirteen");

            LatLng Elizabeth = new LatLng(43.993556, -79.481960);
            final Marker park14 = mMap.addMarker(new MarkerOptions().position(Elizabeth).title("Elizabeth Hader Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String ElizabethHaderPark = park14.getId();
            markerMap.put(ElizabethHaderPark, "action_fourteen");

            LatLng Highland = new LatLng(43.982584, -79.460235);
            final Marker park15 = mMap.addMarker(new MarkerOptions().position(Highland).title("Highland Field").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String HighlandField = park15.getId();
            markerMap.put(HighlandField, "action_fifteen");

            LatLng James = new LatLng(43.994609, -79.447460);
            final Marker park16 = mMap.addMarker(new MarkerOptions().position(James).title("James Lloyd Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String JamesLloydPark = park16.getId();
            markerMap.put(JamesLloydPark, "action_sixteen");

            LatLng Lambert = new LatLng(44.009027, -79.460637);
            final Marker park17 = mMap.addMarker(new MarkerOptions().position(Lambert).title("Lambert Willson Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String LambertWillsonPark = park17.getId();
            markerMap.put(LambertWillsonPark, "action_seventeen");

            LatLng Norm = new LatLng(43.972340, -79.483461);
            final Marker park18 = mMap.addMarker(new MarkerOptions().position(Norm).title("Norm Weller Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String NormWellerPark = park18.getId();
            markerMap.put(NormWellerPark, "action_eighteen");

            LatLng Stewart = new LatLng(44.012877, -79.422810);
            final Marker park19 = mMap.addMarker(new MarkerOptions().position(Stewart).title("Stewart Burnett Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String StewartBurnettPark = park19.getId();
            markerMap.put(StewartBurnettPark, "action_nineteen");

            LatLng Thomas = new LatLng(44.014733, -79.438280);
            final Marker park20 = mMap.addMarker(new MarkerOptions().position(Thomas).title("Thomas Coates Park").snippet("Click for more info").icon(BitmapDescriptorFactory.fromResource(R.drawable.parkicon)));
            String ThomasCoatesPark = park20.getId();
            markerMap.put(ThomasCoatesPark, "action_twenty");

        LatLng Holland = new LatLng(43.980327, -79.438543);
        final Marker trailhead1 = mMap.addMarker(new MarkerOptions().position(Holland).title("Holland River Trail (Nokiidaa Trail)").icon(BitmapDescriptorFactory.fromResource(R.drawable.hikericon)));
        String HollandRiverTrail = trailhead1.getId();
        markerMap.put(HollandRiverTrail, "action_trailhead1");

        LatLng Klaus = new LatLng(43.997923, -79.456358);
        final Marker trailhead2 = mMap.addMarker(new MarkerOptions().position(Klaus).title("Klaus Wehrenberg Trail").icon(BitmapDescriptorFactory.fromResource(R.drawable.hikericon)));
        String KlausWehrenbergTrail = trailhead2.getId();
        markerMap.put(KlausWehrenbergTrail, "action_trailhead2");

        LatLng Lakeview = new LatLng(44.014820, -79.476766);
        final Marker trailhead3 = mMap.addMarker(new MarkerOptions().position(Lakeview).title("Lakeview Trail").icon(BitmapDescriptorFactory.fromResource(R.drawable.hikericon)));
        String LakeviewTrail = trailhead3.getId();
        markerMap.put(LakeviewTrail, "action_trailhead3");

        LatLng McKenzie = new LatLng(44.026531, -79.463635);
        final Marker trailhead4 = mMap.addMarker(new MarkerOptions().position(McKenzie).title("McKenzie Marsh Trail").icon(BitmapDescriptorFactory.fromResource(R.drawable.hikericon)));
        String McKenzieMarshTrail = trailhead4.getId();
        markerMap.put(McKenzieMarshTrail, "action_trailhead4");

        LatLng Trent = new LatLng(44.027218, -79.440605);
        final Marker trailhead5 = mMap.addMarker(new MarkerOptions().position(Trent).title("Trent Park Municipal Trail").icon(BitmapDescriptorFactory.fromResource(R.drawable.hikericon)));
        String TrentParkMunicipalTrail = trailhead5.getId();
        markerMap.put(TrentParkMunicipalTrail, "action_trailhead5");

        LatLng Oakridges = new LatLng(43.975602, -79.482827);
        final Marker trailhead6 = mMap.addMarker(new MarkerOptions().position(Oakridges).title("Oak Ridges Trail").icon(BitmapDescriptorFactory.fromResource(R.drawable.hikericon)));
        String OakRidgesTrail = trailhead6.getId();
        markerMap.put(OakRidgesTrail, "action_trailhead6");

        final LatLng Wildlife = new LatLng(43.999456, -79.463790);
        final Marker currentPos = mMap.addMarker(new MarkerOptions().position(Wildlife).title("Location Indicator").draggable(true).snippet("Click and hold to drag to desired location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        String drag = currentPos.getId();
        markerMap.put(drag, "action_a");


        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener(){
            @Override
            public void onInfoWindowClick(Marker marker) {
                String actionId = markerMap.get(marker.getId());
                if (actionId.equals("action_one")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Fleury Park");
                    startIntent.putExtra("DESC", "60 Hartwell Way\n" +
                            "\u200B5.2 acres\n" +
                            "\n" +
                            "\u200BSplash pad\n" +
                            "Washroom facilities\n" +
                            "Vita Parcour fitness trail\n" +
                            "Gazebo\n" +
                            "2 Half basketball courts \n" +
                            "1 Senior/junior playground\n" +
                            "1 Natural outdoor ice rink\n" +
                            "19 car paved parking facility\n" +
                            "1 soccer field\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);

                } else if (actionId.equals("action_two")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Machell Park Playground");
                    startIntent.putExtra("DESC", "2A Aurora Heights Drive & 15 Orchard Heights Dr.\n" +
                            "\u200B14.6 acres\n" +
                            "\n" +
                            "\u200B1 Senior/junior playground\n" +
                            "2 soccer facility\n" +
                            "2 softball facilities\n" +
                            "56 car paved parking facility \n" +
                            "1 Natural outdoor ice rink \n" +
                            "Posted toboggan area\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_three")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Town Park Aurora");
                    startIntent.putExtra("DESC", "49 Wells St.\n" +
                            "\u200B4 acres\n" +
                            "\n" +
                            "1 softball facility\n" +
                            "2 soccer facilities\n" +
                            "Bandshell \n" +
                            "Washroom facilities\n" +
                            "1 Senior/junior playground\n" +
                            "Splash Pad\n" +
                            "1 Natural outdoor ice rink\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_four")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Confederation Park");
                    startIntent.putExtra("DESC", "30 Glass Dr.\n" +
                            "\u200B15 acres\n" +
                            "1 Senior/junior playground\n" +
                            "2 softball facilities\n" +
                            "2 soccer facilities \n" +
                            "2 full basketball courts\n" +
                            "Picnic shelter\n" +
                            "1 Natural outdoor ice rink\n" +
                            "31 car paved parking facility\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_five")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Copland Park");
                    startIntent.putExtra("DESC", "\u200B225 Aurora Heights Dr.\n" +
                            "\u200B5 acres\n" +
                            "\n" +
                            "1 Senior/junior playground\n" +
                            "1 softball facility\n" +
                            "Posted toboggan area\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_six")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Summit Park");
                    startIntent.putExtra("DESC", "267 Orchard Heights Boulevard\n" +
                            "\u200B7.9 acres\n" +
                            "\n" +
                            "\u200B1 Senior/junior playground\n" +
                            "1 Full basketball court\n" +
                            "1 softball facility\n" +
                            "1 soccer facility\n" +
                            "1 two-court lighted tennis facility \n" +
                            "20 car paved parking facility\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_seven")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Hickson Park");
                    startIntent.putExtra("DESC", "155 Conover Avenue\n" +
                            "\u200B5.3 acres\n" +
                            "\n" +
                            "\u200B1 Senior/junior playground\n" +
                            "Skateboard facility\n" +
                            "BMX circuit\n" +
                            "1 soccer facility\n" +
                            "2 Half basketball courts\n" +
                            "Gazebo\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_eight")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Vandorf Woodlot Park");
                    startIntent.putExtra("DESC", "200 Vandorf Side Rd. & 422 Stone Rd.\n" +
                            "\u200B66.5 acres\n" +
                            "\n" +
                            "\u200BAccess to the Tim Jones Trail & Klaus Wehrenberg Trail system\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);

                } else if (actionId.equals("action_nine")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Sheppards Bush Trail");
                    startIntent.putExtra("DESC", "93 & 93A Industrial Parkway South\n" +
                            "\u200B62.75 acres\n" +
                            "\n" +
                            "\u200B1 Artificial Turf soccer facility\n" +
                            "10 soccer facilities\n" +
                            "Picnic shelter\n" +
                            "Washroom facility and concession stand\n" +
                            "Trail entrance to Tim Jones Trail & Klaus Wehrenberg Trail\n" +
                            "Vita Parcour fitness trail\n" +
                            "156 car parking facility (2 lots)\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_ten")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Ada Johnson Park");
                    startIntent.putExtra("DESC", "60 Hartwell Way\n" +
                            "\u200B5.2 acres\n" +
                            "\n" +
                            "\u200BSplash pad\n" +
                            "Washroom facilities\n" +
                            "Vita Parcour fitness trail\n" +
                            "Gazebo\n" +
                            "2 Half basketball courts \n" +
                            "1 Senior/junior playground\n" +
                            "1 Natural outdoor ice rink\n" +
                            "19 car paved parking facility\n" +
                            "1 soccer field\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_eleven")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Atkinson Park");
                    startIntent.putExtra("DESC", "46 Twelve Oaks Dr.\n" +
                            "\u200B10.24 acres\n" +
                            "\n" +
                            "\u200B200 metres of paved pathway\n" +
                            "connecting to the adjacent McKenzie Marsh on the south side of St Johns Sd. Road\n" +
                            "1 Senior/junior playground\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_twelve")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Case Woodlot");
                    startIntent.putExtra("DESC", "675 Henderson Dr.\n" +
                            "\u200B67 acres\n" +
                            "\n" +
                            "\u200BWoodchip walking trails\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_thirteen")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Craddock Park");
                    startIntent.putExtra("DESC", "5 Batson Dr.\n" +
                            "\u200B9.7 acres\n" +
                            "\n" +
                            "\u200B1 soccer facility\n" +
                            "20 car turf parking lot\n" +
                            "Natural open space area\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_fourteen")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Elizabeth Hader Park");
                    startIntent.putExtra("DESC", "69 Timpson Dr.\n" +
                            "\u200B17 acres\n" +
                            "\n" +
                            "\u200B1 Senior/junior playground\n" +
                            "1 softball facility\n" +
                            "Open space natural area\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_fifteen")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Highland Field");
                    startIntent.putExtra("DESC", "510 Industrial Parkway South\n" +
                            "\u200B4.7 acres\n" +
                            "\n" +
                            "1 Soccer facility\n" +
                            "Home of the Aurora Soccer Club\n" +
                            "Full clubhouse facility on the property\n" +
                            "65 car gravel parking facility\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);

                } else if (actionId.equals("action_sixteen")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "James Lloyd Park");
                    startIntent.putExtra("DESC", "355 Stone Road\n" +
                            "\u200B5.3 acres\n" +
                            "\n" +
                            "\u200B1 softball facility\n" +
                            "1 Senior/junior playground \n" +
                            "1 Full basketball court\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_seventeen")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Lambert Willson Park");
                    startIntent.putExtra("DESC", "115 & 135 Industrial Parkway North\n" +
                            "\u200B28 acres\n" +
                            "\n" +
                            "\u200B3 senior softball facilities \n" +
                            "1 baseball facility\n" +
                            "1 soccer facility\n" +
                            "1 Senior/junior playground\n" +
                            "Skateboard park\n" +
                            "2 Beach volleyball courts\n" +
                            "Posted toboggan area\n" +
                            "Washroom facility\n" +
                            "Picnic shelter\n" +
                            "Gazebo\n" +
                            "Entrances to Aurora Community Arboretum\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_eighteen")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Norm Weller Park");
                    startIntent.putExtra("DESC", "250 McClellan Way\n" +
                            "\u200B5.8 acres\n" +
                            "\n" +
                            "1 softball facility\n" +
                            "1 soccer facility\n" +
                            "1 two-court lighted tennis facility\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);

                } else if (actionId.equals("action_nineteen")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Stewart Burnett Park");
                    startIntent.putExtra("DESC", "1344 Wellington St., East (SARC Recreation Complex)\n" +
                            "\u200B18 acres\n" +
                            "\n" +
                            "\u200B1 Baseball facility\n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                } else if (actionId.equals("action_twenty")) {
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Thomas Coates Park");
                    startIntent.putExtra("DESC", "234 Mavrinac Boulevard\n" +
                            "\u200B6 acres \n" +
                            "\n" +
                            "\u200B1 Senior/junior playground\n" +
                            "Walking trail \n" +
                            "Open play area \n" +
                            "1 basketball court \n" +
                            "1 tennis court \n" +
                            "1 pickleball court \n");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                }else if (actionId.equals("action_a")) {
                    System.out.println("heh");


                } else {
                    System.out.println("heh");
                }
            }
        });

        Button helpButton = (Button) findViewById(R.id.helpButton);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), HelpScreen.class);
                startActivity(startIntent);
            }
        });


        Button toggleParks = (Button) findViewById(R.id.toggleParks);
        toggleParks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggler == 0) {
                    park1.setVisible(false);
                    park2.setVisible(false);
                    park3.setVisible(false);
                    park4.setVisible(false);
                    park5.setVisible(false);
                    park6.setVisible(false);
                    park7.setVisible(false);
                    park8.setVisible(false);
                    park9.setVisible(false);
                    park10.setVisible(false);
                    park11.setVisible(false);
                    park12.setVisible(false);
                    park13.setVisible(false);
                    park14.setVisible(false);
                    park15.setVisible(false);
                    park16.setVisible(false);
                    park17.setVisible(false);
                    park18.setVisible(false);
                    park19.setVisible(false);
                    park10.setVisible(false);
                    toggler = toggler + 1;
                }
                else if(toggler == 1) {
                    park1.setVisible(true);
                    park2.setVisible(true);
                    park3.setVisible(true);
                    park4.setVisible(true);
                    park5.setVisible(true);
                    park6.setVisible(true);
                    park7.setVisible(true);
                    park8.setVisible(true);
                    park9.setVisible(true);
                    park10.setVisible(true);
                    park11.setVisible(true);
                    park12.setVisible(true);
                    park13.setVisible(true);
                    park14.setVisible(true);
                    park15.setVisible(true);
                    park16.setVisible(true);
                    park17.setVisible(true);
                    park18.setVisible(true);
                    park19.setVisible(true);
                    park10.setVisible(true);
                    toggler = toggler - 1;
                }
            }
        });
        Button toggleTrails = (Button) findViewById(R.id.toggleTrails);
        toggleTrails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Geocoder gc = new Geocoder(MapsActivity.this);
                List<Address> list = null;

                    final LatLng draggablePos = marker.getPosition();
                    libraryLat = draggablePos.latitude;
                    fullLng = draggablePos.longitude;

                System.out.println("CURRENT LATITUDE: " + libraryLat + "CURRENT LONGITUDE: " + fullLng);
                }
            });



        ImageView hanathansucks = (ImageView)findViewById(R.id.hanathansucks);
        hanathansucks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent startIntent = new Intent(getApplicationContext(), WildLifeSubmissions.class);
                startIntent.putExtra("LAT", Double.toString(libraryLat));
                startIntent.putExtra("LNG", Double.toString(fullLng));
                startIntent.putExtra("ANIMALS", (stringanimals));
                startIntent.putExtra("LATITUDES", (stringlatitudes));
                startIntent.putExtra("LONGITUDES", (stringlongitudes));
                startIntent.putExtra("DATES", (stringdates));

                //show how to pass information to another activity
                startActivity(startIntent);



            }

        });

        System.out.println("ANIMAL TYPES after evevevevevrything: " + animalTypes);

    }
}

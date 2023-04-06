package com.example.map;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import androidx.appcompat.widget.SearchView;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.map.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<Address> ListGeoCoder;
    SearchView searchView;
    String a;
    private static final int LOCATION_PERMISSION_CODE = 101;
    double longitude,latitude;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding = ActivityMapsBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());
  //      setContentView(R.layout.activity_map);
        searchView = findViewById(R.id.idSearchView1);
    //    WebView webView=findViewById(R.id.webView);
  //      webView.getSettings().setJavaScriptEnabled(true);
    //    webView.loadUrl("file:///android_asset/index.js");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
       // if (isLocationPermissionGranted()) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
          //  SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    // on below line we are getting the
                    // location name from search view.
                    String location = searchView.getQuery().toString();
                 //   mMap.addMarker(new MarkerOptions().position(lt).title(location));



                    // below line is to create a list of address
                    // where we will store the list of all address.
                    List<Address> addressList = null;

                    // checking if the entered location is null or not.
                    if (location != null || location.equals("")) {
                        // on below line we are creating and initializing a geo coder.
                        Geocoder geocoder = new Geocoder(MapsActivity.this);
                        try {
                            // on below line we are getting location from the
                            // location name and adding that location to address list.
                            addressList = geocoder.getFromLocationName(location, 1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // on below line we are getting the location
                        // from our list a first position.
                        Address address = addressList.get(0);

                        // on below line we are creating a variable for our location
                        // where we will add our locations latitude and longitude.
                        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());

                        // on below line we are adding marker to that position.
                        mMap.addMarker(new MarkerOptions().position(latLng).title(location));

                        // below line is to animate camera to that position.
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                    }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            mapFragment.getMapAsync(this);


            try {
                ListGeoCoder = new Geocoder(this).getFromLocationName("LICET : Loyola-ICAM College of Engineering and Technology", 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            longitude = ListGeoCoder.get(0).getLongitude();
            latitude = ListGeoCoder.get(0).getLatitude();
            Log.i("GOOGLE_MAP_TAG", "Address has latitude: " + String.valueOf(latitude) + " \n Address has longitude: " + String.valueOf(longitude));

      //  }
       // else{
         //   requestLocationPermission();
//        }
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

        LatLng licet = new LatLng(latitude,longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(licet,18));
        LatLng d_block = new LatLng(13.0595175 ,80.2338888);
        LatLng f_block = new LatLng(13.059544, 80.233576);
        LatLng g_block = new LatLng(13.059291, 80.233389);
        LatLng j_block = new LatLng(13.059507, 80.233306);
        LatLng i_block = new LatLng(13.059080, 80.233331);
        LatLng h_block = new LatLng(13.059088, 80.233585);
        LatLng a_block = new LatLng(13.058878, 80.233753);
        LatLng b_block = new LatLng(13.059065, 80.233836);
        LatLng e_block = new LatLng(13.059751, 80.233724);


        // Log.i("map", searchView.getQuery().toString());
    //    if(a=="j_block"){
      //      mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(j_block,20));
       // }
        Marker m;
        mMap.addMarker(new MarkerOptions().position(licet).title("Central Lobby"));
        mMap.addMarker(new MarkerOptions().position(d_block).title("D BLOCK"));
        mMap.addMarker(new MarkerOptions().position(f_block).title("F BLOCK"));
        mMap.addMarker(new MarkerOptions().position(g_block).title("G BLOCK"));
        mMap.addMarker(new MarkerOptions().position(j_block).title("J BLOCK"));
        mMap.addMarker(new MarkerOptions().position(i_block).title("I BLOCK"));
        mMap.addMarker(new MarkerOptions().position(h_block).title("H BLOCK"));
        mMap.addMarker(new MarkerOptions().position(a_block).title("A BLOCK"));
        mMap.addMarker(new MarkerOptions().position(b_block).title("B BLOCK"));
        mMap.addMarker(new MarkerOptions().position(e_block).title("E BLOCK"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a_block));
    //    mMap.addPolygon(new PolygonOptions());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(licet));
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        new LatLng(-35.016, 143.321),
                        new LatLng(-34.747, 145.592),
                        new LatLng(-34.364, 147.891),
                        new LatLng(-33.501, 150.217),
                        new LatLng(-32.306, 149.248),
                        new LatLng(-32.491, 147.309)));
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        }
    }
    private boolean isLocationPermissionGranted(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else{
            return false;
        }
    }
    public void requestLocationPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_CODE);
    }

}
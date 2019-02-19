package com.sharma.kuhuk.mapviewdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Screen4 extends AppCompatActivity implements OnMapReadyCallback {

    MapView mapView;
    private GoogleMap map;
    private SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);

        if (mapFragment != null)
            mapFragment.getMapAsync(this);

        // Hide the status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //Hide the action bar
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.hide();
    }

    // For MapFragment (Spidy code)
    private BitmapDescriptor bitmapDescriptorFromVector(OnMapReadyCallback context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(this, vectorResId);
        assert vectorDrawable != null;
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.clear(); //clear old markers
        CameraPosition googlePlex = CameraPosition.builder()
                .target(new LatLng(37.4219999,-122.0862462))
                .zoom(10)
                .bearing(0)
                .tilt(45)
                .build();

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4219999,-122.0862462),12.0f));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.4219999, -122.0862462))
                .title("Spider Man")
                .icon(bitmapDescriptorFromVector(this,R.drawable.spider)));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.4629101,-122.2449094))
                .title("Cinderella")
                .snippet("Everyone loves her shoes")
                .icon(bitmapDescriptorFromVector(this, R.drawable.cinderella_icon)));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.3092293,-122.1136845))
                .title("Captain America"));
    }
}

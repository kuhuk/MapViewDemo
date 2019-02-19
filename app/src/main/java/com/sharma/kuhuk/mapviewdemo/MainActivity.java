package com.sharma.kuhuk.mapviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {

    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    private MapFragment map;
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMapDemo = findViewById(R.id.btnScreen3);
        btnMapDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Screen3.class));
            }
        });

        Button btnScreen4 = findViewById(R.id.btnScreen4);
        btnScreen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Screen4.class));
            }
        });

        Button btnUserDashboard = findViewById(R.id.btnUserDashboard);
        btnUserDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserDashboard.class));
            }
        });
    }
}

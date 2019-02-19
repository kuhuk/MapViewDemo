package com.sharma.kuhuk.mapviewdemo.myVisits;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sharma.kuhuk.mapviewdemo.R;
import com.sharma.kuhuk.mapviewdemo.screen3.FragmentScreen3;

public class MyVisits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_visits);

        // Hide the status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //Hide the action bar
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.hide();

        //attach fragment (MapFragment) on this activity
        getSupportFragmentManager().beginTransaction().replace(R.id.container_my_visits, new FragmentMyVisits()).commit();
    }
}

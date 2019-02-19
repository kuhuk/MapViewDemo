package com.sharma.kuhuk.mapviewdemo.screen3;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.sharma.kuhuk.mapviewdemo.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentScreen3 extends Fragment implements OnMapReadyCallback {

    // For RecyclerView
    @SuppressLint("StaticFieldLeak")
    private static RecyclerView recyclerView;
    private static ArrayList<String> stringArrayList;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;
    static View.OnClickListener myOnClickListener;

    // For MapFragment
    private final LatLng HAMBURG = new LatLng(53.558, 9.927);

    // For MapFragment
    public FragmentScreen3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_screen3, container, false);

        // Use SuppoprtMapFragment for using in fragment instead of activity. Because MapFragment = activity & SupportMapFragment = fragment
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.frg);

        if (mapFragment != null)
        mapFragment.getMapAsync(this);

        //RecyclerView code starts here
        // Initialize ArrayList and add elements to it
        stringArrayList = new ArrayList<>();
        for (int i = 0; i <= 14; i++)
            stringArrayList.add("Element "+i);

        recyclerView = rootView.findViewById(R.id.rv_screen3);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new RecyclerViewAdapterS3(stringArrayList);
        recyclerView.setAdapter(adapter);

        myOnClickListener = new FragmentScreen3.MyOnClickListener(getActivity());
        //RecyclerView code ends here

        return rootView; //For FragmentScreen3
    }

    //onClick events (RecyclerView code)
    private static class MyOnClickListener implements View.OnClickListener {
        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int position = recyclerView.getChildPosition(v);
            Toast.makeText(context, "Element "+position, Toast.LENGTH_LONG).show();
        }
    }

    // For MapFragment (Spidy code)
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        assert vectorDrawable != null;
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    // For MapFragment
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
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.spider)));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.4629101,-122.2449094))
                .title("Cinderella")
                .snippet("Everyone loves her shoes")
        .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.cinderella_icon)));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.3092293,-122.1136845))
                .title("Captain America"));
    }
}

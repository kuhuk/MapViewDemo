package com.sharma.kuhuk.mapviewdemo.myVisits;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sharma.kuhuk.mapviewdemo.R;
import com.sharma.kuhuk.mapviewdemo.screen3.FragmentScreen3;
import com.sharma.kuhuk.mapviewdemo.screen3.RecyclerViewAdapterS3;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMyVisits extends Fragment {

    // For RecyclerView
    @SuppressLint("StaticFieldLeak")
    private static RecyclerView recyclerView;
    private static ArrayList<String> stringArrayList2;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;
    static View.OnClickListener mvOnClickListener;

    public FragmentMyVisits() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootViewMV = inflater.inflate(R.layout.fragment_fragment_my_visits, container, false);

        //RecyclerView code starts here
        // Initialize ArrayList and add elements to it
        stringArrayList2 = new ArrayList<>();
        for (int i = 0; i <= 14; i++)
            stringArrayList2.add("Element " + i);

        recyclerView = rootViewMV.findViewById(R.id.rv_my_visits);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new RecyclerViewAdapterMV(stringArrayList2);
        recyclerView.setAdapter(adapter);

        mvOnClickListener = new FragmentMyVisits.MVOnClickListener(getActivity());
        //RecyclerView code ends here

        return rootViewMV;
    }
    //onClick events (RecyclerView code)
    private static class MVOnClickListener implements View.OnClickListener {
        private final Context context;

        private MVOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int position = recyclerView.getChildPosition(v);
            Toast.makeText(context, "Element "+position, Toast.LENGTH_LONG).show();
        }
    }
}

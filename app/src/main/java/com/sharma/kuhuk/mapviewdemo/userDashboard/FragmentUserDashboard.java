package com.sharma.kuhuk.mapviewdemo.userDashboard;


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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUserDashboard extends Fragment {

    // For RecyclerView
    @SuppressLint("StaticFieldLeak")
    private static RecyclerView recyclerView;
    private static ArrayList<String> stringArrayList1;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;
    static View.OnClickListener myOnClickListener;


    public FragmentUserDashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootViewUD = inflater.inflate(R.layout.fragment_user_dashboard, container, false);

        //RecyclerView code starts here
        // Initialize ArrayList and add elements to it
        stringArrayList1 = new ArrayList<>();
        for (int i = 0; i <= 4; i++)
            stringArrayList1.add("Element "+i);

        recyclerView = rootViewUD.findViewById(R.id.rv_user_dashboard);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new RecyclerViewAdapterUD(stringArrayList1);
        recyclerView.setAdapter(adapter);

        myOnClickListener = new FragmentUserDashboard.UDOnClickListener(getActivity());
        //RecyclerView code ends here

        return rootViewUD;
    }

    //onClick events (RecyclerView code)
    private static class UDOnClickListener implements View.OnClickListener {
        private final Context context;

        private UDOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int position = recyclerView.getChildPosition(v);
            Toast.makeText(context, "Element "+position, Toast.LENGTH_LONG).show();
        }
    }

}

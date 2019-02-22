package com.sharma.kuhuk.mapviewdemo.faq;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
public class FragmentFAQ extends Fragment {

    // For RecyclerView
    @SuppressLint("StaticFieldLeak")
    private static RecyclerView recyclerView;
    private static ArrayList<String> stringArrayList;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;
    static View.OnClickListener faqOnClickListener;

    public FragmentFAQ() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootViewFAQ = inflater.inflate(R.layout.fragment_faq, container, false);

        //RecyclerView code starts here
        // Initialize ArrayList and add elements to it
        stringArrayList = new ArrayList<>();
        for (int i = 0; i <= 14; i++)
            stringArrayList.add("Element "+i);

        recyclerView = rootViewFAQ.findViewById(R.id.rv_faq);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new AdapterFAQ(stringArrayList);
        recyclerView.setAdapter(adapter);

        faqOnClickListener = new FragmentFAQ.FAQOnClickListener(getActivity());
        //RecyclerView code ends here

        return rootViewFAQ;
    }

    //onClick events (RecyclerView code)
    private class FAQOnClickListener implements View.OnClickListener {
        private final Context context;

        private FAQOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
//            int position = recyclerView.getChildPosition(v);
//            Toast.makeText(context, "Element "+position, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getActivity(), FAQDetails.class);
            startActivity(intent);
        }
    }
}

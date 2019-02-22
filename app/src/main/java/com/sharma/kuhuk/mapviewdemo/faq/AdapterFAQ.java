package com.sharma.kuhuk.mapviewdemo.faq;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sharma.kuhuk.mapviewdemo.R;
import com.sharma.kuhuk.mapviewdemo.screen3.FragmentScreen3;
import com.sharma.kuhuk.mapviewdemo.screen3.RecyclerViewAdapterS3;

import java.util.ArrayList;

public class AdapterFAQ extends RecyclerView.Adapter<AdapterFAQ.FAQViewHolder> {

    private final ArrayList<String> arrayList;
    AdapterFAQ(ArrayList<String> strings) {
        arrayList = strings;
    }

    @NonNull
    @Override
    public FAQViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_faq, viewGroup, false);

        view.setOnClickListener(FragmentFAQ.faqOnClickListener);
        return new AdapterFAQ.FAQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FAQViewHolder faqViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    //inner class - ViewHolder
    static class FAQViewHolder extends RecyclerView.ViewHolder {

        TextView tvLocationTag1;

        FAQViewHolder(View v) {
            super(v);

//        this.textView3 = v.findViewById(R.id.tv3);
        }
    }
}

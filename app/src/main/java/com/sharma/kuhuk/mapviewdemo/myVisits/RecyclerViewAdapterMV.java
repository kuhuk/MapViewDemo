package com.sharma.kuhuk.mapviewdemo.myVisits;

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

public class RecyclerViewAdapterMV extends RecyclerView.Adapter<RecyclerViewAdapterMV.MVViewHolder> {

    private final ArrayList<String> arrayList;
    RecyclerViewAdapterMV(ArrayList<String> strings) {
        arrayList = strings;
    }

    //inner class - ViewHolder
    static class MVViewHolder extends RecyclerView.ViewHolder {

//        ImageView ivCardImage;

        MVViewHolder(View v) {
            super(v);

//            this.tvLocationTag1 = v.findViewById(R.id.tvLocationTag1);
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapterMV.MVViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_recycler_view_mv, viewGroup, false);

        view.setOnClickListener(FragmentMyVisits.mvOnClickListener);
        return new RecyclerViewAdapterMV.MVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterMV.MVViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

package com.sharma.kuhuk.mapviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterUD extends RecyclerView.Adapter<RecyclerViewAdapterUD.UDViewHolder> {

private final ArrayList<String> arrayList1;
        RecyclerViewAdapterUD(ArrayList<String> strings1) {
        arrayList1 = strings1;
        }

    //inner class - ViewHolder
    class UDViewHolder extends RecyclerView.ViewHolder {

        private Button btnRegister;

        UDViewHolder(View v) {
            super(v);

            this.btnRegister = v.findViewById(R.id.btnRegister);
        }
    }

    @NonNull
    @Override
    public UDViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewUD = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_recycler_view_ud, viewGroup, false);

        viewUD.setOnClickListener(FragmentUserDashboard.myOnClickListener);
        return new RecyclerViewAdapterUD.UDViewHolder(viewUD);
    }

    @Override
    public void onBindViewHolder(@NonNull UDViewHolder udViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }
}

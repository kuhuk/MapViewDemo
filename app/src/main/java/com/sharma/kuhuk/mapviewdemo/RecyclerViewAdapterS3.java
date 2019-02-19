package com.sharma.kuhuk.mapviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterS3 extends RecyclerView.Adapter<RecyclerViewAdapterS3.MyViewHolder> {

    private final ArrayList<String> arrayList;
    RecyclerViewAdapterS3(ArrayList<String> strings) {
        arrayList = strings;
        }

//inner class - ViewHolder
static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCardImage;
        TextView tvLocationTag1;
        TextView tvLocationTag2;
//        final TextView textView3;

    MyViewHolder(View v) {
        super(v);

//        this.ivCardImage = v.findViewById(R.id.ivCardImage);
        this.tvLocationTag1 = v.findViewById(R.id.tvLocationTag1);
        this.tvLocationTag2 = v.findViewById(R.id.tvLocationTag2);
//        this.textView3 = v.findViewById(R.id.tv3);
//        this.mButton = v.findViewById(R.id.btn_paynow);
    }
}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_recycler_view_s3, viewGroup, false);

        view.setOnClickListener(FragmentScreen3.myOnClickListener);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tvLocationTag1.setText(arrayList.get(i));
        myViewHolder.tvLocationTag2.setText(arrayList.get(i));
//        myViewHolder.textView3.setText(arrayList.get(i));
//        myViewHolder.mButton.setText(arrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

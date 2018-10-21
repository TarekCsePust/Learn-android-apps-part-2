package com.example.hasantarek.recyclerview77;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 7/31/2017.
 */
public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.RecyclerviewHolder> {
    ArrayList<String>arrayList=new ArrayList<String>();

    public Recycleradapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerviewHolder recyclerviewHolder = new RecyclerviewHolder(view);
        return recyclerviewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerviewHolder holder, int position) {

        holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerviewHolder extends RecyclerView.ViewHolder
    {

        TextView textView;
        public RecyclerviewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.item_id);
        }
    }
}

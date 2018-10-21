package com.example.hasantarek.filterrecycler96;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 8/17/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {
   private ArrayList<Country>arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Country> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        holder.flag.setImageResource(arrayList.get(position).getFlag_id());
        holder.name.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder
    {

        ImageView flag;
        TextView name;
        public MyviewHolder(View itemView) {
            super(itemView);
            flag = (ImageView)itemView.findViewById(R.id.flag);
            name = (TextView)itemView.findViewById(R.id.name);
        }
    }

    public void setFilter(ArrayList<Country>List)
    {
        arrayList = new ArrayList<>();
        arrayList.addAll(List);
        notifyDataSetChanged();
    }

}

package com.example.hasantarek.collapsing95;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 8/17/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyviewHolder> {
    ArrayList <Album> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Album> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        holder.imageView.setImageResource(arrayList.get(position).getImg_id());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;

        public MyviewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.album);
        }
    }
}

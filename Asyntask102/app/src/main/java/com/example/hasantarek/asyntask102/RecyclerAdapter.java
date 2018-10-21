package com.example.hasantarek.asyntask102;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 8/18/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder>{

    ArrayList <Contact>arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Contact> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        holder.Name.setText(arrayList.get(position).getName());
        holder.ID.setText(arrayList.get(position).getId());
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder
    {

        TextView ID,Name;

        public MyviewHolder(View itemView) {
            super(itemView);
            ID = (TextView)itemView.findViewById(R.id.name_id);
            Name = (TextView)itemView.findViewById(R.id.name);
        }
    }
}

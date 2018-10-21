package com.example.hasantarek.gson103;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasan Tarek on 8/27/2017.
 */
public class RecylcerAdapter extends RecyclerView.Adapter<RecylcerAdapter.MyviewHolder> {

    List<Contact> arrayList = new ArrayList<>();

    public RecylcerAdapter(List<Contact> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        holder.id.setText(Integer.toString(arrayList.get(position).getId()));
        holder.name.setText(arrayList.get(position).getName());
        holder.email.setText(arrayList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class MyviewHolder extends RecyclerView.ViewHolder
    {

        TextView id,name,email;
        public MyviewHolder(View itemView) {
            super(itemView);
            id = (TextView)itemView.findViewById(R.id.contact_id);
            name = (TextView)itemView.findViewById(R.id.name_id);
            email = (TextView)itemView.findViewById(R.id.email_id);
        }
    }
}

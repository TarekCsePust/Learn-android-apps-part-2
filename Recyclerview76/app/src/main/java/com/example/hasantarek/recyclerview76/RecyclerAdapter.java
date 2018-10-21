package com.example.hasantarek.recyclerview76;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 7/30/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerviewHolder> {

    ArrayList<Listprovider>arrayList = new ArrayList<Listprovider>();
    private static  final int Type_head=0;
    private static final int Type_list=1;

    public RecyclerAdapter(ArrayList<Listprovider> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerviewHolder recyclerviewHolder;
        if(viewType == Type_list)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
            recyclerviewHolder = new RecyclerviewHolder(view,viewType);
            return recyclerviewHolder;
        }
        else
        if(viewType == Type_head)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_layout,parent,false);
            recyclerviewHolder = new RecyclerviewHolder(view,viewType);
            return recyclerviewHolder;
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerviewHolder holder, int position) {
        Listprovider listprovider;
        if(holder.view_type == Type_list)
        {
            listprovider =arrayList.get(position-1);
            holder.list_image.setImageResource(listprovider.getImage_id());
            holder.list_pro.setText(listprovider.getLproduction());
            holder.list_actor.setText(listprovider.getLactor());
        }
        else
            if(holder.view_type == Type_head)
            {
                holder.title_img.setText("Picture");
                holder.title_pro.setText("Production");
                holder.title_act.setText("Actor");
            }

    }

    @Override
    public int getItemCount() {
        return arrayList.size()+1;
    }

    public static class RecyclerviewHolder extends RecyclerView.ViewHolder
    {
        int view_type;
        //variable for list
        ImageView list_image;
        TextView list_pro,list_actor;
        //variable for header
        TextView title_img,title_pro,title_act;
        public RecyclerviewHolder(View itemView,int view_type) {
            super(itemView);
            if(view_type == Type_list)
            {
                list_image = (ImageView)itemView.findViewById(R.id.img_id);
                list_pro = (TextView)itemView.findViewById(R.id.pro_id);
                list_actor = (TextView)itemView.findViewById(R.id.act_id);
                view_type = 1;
            }
            else
            if(view_type == Type_head)
            {
                title_img = (TextView)itemView.findViewById(R.id.title_pic);
                title_act = (TextView)itemView.findViewById(R.id.title_actor);
                title_pro = (TextView)itemView.findViewById(R.id.title_pro);
                view_type = 0;
            }

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
        {
            return Type_head;
        }
        return Type_list;
    }
}

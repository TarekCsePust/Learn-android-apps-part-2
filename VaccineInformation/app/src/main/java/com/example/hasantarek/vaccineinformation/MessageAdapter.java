package com.example.hasantarek.vaccineinformation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasan Tarek on 11/27/2017.
 */
public class MessageAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public MessageAdapter(Context context, int resource) {
        super(context, resource);
    }


    static class handler
    {
        TextView Message,date;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        handler datahandler = new handler();
        if(convertView == null)
        {
            LayoutInflater inflater =(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_message_layout,parent,false);
            datahandler.Message = (TextView)row.findViewById(R.id.text);
            datahandler.date = (TextView)row.findViewById(R.id.date);

            row.setTag(datahandler);
        }
        else
        {
            datahandler = (handler)row.getTag();
        }

        MessagedataProvider messagedataProvider;
        messagedataProvider =(MessagedataProvider)this.getItem(position);
        datahandler.Message.setText(messagedataProvider.getText());
        datahandler.date.setText(messagedataProvider.getDate());


        return row;
    }
}
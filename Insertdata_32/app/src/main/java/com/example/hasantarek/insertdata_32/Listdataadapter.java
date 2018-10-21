package com.example.hasantarek.insertdata_32;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasan Tarek on 7/14/2017.
 */
public class Listdataadapter extends ArrayAdapter {
    List list = new ArrayList();
    public Listdataadapter(Context context, int resource) {
        super(context, resource);
    }

    static class Layouthandler
    {
        TextView lname,lmobile,lemail;
    }
    public void  add(Object object)
    {
        super.add(object);
        list.add(object);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Layouthandler layouthandler;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)
                    this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = layoutInflater.inflate(R.layout.row_layout,parent,false);

             layouthandler = new Layouthandler();
              //id from rowlayout.xml
             layouthandler.lname = (TextView)row.findViewById(R.id.cname);
             layouthandler.lmobile = (TextView)row.findViewById(R.id.cmobile);
             layouthandler.lemail = (TextView)row.findViewById(R.id.cemail);
            row.setTag(layouthandler);
        }
        else
        {
            layouthandler = (Layouthandler)row.getTag();
        }
        Dataprovider dataprovider = (Dataprovider)this.getItem(position);
        layouthandler.lname.setText(dataprovider.getDname().toString());
        layouthandler.lmobile.setText(dataprovider.getDmobile().toString());
        layouthandler.lemail.setText(dataprovider.getDemail().toString());
        return row;
    }
}

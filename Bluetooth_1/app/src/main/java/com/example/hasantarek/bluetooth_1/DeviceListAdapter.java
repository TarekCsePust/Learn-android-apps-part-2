package com.example.hasantarek.bluetooth_1;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 8/28/2017.
 */
public class DeviceListAdapter extends ArrayAdapter<BluetoothDevice>{

    LayoutInflater layoutinflator;
    public  Context context;
    ArrayList<BluetoothDevice> arrayList = new ArrayList<>();
    int res_id;

    public DeviceListAdapter(Context context, int res_id, ArrayList<BluetoothDevice> arrayList) {
        super(context,res_id,arrayList);
        layoutinflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arrayList = arrayList;
        this.res_id = res_id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = layoutinflator.inflate(res_id, null);
        BluetoothDevice device = arrayList.get(position);
        if(device!=null)
        {
            TextView devicename = (TextView)convertView.findViewById(R.id.device_name);
            TextView deviceaddress = (TextView)convertView.findViewById(R.id.address);
            if(devicename!=null)
            {
                devicename.setText(device.getName());
            }

            if(deviceaddress!=null)
            {
                deviceaddress.setText(device.getAddress());
            }
        }

        return convertView;

    }
}

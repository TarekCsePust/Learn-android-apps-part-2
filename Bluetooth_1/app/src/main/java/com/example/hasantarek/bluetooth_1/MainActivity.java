package com.example.hasantarek.bluetooth_1;

import android.Manifest;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button button_on;
    BluetoothAdapter bluetoothAdapter;
    ArrayList<BluetoothDevice> arrayList;
    DeviceListAdapter deviceListAdapter;
    ListView listView;
    //ConnectThread connectThread;



    private final BroadcastReceiver mregisterReciver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            if(action.equals(bluetoothAdapter.ACTION_STATE_CHANGED))
            {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,bluetoothAdapter.ERROR);
                switch (state)
                {
                    case BluetoothAdapter.STATE_ON:
                        Toast.makeText(MainActivity.this,"State off",Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Toast.makeText(MainActivity.this,"Turing On",Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothAdapter.STATE_OFF:
                        Toast.makeText(MainActivity.this,"State off",Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        Toast.makeText(MainActivity.this,"Turing off",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };







    private final BroadcastReceiver mregisterReciver2= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            if(action.equals(bluetoothAdapter.ACTION_SCAN_MODE_CHANGED))
            {
                final int mode = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE,bluetoothAdapter.ERROR);
                switch (mode)
                {
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
                        Toast.makeText(MainActivity.this,"Discoverable enable",Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
                        Toast.makeText(MainActivity.this,"Discoverable disable to recve connection",Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothAdapter.SCAN_MODE_NONE:
                        Toast.makeText(MainActivity.this,"Discoverable not able to recve connection",Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothAdapter.STATE_CONNECTING:
                        Toast.makeText(MainActivity.this,"Connecting",Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothAdapter.STATE_CONNECTED:
                        Toast.makeText(MainActivity.this,"Connected",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };









    private final BroadcastReceiver mregisterReciver3= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


            String action = intent.getAction();
            Toast.makeText(MainActivity.this,"Found discover",Toast.LENGTH_SHORT).show();


            if(action.equals(BluetoothDevice.ACTION_FOUND))
            {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                arrayList.add(device);


                deviceListAdapter.notifyDataSetChanged();
            }
        }
    };







    private final BroadcastReceiver mregisterReciver4= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            if(action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED))
            {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if(device.getBondState() == BluetoothDevice.BOND_BONDED)
                {
                    Toast.makeText(MainActivity.this,"Bonded",Toast.LENGTH_SHORT).show();
                }
                if(device.getBondState() == BluetoothDevice.BOND_BONDING)
                {
                    Toast.makeText(MainActivity.this,"Bondeding",Toast.LENGTH_SHORT).show();
                }
                if(device.getBondState() == BluetoothDevice.BOND_NONE)
                {
                    Toast.makeText(MainActivity.this,"not Bonded",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };





    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"on Destroy is called",Toast.LENGTH_SHORT).show();
        unregisterReceiver(mregisterReciver);
       // connectThread.cancel();

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_on = (Button)findViewById(R.id.onoff_id);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        listView = (ListView)findViewById(R.id.list_view);
        arrayList = new ArrayList<>();
        deviceListAdapter = new DeviceListAdapter(this,R.layout.device_adapter_view,arrayList);
        listView.setAdapter(deviceListAdapter);
        IntentFilter  filter = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        registerReceiver(mregisterReciver4,filter);

        listView.setOnItemClickListener(MainActivity.this);
        button_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enabledisable();
            }
        });


    }




    public void enabledisable()
    {
        if(bluetoothAdapter == null)
        {
            Toast.makeText(MainActivity.this,"not bluetooth that device",Toast.LENGTH_LONG).show();
        }
        if(!bluetoothAdapter.isEnabled())
        {
            Intent enable = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enable);
            IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mregisterReciver, intentFilter);

        }
        if(bluetoothAdapter.isEnabled())
        {
            bluetoothAdapter.disable();
            IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mregisterReciver, intentFilter);
        }
    }





    public void discoverable(View view)
    {

        Intent dicoverable = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        dicoverable.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,300);
        startActivity(dicoverable);

        IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
        registerReceiver(mregisterReciver2, intentFilter);

    }





    public void discoverlist(View view)
    {


        Toast.makeText(MainActivity.this,"click discover",Toast.LENGTH_SHORT).show();




            arrayList.clear();

            deviceListAdapter.notifyDataSetChanged();
            if (bluetoothAdapter.isDiscovering()) {

                Toast.makeText(MainActivity.this," discovering",Toast.LENGTH_SHORT).show();
                bluetoothAdapter.cancelDiscovery();
                checkBTpermission();
                bluetoothAdapter.startDiscovery();
                IntentFilter discoverdevice = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                registerReceiver(mregisterReciver3, discoverdevice);

            }

            else {

                Toast.makeText(MainActivity.this,"not  discovering",Toast.LENGTH_SHORT).show();
                checkBTpermission();
                bluetoothAdapter.startDiscovery();
                IntentFilter discoverdevice = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                registerReceiver(mregisterReciver3, discoverdevice);

            }






    }














    public void checkBTpermission()
    {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            int permission = this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
            permission += this.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
            Toast.makeText(MainActivity.this,"upper lolypop permission " + permission,Toast.LENGTH_SHORT).show();
            if (permission != 0) {
                this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1001);//any number
            }
        }
        else
        {
            Toast.makeText(MainActivity.this,"no need to check permission bcz lower of lolypop",Toast.LENGTH_SHORT).show();

        }



    }






    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        bluetoothAdapter.cancelDiscovery();

        String dvname = arrayList.get(position).getName();
        String dvaddress = arrayList.get(position).getName();

        //BluetoothDevice device =(BluetoothDevice) parent.getItemAtPosition(position);
        Toast.makeText(MainActivity.this,"You click " + dvname,Toast.LENGTH_SHORT).show();
        //connectThread = new ConnectThread(device);
       // connectThread.start();

      if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT)
        {
            Toast.makeText(MainActivity.this,"Try to connect " + dvname ,Toast.LENGTH_SHORT).show();
            arrayList.get(position).createBond();
       }
    }













  /*  private class ConnectThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;

        UUID MY_UUID = UUID.fromString("ec79da00-853f-11e4-b4a9-0800200c9a66");
        public ConnectThread(BluetoothDevice device) {
            // Use a temporary object that is later assigned to mmSocket
            // because mmSocket is final.

            BluetoothSocket tmp = null;
            mmDevice = device;

            try {
                // Get a BluetoothSocket to connect with the given BluetoothDevice.
                // MY_UUID is the app's UUID string, also used in the server code.
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e) {
                Toast.makeText(MainActivity.this,"Socket's create() method failed",Toast.LENGTH_SHORT).show();
               // Log.e(TAG, "Socket's create() method failed", e);
            }
            mmSocket = tmp;
            Toast.makeText(MainActivity.this,"Thread called",Toast.LENGTH_SHORT).show();
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            bluetoothAdapter.cancelDiscovery();

            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                Toast.makeText(MainActivity.this,"try to connect",Toast.LENGTH_SHORT).show();
                mmSocket.connect();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocket.close();
                } catch (IOException closeException) {
                    Toast.makeText(MainActivity.this,"Could not close the client socket",Toast.LENGTH_SHORT).show();
                    //Log.e(TAG, "Could not close the client socket", closeException);
                }
                return;
            }

            Toast.makeText(MainActivity.this,"Connetced",Toast.LENGTH_SHORT).show();
            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.
            //manageMyConnectedSocket(mmSocket);
        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {

                Toast.makeText(MainActivity.this,"Could not close the client socket",Toast.LENGTH_SHORT).show();
                //Log.e(TAG, "Could not close the client socket", e);
            }
        }
    }
*/







}

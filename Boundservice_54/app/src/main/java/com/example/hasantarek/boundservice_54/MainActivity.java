package com.example.hasantarek.boundservice_54;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    TextView textView;
    Myservice myservice;
    boolean Isbind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        Intent intent = new Intent(this,Myservice.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }


    public void firstmsg(View view)
    {

        String msg = myservice.getMessage();
        textView.setText(msg);
    }

    public void secondmsg(View view)
    {

        String msg = myservice.getSecondMessage();
        textView.setText(msg);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Myservice.Localservice localservice = (Myservice.Localservice)service;
            myservice = localservice.getService();
            Isbind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            Isbind = false;

        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if(Isbind)
        {
            unbindService(serviceConnection);
            Isbind = false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

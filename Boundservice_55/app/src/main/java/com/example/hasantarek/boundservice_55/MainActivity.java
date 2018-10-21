package com.example.hasantarek.boundservice_55;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Messenger messenger = null;
    boolean Isbind = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sayHello(View view)
    {

        if(Isbind)
        {
            String btn_txt = ((Button)view).getText().toString();
            if(btn_txt.equals("Say Hello"))
            {
                Message message = Message.obtain(null,Myservice.Job_1,0,0,0);
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            else
                if(btn_txt.equals("Say hello again"))
                {
                    Message message = Message.obtain(null,Myservice.Job_2,0,0,0);
                    try {
                        messenger.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"bind ervice first",Toast.LENGTH_SHORT).show();
        }
    }

    public void bindservice(View view)
    {

        Intent intent = new Intent(this,Myservice.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            messenger = new Messenger(service);
            Isbind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            messenger = null;
            Isbind = false;
        }
    };

    @Override
    protected void onStop() {
        unbindService(serviceConnection);
        messenger = null;
        Isbind = false;
        super.onStop();
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

package com.example.hasantarek.service_56;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
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
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private final int Job_1 = 1;
    private final int Job_2 = 2;
    private final int Job_1_responce = 3;
    private final int Job_2_responce = 4;
    Messenger messenger = null;
    boolean Isbind = false;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,Myservice.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
        textView = (TextView)findViewById(R.id.textView);
    }



    public void getMessage(View view)
    {
        Message message;
        String txt = ((Button)view).getText().toString();
        if(txt.equals("Get frist message"))
        {
             message = Message.obtain(null,Job_1);
             message.replyTo = new Messenger(new Responcehandler());
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        else
        if(txt.equals("Get second message"))
        {
            message = Message.obtain(null,Job_2);
            message.replyTo = new Messenger(new Responcehandler());
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
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
        Isbind = false;
        messenger = null;
        super.onStop();
    }


    class  Responcehandler extends Handler
    {
        @Override
        public void handleMessage(Message msg) {

            String message;
            switch (msg.what)
            {
                case Job_1_responce:
                    message = msg.getData().getString("responce");
                    textView.setText(message);
                    break;
                case Job_2_responce:
                    message = msg.getData().getString("responce");
                    textView.setText(message);
                    break;
                default:
                    super.handleMessage(msg);

            }

        }
    }
}

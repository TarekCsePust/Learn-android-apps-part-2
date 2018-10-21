package com.example.hasantarek.boundservice_55;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

import java.util.logging.Handler;

/**
 * Created by Hasan Tarek on 7/19/2017.
 */
public class Myservice extends Service {
    static final int Job_1 = 1;
    static final int Job_2=2;
    Messenger messenger = new Messenger(new IcommingHandler());
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(),"binded service",Toast.LENGTH_SHORT).show();
        return messenger.getBinder();
    }

     class IcommingHandler extends android.os.Handler
    {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what)
            {
                case Job_1:
                    Toast.makeText(getApplicationContext(),"Say hello from job 1",Toast.LENGTH_SHORT).show();
                    break;
                case Job_2:
                    Toast.makeText(getApplicationContext(),"Say hello from job 2",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }

        }
    }
}

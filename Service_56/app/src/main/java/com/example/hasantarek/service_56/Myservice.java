package com.example.hasantarek.service_56;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/**
 * Created by Hasan Tarek on 7/19/2017.
 */
public class Myservice extends Service {
    private final int Job_1 = 1;
    private final int Job_2 = 2;
    private final int Job_1_responce = 3;
    private final int Job_2_responce = 4;
    Messenger messenger = new Messenger(new IcommingHandler());

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    class IcommingHandler extends Handler
    {
        @Override
        public void handleMessage(Message msg) {
            Message MSG;
            String message;
            Bundle bundle = new Bundle();
            switch (msg.what)
            {
                case Job_1:
                    message = "This is the first message from service";
                    MSG = android.os.Message.obtain(null,Job_1_responce);
                    bundle.putString("responce",message);
                    MSG.setData(bundle);

                    try {
                        msg.replyTo.send(MSG);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                    break;
                case Job_2:
                    message = "This is the second message from service";
                    MSG = android.os.Message.obtain(null,Job_1_responce);
                    bundle.putString("responce",message);
                    MSG.setData(bundle);

                    try {
                        msg.replyTo.send(MSG);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }

        }
    }
}

package com.example.hasantarek.service_53;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Hasan Tarek on 7/18/2017.
 */
public class Myservice extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public Myservice() {
        super("My_worker");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Started Service",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Stoped Service",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        synchronized (this)
        {
            int count = 0;
            while (count<10)
            {
                try {
                    wait(1500);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

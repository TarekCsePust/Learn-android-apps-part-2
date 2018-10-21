package com.example.hasantarek.service_51;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Hasan Tarek on 7/18/2017.
 */
public class Myservice extends Service{



    final class Mythreadclass implements Runnable
    {
        int service_id;
       public Mythreadclass(int service_id)
        {
            this.service_id = service_id;
        }

        @Override
        public void run() {
            int i=0;
            synchronized (this)
            {
                while (i<10)
                {
                    try {
                        wait(1500);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                stopSelf(this.service_id);
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Started service",Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new Mythreadclass(startId));
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Destroy service",Toast.LENGTH_SHORT).show();
    }
}

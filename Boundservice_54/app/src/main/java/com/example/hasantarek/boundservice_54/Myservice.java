package com.example.hasantarek.boundservice_54;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by Hasan Tarek on 7/18/2017.
 */
public class Myservice extends Service {

    private final IBinder iBinder = new Localservice();
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class Localservice extends Binder
    {

        Myservice getService()
        {
            return Myservice.this;
        }
    }

    public String getMessage()
    {
        return "hello Tarek";
    }

    public String getSecondMessage()
    {
        return "Bound service method";
    }
}

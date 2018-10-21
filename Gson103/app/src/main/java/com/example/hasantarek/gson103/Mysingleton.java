package com.example.hasantarek.gson103;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Hasan Tarek on 8/27/2017.
 */
public class Mysingleton  {


    private static Mysingleton mInstance;
    private RequestQueue requestQueue;
    private Context context;

    public Mysingleton(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }

    public static synchronized Mysingleton getmInstance(Context context)
    {
        if(mInstance == null)
        {
            mInstance = new Mysingleton(context);
        }

        return mInstance;
    }

    public  <T> void addTorequest(Request<T> request)
    {
        requestQueue.add(request);
    }

}

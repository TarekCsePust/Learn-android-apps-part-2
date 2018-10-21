package com.example.hasantarek.volley_88;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Hasan Tarek on 8/5/2017.
 */
public class Mysingleton {

    private static Mysingleton mysingleton;
    private static  Context context;
    private RequestQueue requestQueue;


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

    public static synchronized Mysingleton getInstance(Context context)
    {
        if(mysingleton == null)
        {
            mysingleton = new Mysingleton(context);
        }

        return mysingleton;
    }

    public <T> void addrequestqueue(Request<T> request)
    {
        requestQueue.add(request);
    }
}

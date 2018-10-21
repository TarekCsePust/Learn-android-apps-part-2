package com.example.hasantarek.dailynotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int id;
    Button button;
    shraepref s;
    ArrayList<PendingIntent> intentArray = new ArrayList<PendingIntent>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        s = new shraepref(getApplicationContext());
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        id = sharedPreferences.getInt("id",0);
        Toast.makeText(getApplicationContext(),id+"",Toast.LENGTH_SHORT).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar2[] = new Calendar[10];

                calendar2[0] = Calendar.getInstance();
                calendar2[0].set(Calendar.YEAR,2017);
                calendar2[0].set(Calendar.MONTH,10-1);
                calendar2[0].set(Calendar.DAY_OF_MONTH,13);
                calendar2[0].set(Calendar.HOUR_OF_DAY,00);
                calendar2[0].set(Calendar.MINUTE,15);
                calendar2[0].set(Calendar.SECOND,1);

                calendar2[1] = Calendar.getInstance();
                calendar2[1].set(Calendar.YEAR, 2017);
                calendar2[1].set(Calendar.MONTH, 10 - 1);
                calendar2[1].set(Calendar.DAY_OF_MONTH, 13);
                calendar2[1].set(Calendar.HOUR_OF_DAY, 00);
                calendar2[1].set(Calendar.MINUTE,16);
                calendar2[1].set(Calendar.SECOND, 1);


                calendar2[2] = Calendar.getInstance();
                calendar2[2].set(Calendar.YEAR, 2017);
                calendar2[2].set(Calendar.MONTH, 10 - 1);
                calendar2[2].set(Calendar.DAY_OF_MONTH, 13);
                calendar2[2].set(Calendar.HOUR_OF_DAY, 00);
                calendar2[2].set(Calendar.MINUTE, 3);
                calendar2[2].set(Calendar.SECOND, 1);



                for(int i=0;i<2;i++)
                {
                    id++;
                    Intent intent = new Intent(getApplicationContext(),Notification.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),i,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP,calendar2[i].getTimeInMillis(),pendingIntent);
                    intentArray.add(pendingIntent);

                }
               s.id(id);
                /*Calendar calendar =Calendar.getInstance();
                calendar.set(Calendar.YEAR,2017);
                calendar.set(Calendar.MONTH,10-1);
                calendar.set(Calendar.DAY_OF_MONTH,13);
                calendar.set(Calendar.HOUR_OF_DAY,00);
                calendar.set(Calendar.MINUTE,1);
                calendar.set(Calendar.SECOND,1);

                Calendar calendar1 =Calendar.getInstance();
                calendar1.set(Calendar.YEAR,2017);
                calendar1.set(Calendar.MONTH,10-1);
                calendar1.set(Calendar.DAY_OF_MONTH,13);
                calendar1.set(Calendar.HOUR_OF_DAY,00);
                calendar1.set(Calendar.MINUTE,4);
                calendar1.set(Calendar.SECOND,1);
                Toast.makeText(MainActivity.this,"Set alarm",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),Notification.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                Intent intent1 = new Intent(getApplicationContext(),Notification.class);
                PendingIntent pendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(),2,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager1 = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager1.set(AlarmManager.RTC_WAKEUP,calendar1.getTimeInMillis(),pendingIntent1);
                intentArray.add(pendingIntent);
                intentArray.add(pendingIntent1);*/

            }
        });
    }


    public void notification(View view)
    {
        Calendar calendar2[] = new Calendar[10];

        calendar2[0] = Calendar.getInstance();
        calendar2[0].set(Calendar.YEAR,2017);
        calendar2[0].set(Calendar.MONTH,10-1);
        calendar2[0].set(Calendar.DAY_OF_MONTH,13);
        calendar2[0].set(Calendar.HOUR_OF_DAY,00);
        calendar2[0].set(Calendar.MINUTE,15);
        calendar2[0].set(Calendar.SECOND,1);


        id++;
        s.id(id);
        Intent intent = new Intent(getApplicationContext(),Notification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),id,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar2[0].getTimeInMillis(), pendingIntent);
        intentArray.add(pendingIntent);

    }
}

package com.example.hasantarek.timepeacker_20;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Hasan Tarek on 6/17/2017.
 */
public class TimeSetting implements TimePickerDialog.OnTimeSetListener {

    Context mcontext;
    public TimeSetting(Context context)
    {
        this.mcontext = context;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        Toast.makeText(this.mcontext,"select:"+hourOfDay+" "+minute,Toast.LENGTH_SHORT).show();
    }
}

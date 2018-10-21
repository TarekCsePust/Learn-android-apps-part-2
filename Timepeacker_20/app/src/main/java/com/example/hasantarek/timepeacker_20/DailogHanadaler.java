package com.example.hasantarek.timepeacker_20;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by Hasan Tarek on 6/17/2017.
 */
public class DailogHanadaler extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minit = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog;
        TimeSetting timeSetting = new TimeSetting(getActivity());
        timePickerDialog = new TimePickerDialog(getActivity(),timeSetting,hour,minit,
                android.text.format.DateFormat.is24HourFormat(getActivity())
               );
        return timePickerDialog;
    }
}

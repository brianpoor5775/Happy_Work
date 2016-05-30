package com.parse.starter;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;


/**
 * Created by Jean Leong on 5/16/2016.
 */
public class HwDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        DatePickerDialog.OnDateSetListener mListener;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            mListener.onDateSet(datePicker, i, i2, i3);

            System.out.print( "year" + i + "month" + i2 + "day" + i3);
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            Log.i("onAttach", "!!!!!!!!!!!!!!!!!!!!!!!!!!");
            try {
                mListener = (DatePickerDialog.OnDateSetListener) activity;
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
}

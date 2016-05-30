/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class MainActivity extends ActionBarActivity implements DatePickerDialog.OnDateSetListener{

    Button addTask;
    ArrayList<String> hwList = new ArrayList<String>();
    String day, month, year;
    Button datePickerButton;
    ListView hwView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        addTask = (Button) findViewById(R.id.addTask);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTaskStart = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(addTaskStart);
            }
        });

        setToday();
        populateHwList();

        datePickerButton = (Button) findViewById(R.id.datePickerButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HwDatePicker hwDatePicker = new HwDatePicker();
                hwDatePicker.show(getFragmentManager(), "Date Picker");
            }
        });





        /*ParseObject testObject = new ParseObject("Suzumiya");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        final ParseObject gameScore = new ParseObject("Haruhi");
        gameScore.put("score", 2000);
        gameScore.put("playerName", "Bill Collins");
        gameScore.put("cheatMode", false);

        try {
          gameScore.save();
          Log.d("Test", "Success");
        } catch (ParseException e) {
          Log.d("Test", "Error: " + e.getMessage());
        }*/
        /*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Haruhi");
        if (query == null) {
          Log.d("Query", "no such data base");
        }
        query.whereEqualTo("playerName", "Bill Collins");
        try {
          List<ParseObject> resList = query.find();
          Log.d("Query result", "found entries:" + resList.size());

        } catch (ParseException e) {

        }
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public List<ParseObject> findHw() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
        if (query == null) {
            Log.d("Query", "no such data base");
        }
        query.whereEqualTo("month", month);
        try {
            Log.d("Query result", "found entries:" + query.find().size());
            return query.find();


        } catch (ParseException e) {
            return null;
        }
    }
    public void setToday() {
        final Calendar c = Calendar.getInstance();
        year = "" + c.get(Calendar.YEAR);
        month = "" + (c.get(Calendar.MONTH) + 1);
        day = "" + c.get(Calendar.DAY_OF_MONTH);
        Log.d("setToday", month);
        if (Integer.parseInt(month) <= 8)
            this.month = "0" + month;
        else {
            this.month = "" + month;
        }
        this.year = "" + year;
        if (Integer.parseInt(day) <= 9)
            this.day = "0" + day;
        else {
            this.day = "" + day;
        }
        Log.d("setToday", month + "/" + "day");
    }

    public void onDateSet(DatePicker datePicker, int year, int month, int day){
        /*Calendar calendar = Calendar.getInstance();
        calendar.set(year,month, day);
        this.date = calendar.getTime().toString();
        */
        if (month <= 8)
            this.month = "0" + (month+1);
        else {
            this.month = "" + (month+1);
        }
        this.year = "" + year;
        if (day <= 9)
            this.day = "0" + day;
        else {
            this.day = "" + day;
        }
        populateHwList();
    }
    public void populateHwList(){
        hwList = new ArrayList<String>();
        List<ParseObject> parseRetrived = findHw();
        for (int i = 0; i < parseRetrived.size(); i++)
            hwList.add(parseRetrived.get(i).get("date").toString() + "    " +
            parseRetrived.get(i).get("course").toString() + "    " +
            parseRetrived.get(i).get("assignment").toString());
        Collections.sort(hwList);
        //Collections.reverse(hwList);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.hwlistview_item, hwList);
        hwView = (ListView) findViewById(R.id.hwListView);
        hwView.setAdapter(adapter);
    }
}

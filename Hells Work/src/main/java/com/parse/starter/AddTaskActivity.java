package com.parse.starter;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class AddTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener{
    Spinner courseList;
    TextView assignment;
    Button dueDateButton;
    String name, date, subject;
    String month, day, year;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        dueDateButton = (Button) findViewById(R.id.dueDateButton);
        dueDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HwDatePicker hwDatePicker = new HwDatePicker();
                hwDatePicker.show(getFragmentManager(), "Date Picker");
            }
        });

        courseList = (Spinner) findViewById(R.id.courseSpinner);
        addItemsOnTypeSpinner(courseList);
        addListenerOnSpinnerItemSelection(courseList);

        assignment = (TextView) findViewById(R.id.assignemntText);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = assignment.getText().toString();
                ParseObject task = new ParseObject("Task");
                task.put("assignment", name);
                task.put("date", date);
                task.put("month", month);
                task.put("day", day);
                task.put("year",year);
                task.put("course", subject);
                task.saveInBackground();
            }
        });

    }
    //Spinner Methods
    public void addItemsOnTypeSpinner(Spinner spinner) {

        List<String> list = new ArrayList<String>();
        list.add("AP Calculus AB");
        list.add("AP Calculus BC");
        list.add("AP Statistics");
        list.add("SUPA Forensics");
        list.add("Chorus");
        list.add("Band");
        list.add("Orchestra");
        list.add("Introduction to Theater");
        list.add("Acting 1");
        list.add("Acting Lab");
        list.add("Music Technology");
        list.add("Performance Technology");
        list.add("Music Theory");
        list.add("AP Music Theory");
        list.add("Studio Art");
        list.add("Advanced Studio Art");
        list.add("AP Studio Art 2-D Design");
        list.add("AP Studio Art Drawing");
        list.add("AP Studio Art 3-D Design");
        list.add("Studio in Crafts");
        list.add("Mixed Media");
        list.add("Ceramics");
        list.add("Advanced Ceramics");
        list.add("AP Art 3-D Design");
        list.add("Digital Art & Photography");
        list.add("Drawing");
        list.add("Painting");
        list.add("Photography");
        list.add("Advanced Photography");
        list.add("Independent Study in Art");
        list.add("Geometry");
        list.add("Geometry H");
        list.add("Quantitative Geometry");
        list.add("Algebra 1");
        list.add("Algebra 1A");
        list.add("Algebra 1B");
        list.add("ESOL Mathematics");
        list.add("Algebra 2 & Trigonometry");
        list.add("Algebra 2 & Trigonometry H");
        list.add("Algebra 2A");
        list.add("Algebra 2B");
        list.add("Pre-Calculus");
        list.add("Pre-Calculus H");
        list.add("College Algebra");
        //list.add("");
        list.add("ESOL Science");
        list.add("AP Chemistry");
        list.add("AP Biology");
        list.add("Living Environment R");
        list.add("Physics Topics");
        list.add("Physics R");
        list.add("Chemistry in the Community");
        list.add("Chemistry R");
        list.add("Chemistry H");
        list.add("Earth Science R");
        list.add("AP Environmental Science");
        list.add("AP Physics C");
        list.add("Science Research");
        list.add("Introduction to Engineering Design");
        list.add("Principles of Engineering");
        list.add("Computer Integrated Manufacturing");
        list.add("Astronomy");
        list.add("Bioethics");
        list.add("Clmate & Meteorology");
        list.add("SUNY Oneonta – Planet Earth");
        list.add("Sustainability: Action for Change");
        list.add("Introduction to Computer Science");
        list.add("Computer Science 1");
        list.add("AP Computer Science Principles");
        list.add("AP Computer Science A");
        list.add("Film Writing & Analysis");
        list.add("Creative Writing");
        list.add("World Mythology");
        list.add("Public Speaking & Speech Writing");
        list.add("Journalism/Writing to Publish");
        list.add("Race & Gender in Literature");
        list.add("Modern Literature");
        list.add("Philosophy of the Wild");
        list.add("ESOL");
        list.add("AP Language & Composition");
        list.add("AP Literature & Composition");
        list.add("Mastering Microsoft Office");
        list.add("Freshamn Writing Seminar");
        list.add("English 1R");
        list.add("English 2R");
        list.add("English 2H");
        list.add("English 3R");
        list.add("English 3H");
        list.add("Society, Literature, and Truth (SLT)");
        list.add("Economics");
        list.add("Public Affairs");
        list.add("Economics H");
        list.add("Public Affairs H");
        list.add("Global History nad Geography");
        list.add("World Histroy 10");
        list.add("AP World History");
        list.add("AP U.S. History");
        list.add("U.S. History R");
        list.add("Developmental Psychology");
        list.add("Philosophy");
        list.add("Independent Study");
        list.add("Money Management");
        list.add("Computers & Business for English Language Learners");
        list.add("Business Law");
        list.add("Sports Marketing");
        list.add(" -Select Course- ");
        list.add("Research Seminar in American History");
        list.add("ESL Social Studies");
        list.add("Diversity Studies - Race, Class, and Gender");
        list.add("Classics, Culture, and the Human Condition");
        list.add("America's Challenge Diversity");
        list.add("Accounting 1");
        list.add("College Accounting");
        list.add("AP European History");
        list.add("Introduction to Engineering Design");
        list.add("Physical Education");
        list.add("Health Education");
        list.add("Modern World Languages");
        list.add("French 2");
        list.add("French 3");
        list.add("French 4");
        list.add("French 5");
        list.add("AP French");
        list.add("Italian 2");
        list.add("Italian 3");
        list.add("Italian 4");
        list.add("Italian 5");
        list.add("AP Italian");
        list.add("French and Italian Levels 1 & 2");
        list.add("Spanish 1");
        list.add("Spanish 2");
        list.add("Spanish 3");
        list.add("Spanish 4");
        list.add("Spanish 5");
        list.add("AP Spanish");
        list.add("Introduction to Spanish Language & Literature");
        list.add("Latin American Studies");
        list.add("Iberian Studies");
        list.add("AP Spanish Language");
        list.add("AP Spanish Literature");
        list.add("Latin American Studies");
        list.add("Latin 1 & 2");
        list.add("Latin 3");
        list.add("Latin 4");
        list.add("French 1 & 2");
        list.add("Italian 1 & 2");
        list.add("Introduction to Latin & Greek");
        Collections.sort(list);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection(Spinner spinner) {
        //spinner.setOnItemSelectedListener(new SpinnerOnItemSelectedListener());
        spinner.setOnItemSelectedListener(this);
        Log.d("[addListenerOnSpinner]", "setSpinner");
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        subject = parent.getItemAtPosition(pos).toString();
        Log.d("It works :D", "It really does");
    }

    public void onNothingSelected(AdapterView<?> parent){
        //another interface callback
        Log.i("Nothing was Selected??", "" + subject);
    }

    //Date Picker Methods
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
        this.date = "" + this.year + "/" + this.month + "/" + this.day;
        setText();
    }

    public void setText(){
        dueDateButton.setText(date);
    }
}

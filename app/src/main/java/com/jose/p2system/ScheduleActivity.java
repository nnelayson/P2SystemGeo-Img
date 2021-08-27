package com.jose.p2system;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button btnSchedDone;
    EditText etDate, et_fname, et_lname, et_femail, et_fphone;
    TextView tvtTimer2;
    int  t2Hour, t2Minute;
    DatePickerDialog.OnDateSetListener setListener;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        // Set Time
        tvtTimer2 = findViewById(R.id.tv_timer2);


        //Date
        etDate = findViewById(R.id.et_date);
        btnSchedDone = findViewById(R.id.btnSchedDone);

        // Assign Variables for Validation
        et_fname = findViewById(R.id.et_fname);
        et_lname = findViewById(R.id.et_lname);
        et_femail = findViewById(R.id.et_femail);
        et_fphone = findViewById(R.id.et_fphone);

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add Validation for First Name
        awesomeValidation.addValidation(this,R.id.et_fname,
                RegexTemplate.NOT_EMPTY,R.string.invalid_fname);

        //Add Validation for Last Name
        awesomeValidation.addValidation(this,R.id.et_lname,
                RegexTemplate.NOT_EMPTY,R.string.invalid_lname);

        //for Email
        awesomeValidation.addValidation(this,R.id.et_femail
                , Patterns.EMAIL_ADDRESS,R.string.invalid_femail);

        //for Phone
        awesomeValidation.addValidation(this,R.id.et_fphone
                ,"[5-9]{1}[0-9]{9}$",R.string.invalid_fphone);


        //Spinner
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        btnSchedDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (awesomeValidation.validate()) {
                    // On Success

                    Toast.makeText(getApplicationContext(),"Form Validation Successfully...", Toast.LENGTH_SHORT);

                } else {
                    Toast.makeText(getApplicationContext()
                            ,"Validation Failed.", Toast.LENGTH_SHORT);
                }

                Intent intent = new Intent(ScheduleActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        ScheduleActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month +1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });

        tvtTimer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        ScheduleActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t2Hour = hourOfDay;
                                t2Minute = minute;
                                String time = t2Hour + ":" + t2Minute;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);

                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    tvtTimer2.setText(f12Hours.format(date));

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },12,0,false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                timePickerDialog.updateTime(t2Hour,t2Minute);
                timePickerDialog.show();


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       /// String text = parent.getItemAtPosition(position).toString();
       /// Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
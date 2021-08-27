package com.jose.p2system;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class AdoptionActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton, btnNext;

    AwesomeValidation awesomeValidation;
    EditText et_name, et_age, et_address, et_phone, et_email, et_occupation, et_alter, et_relationship, et_mobile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption);

        dateButton = findViewById(R.id.dateButton);
        dateButton.setText(getTodayDate());
        btnNext = findViewById(R.id.btnNext);



        //Assign Variables
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_address = findViewById(R.id.et_address);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_occupation = findViewById(R.id.et_occupation);
        et_alter = findViewById(R.id.et_alter);
        et_relationship = findViewById(R.id.et_relationship);
        et_mobile = findViewById(R.id.et_mobile);



        

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add Validation for Name
        awesomeValidation.addValidation(this,R.id.et_name,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        //For Mobile Number
        awesomeValidation.addValidation(this,R.id.et_phone
        ,"[5-9]{1}[0-9]{9}$",R.string.invalid_phone);

        //for Email
        awesomeValidation.addValidation(this,R.id.et_email
        , Patterns.EMAIL_ADDRESS,R.string.invalid_email);


        // Picker
       initdatePicker();


       btnNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               Intent intent = new Intent(AdoptionActivity.this, ScheduleActivity.class);
               startActivity(intent);
           }
       });



    }

    private String getTodayDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
             int month = cal.get(Calendar.MONTH);
            month = month + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);

              return  makeDateString(day, month, year);

          }

          private void initdatePicker() {

             DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
               public void onDateSet(DatePicker view, int year, int month, int day) {
                     month = month + 1;
               String date = makeDateString(day, month, year);
                  dateButton.setText(date);


               }
          };
              Calendar cal = Calendar.getInstance();
              int year = cal.get(Calendar.YEAR);
              int month = cal.get(Calendar.MONTH);
               int day = cal.get(Calendar.DAY_OF_MONTH);

              int style = AlertDialog.THEME_HOLO_LIGHT;

             datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
              datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
          }

           private String makeDateString(int day, int month, int year) {

              return getMonthFormat(month) + " " + day + " " + year;


           }

          private String getMonthFormat(int month) {

              if(month == 1)
                   return "JAN";
              if(month == 2)
                  return "FEB";
              if(month == 3)
               return "MAR";
              if(month == 4)
                 return "APR";
               if(month == 5)
               return "MAY";
                if(month == 6)
               return "JUN";
           if(month == 7)
                 return "JUL";
             if(month == 8)
                 return "AUG";
             if(month == 9)
                return "SEP";
            if(month == 10)
                return "OCT";
            if(month == 11)
                return "NOV";
             if(month == 12)
                  return "DEC";
          ///    Default
             return "JAN";


          }

           public void openDatePicker(View view){

              datePickerDialog.show();

          }

}
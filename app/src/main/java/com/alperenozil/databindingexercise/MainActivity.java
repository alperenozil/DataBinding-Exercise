package com.alperenozil.databindingexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alperenozil.databindingexercise.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler mainActivityClickHandler;
    private static final String TAG = "MainActivity";
    private Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        student=new Student("name","mail");
        mainActivityClickHandler=new MainActivityClickHandler(this);
        activityMainBinding.setClickHandler(mainActivityClickHandler);

    }

    public Student setStudent(Student student,String name){
        student.setName(name);
        return student;
    }

    public class MainActivityClickHandler{
        Context context;

        public MainActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onFirstButtonClick(View view){
            // on every button click it changes student name and ui updates itself automatically.
            activityMainBinding.setStudent(setStudent(student,String.valueOf(System.currentTimeMillis())));
            Log.d(TAG, "onFirstButtonClick: ");
        }
    }
}
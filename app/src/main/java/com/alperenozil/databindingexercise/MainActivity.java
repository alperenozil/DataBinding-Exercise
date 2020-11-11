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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setStudent(getStudent());

        mainActivityClickHandler=new MainActivityClickHandler(this);
        activityMainBinding.setClickHandler(mainActivityClickHandler);

    }

    public Student getStudent(){
        Student student=new Student("alperen","mail");
        return student;
    }

    public class MainActivityClickHandler{
        Context context;

        public MainActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onFirstButtonClick(View view){
            Log.d(TAG, "onFirstButtonClick: ");
        }
    }
}
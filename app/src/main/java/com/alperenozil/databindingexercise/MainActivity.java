package com.alperenozil.databindingexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewEmail,textViewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewEmail=findViewById(R.id.textViewEmail);
        textViewName=findViewById(R.id.textViewName);

        textViewName.setText(getStudent().getName());
        textViewEmail.setText(getStudent().getEmail());
    }

    public Student getStudent(){
        Student student=new Student("alperen","mail");
        return student;
    }
}
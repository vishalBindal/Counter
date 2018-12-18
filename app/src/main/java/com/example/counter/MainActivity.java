package com.example.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView countView;
    Button incButton;
    Button resetButton;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView=findViewById(R.id.display);
        incButton=findViewById(R.id.increase);
        resetButton=findViewById(R.id.reset);
        count=0;
    }

    public void inc(View view){
        count++;
        countView.setText("" + count);
    }

    public void res(View view){
        count=0;
        countView.setText("" + count);
    }
}


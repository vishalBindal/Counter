package com.example.counter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView countView;
    Button incButton;
    Button resetButton;
    int count;
    EditText incrementNo;
    int increment;
    RadioGroup radioGroup;
    RadioGroup radioGroup2;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView=findViewById(R.id.display);
        incButton=findViewById(R.id.increase);
        resetButton=findViewById(R.id.reset);
        count=0;
        incrementNo=findViewById(R.id.editText);
        increment=1;
        radioGroup=findViewById(R.id.rGroup);
        radioGroup2=findViewById(R.id.rGroup2);
        radioGroup.check(R.id.inc1);
        incrementNo.setEnabled(false);
        radioGroup2.clearCheck();
    }

    public void readNo(){
        if(incrementNo!=null){
            if(incrementNo.getText().toString().equals("")){
                increment=1;
            }
            else {
                increment = Integer.parseInt(incrementNo.getText().toString());
            }
        }
    }

    public void onRadioButtonClicked(View view) {
        //boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.inc_other:
                    incrementNo.setEnabled(true);
                    radioGroup.clearCheck();
                    break;
            default:
                incrementNo.setEnabled(false);
                radioGroup2.clearCheck();
        }
    }

    public void check(){
            if(radioGroup.getCheckedRadioButtonId()==-1) {
                readNo();
            }
            else {
                radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                switch (radioButton.getId()) {
                    case R.id.inc1:
                        increment = 1;
                        break;
                    case R.id.inc2:
                        increment=2;
                        break;
                    case R.id.inc5:
                        increment = 5;
                        break;
                    case R.id.inc10:
                        increment = 10;
                        break;
                }
            }
        }


    public void inc(View view){
        countView.animate()
                .alpha(0f)
                .setDuration(70)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        check();
                        count+=increment;
                        countView.setText("" + count);
                        countView.animate()
                                .alpha(1f)
                                .setDuration(70)
                                .setListener(null);
                    }
                });


    }

    public void res(View view){
        count=0;
        countView.setText("" + count);
    }
}


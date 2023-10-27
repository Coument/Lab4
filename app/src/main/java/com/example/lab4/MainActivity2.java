package com.example.lab4;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    private EditText editText;
    private RadioGroup group1,group2;
    private Button  btn;
    private String sugar="無糖";
    private String ice="去冰";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        group1=findViewById(R.id.rgroup);
        group1.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i==R.id.radioButton){
                sugar="無糖";
            }
            else if (i==R.id.radioButton2){
                sugar="少糖";
            }
            else if (i==R.id.radioButton3){
                sugar="半糖";
            }
            else if (i==R.id.radioButton4){
                sugar="全糖";
            }
        });
        group2=findViewById(R.id.rgroup2);
        group2.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i==R.id.radioButton5){
                ice="去冰";
            }
            else if (i==R.id.radioButton6){
                ice="微冰";
            }
            else if (i==R.id.radioButton7){
                ice="少冰";
            }
            else if (i==R.id.radioButton8){
                ice="正常";
            }
        });
        btn=findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            editText=findViewById(R.id.editdrink);
            String drink=editText.getText().toString();
            Intent i=new Intent();
            Bundle b=new Bundle();
            b.putString("drink",drink);
            b.putString("sugar",sugar);
            b.putString("ice",ice);
            i.putExtras(b);
            setResult(Activity.RESULT_OK,i);
            finish();
        });
    }
}
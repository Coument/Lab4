package com.example.lab4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView meal;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meal=findViewById(R.id.meal);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(view -> {
            mealresult.launch(new Intent(this, MainActivity2.class));
        });
    }
    private final ActivityResultLauncher<Intent> mealresult=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
        if(result.getResultCode()==Activity.RESULT_OK){
            Intent intent=result.getData();
            if (intent!=null && intent.getExtras()!=null){
                Bundle b=intent.getExtras();
                String str1=b.getString("drink");
                String str2=b.getString("sugar");
                String str3=b.getString("ice");
                meal.setText(String.format("飲料:%s\n甜度:%s\n冰塊:%s",str1,str2,str3));
            }
        }
    });
}
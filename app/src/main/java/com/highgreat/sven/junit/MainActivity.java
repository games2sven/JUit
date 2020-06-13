package com.highgreat.sven.junit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.highgreat.sven.junit.activity.CalculatorActivity;
import com.highgreat.sven.junit.activity.PersonalInfoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.calculator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CalculatorActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        findViewById(R.id.personal_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PersonalInfoActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}
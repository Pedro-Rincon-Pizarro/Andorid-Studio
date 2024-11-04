package com.example.appradiobutton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RadioButton btn1, btn2;
        RadioGroup rg;
        TextView txt;
        CheckBox chb;

        btn1 = findViewById(R.id.radioButton);
        btn2 = findViewById(R.id.radioButton2);

        rg = findViewById(R.id.radioGroup);

        txt = findViewById(R.id.textView);

        chb = findViewById(R.id.checkBox);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId)
            {
                if(checkedId == R.id.radioButton)
                {
                    txt.setText(getString(R.string.textView1)  + " " + btn1.getText());
                }
                else
                {
                    txt.setText(getString(R.string.textView1) +  " " + btn2.getText());
                }
            }
        });

        chb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b)
                {
                    Toast.makeText(MainActivity.this, "Te encanta programar!!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "¿No te gusta programar?", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
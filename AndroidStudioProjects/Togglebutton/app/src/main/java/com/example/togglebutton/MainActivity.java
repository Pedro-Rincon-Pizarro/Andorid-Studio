package com.example.togglebutton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    ImageView img;
    ToggleButton tbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        txt = findViewById(R.id.textView);
        img = findViewById(R.id.imageView);
        tbt = findViewById(R.id.toggleButton);


        tbt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b)
                {
                    tbt.getTextOn();
                    txt.setText("Llamando...");
                    img.setImageResource(R.drawable.colgar);
                }
                else
                {
                    tbt.getTextOff();
                    txt.setText("");
                    img.setImageResource(R.drawable.llamar);
                }

            }
        });
    }
}
package com.example.traduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    GridLayout grid;
    View view;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.grid1);
        for(int i = 0; i < grid.getChildCount(); i++)
        {
            view = grid.getChildAt(i);
            if(view instanceof Button)
            {
                view.setBackgroundColor(Color.parseColor("green"));
            }
            else if(view instanceof TextView)
            {
                view.setBackgroundColor(Color.parseColor("yellow"));
            }
        }
    }
}
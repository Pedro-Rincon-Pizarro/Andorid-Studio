package com.example.botonesauto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    GridLayout grid;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.grid1);

        for (int fila = 0; fila < grid.getRowCount(); fila++)
        {
            for(int columna = 0; columna < grid.getColumnCount(); columna++)
            {
                button = new Button(this);
                button.setText("Fila " + fila + " Col: " + columna);
                button.setId(ViewGroup.generateViewId());
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec =  GridLayout.spec(fila);
                params.columnSpec = GridLayout.spec(columna);
                params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                params.setMargins(10, 10, 10, 10);

                grid.addView(button,params);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setBackgroundColor(Color.parseColor("yellow"));
                    }
                });
            }
        }


    }
}
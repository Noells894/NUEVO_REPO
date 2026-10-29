// REEMPLAZA ESTA PRIMERA LÍNEA POR TU LÍNEA DE PACKEGE ORIGINAL SI SIGUE EN ROJO
package com.example.myapplication;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Switch switch1;
    private TextView textViewStatus;


    protected void Bundle_onCreate(Bundle savedInstanceState) {
        // Marcador de posición para asegurar que no se rompa la estructura
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        switch1 = findViewById(R.id.switch1);
        textViewStatus = findViewById(R.id.textViewStatus);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    textViewStatus.setText("Estado: no esta apagado");
                } else {
                    textViewStatus.setText("Estado: no esta encendido");
                }
            }
        });
    }
}
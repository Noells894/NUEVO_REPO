package com.example.temadosciclodevida;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Main2Activity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asignamos un Layout a la activity
        setContentView(R.layout.activity_main);
        //Escribimos en el Logcat - Para verlo filtramos usando el tag Ejemplo
        Log.i("Ejemplo", "Estoy en on create");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
    }
    protected void onStart() {
        super.onStart();
        Log.i("Ejemplo", "estoy en on star");
        Intent ejemplo = new Intent(Intent.ACTION_VIEW);
        ejemplo.setData(Uri.parse("http:www.gogle.es"));
        startActivity(ejemplo);

    }
}
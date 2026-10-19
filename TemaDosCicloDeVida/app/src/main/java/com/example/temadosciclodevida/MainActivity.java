package com.example.temadosciclodevida;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

    public class MainActivity extends AppCompatActivity{
    //On create es cuando se crea la activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //Asignamos un Layout a la activity
        setContentView(R.layout.activity_main);
    //Escribimos en el Logcat - Para verlo filtramos usando el tag Ejemplo
        Log.i("Ejemplo", "Estoy en on create");
    }
    protected void onStart() {
        super.onStart();
        Log.i("Ejemplo", "estoy en on star");
    }
    protected void onRestart() {
        super.onRestart();
        Log.i("Ejemplo", "estoy en on restat");
    }
    protected void onResume() {
        super.onResume();
        Log.i("Ejemplo", "estoy en on resume");
    }
    protected void onPause () {
        super.onPause();
        Log.i("Ejemplo", "estoy en on pause");
    }
    protected void onStop() {
        super.onStop();
        Log.i("Ejemplo", "Estoy en on Stop");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ejemplo", "estoy en on destroy");
        Intent ejemplo= new Intent(this, MainActivity2.class);
        startActivity(ejemplo);
    };
}

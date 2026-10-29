// Indica la ubicación de esta clase dentro de tu proyecto de RatingBar
package com.example.ratingbar;

// Importa la herramienta necesaria para manejar el arranque de la pantalla
import android.os.Bundle;
// Importa la clase que permite controlar la barra de estrellas (RatingBar) en Java
import android.widget.RatingBar;
// Importa la clase que permite modificar textos (TextView) en Java
import android.widget.TextView;

// Importa la librería para permitir diseños que ocupen toda la pantalla física
import androidx.activity.EdgeToEdge;
// Importa la base estándar sobre la que se construyen las pantallas modernas de Android
import androidx.appcompat.app.AppCompatActivity;
// Importa la herramienta para gestionar dimensiones de los márgenes del sistema
import androidx.core.graphics.Insets;
// Importa funciones de compatibilidad para controlar vistas del sistema
import androidx.core.view.ViewCompat;
// Importa la herramienta para detectar las barras de estado y navegación del móvil
import androidx.core.view.WindowInsetsCompat;

// Define la clase principal de tu pantalla
public class MainActivity extends AppCompatActivity {

    // Declara una variable privada para guardar la referencia a tu barra de estrellas
    private RatingBar ratingBar;
    // Declara una variable privada para guardar la referencia a tu texto de puntuación
    private TextView textViewRating;

    // El método onCreate se ejecuta en cuanto se abre la aplicación
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Llama a la configuración interna obligatoria de Android
        super.onCreate(savedInstanceState);

        // Habilita el diseño de borde a borde para que la app aproveche toda la pantalla
        EdgeToEdge.enable(this);

        // Conecta este código Java con el archivo de diseño visual XML
        setContentView(R.layout.activity_main);


        // Vincula la variable de Java con el componente RatingBar del XML usando su ID único
        ratingBar = findViewById(R.id.ratingBar);
        // Vincula la variable de Java con el componente TextView del XML usando su ID único
        textViewRating = findViewById(R.id.textViewRating);

        // Asigna un escuchador al RatingBar para vigilar cuando cambien las estrellas (Código de tu imagen)
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            // Este método se activa automáticamente cada vez que el usuario pulsa o arrastra sobre las estrellas
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // Actualiza el TextView con la calificación seleccionada (el parámetro 'rating' guarda el número)
                textViewRating.setText("Calificación: " + rating);
            }
        });
    }
}

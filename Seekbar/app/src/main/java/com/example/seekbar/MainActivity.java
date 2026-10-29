// Indica la ubicación de esta clase dentro de tu proyecto de SeekBar
package com.example.seekbar;

// Importa la herramienta necesaria para manejar el arranque de la pantalla
import android.os.Bundle;
// Importa la clase que permite controlar la barra deslizante (SeekBar) en Java
import android.widget.SeekBar;
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

    // Declara una variable privada para guardar la referencia a tu barra deslizante
    private SeekBar seekBar;
    // Declara una variable privada para guardar la referencia a tu texto
    private TextView textViewProgress;

    // El método onCreate se ejecuta en cuanto se abre la aplicación
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Llama a la configuración interna obligatoria de Android
        super.onCreate(savedInstanceState);

        // Habilita el diseño de borde a borde para que la app aproveche toda la pantalla
        EdgeToEdge.enable(this);

        // Conecta este código Java con el archivo de diseño visual XML
        setContentView(R.layout.activity_main);

        // Configura un escuchador para ajustar los márgenes según las barras del sistema (hora, batería, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincula la variable de Java con el componente SeekBar del XML usando su ID único
        seekBar = findViewById(R.id.seekBar);
        // Vincula la variable de Java con el componente TextView del XML usando su ID único
        textViewProgress = findViewById(R.id.textViewProgress);

        // Asigna un escuchador al SeekBar para vigilar los movimientos del usuario (Código de tu imagen)
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // 1. Este método se activa CADA VEZ que el usuario desliza el dedo y cambia el número
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Modifica el texto en tiempo real para mostrar la palabra "Valor: " seguida del número actual
                textViewProgress.setText("Valor: " + progress);
            }

            // 2. Este método se activa JUSTO CUANDO el usuario pone el dedo sobre la barra para empezar a moverla
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Aquí puedes añadir lógica si necesitas hacer algo cuando el usuario empieza a mover el SeekBar
            }

            // 3. Este método se activa JUSTO CUANDO el usuario levanta el dedo de la barra tras terminar de moverla
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Aquí puedes añadir lógica si necesitas hacer algo cuando el usuario termina de mover el SeekBar
            }
        });
    }
}

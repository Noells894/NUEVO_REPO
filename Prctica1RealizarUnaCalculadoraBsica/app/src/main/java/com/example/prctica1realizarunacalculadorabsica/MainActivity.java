package com.example.prctica1realizarunacalculadorabsica;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //cramos botones
    public Button boton1;
    public Button boton2;
    public Button boton3;
    public Button boton4;
    public Button boton5;
    public Button boton6;
    public Button boton7;
    public Button boton8;
    public Button boton9;
    public Button boton0;
    public Button botonmas;
    public Button botonmenos;
    public Button botonpor;
    public Button botonentre;
    public Button botonborrar;
    public Button botonigual;
    public Button botonpotencia;
    public Button botonresultado;
    public Button botonborrartodo;
    public Button botonrespuesta;
    public Button botoncoma;

    String[] operadores = {"+", "-", "*", "/", "^"};
    String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //nombramos los botones segun el id del xml
        boton1 = findViewById(R.id.boton1);
        boton2 = findViewById(R.id.boton2);
        boton3 = findViewById(R.id.boton3);
        boton4 = findViewById(R.id.boton4);
        boton5 = findViewById(R.id.boton5);
        boton6 = findViewById(R.id.boton6);
        boton7 = findViewById(R.id.boton7);
        boton8 = findViewById(R.id.boton8);
        boton9 = findViewById(R.id.boton9);
        boton0 = findViewById(R.id.boton0);
        botonmas = findViewById(R.id.botonmas);
        botonmenos = findViewById(R.id.botonmenos);
        botonpor = findViewById(R.id.botonpor);
        botonentre = findViewById(R.id.botonentre);
        botonborrar = findViewById(R.id.botonborrar);
        botonigual = findViewById(R.id.botonigual);
        botonresultado = findViewById(R.id.botonresultado);
        botonborrartodo = findViewById(R.id.botonborrartodo);
        botonrespuesta = findViewById(R.id.botonrespuesta);
        botoncoma = findViewById(R.id.botoncoma);
        botonpotencia = findViewById(R.id.botonpotencia);

        //listeners
        boton1.setOnClickListener(v -> {
            PonerSimbolo("1");
        });

        boton2.setOnClickListener(v -> {
            PonerSimbolo("2");
        });

        boton3.setOnClickListener(v -> {
            PonerSimbolo("3");
        });

        boton4.setOnClickListener(v -> {
            PonerSimbolo("4");
        });

        boton5.setOnClickListener(v -> {
            PonerSimbolo("5");
        });

        boton6.setOnClickListener(v -> {
            PonerSimbolo("6");
        });

        boton7.setOnClickListener(v -> {
            PonerSimbolo("7");
        });

        boton8.setOnClickListener(v -> {
            PonerSimbolo("8");
        });

        boton9.setOnClickListener(v -> {
            PonerSimbolo("9");
        });

        boton0.setOnClickListener(v -> {
            PonerSimbolo("0");
        });

        botonmas.setOnClickListener(v -> {
            PonerSimbolo("+");
        });

        botonmenos.setOnClickListener(v -> {
            PonerSimbolo("-");
        });

        botonpor.setOnClickListener(v -> {
            PonerSimbolo("*");
        });

        botonentre.setOnClickListener(v -> {
            PonerSimbolo("/");
        });

        botonpotencia.setOnClickListener(v -> {
            PonerSimbolo("^");
        });

        botonborrar.setOnClickListener(v -> {
            String texto = botonresultado.getText().toString();

            if (!texto.isEmpty()) {
                texto = texto.substring(0, texto.length() - 1);
                botonresultado.setText(texto);
            }
        });

        botonborrartodo.setOnClickListener(v -> {
            botonresultado.setText("0");
        });

        botoncoma.setOnClickListener(v -> {
            PonerSimbolo(",");
        });

        botonigual.setOnClickListener(v -> {
            calcular();
        });
    }
    public void PonerSimbolo(String simbolo) {
        String texto = botonresultado.getText().toString();

        if (texto.equals("0") && !simbolo.equals(",")) {
            if (Arrays.asList(operadores).contains(simbolo)) {
                return;
            } else {
                texto = "";
            }
        }

        if (texto.isEmpty()) {
            if (Arrays.asList(operadores).contains(simbolo)) {
                return;
            }
        }

        if (simbolo.equals(",")) {
            int posicion = texto.lastIndexOf(",");                      //buscamos la posicion de la ultima coma
            if (posicion != -1) {
                int operador = Math.max(                              //buscamos la posicion del ultimo operador
                        Math.max(texto.lastIndexOf("+"), texto.lastIndexOf("-")),  //buscamos el ultimo + o -
                        Math.max(texto.lastIndexOf("*"), texto.lastIndexOf("/"))   //buscamos el ultimo * o /
                );
                if (posicion > operador) {                             //si la coma esta despues del operador
                    return;                                             //no permitimos poner otra coma
                }
            }
            if (texto.isEmpty() || texto.endsWith("+") ||             //si esta vacio o termina en +
                    texto.endsWith("-") || texto.endsWith("*") ||     //si termina en - o *
                    texto.endsWith("/")) {                             //si termina en /
                texto = texto + "0";                                   //añadimos un 0 antes de la coma
            }
        }
        if (Arrays.asList(numeros).contains(simbolo)) {

            int operador = Math.max(
                    Math.max(texto.lastIndexOf("+"), texto.lastIndexOf("-")),
                    Math.max(texto.lastIndexOf("*"), texto.lastIndexOf("/"))
            );

            String numero = texto.substring(operador + 1);

            if (numero.equals("0") && !simbolo.equals("0")) {
                texto = texto.substring(0, texto.length() - 1);
            }

            if (numero.equals("0") && simbolo.equals("0")) {
                return;
            }
        }

        if (!texto.isEmpty()) {
            String ultimo = String.valueOf(texto.charAt(texto.length() - 1));

            if (Arrays.asList(operadores).contains(ultimo) &&
                    Arrays.asList(operadores).contains(simbolo)) {

                texto = texto.substring(0, texto.length() - 1);
            }
        }

        botonresultado.setText(texto + simbolo);
    }

    public void calcular() {
        String texto = botonresultado.getText().toString();

        if (texto.isEmpty()) {
            return;
        }

        if (texto.endsWith("+") || texto.endsWith("-") ||
                texto.endsWith("*") || texto.endsWith("/") ||
                texto.endsWith("^")) {
            return;
        }

        texto = texto.replace(',', '.');

        double resultado = 0;
        double numero = 0;
        char operador = '+';
        int posicion = 0;

        do {
            String numeroTexto = "";

            while (posicion < texto.length() &&
                    (Character.isDigit(texto.charAt(posicion)) ||
                            texto.charAt(posicion) == '.')) {

                numeroTexto = numeroTexto + texto.charAt(posicion);
                posicion++;
            }

            numero = Double.parseDouble(numeroTexto);

            switch (operador) {
                case '+':
                    resultado = resultado + numero;
                    break;

                case '-':
                    resultado = resultado - numero;
                    break;

                case '*':
                    resultado = resultado * numero;
                    break;

                case '/':
                    resultado = resultado / numero;
                    break;

                case '^':
                    double base = resultado;
                    double exponente = numero;
                    resultado = 1;

                    for (int i = 0; i < exponente; i++) {
                        resultado = resultado * base;
                    }
                    break;
            }

            if (posicion < texto.length()) {
                operador = texto.charAt(posicion);
                posicion++;
            }

            String resultadoTexto = String.valueOf(resultado);

            if (resultadoTexto.endsWith(".0")) {
                resultadoTexto = resultadoTexto.substring(
                        0, resultadoTexto.length() - 2
                );
            }

            resultadoTexto = resultadoTexto.replace('.', ',');

            botonresultado.setText(resultadoTexto);

        } while (posicion < texto.length());
    }
}
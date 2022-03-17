package com.criscmad.ingles;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;

public class Juego extends AppCompatActivity implements View.OnClickListener {

    public Toolbar toolbar;
    public TextView txtv_estadoJuego,
            txtv_palabrasTraducidas,
            txtv_palabras,
            txtv_cronometro;
    public ImageView imgv_estadoJuego, imgv_stop , imgv_palabrasTraducidas,
            imgv_cronometro;
    public TextView[] palabraNo = new TextView[24];

    //Variables de clase
    public boolean estadoJuego = false; // true = play, false = stop o pause
    public int palabrasTraducidas,
            palabras,
            totalPalabras,
            cronometro,
            tiempoPorPalabra;
    public CountDownTimer countDownTimer;
    public boolean[] palabrasUsadas = new boolean[24];
    public String[] listaPalabrasIngles = {"cat", "dog", "elephant", "Spider", "snake", "glass",
            "computer", "keyboard", "box", "shoe", "sweater", "bracelet", "fan", "balloon", "flag",
            "car", "school", "window", "hat", "eye", "lip", "kiss", "microphone", "song", "hair",
            "stairs", "lamp", "knock", "police", "weapon", "brother", "girlfriend", "uncle", "mom",
            "dad"};
    public String[] listaPalabrasEspañol = {"gato", "perro", "elefante", "araña", "serpiente",
            "vaso", "computador", "teclado", "caja", "zapato", "sueter", "pulsera",
            "ventilador", "globo", "bandera", "carro", "colegio", "ventana",
            "sombrero", "ojo", "labio", "beso", "microfono", "cancion", "cabello",
            "escalera", "lampara", "golpe", "policia", "arma", "hermano", "novia",
            "tio", "mama", "papa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        iniciarObjetos();
        procesos();
    }

    //DECLARAR OBJETOS/WIDGETS
    private void iniciarObjetos() {
        toolbar = findViewById(R.id.act_jue_toolbar);

        imgv_estadoJuego = findViewById(R.id.act_jue_img_estadoJuego);
        imgv_estadoJuego.setOnClickListener(this);

        imgv_stop = findViewById(R.id.act_jue_img_stop);
        imgv_stop.setOnClickListener(this);

        txtv_estadoJuego = findViewById(R.id.act_jue_estadoJuego);

        txtv_palabrasTraducidas = findViewById(R.id.act_jue_palabrasTraducidas);

        txtv_palabras = findViewById(R.id.act_jue_palabras);

        txtv_cronometro = findViewById(R.id.act_jue_cronometro);

        imgv_palabrasTraducidas = findViewById(R.id.act_jue_img_palabrasTraducidas);
        Drawable drawablePalabrasTraducidas = getDrawable(R.drawable.vector_traducidas);
        assert drawablePalabrasTraducidas != null;
        drawablePalabrasTraducidas.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        imgv_palabrasTraducidas.setImageDrawable(drawablePalabrasTraducidas);

        imgv_cronometro = findViewById(R.id.act_jue_img_cronometro);
        Drawable drawableCronometro = getDrawable(R.drawable.vector_timer);
        assert drawableCronometro != null;
        drawableCronometro.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        imgv_cronometro.setImageDrawable(drawableCronometro);

        //Espacios en donde se mostrarán palabras
        palabraNo[0] = findViewById(R.id.act_jue_palabra_1);
        palabraNo[0].setOnClickListener(this);

        palabraNo[1] = findViewById(R.id.act_jue_palabra_2);
        palabraNo[1].setOnClickListener(this);

        palabraNo[2] = findViewById(R.id.act_jue_palabra_3);
        palabraNo[2].setOnClickListener(this);

        palabraNo[3] = findViewById(R.id.act_jue_palabra_4);
        palabraNo[3].setOnClickListener(this);

        palabraNo[4] = findViewById(R.id.act_jue_palabra_5);
        palabraNo[4].setOnClickListener(this);

        palabraNo[5] = findViewById(R.id.act_jue_palabra_6);
        palabraNo[5].setOnClickListener(this);

        palabraNo[6] = findViewById(R.id.act_jue_palabra_7);
        palabraNo[6].setOnClickListener(this);

        palabraNo[7] = findViewById(R.id.act_jue_palabra_8);
        palabraNo[7].setOnClickListener(this);

        palabraNo[8] = findViewById(R.id.act_jue_palabra_9);
        palabraNo[8].setOnClickListener(this);

        palabraNo[9] = findViewById(R.id.act_jue_palabra_10);
        palabraNo[9].setOnClickListener(this);

        palabraNo[10] = findViewById(R.id.act_jue_palabra_11);
        palabraNo[10].setOnClickListener(this);

        palabraNo[11] = findViewById(R.id.act_jue_palabra_12);
        palabraNo[11].setOnClickListener(this);

        palabraNo[12] = findViewById(R.id.act_jue_palabra_13);
        palabraNo[12].setOnClickListener(this);

        palabraNo[13] = findViewById(R.id.act_jue_palabra_14);
        palabraNo[13].setOnClickListener(this);

        palabraNo[14] = findViewById(R.id.act_jue_palabra_15);
        palabraNo[14].setOnClickListener(this);

        palabraNo[15] = findViewById(R.id.act_jue_palabra_16);
        palabraNo[15].setOnClickListener(this);

        palabraNo[16] = findViewById(R.id.act_jue_palabra_17);
        palabraNo[16].setOnClickListener(this);

        palabraNo[17] = findViewById(R.id.act_jue_palabra_18);
        palabraNo[17].setOnClickListener(this);

        palabraNo[18] = findViewById(R.id.act_jue_palabra_19);
        palabraNo[18].setOnClickListener(this);

        palabraNo[19] = findViewById(R.id.act_jue_palabra_20);
        palabraNo[19].setOnClickListener(this);

        palabraNo[20] = findViewById(R.id.act_jue_palabra_21);
        palabraNo[20].setOnClickListener(this);

        palabraNo[21] = findViewById(R.id.act_jue_palabra_22);
        palabraNo[21].setOnClickListener(this);

        palabraNo[22] = findViewById(R.id.act_jue_palabra_23);
        palabraNo[22].setOnClickListener(this);

        palabraNo[23] = findViewById(R.id.act_jue_palabra_24);
        palabraNo[23].setOnClickListener(this);

    }

    //FUNCIONES: procesos, pausarJuego, reanudarJuego
    private void procesos() {
        //Asignar barra de acción
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Drawable drawableClose = getDrawable(R.drawable.vector_close);
        assert drawableClose != null;
        drawableClose.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        getSupportActionBar().setHomeAsUpIndicator(drawableClose);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Iniciar estado de juego.
        String text = "Por comenzar";
        estadoJuego = false; //Stop
        //Asignar imagen de stop
        Drawable drawableStop = getDrawable(R.drawable.vector_stop);
        assert drawableStop != null;
        drawableStop.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        imgv_stop.setImageDrawable(drawableStop);
        //Asignar imagen del estado de juego
        Drawable drawablePause = getDrawable(R.drawable.vector_pause);
        assert drawablePause != null;
        drawablePause.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        imgv_estadoJuego.setImageDrawable(drawablePause);
        //Asignar varoables a objetos
        txtv_estadoJuego.setText(text);
        //establecer variables iniciales
        palabras = 0;
        totalPalabras = 0;
        palabrasTraducidas = 0;
        cronometro = 0;
        for (int var = 0; var <= 23; var++) {
            palabrasUsadas[var] = false;
        }
        //Iniciar juego
        dialogoInicio().show();
    }

    private void iniciarJuego() {
        //Estdo de iniciarJuego
        String text = "Jugando...";
        estadoJuego = true; //play
        //Imagen de estado de juego
        Drawable drawablePlay = getDrawable(R.drawable.vector_play);
        assert drawablePlay != null;
        drawablePlay.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        imgv_estadoJuego.setImageDrawable(drawablePlay);
        //Asignar a objetos las variables iniciales
        txtv_estadoJuego.setText(text);
        txtv_palabras.setText(String.valueOf(palabras));
        txtv_palabrasTraducidas.setText(String.valueOf(palabrasTraducidas));
        //iniciar cronometro
        countDownTimer = new CountDownTimer(tiempoPorPalabra, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                cronometro += 1;
                txtv_cronometro.setText(String.valueOf(cronometro) + "s");
            }

            @Override
            public void onFinish() {
                if (palabras < 24) {
                    //Agregar la palabra
                    agregarPalabra();
                    //Reiniciar contador
                    countDownTimer.start();
                }
                if (palabras >= 24) {
                    //Detenemos el juego
                    finalizarJuego();
                }
            }
        }.start();
    }

    private void agregarPalabra() {
        //Generamos un núemro aleatorio simulando la posición de la palabra
        Random random = new Random();
        int minimo = 1, maximo = 24;
        int posicionPalabra = random.nextInt((maximo - minimo) + 1) + minimo;
        if (posicionPalabra == 24) { posicionPalabra = 0; }
        //Condicionamos la posición, si en ésta no hay palabra se coloca, sino se repite
        if (palabras < 24) {
            if (palabraNo[posicionPalabra].getText().toString().isEmpty()) {
                //Asignamos la palabra a la posición
                palabraNo[posicionPalabra].setText(listaPalabrasIngles[posicionPalabra]);
                //Incrementamos el numero de palabras
                palabras += 1;
                totalPalabras += 1;
                txtv_palabras.setText(String.valueOf(palabras));
                //
                palabrasUsadas[posicionPalabra] = true;
            } else {
                //Repetimos hasta que encuentre una posicion vacia para colocar la palara
                agregarPalabra();
            }
        }
    }

    private void pausarJuego() {
        //Estado de juego
        String text = "En pausa";
        estadoJuego = false; //pause
        //Imagen de estado de juego
        Drawable drawablePause = getDrawable(R.drawable.vector_pause);
        assert drawablePause != null;
        drawablePause.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        imgv_estadoJuego.setImageDrawable(drawablePause);
        //Asignar variables a objetos
        txtv_estadoJuego.setText(text);
        //Pausar cronómetro
        countDownTimer.cancel();
    }

    private void reanudarJuego() {
        //Estado de juego
        String text = "Jugando...";
        estadoJuego = true; //play
        //Imagen de estado de juego
        Drawable drawablePlay = getDrawable(R.drawable.vector_play);
        assert drawablePlay != null;
        drawablePlay.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        imgv_estadoJuego.setImageDrawable(drawablePlay);
        //Asignar variables a objetos
        txtv_estadoJuego.setText(text);
        //Reanudar cronometro
        countDownTimer.start();
    }

    private void finalizarJuego() {
        //Estado del Juego
        String text = "Fin del Juego";
        estadoJuego = false; //stop
        //Asignar imagen del estado de juego
        Drawable drawableStop = getDrawable(R.drawable.vector_stop);
        assert drawableStop != null;
        drawableStop.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        imgv_estadoJuego.setImageDrawable(drawableStop);
        //Asignar variables a objetos
        txtv_estadoJuego.setText(text);
        //Detener cronómetro
        countDownTimer.cancel();
        //Mostramos resultados
        dialogoFinDeJuego().show();
    }

    //DIALOGOS: dialogoInicio, dialogoSalir, dialogoFinDeJuego, dialogoTraducirPalabra
    private AlertDialog dialogoInicio() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final CharSequence[] dificultad = new CharSequence[3];

        dificultad[0] = "Facil      - 10s por palabra";
        dificultad[1] = "Intermedio -  5s por palabra";
        dificultad[2] = "Dificul    -  3s por palabra";

        builder.setTitle("Selecciona una dificultad")
                .setItems(dificultad, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                tiempoPorPalabra = 10000;
                                break;
                            case 1:
                                tiempoPorPalabra = 5000;
                                break;
                            case 2:
                                tiempoPorPalabra = 3000;
                                break;
                                default:
                                    tiempoPorPalabra = 10000;
                                    break;
                        }
                        //iniciamos el juego
                        iniciarJuego();
                    }
                });

        return  builder.create();
    }

    private AlertDialog dialogoSalir() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("¿Estas seguro de que deseas salir?")
                .setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Iniciar actividad principal al salir
                        startActivity(new Intent(Juego.this, Principal.class));
                        //Finalizar acividad de iniciarJuego
                        finish();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Reanudamos el juego
                        reanudarJuego();
                    }
                });

        return builder.create();
    }

    private AlertDialog dialogoFinDeJuego() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Fin del Juego")
                .setMessage("Estadisticas del juego:" + "\n"
                        + "Total Palabras: " + totalPalabras + "\n"
                        + "Palabras traducidas: " + palabrasTraducidas + "\n"
                        + "Tiempo de Juego: " + cronometro + " segundos")
                .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Iniciar actividad principal al salir
                        startActivity(new Intent(Juego.this, Principal.class));
                        //Finalizar acividad de iniciarJuego
                        finish();
                    }
                });

        return builder.create();
    }

    private AlertDialog dialogoTraducirPalabra(final int posicion) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.dialogo_traducir,
                null);

        String palabra = palabraNo[posicion].getText().toString();
        TextView txtv_palabra = view.findViewById(R.id.dialog_txtv_palabra);
        final EditText etxt_traduccion = view.findViewById(R.id.dialog_etxt_traducion);

        txtv_palabra.setText(palabra);

        builder.setView(view)
                .setPositiveButton("Traducir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (etxt_traduccion.getText().toString()
                                .equals(listaPalabrasEspañol[posicion])) {
                            //Eliminamos la palabra a la posición ...
                            palabraNo[posicion].setText("");
                            //disminuimos el numero de palabras
                            palabras -= 1;
                            palabrasTraducidas += 1;
                            txtv_palabras.setText(String.valueOf(palabras));
                            txtv_palabrasTraducidas.setText(String.valueOf(palabrasTraducidas));
                            //Elliminamos la palabra
                            palabrasUsadas[posicion] = false;
                        } else {
                            //Damos aviso de que se equivocó
                            Toast.makeText(Juego.this, "Esa no es la palabra :(",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        return builder.create();
    }

    //LISTENER: onOptionsItemSelected, onClick
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            //Respuesta al boton de atras en la barra de acción
            case android.R.id.home:
                //Pausamos el juego
                pausarJuego();
                //Iniciar dialogo de confirmación para salir
                dialogoSalir().show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_jue_img_stop:
                dialogoFinDeJuego().show();
                break;
            case R.id.act_jue_img_estadoJuego:
                if (estadoJuego) { //play
                    pausarJuego();
                } else { // pause o stop
                    reanudarJuego();
                }
                break;
            case R.id.act_jue_palabra_1:
                dialogoTraducirPalabra(0).show();
                break;
            case R.id.act_jue_palabra_2:
                dialogoTraducirPalabra(1).show();
                break;
            case R.id.act_jue_palabra_3:
                dialogoTraducirPalabra(2).show();
                break;
            case R.id.act_jue_palabra_4:
                dialogoTraducirPalabra(3).show();
                break;
            case R.id.act_jue_palabra_5:
                dialogoTraducirPalabra(4).show();
                break;
            case R.id.act_jue_palabra_6:
                dialogoTraducirPalabra(5).show();
                break;
            case R.id.act_jue_palabra_7:
                dialogoTraducirPalabra(6).show();
                break;
            case R.id.act_jue_palabra_8:
                dialogoTraducirPalabra(7).show();
                break;
            case R.id.act_jue_palabra_9:
                dialogoTraducirPalabra(8).show();
                break;
            case R.id.act_jue_palabra_10:
                dialogoTraducirPalabra(9).show();
                break;
            case R.id.act_jue_palabra_11:
                dialogoTraducirPalabra(10).show();
                break;
            case R.id.act_jue_palabra_12:
                dialogoTraducirPalabra(11).show();
                break;
            case R.id.act_jue_palabra_13:
                dialogoTraducirPalabra(12).show();
                break;
            case R.id.act_jue_palabra_14:
                dialogoTraducirPalabra(13).show();
                break;
            case R.id.act_jue_palabra_15:
                dialogoTraducirPalabra(14).show();
                break;
            case R.id.act_jue_palabra_16:
                dialogoTraducirPalabra(15).show();
                break;
            case R.id.act_jue_palabra_17:
                dialogoTraducirPalabra(16).show();
                break;
            case R.id.act_jue_palabra_18:
                dialogoTraducirPalabra(17).show();
                break;
            case R.id.act_jue_palabra_19:
                dialogoTraducirPalabra(18).show();
                break;
            case R.id.act_jue_palabra_20:
                dialogoTraducirPalabra(19).show();
                break;
            case R.id.act_jue_palabra_21:
                dialogoTraducirPalabra(20).show();
                break;
            case R.id.act_jue_palabra_22:
                dialogoTraducirPalabra(21).show();
                break;
            case R.id.act_jue_palabra_23:
                dialogoTraducirPalabra(22).show();
                break;
            case R.id.act_jue_palabra_24:
                dialogoTraducirPalabra(23).show();
                break;
        }
    }
}

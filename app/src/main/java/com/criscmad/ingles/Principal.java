package com.criscmad.ingles;

import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    public Button btn_iniciar;
    public Button btn_informacion;
    public Button btn_comoJugar;
    public Button btn_puntuaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        iniciarObjetos();
        procesos();
    }

    private void iniciarObjetos() {
        btn_iniciar = findViewById(R.id.act_pri_btn_iniciar);
        btn_iniciar.setOnClickListener(this);

        btn_puntuaciones = findViewById(R.id.act_pri_btn_puntuaciones);
        btn_puntuaciones.setOnClickListener(this);

        btn_comoJugar = findViewById(R.id.act_pri_btn_comoJugar);
        btn_comoJugar.setOnClickListener(this);

        btn_informacion = findViewById(R.id.act_pri_btn_informacion);
        btn_informacion.setOnClickListener(this);
    }

    private void procesos() {}

    //DIALOGOS: dialogoComoJugar, dialogoInformación
    private AlertDialog dialogoComoJugar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        return builder.create();
    }

    private AlertDialog dialogoInformacion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        return builder.create();
    }

    //LISTENER: onClick
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_pri_btn_iniciar:
                //Lanzar actividad de Juego
                startActivity(new Intent(Principal.this, Juego.class));
                //Finalizar actividad principal
                finish();
                break;
            case R.id.act_pri_btn_puntuaciones:
                //Lanzar actividad de puntuaciones
                startActivity(new Intent(Principal.this,Puntuaciones.class));
                //Finalizamos la actividad principal
                finish();
            case R.id.act_pri_btn_comoJugar:
                //Lanzar dialogo de ayuda sobre como jugar
                dialogoComoJugar().show();
                break;
            case R.id.act_pri_btn_informacion:
                //Lanzar dialogo de información
                dialogoInformacion().show();
                break;
        }
    }
}

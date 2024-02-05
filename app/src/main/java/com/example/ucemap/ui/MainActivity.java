package com.example.ucemap.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;

import com.example.ucemap.R;
import com.example.ucemap.service.informacionSingleton.InformacionHolder;
import com.example.ucemap.utilidades.FuncionesAdicionales;

public class MainActivity extends AppCompatActivity {

    private Button botonCambiarMenuPrincipal;
    public static int alturaBarraNavegacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos Informacion Holder
        InformacionHolder informacionHolder = InformacionHolder.obtenerInstancia();

        //Importante para establacer dimensiones
        alturaBarraNavegacion = (FuncionesAdicionales.obtenerAlturaBarraNavegacion(this)+7);

        botonCambiarMenuPrincipal = findViewById(R.id.botonComencemos);

        botonCambiarMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuPrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FuncionesAdicionales.mostrarMensaje(this, "Adios!!");
        finish();
    }
}
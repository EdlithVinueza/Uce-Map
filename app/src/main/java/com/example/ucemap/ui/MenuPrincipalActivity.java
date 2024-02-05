package com.example.ucemap.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;

import com.example.ucemap.R;
import com.example.ucemap.data.DatosJason;
import com.example.ucemap.service.informacionSingleton.InformacionHolder;
import com.example.ucemap.utilidades.FuncionesAdicionales;

public class MenuPrincipalActivity extends AppCompatActivity {
    private Button botonFacultad;
    private Button botonEdificio;
    private Intent intent;
    public static String tituloLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        botonFacultad = findViewById(R.id.bottonFacultad);
        botonEdificio = findViewById(R.id.bottonEdificio);

        botonFacultad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MenuPrincipalActivity.this, ListaOpcionesActivity.class);
                tituloLayout = "Escoge una Facultad";
                InformacionHolder.setTipoEntidadAsociada(DatosJason.FACULTAD_NOMBRE_DOCUMENTO_INTERNO);
                InformacionHolder.setTipoAtributoAsociado(DatosJason.ATRIBUTO_GENERAL_NOMBRE);
                startActivity(intent);
                finish();
            }
        });

        botonEdificio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MenuPrincipalActivity.this, ListaOpcionesActivity.class);
                tituloLayout = "Escoge un Edificio";
                InformacionHolder.setTipoEntidadAsociada(DatosJason.EDIFICIO_NOMBRE_DOCUMENTO_INTERNO);
                InformacionHolder.setTipoAtributoAsociado(DatosJason.ATRIBUTO_GENERAL_NOMBRE);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public Intent getIntent() {
        return intent;
    }

    @Override
    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        FuncionesAdicionales.mostrarMensaje(this, "Regresamos!!");
        finish();

    }

}
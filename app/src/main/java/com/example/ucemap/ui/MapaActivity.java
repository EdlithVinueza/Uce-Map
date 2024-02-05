package com.example.ucemap.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ucemap.R;
import com.example.ucemap.data.DatosJason;
import com.example.ucemap.repository.modelo.Posicion;
import com.example.ucemap.service.informacionFactory.IInformacionFactory;
import com.example.ucemap.repository.modelo.Informacion;
import com.example.ucemap.service.informacionFactory.InformacionFactory;
import com.example.ucemap.service.informacionSingleton.InformacionHolder;
import org.json.JSONException;

import java.io.IOException;

public class MapaActivity extends AppCompatActivity {

    private Button botonGenerarCamino;
    private Button botonDetalles;
    private Intent intent;
    private Informacion informacion;
    private Posicion posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);

        botonGenerarCamino = findViewById(R.id.bottonCamino);
        botonDetalles = findViewById(R.id.bottonDetalles);

        //Aplicamos el objeto informacionHolder para extraer la informacion que no cambia
        InformacionHolder informacionHolder = InformacionHolder.obtenerInstancia();

        //Actualizar titulo de Layout dependiendo de la entidad escogida
        TextView textTiruloMapa = findViewById(R.id.textTituloMapa);
        textTiruloMapa.setText(InformacionHolder.getNombreEntidadAsociada());

        //Uso de la bandera
        if (!InformacionHolder.getInformacionInicializada()) {
            try {
                //Aplicacion del Factory para crear la informacion
                IInformacionFactory iInformacionFactory = InformacionFactory.contruirInformacion(InformacionHolder.getTipoEntidadAsociada());
                informacion = iInformacionFactory.generarInformacion(this, InformacionHolder.getTipoAtributoAsociado(), InformacionHolder.getNombreEntidadAsociada());
                InformacionHolder.setInformacion(informacion);
                InformacionHolder.setInformacionInicializada(true);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //-------------------------------------------------------------------------------------------
        posicion = InformacionHolder.getInformacion().getPosicion(); //<--- Posicion
        //-------------------------------------------------------------------------------------------
        botonGenerarCamino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();

            }
        });

        //-------------------------------------------------------------------------------------------
        botonDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MapaActivity.this, DetallesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MapaActivity.this, ListaOpcionesActivity.class);
        startActivity(intent);
        finish();
    }

}
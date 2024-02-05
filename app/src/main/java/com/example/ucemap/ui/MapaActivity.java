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


import org.json.JSONException;

import java.io.IOException;

public class MapaActivity extends AppCompatActivity {

    private Button botonGenerarCamino;
    private Button botonDetalles;
    private Intent intent;
    private String nombreEntidadMapa;
    private String nombreDocumentoInternoParaMapa;
    private String nombreAtributoParaEvaluarMapa;
    private Informacion informacion;
    private Posicion posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);



        botonGenerarCamino = findViewById(R.id.bottonCamino);
        botonDetalles = findViewById(R.id.bottonDetalles);

        //Atributos  obtenidos de RecycleViewAdaptadorListaOpciones
        nombreEntidadMapa = getIntent().getStringExtra("entidadEscogidaMapa"); //Viene de RecycleViewAdpatador
        //Atributos inicializados con static de Menu Principal
        nombreDocumentoInternoParaMapa=MenuPrincipalActivity.nombreDocumentoInterno;
        nombreAtributoParaEvaluarMapa= MenuPrincipalActivity.atributoParaEvaluar;

        //Atualizar titulo de Layout dependiendo de la entidad escogida
        TextView textTiruloMapa = findViewById(R.id.textTituloMapa);
        textTiruloMapa.setText(nombreEntidadMapa);

        try {
            //Aplicacion del Factory, su funcion es que con una sola busqueda se separa la informacion
            IInformacionFactory iInformacionFactory =  InformacionFactory.contruirInformacion(nombreDocumentoInternoParaMapa);
            informacion = iInformacionFactory.generarInformacion(this,nombreAtributoParaEvaluarMapa, nombreEntidadMapa);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Solo pueden editar esto, me tocan algo mas y los saco del grupo
        //-------------------------------------------------------------------------------------------
        posicion = informacion.getPosicion(); //<--- Posicion

        botonGenerarCamino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //-------------------------------------------------------------------------------------------
        botonDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MapaActivity.this, DetallesActivity.class);
                startActivity(intent);
                finish();
                //Informacion que se debe mandar Layout de detalles
                DetallesActivity.setListaDescripciones(informacion.getDescripcion());
                DetallesActivity.setListaImagenes(informacion.getImagenes());
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, ListaOpcionesActivity.class);
        startActivity(intent);
        finish();
    }

}

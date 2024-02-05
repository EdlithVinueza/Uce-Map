package com.example.ucemap.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ucemap.R;
import com.example.ucemap.data.DatosJason;
import com.example.ucemap.repository.modelo.ListaOpciones;
import com.example.ucemap.service.listaOpcionesFactory.IListaOpcionesFactory;
import com.example.ucemap.service.listaOpcionesFactory.ListaOpcionesFactory;
import com.example.ucemap.ui.adapters.RecycleViewAdaptadorListaOpciones;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class ListaOpcionesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewListaOpciones;
    private RecycleViewAdaptadorListaOpciones adaptadorOpciones;
    private List<ListaOpciones> listaOpciones;

    private String tituloLayoutListaOpciones;

    private String nombreArchivoInternoListaOpciones;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_opciones);



        //Atributos  obtenidos del Menu Principal
        tituloLayoutListaOpciones = getIntent().getStringExtra("tituloLayoutListaOpciones");

        nombreArchivoInternoListaOpciones = getIntent().getStringExtra("nombreArchivoInternoListaOpciones");



        // Atualizar titulo de Layout dependiendo del documento escogido
        TextView tipoListaOpciones = findViewById(R.id.tipoListaOpciones);
        tipoListaOpciones.setText(tituloLayoutListaOpciones);

        //---------------------------------------------------------------------------------

        recyclerViewListaOpciones = (RecyclerView) findViewById(R.id.recycleOpciones);
        recyclerViewListaOpciones.setLayoutManager(new LinearLayoutManager(this));

        try {
            cargarListaOpciones();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        adaptadorOpciones = new RecycleViewAdaptadorListaOpciones(this,listaOpciones);

        recyclerViewListaOpciones.setAdapter(adaptadorOpciones);

        recyclerViewListaOpciones.setPadding(
                recyclerViewListaOpciones.getPaddingLeft(),
                recyclerViewListaOpciones.getPaddingTop(),
                recyclerViewListaOpciones.getPaddingRight(),
                MainActivity.alturaBarraNavegacion + getResources().getDimensionPixelSize(R.dimen.margen_inferior_default)
        );
    }

    public void cargarListaOpciones() throws JSONException, IOException {
        IListaOpcionesFactory iListaOpcionesFactory = ListaOpcionesFactory.generarListaOpciones(nombreArchivoInternoListaOpciones);
        listaOpciones=iListaOpcionesFactory.crearListaOpciones(getApplicationContext());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);
        finish();
    }
}

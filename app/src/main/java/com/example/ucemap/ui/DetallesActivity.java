package com.example.ucemap.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ucemap.R;
import com.example.ucemap.repository.modelo.Descripcion;
import com.example.ucemap.ui.adapters.RecycleViewAdaptadorListaDetalles;
import com.example.ucemap.ui.adapters.RecycleViewAdaptadorListaOpciones;

import java.util.ArrayList;
import java.util.List;

public class DetallesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewListaOpciones;
    private RecycleViewAdaptadorListaDetalles adaptadorOpciones;

    private static List<Descripcion> listaOpciones;
    private static List<String> listaImagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_opcion_escogida);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        recyclerViewListaOpciones = (RecyclerView) findViewById(R.id.recycleDetalles);
        recyclerViewListaOpciones.setLayoutManager(new LinearLayoutManager(this));

        adaptadorOpciones = new RecycleViewAdaptadorListaDetalles(this,listaOpciones);

        recyclerViewListaOpciones.setAdapter(adaptadorOpciones);

        recyclerViewListaOpciones.setPadding(
                recyclerViewListaOpciones.getPaddingLeft(),
                recyclerViewListaOpciones.getPaddingTop(),
                recyclerViewListaOpciones.getPaddingRight(),
                MainActivity.alturaBarraNavegacion + getResources().getDimensionPixelSize(R.dimen.margen_inferior_default)
        );

    }

    public static List<Descripcion> getListaDescripciones() {
        return listaOpciones;
    }

    public static void setListaDescripciones(List<Descripcion> listaDescripciones) {
        DetallesActivity.listaOpciones = listaDescripciones;
    }

    public static List<String> getListaImagenes() {
        return listaImagenes;
    }

    public static void setListaImagenes(List<String> listaImagenes) {
        DetallesActivity.listaImagenes = listaImagenes;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MapaActivity.class);
        startActivity(intent);
        finish();

    }
}

package com.example.ucemap.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ucemap.R;
import com.example.ucemap.repository.modelo.Descripcion;
import com.example.ucemap.service.informacionSingleton.InformacionHolder;
import com.example.ucemap.ui.adapters.RecycleViewAdaptadorListaDetalles;
import com.example.ucemap.ui.adapters.RecycleViewAdaptadorListaOpciones;
import com.example.ucemap.utilidades.FuncionesAdicionales;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class DetallesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewListaOpciones;
    private RecycleViewAdaptadorListaDetalles adaptadorOpciones;
    private static List<Descripcion> listaOpciones;
    private static List<CarouselItem> listaImagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_opcion_escogida);

        //Cargamos los atributos desde Informacion Holder
        setListaDescripciones(InformacionHolder.getInformacion().getDescripcion());
        setListaImagenes(InformacionHolder.getInformacion().getImagenes());

        //Cargamos el carrusel
        ImageCarousel carousel = findViewById(R.id.carousel);
        carousel.registerLifecycle(getLifecycle());
        carousel.setData(listaImagenes);

        //Cargamos el Recycle Con los detalles de la Entidad Escogida
        recyclerViewListaOpciones = (RecyclerView) findViewById(R.id.recycleDetalles);
        recyclerViewListaOpciones.setLayoutManager(new LinearLayoutManager(this));
        adaptadorOpciones = new RecycleViewAdaptadorListaDetalles(this, listaOpciones);
        recyclerViewListaOpciones.setAdapter(adaptadorOpciones);

        //Calculamos la barra de navegacion
        recyclerViewListaOpciones.setPadding(
                recyclerViewListaOpciones.getPaddingLeft(),
                recyclerViewListaOpciones.getPaddingTop(),
                recyclerViewListaOpciones.getPaddingRight(),
                MainActivity.alturaBarraNavegacion + getResources().getDimensionPixelSize(R.dimen.margen_inferior_default)
        );
    }

    //SET Y GET
    public static List<Descripcion> getListaDescripciones() {
        return listaOpciones;
    }

    public static void setListaDescripciones(List<Descripcion> listaDescripciones) {
        DetallesActivity.listaOpciones = listaDescripciones;
    }

    public static List<CarouselItem> getListaImagenes() {
        return listaImagenes;
    }

    public static void setListaImagenes(List<CarouselItem> listaImagenes) {
        DetallesActivity.listaImagenes = listaImagenes;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(DetallesActivity.this, MapaActivity.class);
        FuncionesAdicionales.mostrarMensaje(getApplicationContext(),"Estamos en el Mapa");
        startActivity(intent);
        finish();

    }

}

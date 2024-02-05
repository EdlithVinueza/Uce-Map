package com.example.ucemap.service;

import android.content.Context;

import com.example.ucemap.repository.EdificioRepositoryImpl;
import com.example.ucemap.repository.IEdificioRepository;
import com.example.ucemap.repository.modelo.Descripcion;
import com.example.ucemap.repository.modelo.Edificio;
import com.example.ucemap.repository.modelo.ListaOpciones;
import com.example.ucemap.repository.modelo.Posicion;
import com.example.ucemap.utilidades.FuncionesAdicionales;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EdificioServiceImpl implements IEdificioService {
    private IEdificioRepository iEdificioRepository;
    @Override
    public Edificio buscarEdificioPorNombre(Context context, String atributoParaExtraer, String atributoComparacion) throws IOException, JSONException {
        iEdificioRepository= new EdificioRepositoryImpl();
        return iEdificioRepository.seleccionarEdificioPorNombre(context,atributoParaExtraer,atributoComparacion);
    }

    @Override
    public List<ListaOpciones> buscarTodasLosEdificiosPorNombre(Context context) throws IOException, JSONException {
        iEdificioRepository= new EdificioRepositoryImpl();
        return iEdificioRepository.seleccionarTodasLosEdificiosPorNombre(context);
    }

    @Override
    public List<Descripcion> generarDescripcionEdificio(Edificio edificio){
        List<Descripcion> listaDescripcions = new ArrayList<>();
        Descripcion l1 = new Descripcion("Nombre", edificio.getNombre());
        String servicios = FuncionesAdicionales.agregarViñetas(edificio.getServicios());
        Descripcion l2 = new Descripcion("Servicios", servicios);
        Descripcion l3 = new Descripcion("Descripcion",edificio.getDescripcion());
        listaDescripcions.add(l1);
        listaDescripcions.add(l2);
        listaDescripcions.add(l3);
        return listaDescripcions;
    }
    @Override
    public Posicion generarPosicionEdificio(Edificio edificio){
        return new Posicion(edificio.getNombre(), edificio.getLatitud(), edificio.getLongitud());
    }

}

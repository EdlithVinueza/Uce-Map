package com.example.ucemap.service;

import android.content.Context;

import com.example.ucemap.repository.FacultadRepositoryImpl;
import com.example.ucemap.repository.IFacultadRepository;
import com.example.ucemap.repository.modelo.Descripcion;
import com.example.ucemap.repository.modelo.Facultad;
import com.example.ucemap.repository.modelo.ListaOpciones;
import com.example.ucemap.repository.modelo.Posicion;
import com.example.ucemap.utilidades.FuncionesAdicionales;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FacultadServiceImpl implements IFacultadService {

    private IFacultadRepository iFacultadRepository;
    @Override
    public Facultad buscarFacultadPorNombre(Context context, String atributoParaExtraer, String atributoComparacion) throws IOException, JSONException {
        iFacultadRepository = new FacultadRepositoryImpl();
        return iFacultadRepository.seleccionarFacultadPorNombre(context,atributoParaExtraer,atributoComparacion);
    }

    @Override
    public List<ListaOpciones> buscarTodasLasFacultadPorNombre(Context context) throws JSONException, IOException {
        iFacultadRepository = new FacultadRepositoryImpl();
        return iFacultadRepository.seleccionarTodasLasFacultadPorNombre(context);
    }

    @Override
    public List<Descripcion> crearDescripcionFacultad(Facultad facultad){
        List<Descripcion> listaDescripcions = new ArrayList<>();
        Descripcion l1 = new Descripcion("Nombre", facultad.getNombre());
        String servicios = FuncionesAdicionales.agregarViñetas(facultad.getServicios());
        Descripcion l2 = new Descripcion("Servicios", servicios);
        Descripcion l3 = new Descripcion("Descripcion",facultad.getDescripcion());
        listaDescripcions.add(l1);
        listaDescripcions.add(l2);
        listaDescripcions.add(l3);
        return listaDescripcions;
    }
    @Override
    public Posicion generarPosicionFacultad(Facultad facultad){
        return new Posicion(facultad.getNombre(),facultad.getLatitud(), facultad.getLongitud());
    }

}

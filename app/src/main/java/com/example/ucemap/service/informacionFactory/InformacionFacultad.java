package com.example.ucemap.service.informacionFactory;

import android.content.Context;

import com.example.ucemap.repository.FacultadRepositoryImpl;
import com.example.ucemap.repository.IFacultadRepository;
import com.example.ucemap.repository.modelo.Descripcion;
import com.example.ucemap.repository.modelo.Facultad;
import com.example.ucemap.repository.modelo.Informacion;
import com.example.ucemap.repository.modelo.Posicion;
import com.example.ucemap.service.FacultadServiceImpl;
import com.example.ucemap.service.IFacultadService;
import com.example.ucemap.utilidades.FuncionesAdicionales;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class InformacionFacultad implements IInformacionFactory{
    private IFacultadService iFacultadService;

    @Override
    public Informacion generarInformacion(Context context, String atributoParaExtraer, String atributoComparacion) throws JSONException, IOException {
        iFacultadService = new FacultadServiceImpl();
        Facultad facultad = iFacultadService.buscarFacultadPorNombre(context,atributoParaExtraer,atributoComparacion);
        Posicion posicion = iFacultadService.generarPosicionFacultad(facultad);
        List<Descripcion> descripcion = iFacultadService.crearDescripcionFacultad(facultad);
        List<String> imagenesTmp = facultad.getImagenes();
        List<CarouselItem> imagenes = FuncionesAdicionales.convertirAListaCarouselItem(imagenesTmp);
        return new Informacion(posicion,descripcion,imagenes);
    }
}

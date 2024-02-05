package com.example.ucemap.service.informacionFactory;

import android.content.Context;

import com.example.ucemap.repository.EdificioRepositoryImpl;
import com.example.ucemap.repository.IEdificioRepository;
import com.example.ucemap.repository.modelo.Descripcion;
import com.example.ucemap.repository.modelo.Edificio;
import com.example.ucemap.repository.modelo.Informacion;
import com.example.ucemap.repository.modelo.Posicion;
import com.example.ucemap.service.EdificioServiceImpl;
import com.example.ucemap.service.IEdificioService;
import com.example.ucemap.utilidades.FuncionesAdicionales;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class InformacionEdificio implements IInformacionFactory{

    private IEdificioService iEdificioService;
    @Override
    public Informacion generarInformacion(Context context, String atributoParaExtraer, String atributoComparacion) throws JSONException, IOException {
        iEdificioService = new EdificioServiceImpl();
        Edificio edificio = iEdificioService.buscarEdificioPorNombre(context,atributoParaExtraer,atributoComparacion);
        Posicion posicion = iEdificioService.generarPosicionEdificio(edificio);
        List<Descripcion> descripcion = iEdificioService.generarDescripcionEdificio(edificio);
        List<String> imagenesTmp = edificio.getImagenes();
        List<CarouselItem> imagenes = FuncionesAdicionales.convertirAListaCarouselItem(imagenesTmp);
        return new Informacion(posicion,descripcion,imagenes);


    }
}

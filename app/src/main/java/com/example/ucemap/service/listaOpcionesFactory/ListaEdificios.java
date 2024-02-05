package com.example.ucemap.service.listaOpcionesFactory;

import android.content.Context;

import com.example.ucemap.repository.modelo.ListaOpciones;
import com.example.ucemap.service.EdificioServiceImpl;
import com.example.ucemap.service.IEdificioService;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class ListaEdificios implements IListaOpcionesFactory{
    
    private IEdificioService iEdificioService;
    @Override
    public List<ListaOpciones> crearListaOpciones(Context context) throws JSONException, IOException {
        iEdificioService = new EdificioServiceImpl();
        return iEdificioService.buscarTodasLosEdificiosPorNombre(context);
    }
}

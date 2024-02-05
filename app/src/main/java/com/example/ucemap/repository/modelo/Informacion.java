package com.example.ucemap.repository.modelo;

import com.example.ucemap.repository.modelo.Descripcion;
import com.example.ucemap.repository.modelo.Posicion;

import java.util.List;

public class Informacion {
    private Posicion posicion;
    private List<Descripcion>  descripcion;
    private List<String> imagenes;

    public Informacion() {
    }

    public Informacion(Posicion posicion, List<Descripcion> descripcion, List<String> imagenes) {
        this.posicion = posicion;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public List<Descripcion> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(List<Descripcion> descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }
}

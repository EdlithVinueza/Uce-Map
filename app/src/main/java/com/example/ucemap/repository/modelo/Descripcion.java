package com.example.ucemap.repository.modelo;

import android.os.Parcelable;

public class Descripcion{

    public String titulo;
    public String descripcion;

    public Descripcion(String nombre, Descripcion edificioNombre) {
    }
    public Descripcion(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

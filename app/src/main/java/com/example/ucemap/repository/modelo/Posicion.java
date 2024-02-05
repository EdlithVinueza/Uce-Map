package com.example.ucemap.repository.modelo;

public class Posicion {
    private String nombre;
    private Double latitud;
    private Double longitud;

    public Posicion(String nombre, Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
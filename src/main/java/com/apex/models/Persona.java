package com.apex.models;

public abstract class Persona {
    protected String nombre;
    protected String documento;
    protected String edad;

    public Persona(String nombre, String documento, String edad) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarCarnet();
}

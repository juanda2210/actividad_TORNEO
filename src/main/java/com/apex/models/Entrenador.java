package com.apex.models;

public class Entrenador extends Persona{

    private String aniosExp;

    public Entrenador(String nombre, String documento, String edad, String aniosExp) {
        super(nombre, documento, edad);
        this.aniosExp = aniosExp;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Entrenador");
    }
}

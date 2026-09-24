package com.apex.models;

public class Jugador extends Persona{

    private Posicion posicion;
    private int dorsal;

    public Jugador(String nombre, String documento, String edad, Posicion posicion, int dorsal) {
        super(nombre, documento, edad);
        this.posicion = posicion;
        this.dorsal = dorsal;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Jugador");
    }
}

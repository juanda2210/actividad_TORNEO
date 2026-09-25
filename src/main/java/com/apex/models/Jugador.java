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
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void mostrarCarnet() {
        System.out.println("\n------------------------");
        System.out.println("Jugador " + this.nombre);
        System.out.println("------------------------");
        System.out.println("Posicion: " + this.posicion.toString());
        System.out.println("Dorsal: " + this.dorsal);
        System.out.println("Edad: " + this.edad);
    }
}

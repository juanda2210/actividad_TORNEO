package com.apex.models;

public class Entrenador extends Persona{

    private String aniosExp;

    public Entrenador(String nombre, String documento, String edad, String aniosExp) {
        super(nombre, documento, edad);
        this.aniosExp = aniosExp;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void mostrarCarnet() {
        System.out.println("\n------------------------");
        System.out.println("Entrenador " + this.nombre);
        System.out.println("------------------------");
        System.out.println("Experiencia: " + this.aniosExp + " años");
        System.out.println("Edad: " + this.edad);
    }
}

package com.apex.models;

import java.util.List;

public class Equipo {
    private String nombre;
    private int posicion;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public static String verificarNombre(String nombre,Torneo torneo) {
        List<String> equipos = torneo.getEquipos();
        return equipos.stream()
                .filter(equipo -> equipo.equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

}

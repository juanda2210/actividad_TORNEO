package com.apex.models;

import java.util.List;

public class Equipo {
    private String nombre;
    //private int posicion;
    private int puntos;
    private int golesAFavor;
    private int golesEnContra;
    private int diferenciaDeGoles;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
        this.diferenciaDeGoles = this.golesAFavor - this.golesEnContra;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDiferenciaDeGoles() {
        return diferenciaDeGoles;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public int getPuntos() {
        return puntos;
    }

    public void gana() {
        this.puntos += 3;
    }

    public void empata() {
        this.puntos ++;
    }

    public static String verificarNombre(String nombre, Torneo torneo) {
        List<String> equipos = torneo.getEquipos();
        return equipos.stream()
                .filter(equipo -> equipo.equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }




}

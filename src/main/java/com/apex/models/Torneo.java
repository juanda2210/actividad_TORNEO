package com.apex.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private String nombre;
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public Torneo() {
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getEquipos() {
        return equipos.stream()
                .map(equipo -> equipo.getNombre())
                .toList();
    }

    public void nuevoEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public Equipo buscarEquipo(String nombreEquipo) {
        return equipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(nombreEquipo))
                .findFirst()
                .orElse(null);
    }

    public void nuevoPartido(Partido partido) {
        partidos.add(partido);
    }

    public void mostrarPartidos() {
        partidos.forEach(partido -> partido.mostrarResumen());
    }

    public void mostrarEquipos() {
        List<String> nombreEquipos = this.getEquipos();
        nombreEquipos.forEach(equipo -> System.out.println(equipo));
    }

    public Partido seleccionarPartido(LocalDateTime fecha) {
        return partidos.stream()
                .filter(partido -> partido.getFecha().isEqual(fecha))
                .findFirst()
                .orElse(null);
    }

    /*public Equipo seleccionarEquipo(String nombreEquipo) {
        return equipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(nombreEquipo))
                .findFirst()
                .orElse(null);
    }*/


}

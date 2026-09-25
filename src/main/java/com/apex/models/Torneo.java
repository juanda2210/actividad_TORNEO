package com.apex.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Torneo {
    private String nombre;
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private List<Persona> personas;
    private List<Equipo> posiciones;

    public Torneo() {
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
        posiciones = new ArrayList<>();
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

    public void mostrarEquipos() {
        List<String> nombreEquipos = this.getEquipos();
        nombreEquipos.forEach(equipo -> System.out.println(equipo));
    }

    /*public Equipo seleccionarEquipo(String nombreEquipo) {
        return equipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(nombreEquipo))
                .findFirst()
                .orElse(null);
    }*/

    public void nuevoPartido(Partido partido) {
        partidos.add(partido);
    }

    public void mostrarPartidos() {
        partidos.forEach(partido -> partido.mostrarResumen());
    }


    public Partido seleccionarPartido(LocalDateTime fecha) {
        return partidos.stream()
                .filter(partido -> partido.getFecha().isEqual(fecha))
                .findFirst()
                .orElse(null);
    }

    public void nuevaPersona(Persona persona) {
        personas.add(persona);
    }

    public Persona buscarPersona(String nombre) {
        return personas.stream()
                .filter(persona -> persona.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    private List<Equipo> generarPosiciones() {
        return equipos.stream()
                .sorted(Comparator.comparingInt(Equipo::getPuntos)
                        .reversed()
                        .thenComparing(Comparator.comparingInt(Equipo::getDiferenciaDeGoles)
                                .reversed())
                        .thenComparing(Comparator.comparingInt(Equipo::getGolesAFavor)
                                .reversed()))
                .toList();
    }

    public void cargarTablaPosiciones() {
        this.posiciones = this.generarPosiciones();
    }

    public void mostrarTablaDePosiciones() {
        System.out.println("TABLA DE POSICIONES TORNEO " +this.getNombre());
        System.out.println("-----------------------------------------------");
        System.out.println("#----EQUIPO------PUNTOS--GF--GC--DG");
        for (int i = 0; i < posiciones.size(); i++) {
            Equipo equipo = posiciones.get(i);

            System.out.println((i+1) + ". " + equipo.getNombre() + "   " +
                    equipo.getPuntos() + "   " + equipo.getGolesAFavor() + "   " +
                    equipo.getGolesEnContra() + "   " + equipo.getDiferenciaDeGoles());
        }
    }

    public void mostrarReporteFinal() {
        System.out.println("\nREPORTE FINAL TORNEO " + this.getNombre());
        System.out.println("----------------------------------------");
        System.out.println("Equipos participantes: ");
        this.mostrarEquipos();
        System.out.println("\n--------------------------------------");
        System.out.println("---------Tabla de posiciones-----------");
        this.mostrarTablaDePosiciones();
        System.out.println("\n--------------------------------------");
        System.out.println("---------------Partidos----------------");
        this.mostrarPartidos();
        System.out.println("\n------------------------------------------------");
        System.out.println("Nos vemos en una proxima experiencia de campeonato");
        System.out.println("BYEEEEEE");
        System.out.println("⚽🏆");
    }
}

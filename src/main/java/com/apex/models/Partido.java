package com.apex.models;

import java.time.LocalDateTime;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private int marcadorLocal;
    private int marcadorVisitante;
    private LocalDateTime fecha;
    private EstadoDePartido estadoDePartido;

    public Partido(Equipo local, Equipo visitante) {
        if (local == visitante) {
            throw new IllegalArgumentException("PAILA MI PAPA, NO SE PUEDEN AGENDAR PARTIDOS ENTRE EL MISMO EQUIPO");
        }
        this.local = local;
        this.visitante = visitante;
        this.fecha = LocalDateTime.now();
        this.estadoDePartido = EstadoDePartido.AGENDADO;
    }

    public EstadoDePartido getEstadoDePartido() {
        return estadoDePartido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setMarcadorLocal(int marcadorLocal) {
        this.marcadorLocal = marcadorLocal;
    }

    public void setMarcadorVisitante(int marcadorVisitante) {
        this.marcadorVisitante = marcadorVisitante;
    }

    public void partidoJugado() {
        this.estadoDePartido = EstadoDePartido.JUGADO;
    }


    public void mostrarResumen() {
        System.out.println("\nPARTIDO DEL DIA " + this.fecha.getDayOfMonth() + "/" + this.fecha.getMonth());
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(this.local + " " + marcadorLocal + " VS " + marcadorVisitante + " " + this.visitante);
        System.out.println("---------------------------------------------------------------------------");
    }

    public void mostrarFecha() {
        System.out.println("\nPARTIDO DEL DIA " + this.fecha.getDayOfMonth() + "/" + this.fecha.getMonth());
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(this.local + " " + " VS " + " " + this.visitante);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Codigo de fecha de acceso: " + this.fecha);
    }

    public void definirPuntos() {
        if (this.marcadorLocal > this.marcadorVisitante) {
            this.local.gana();
        } else if (this.marcadorVisitante > this.marcadorLocal) {
            this.visitante.gana();
        } else {
            this.local.empata();
            this.visitante.empata();
        }
    }


}

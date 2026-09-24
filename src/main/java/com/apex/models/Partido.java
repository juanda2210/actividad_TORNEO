package com.apex.models;

import java.time.LocalDateTime;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private int marcadorLocal;
    private int marcadorVisitante;
    private LocalDateTime fecha;

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
        this.fecha = LocalDateTime.now();
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

    public void mostrarResumen() {
        System.out.println("\nPARTIDO DEL DIA " + this.fecha.getDayOfMonth() + "/" + this.fecha.getMonth());
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(this.local + " " + marcadorLocal + " VS " + marcadorVisitante + " " + this.visitante);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Codigo de fecha de acceso: " + this.fecha);
    }
}

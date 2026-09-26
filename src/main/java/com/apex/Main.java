package com.apex;

import com.apex.models.*;
import com.apex.util.ScannerUtils;

import java.time.LocalDateTime;

public class Main {

    public static final int REGISTRAR_EQUIPO = 1;
    public static final int REGISTRAR_PERSONA = 2;
    public static final int PROGRAMAR_PARTIDO = 3;
    public static final int REGISTRAR_RESULTADO = 4;
    public static final int MOSTRAR_TABLA_POSICIONES = 5;
    public static final int BUSCAR_JUGADOR = 6;
    public static final int GENERAR_REPORTE_FINAL = 7;
    public static final int SALIR = 8;


    public static void main(String[] args) {

        Torneo torneo = new Torneo();
        String nombreTorneo = ScannerUtils.capturarTexto("Nombre del torneo");
        torneo.setNombre(nombreTorneo);
        System.out.println("TORNEO CREADO SATISFACTORIAMENTE 🏆");


        while (true) {
            System.out.println("\n===== MENÚ DEL TORNEO =====");
            System.out.println("1. Registrar un equipo");
            System.out.println("2. Registrar un jugador o entrenador");
            System.out.println("3. Programar un partido");
            System.out.println("4. Registrar el resultado de un partido");
            System.out.println("5. Mostrar tabla de posiciones");
            System.out.println("6. Buscar un jugador por nombre");
            System.out.println("7. Generar reporte final del torneo");
            System.out.println("8. Salir del programa");

            int opcion = ScannerUtils.capturarNumero("Selecciona una opción");

            switch (opcion) {

                case REGISTRAR_EQUIPO:
                    // Registrar un equipo
                    while (true) {

                        String nombre = ScannerUtils.capturarEquipo("Nombre del equipo");

                        if (Equipo.verificarNombre(nombre, torneo) != null) {
                            System.err.println("Ese equipo ya está registrado. Intenta con otro nombre.");
                            continue;
                        }

                        Equipo equipo = new Equipo(nombre);
                        torneo.nuevoEquipo(equipo);

                        System.out.println("Equipo registrado correctamente.");
                        break;
                    }

                case REGISTRAR_PERSONA:
                    // Registrar un jugador o entrenador
                    int decision = ScannerUtils.capturarNumero("""
                            1. Jugador
                            2. Entrenador""");
                    if (decision == 1) {
                        String nombre = ScannerUtils.capturarTexto("Nombre");
                        String documento = ScannerUtils.capturarTexto("Documento");
                        String edad = ScannerUtils.capturarTexto("Edad");
                        Posicion posicion = ScannerUtils.capturarPosicion("Posicion");
                        int dorsal = ScannerUtils.capturarNumero("Numero dorsal");

                        Persona persona = new Jugador(nombre, documento, edad, posicion, dorsal);
                        torneo.nuevaPersona(persona);
                        System.out.println("JUGADOR AGREGADO SATISFACTORIAMENTE");
                    } else if (decision == 2) {
                        String nombre = ScannerUtils.capturarTexto("Nombre");
                        String documento = ScannerUtils.capturarTexto("Documento");
                        String edad = ScannerUtils.capturarTexto("Edad");
                        String aniosExp = ScannerUtils.capturarTexto("Años de experiencia");

                        Persona persona = new Entrenador(nombre, documento, edad, aniosExp);
                        torneo.nuevaPersona(persona);
                        System.out.println("ENTRENADOR AGREGADO SATISFACTORIAMENTE");
                    } else {
                        System.err.println("OPCION NO VALIDA DENTRO DEL MENÚ");
                    }
                    break;

                case PROGRAMAR_PARTIDO:
                    // Programar un partido
                    System.out.println("--------------------Equipos-----------------");
                    torneo.mostrarEquipos();
                    System.out.println("--------------------------------------------\n");
                    String nombreLocal = ScannerUtils.capturarTexto("Seleccione local");
                    String nombreVisitante = ScannerUtils.capturarTexto("Seleccione visitante");

                    Equipo local = torneo.buscarEquipo(nombreLocal);
                    Equipo visitante = torneo.buscarEquipo(nombreVisitante);

                    if (local != null && visitante != null) {
                        try {
                            Partido partido = new Partido(local, visitante);
                            torneo.nuevoPartido(partido);
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage());
                        }
                    } else {
                        System.err.println("Alguno de los dos equipos no han sido encontrados");
                    }
                    break;

                case REGISTRAR_RESULTADO:
                    // Registrar el resultado de un partido
                    System.out.println("------------------Partidos------------------");
                    torneo.mostrarPartidosAgendados();
                    System.out.println("--------------------------------------------");
                    LocalDateTime fecha = ScannerUtils.capturarFecha("Codigo de fecha");
                    Partido partido = torneo.seleccionarPartido(fecha);

                    if (partido != null) {
                        partido.mostrarResumen();
                        System.out.println("------------------------------------------");
                        int golesLocal = ScannerUtils.capturarGoles("Goles del equipo local");
                        int golesVisitante = ScannerUtils.capturarGoles("Goles del equipo visitante");
                        partido.setMarcadorLocal(golesLocal);
                        partido.setMarcadorVisitante(golesVisitante);

                        System.out.println("MARCADOR REGISTRADO SATISFACTORIAMENTE");
                        System.out.println("--------------------------------------");
                        partido.mostrarResumen();

                        partido.partidoJugado();
                        partido.definirPuntos();
                        torneo.cargarTablaPosiciones();
                    } else {
                        System.err.println("Codigo de fecha no encontrado");
                    }
                    break;

                case MOSTRAR_TABLA_POSICIONES:
                    torneo.mostrarTablaDePosiciones();
                    break;

                case BUSCAR_JUGADOR:
                    // Buscar un jugador por nombre
                    String nombre = ScannerUtils.capturarTexto("Nombre");
                    Persona persona = torneo.buscarPersona(nombre);

                    if (persona != null && persona instanceof Jugador) {
                        persona.mostrarCarnet();
                    }
                    break;

                case GENERAR_REPORTE_FINAL:
                    // Generar el reporte final del torneo
                    torneo.mostrarReporteFinal();

                    break;

                case SALIR:
                    System.out.println("Saliendo del programa...");
                    return;

                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    break;
            }
        }
    }
}


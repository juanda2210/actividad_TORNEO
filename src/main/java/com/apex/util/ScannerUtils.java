package com.apex.util;

import com.apex.models.Posicion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ScannerUtils {

    public static Scanner SCANNER = new Scanner(System.in);

    public static String capturarTexto(String mensaje) {
        System.out.println(mensaje + ": ");
        return SCANNER.nextLine();
    }

    public static int capturarNumero(String mensaje) {
        System.out.println(mensaje + ": ");

        while (!SCANNER.hasNextInt()) {
            System.out.println("Dato no aceptado " + mensaje + ": ");
            SCANNER.next();
        }

        int dato = SCANNER.nextInt();
        SCANNER.nextLine();
        return dato;
    }

    public static double capturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");

        while (!SCANNER.hasNextDouble()) {
            System.out.println("Dato no aceptado " + mensaje + ": ");
            SCANNER.next();
        }

        double dato = SCANNER.nextDouble();
        SCANNER.nextLine();
        return dato;
    }

    public static LocalDateTime capturarFecha(String mensaje) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            System.out.println(mensaje + " (dd/MM/yyyy HH:mm): ");
            String entrada = SCANNER.nextLine();

            try {
                return LocalDateTime.parse(entrada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Utiliza el formato dd/MM/yyyy HH:mm.");
            }
        }
    }

    public static String capturarEquipo(String mensaje) {
        String nombre;

        while (true) {
            System.out.println(mensaje + ": ");
            nombre = SCANNER.nextLine();

            if (!nombre.isBlank()) {
                return nombre;
            }

            System.err.println("Error: el nombre del equipo no puede estar vacío.");
        }
    }

    public static Posicion capturarPosicion(String mensaje) {
        while (true) {
            System.out.println(mensaje + " Opciones");
            for (Posicion genero : Posicion.values()) {
                System.out.println("-" + genero.name());
            }
            System.out.println("¿Cual quieres?");
            String entrada = SCANNER.nextLine();

            try {
                return Posicion.valueOf(entrada.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Dato no aceptado " + mensaje + ": ");
            }
        }
    }

    public static int capturarGoles(String mensaje) {
        while (true) {
            System.out.println(mensaje + ": ");

            while (!SCANNER.hasNextInt()) {
                System.err.println("Dato no aceptado " + mensaje + ": ");
                SCANNER.next();
            }

            int dato = SCANNER.nextInt();
            SCANNER.nextLine();

            if (dato >= 0) {
                return dato;
            }

            System.err.println("El número de goles no puede ser un valor negativo.");
        }
    }

}

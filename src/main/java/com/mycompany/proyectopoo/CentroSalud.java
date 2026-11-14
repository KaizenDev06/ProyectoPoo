package com.mycompany.proyectopoo;

import java.util.ArrayList;
import java.util.Scanner;

public class CentroSalud extends LugarPokemon{
    private static int contador = 1;
    private String enfermeraCargo;
    private static int enfermeraCentro = 1; 
    
    //Constructores
    public CentroSalud(String nombre, String ciudad, String enfermeraCargo){
        super(generarCodigo(), nombre, ciudad);
        this.enfermeraCargo = enfermeraCargo;
    }
    
    
    
    //Generar codigo
    public static String generarCodigo() {
        String nuevoCodigo = String.format("ET-%03d", contador);
        contador++;
        return nuevoCodigo;
    }
    //metodo
// ================= ADMINISTRAR CENTROS DE SALUD =================
    public void menuCentrosSalud(Scanner sc, Entrenador entrenador, ArrayList<CentroSalud> centros) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- ADMINISTRAR CENTROS DE SALUD ---");
            System.out.println("1. Listar Centros de Salud");
            System.out.println("2. Registrar nuevo Centro de Salud");
            System.out.println("3. Registrar Visita / Curación de Pokemones");
            System.out.println("4. Regresar");
            opcion = leerEntero(sc, "Ingrese una opción: ", 1, 4);
            switch (opcion) {
                case 1: listarCentros(centros); break;
                case 2: registrarCentro(sc, centros); break;
                case 3: registrarVisita(sc, entrenador, centros); break;
                case 4: System.out.println("\nRegresando..."); break;
            }
        }
    }

    public void listarCentros(ArrayList<CentroSalud> centros) {
        System.out.println("\n--- CENTROS DE SALUD POKEMON ---");
        if (centros.isEmpty()) {
            System.out.println("No hay centros de salud registrados.");
            return;
        }
        for (CentroSalud c : centros) {
            System.out.println("Cód: " + c.getCodigo() + " | " + c.getNombre()
                    + " | Ciudad: " + c.getCiudad()
                    + " | Enfermera: " + c.getEnfermeraCargo());
        }
    }

    public void registrarCentro(Scanner sc, ArrayList<CentroSalud> centros) {
        System.out.println("\n--- REGISTRAR CENTRO DE SALUD (escribe 0 en el nombre para cancelar) ---");
        String nombre = leerTexto(sc, "Nombre: ");
        if (nombre.equals("0")) {
            return;
        }
        String ciudad = leerTexto(sc, "Ubicación/Ciudad: ");
        String enfermera = leerTexto(sc, "Nombre de la enfermera a cargo: ");
        CentroSalud c = new CentroSalud(nombre, ciudad, enfermera);
        centros.add(c);
        System.out.println("\n¡Centro de salud registrado con código " + c.getCodigo() + "!");
    }

    public void registrarVisita(Scanner sc, Entrenador entrenador, ArrayList<CentroSalud> centros) {
        if (centros.isEmpty()) {
            System.out.println("\nNo hay centros de salud registrados.");
            return;
        }
        ArrayList<Pokemon> pokemones = obtenerPokemones(entrenador);
        if (pokemones.isEmpty()) {
            System.out.println("\nNo tienes Pokémones para curar.");
            return;
        }
        System.out.println("\n--- REGISTRAR VISITA ---");
        for (int i = 0; i < centros.size(); i++) {
            CentroSalud c = centros.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " (" + c.getCiudad() + ")");
        }
        System.out.println("0. Regresar");
        int ci = leerEntero(sc, "Seleccione centro: ", 0, centros.size());
        if (ci == 0) {
            return;
        }
        CentroSalud centro = centros.get(ci - 1);

        System.out.println("\n1. Curar todos los Pokémones");
        System.out.println("2. Curar un Pokémon");
        System.out.println("3. Regresar");
        int modo = leerEntero(sc, "Ingrese una opción: ", 1, 3);
        if (modo == 3) {
            return;
        }

        ArrayList<Pokemon> aCurar = new ArrayList<>();
        if (modo == 1) {
            aCurar.addAll(pokemones);
        } else {
            for (int i = 0; i < pokemones.size(); i++) {
                Pokemon p = pokemones.get(i);
                System.out.println((i + 1) + ". " + p.getNombre() + " (PS " + p.getPuntosSalud()
                        + "/" + p.getPuntosSaludMaximos() + ")");
            }
            System.out.println("0. Regresar");
            int pi = leerEntero(sc, "Seleccione Pokémon: ", 0, pokemones.size());
            if (pi == 0) {
                return;
            }
            aCurar.add(pokemones.get(pi - 1));
        }

        System.out.println("\n" + "=".repeat(ANCHO));
        System.out.println("COMPROBANTE DE CURACIÓN");
        System.out.println("Centro: " + centro.getNombre() + " - " + centro.getCiudad());
        System.out.println("Enfermera a cargo: " + centro.getEnfermeraCargo());
        System.out.println("Entrenador: " + entrenador.getNombre());
        System.out.println("-".repeat(ANCHO));
        for (Pokemon p : aCurar) {
            int antes = p.getPuntosSalud();
            p.curar();
            System.out.println(p.getNombre() + ": PS " + antes + " -> " + p.getPuntosSalud());
        }
        System.out.println("=".repeat(ANCHO));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

import java.util.ArrayList;
import java.util.Scanner;

public class Gimnasio extends LugarPokemon{
    private static int contador = 1;    
    private String lider;
    private String medalla;
    private static int contadorGimnasio = 1;  
    
    //Constructores
    public Gimnasio(String nombre, String ciudad, String lider, String medalla){
        super(generarCodigo(), nombre, ciudad);
        this.lider = lider;
        this. medalla = medalla;
    }
    
    //Bitacora de Batalla
    public void registrarCombate(Pokemon pokemonCombatiente, boolean victoria){
        System.out.println("---BITÁCORA DE BATALLA---");
        System.out.println("Gimnasio vísitado: " + this.getNombre()+ "(Lider:" + this.lider + ")");
        System.out.println("Pokemón usado: " + pokemonCombatiente.getNombre());
        if (victoria){
            System.out.println("Resultado: ¡VICTORIA! Has obtenido la medalla: " + this.medalla);
        } else { 
            System.out.println("Resultado: Derrota. Sigue entrenando a tu equipo");
        }
    }
    
    //Generador de codigo
    public static String generarCodigo() {
        String nuevoCodigo = String.format("ET-%03d", contador);
        contador++;
        return nuevoCodigo;
    }
    //Get and Sett
    public String getLider() { return lider; }
    public void setLider(String lider) { this.lider = lider; }
    public String getMedalla() { return medalla; } 
    public void setMedalla(String medalla) { this.medalla = medalla; }   
    //submetodo para administrar los gimnasios del sumenu seleccionar entrenador
// ================= ADMINISTRAR GIMNASIOS =================
    public void menuGimnasios(Scanner sc, Entrenador entrenador, ArrayList<Gimnasio> gimnasios) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- ADMINISTRAR GIMNASIOS POKEMON ---");
            System.out.println("1. Listar Gimnasios");
            System.out.println("2. Registrar nuevo Gimnasio");
            System.out.println("3. Registrar Bitácora de Batalla / Visita a Gimnasio");
            System.out.println("4. Regresar");
            opcion = leerEntero(sc, "Ingrese una opción: ", 1, 4);
            switch (opcion) {
                case 1: listarGimnasios(gimnasios); break;
                case 2: registrarGimnasio(sc, gimnasios); break;
                case 3: registrarBatalla(sc, entrenador, gimnasios); break;
                case 4: System.out.println("\nRegresando..."); break;
            }
        }
    }

    public void listarGimnasios(ArrayList<Gimnasio> gimnasios) {
        System.out.println("\n--- GIMNASIOS ---");
        if (gimnasios.isEmpty()) {
            System.out.println("No hay gimnasios registrados.");
            return;
        }
        for (Gimnasio g : gimnasios) {
            System.out.println("Cód: " + g.getCodigo() + " | " + g.getNombre()
                    + " | Ciudad: " + g.getCiudad()
                    + " | Líder: " + g.getLider()
                    + " | Medalla: " + g.getMedalla());
        }
    }

    public void registrarGimnasio(Scanner sc, ArrayList<Gimnasio> gimnasios) {
        System.out.println("\n--- REGISTRAR GIMNASIO (escribe 0 en el nombre para cancelar) ---");
        String nombre = leerTexto(sc, "Nombre: ");
        if (nombre.equals("0")) {
            return;
        }
        String ciudad = leerTexto(sc, "Ciudad: ");
        String lider = leerTexto(sc, "Líder de gimnasio: ");
        String medalla = leerTexto(sc, "Tipo de medalla: ");
        Gimnasio g = new Gimnasio(nombre, ciudad, lider, medalla);
        gimnasios.add(g);
        System.out.println("\n¡Gimnasio registrado con código " + g.getCodigo() + "!");
    }

    public void registrarBatalla(Scanner sc, Entrenador entrenador, ArrayList<Gimnasio> gimnasios) {
        if (gimnasios.isEmpty()) {
            System.out.println("\nNo hay gimnasios registrados.");
            return;
        }
        ArrayList<Pokemon> pokemones = obtenerPokemones(entrenador);
        if (pokemones.isEmpty()) {
            System.out.println("\nNo tienes Pokémones para combatir.");
            return;
        }
        System.out.println("\n--- REGISTRAR BATALLA ---");
        for (int i = 0; i < gimnasios.size(); i++) {
            Gimnasio g = gimnasios.get(i);
            System.out.println((i + 1) + ". " + g.getNombre() + " (" + g.getCiudad() + ")");
        }
        System.out.println("0. Regresar");
        int gi = leerEntero(sc, "Seleccione gimnasio: ", 0, gimnasios.size());
        if (gi == 0) {
            return;
        }
        Gimnasio gimnasio = gimnasios.get(gi - 1);

        for (int i = 0; i < pokemones.size(); i++) {
            Pokemon p = pokemones.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " (Nv. " + p.getNivel()
                    + ", PS " + p.getPuntosSalud() + ")");
        }
        System.out.println("0. Regresar");
        int pi = leerEntero(sc, "Seleccione Pokémon: ", 0, pokemones.size());
        if (pi == 0) {
            return;
        }
        Pokemon pokemon = pokemones.get(pi - 1);

        System.out.println("1. Victoria");
        System.out.println("2. Derrota");
        int resultado = leerEntero(sc, "Resultado: ", 1, 2);

        System.out.println("\n" + "=".repeat(ANCHO));
        System.out.println("BITÁCORA DE BATALLA");
        System.out.println("Entrenador: " + entrenador.getNombre());
        System.out.println("Gimnasio: " + gimnasio.getNombre() + " (Líder: " + gimnasio.getLider() + ")");
        System.out.println("Pokémon: " + pokemon.getNombre());
        System.out.println("Resultado: " + (resultado == 1 ? "VICTORIA" : "DERROTA"));
        if (resultado == 1) {
            System.out.println("¡Ganaste la medalla " + gimnasio.getMedalla() + "!");
        }
        System.out.println("=".repeat(ANCHO));
    }

    

}


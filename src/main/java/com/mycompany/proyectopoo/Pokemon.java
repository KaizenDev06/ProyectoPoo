/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author raula
 */
public class Pokemon {
    private static int contador = 1;
    private String codigo;
    private String nombre;
    private String especie;
    private String tipoPrincipal;
    private int nivel;
    private int puntosSalud;
    private int puntosSaludMaximos;
    
    

    public Pokemon(String codigo, String nombre, String especie, String tipoPrincipal, int nivel, int puntosSalud, int puntosSaludMaximos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.tipoPrincipal = tipoPrincipal;
        this.nivel = nivel;
        this.puntosSalud = puntosSalud;
        this.puntosSaludMaximos = puntosSaludMaximos;
        this.codigo = generarCodigo();
    }
//metodos
    public void subirNivel(){
        
    }
    public void recibirDaño(int cantidad){
        this.puntosSalud -= cantidad;
        if (this.puntosSalud < 0) {
            this.puntosSalud = 0;
        }
        System.out.println(this.nombre + " recibió " + cantidad + " de daño. Vida actual: " + this.puntosSalud);
    }
    public void curar(){
        this.puntosSalud = this.puntosSaludMaximos;
        System.out.println(this.nombre + " ha sido completamente curado.");
    }
 public static String generarCodigo() {
        String nuevoCodigo = String.format("PK-%03d", contador);
        contador++;
        return nuevoCodigo;
    }
    
    //getter and setters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getTipoPrincipal() {
        return tipoPrincipal;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public int getPuntosSaludMaximos() {
        return puntosSaludMaximos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setTipoPrincipal(String tipoPrincipal) {
        this.tipoPrincipal = tipoPrincipal;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPuntosSaludMaximos(int puntosSaludMaximos) {
        this.puntosSaludMaximos = puntosSaludMaximos;
    }
    
    
    // auxiliares
     private ArrayList<Pokemon> obtenerPokemones(Entrenador entrenador) {
        ArrayList<Pokemon> lista = new ArrayList<>();
        for (Pokebola pb : entrenador.getMochila()) {
            if (!pb.estaVacia()) {
                lista.add(pb.getPokemonContenido());
            }
        }
        return lista;
    }
    
    //metodo creado para el submenu al seleccionar perfil del entrenador
// ================= ADMINISTRAR POKÉMONES =================
    public void menuPokemones(Scanner sc, Entrenador entrenador) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- ADMINISTRAR POKEMONES ---");
            System.out.println("1. Registrar nuevo Pokemon en Pokebola vacía");
            System.out.println("2. Listar mis Pokemones");
            System.out.println("3. Liberar Pokemon (Eliminar de la Pokebola)");
            System.out.println("4. Regresar");
            opcion = leerEntero(sc, "Ingrese una opción: ", 1, 4);
            switch (opcion) {
                case 1: registrarPokemon(sc, entrenador); break;
                case 2: listarPokemones(entrenador); break;
                case 3: liberarPokemon(sc, entrenador); break;
                case 4: System.out.println("\nRegresando..."); break;
            }
        }
    }

    public void registrarPokemon(Scanner sc, Entrenador entrenador) {
        Pokebola vacia = buscarPokebolaVacia(entrenador);
        if (vacia == null) {
            System.out.println("\nNo tienes Pokebolas vacías. Agrega más en "
                    + "'Administrar Información del Entrenador'.");
            return;
        }
        System.out.println("\n--- REGISTRAR NUEVO POKEMON (escribe 0 en el nombre para cancelar) ---");
        String nombre = leerTexto(sc, "Nombre: ");
        if (nombre.equals("0")) {
            return;
        }
        String especie = leerTexto(sc, "Especie: ");
        String tipo = leerTexto(sc, "Tipo principal (Fuego, Agua, Planta, ...): ");
        int nivel = leerEntero(sc, "Nivel (1-100): ", 1, 100);
        int ps = leerEntero(sc, "Puntos de Salud PS (1-999): ", 1, 999);

        Pokemon nuevo = new Pokemon(nombre, especie, tipo, nivel, ps);
        vacia.guardarPokemon(nuevo);
        System.out.println("\n¡" + nombre + " fue guardado en la Pokebola " + vacia.getCodigo() + "!");
    }

    public void listarPokemones(Entrenador entrenador) {
        System.out.println("\n--- MIS POKEMONES ---");
        boolean hay = false;
        for (Pokebola pb : entrenador.getMochila()) {
            if (!pb.estaVacia()) {
                Pokemon p = pb.getPokemonContenido();
                System.out.println("Pokebola " + pb.getCodigo() + " | Cód: " + p.getCodigo()
                        + " | " + p.getNombre() + " (" + p.getEspecie() + ")"
                        + " | Tipo: " + p.getTipoPrincipal()
                        + " | Nv. " + p.getNivel()
                        + " | PS: " + p.getPuntosSalud());
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("Aún no has capturado ningún Pokémon.");
        }
    }

    public void liberarPokemon(Scanner sc, Entrenador entrenador) {
        listarPokemones(entrenador);
        if (obtenerPokemones(entrenador).isEmpty()) {
            return;
        }
        String codigo = leerTexto(sc, "\nCódigo de la Pokebola a liberar (ej. PB-001, 0 para regresar): ");
        if (codigo.equals("0")) {
            return;
        }
        for (Pokebola pb : entrenador.getMochila()) {
            if (pb.getCodigo().equalsIgnoreCase(codigo)) {
                if (pb.estaVacia()) {
                    System.out.println("Esa Pokebola ya está vacía.");
                } else {
                    Pokemon liberado = pb.liberarPokemon();
                    System.out.println("¡" + liberado.getNombre() + " fue liberado! La Pokebola "
                            + pb.getCodigo() + " quedó disponible.");
                }
                return;
            }
        }
        System.out.println("No existe una Pokebola con ese código.");
    }

    
}

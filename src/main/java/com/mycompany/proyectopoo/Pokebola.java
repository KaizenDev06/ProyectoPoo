/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;
import java.util.ArrayList;
/**
 *
 * @author raula
 */
public class Pokebola {
    private static int contador = 1;//contador para el codigo secuencial
    private String codigo;
    private String tipoPokebola;
    private Pokemon pokemonContenido; // El pokémon que atrapó (puede ser null si está vacía)
    private boolean estaDisponible;

    public Pokebola(String codigo, String tipoPokebola) {
        this.codigo = generarCodigo();
        this.tipoPokebola = tipoPokebola;
    }
 //metodo para generar codigo
 public static String generarCodigo() {
        String nuevoCodigo = String.format("PB-%03d", contador);
        contador++;
        return nuevoCodigo;
    }
 // Método para asignar un Pokémon a esta pokébola
    public void asignarPokemon(Pokemon p) {
        this.pokemonContenido = p;
        this.estaDisponible = false; // Ya no está disponible porque tiene un Pokémon
    }

    public Pokemon getPokemonContenido() {
        return pokemonContenido;
    }
    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pokebola.contador = contador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoPokebola() {
        return tipoPokebola;
    }

    public void setTipoPokebola(String tipoPokebola) {
        this.tipoPokebola = tipoPokebola;
    }
    
}

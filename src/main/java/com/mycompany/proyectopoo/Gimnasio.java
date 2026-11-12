/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;
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
}

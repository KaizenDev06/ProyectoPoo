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
public class Equipo {
    private static int contador = 1;//contador para el codigo secuencial
    private String codigo;
    private String nombreEquipo;
    private String color;
    private ArrayList<Entrenador> entrenador;

    public Equipo(String codigo, String nombreEquipo, String color, ArrayList<Entrenador> entrenador) {
        this.codigo = generarCodigo();
        this.nombreEquipo = nombreEquipo;
        this.color = color;
        this.entrenador = entrenador;
    }
 //metodo para generar codigo de equipo
     public static String generarCodigo() {
        String nuevoCodigo = String.format("TEAM-%03d", contador);
        contador++;
        return nuevoCodigo;
    }
    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Equipo.contador = contador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Entrenador> getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(ArrayList<Entrenador> entrenador) {
        this.entrenador = entrenador;
    }

    
    
}

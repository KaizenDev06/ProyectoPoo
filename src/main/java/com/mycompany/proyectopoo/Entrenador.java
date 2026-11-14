/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectopoo;
import java.util.ArrayList;
/**
 *
 * @author raula
 */
public class Entrenador {
    private static int contador = 1;//contador para el codigo secuencial
    private String codigo;
    private String nombre;
    private String usuario;
    private String email;
    private Equipo equipo;
    private ArrayList<Pokebola> mochila;
    
//constructores para entrenador existente y nuevo entrenador
    public Entrenador(String nombre, String usuario, String email,ArrayList mochila) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.mochila = mochila;
        this.codigo = generarCodigo();
    }
    //entrenador sin equipo
    public Entrenador(String nombre, String usuario, String email) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.mochila = new ArrayList<>(); // se inicia con la mochila vacia}
        this.codigo = generarCodigo();

    }
    //entrenador añadido con equipo
    public Entrenador(String codigo, String nombre, String usuario, String email, String equipo, ArrayList<Pokebola> mochila) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.equipo = equipo;
        this.mochila = mochila;
    }
//entrenadores agregados por defecto al inciar el programa tr1 y tr2
   public Entrenador(String nombre, String usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }
 //metodos para generar codigo 
     public static String generarCodigo() {
        String nuevoCodigo = String.format("ET-%03d", contador);
        contador++;
        return nuevoCodigo;
    }

    public static int getContador() {
        return contador;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Pokebola> getMochila() {
        return mochila;
    }

    public void setMochila(ArrayList<Pokebola> mochila) {
        this.mochila = mochila;
    }
    public String getEquipo() {
    return equipo;
}

public void setEquipo(String equipo) {
    this.equipo = equipo;
}


    
    
    
}

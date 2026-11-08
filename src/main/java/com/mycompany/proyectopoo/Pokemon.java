/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;


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
    
    
    
}

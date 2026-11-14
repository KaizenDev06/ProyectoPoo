package com.mycompany.proyectopoo;
public abstract class LugarPokemon {
    private static int contador = 1;
    protected String codigo;
    protected String nombre;
    protected String UbicacionCiudad;
    
    private static int contadorLugares = 1;
    //Constructores
    public LugarPokemon(String codigo, String nombre, String ciudad){
        this.codigo = generarCodigo();
        this.nombre = nombre;
        this.UbicacionCiudad = ciudad; 
    }
    //Generador de codigo
    public static String generarCodigo() {
        String nuevoCodigo = String.format("ET-%03d", contador);
        contador++;
        return nuevoCodigo;
    }
        
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacionCiudad() {
        return UbicacionCiudad;
    }

    public static int getContadorLugares() {
        return contadorLugares;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacionCiudad(String UbicacionCiudad) {
        this.UbicacionCiudad = UbicacionCiudad;
    }

    public static void setContadorLugares(int contadorLugares) {
        LugarPokemon.contadorLugares = contadorLugares;
    }
    
    
    
    
    
    
    
}

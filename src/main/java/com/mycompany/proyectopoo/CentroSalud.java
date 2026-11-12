package com.mycompany.proyectopoo;
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
}

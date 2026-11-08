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
//MAIN DEL PROYECTO
public class BitacoraEntrenador {
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
    // 2. LISTA DE EQUIPOS
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("Valor", "Rojo"));
        listaEquipos.add(new Equipo("Místico", "Azul"));
        listaEquipos.add(new Equipo("Instinto", "Amarillo"));
        
        // Instancia de tu clase controladora de métodos
        metodosbitacora control = new metodosbitacora();
      //menu
        System.out.println("=".repeat(30));
        System.out.println("BITACORA ENTRENADOR");
        System.out.println("=".repeat(30));
        System.out.println("Perfiles Registrados: ");
      int opciones = 0;
      while(opciones != 3){
          System.out.printf("Opciones:\n [1] Crear Nuevo Perfil \n" +"[2] Seleccionar Perfil\n" +"[3] Salir\n");
          System.out.println("Ingrese una opcion: ");
          opciones = sc.nextInt();
          sc.nextLine();
        switch (opciones) {
            case 1:
                control.crearPerfil(sc, entrenadores);
               
            case 2:
                control.seleccionarPerfil(sc, entrenadores,listaEquipos);
                
            case 3:
                System.out.println("\n¡Saliendo del programa. Hasta luego!");
               
            default:
                System.out.println("\nOpción no válida.\n");
        }
    }
    sc.close();
}

                        
    }
      
     
  
    


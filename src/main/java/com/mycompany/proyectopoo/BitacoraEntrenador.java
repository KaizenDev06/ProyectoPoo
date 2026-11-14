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
        //perfiles creados al iniciar el programa
        Entrenador tr1 = new Entrenador("Raul Alcivar","Kaizen");
        Entrenador tr2 = new Entrenador("Santiago Trivino","Petolo");
    
        entrenadores.add(tr1);
        entrenadores.add(tr2);
    // 2. LISTA DE EQUIPOS
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("Valor", "Rojo"));
        listaEquipos.add(new Equipo("Místico", "Azul"));
        listaEquipos.add(new Equipo("Instinto", "Amarillo"));
        // AGREGAMOS A UN EQUIPO LOS ENTRENADORES PREDETERMINADOS
        listaEquipos.get(1).agregarEntrenador(tr1);  // Raul -> Místico
        listaEquipos.get(0).agregarEntrenador(tr2);  // Santiago -> Valor
        
        // Instancia de tu clase controladora de métodos
        metodosbitacora control = new metodosbitacora();
      //menu
        System.out.println("=".repeat(30));
        System.out.println("BITACORA ENTRENADOR");
        System.out.println("=".repeat(30));
        System.out.println("Perfiles Registrados: ");
        for (int i = 0; i < entrenadores.size(); i++) {
         Entrenador t = entrenadores.get(i);
        System.out.println((i + 1) + ". " + t.getNombre() + " (@" + t.getUsuario() + ") - " + t.getNombreEquipo());
}
      int opciones = 0;
      while(opciones != 3){
          System.out.printf("Opciones:\n [1] Crear Nuevo Perfil \n" +"[2] Seleccionar Perfil\n" +"[3] Salir\n");
          System.out.println("Ingrese una opcion: ");
          opciones = sc.nextInt();
          sc.nextLine();
          //condiciones para las opciones 
        if (opciones == 1) { //condicion si selecciono perfil y llama al metodo crearperfil()
            control.crearPerfil(sc, entrenadores,listaEquipos);
         } else if (opciones == 2) {
        control.seleccionarPerfil(sc, entrenadores, listaEquipos); //condicion si quiero seleccionar un perfil y muestra un submenu 
        } else if (opciones == 3) {
        System.out.println("Saliendo..."); //condicion para salir del programa
         } else {
        System.out.println("Opción inválida.");
         }
    }
    sc.close();
}

                        
    }
      
     
  
    


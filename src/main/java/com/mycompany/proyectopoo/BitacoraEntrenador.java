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
    private String codigo;
    private int contador = 1;
    private String nombre;
    private int opciones;
    private String usuario;
    private String email;
   
    public static void main(String[] args) {
    /*Pokemon pk = new Pokemon(String codigo, String nombre, String especie, String tipoPrincipal, int nivel, int puntosSalud, int puntosSaludMaximos);
    Pokebola pb = new Pokebola();
    Equipo team = new Equipo();
    CentroSalud iees = new CentroSalud();
    ComprobanteCuracion comcura = new ComprobanteCuracion(); idk esto lo ire arreglando poco a poco
   */
        Scanner sc = new Scanner(System.in);
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
    
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
          if (opciones == 1){
              System.out.println("=".repeat(30));
              System.out.println("Creacion de perfil para entrenador");
              System.out.println("=".repeat(30));
              System.out.println("Ingrese nombre del Entrenador: ");
              String nombrenuevo = sc.nextLine();
              System.out.println("Ingrese usuario el entrenador: ");
              String usuarionuevo = sc.nextLine();
              System.out.println("Ingrese email del entrenador: ");
              String emailnuevo =sc.nextLine();
              Entrenador trainer = new Entrenador(nombrenuevo, usuarionuevo, emailnuevo, new ArrayList<>());
              entrenadores.add(trainer);
              // Mostramos un mensaje de éxito y sus datos usando los getters
                System.out.println("\n¡Perfil creado con éxito!");
                System.out.println("----------------------------------------");
                System.out.printf(trainer.getCodigo() + " "+ trainer.getNombre()+" "+ trainer.getUsuario()+" "+ trainer.getEmail() + "\n");
                System.out.println("----------------------------------------\n");
             
          } else if (opciones == 2){
                System.out.println("\n--- LISTA DE ENTRENADORES REGISTRADOS ---");
                if (entrenadores.isEmpty()) {
                    System.out.println("No hay entrenadores registrados todavía.\n");
                } else {
                    for (int i = 0; i < entrenadores.size(); i++) {
                        Entrenador t = entrenadores.get(i);
                        int cantidadPokebolas = t.getMochila().size();
                        System.out.println((i + 1) + ". "+t.getCodigo() + t.getNombre() + " (@" + t.getUsuario() + ")"+ "Equipo:"+ t.getEquipo() + Pokebolas en mochila: "+cantidadPokebolas);
                    }
                    System.out.println();
                }
            } else if (opciones == 3) {
                System.out.println("\n¡Saliendo del programa. Hasta luego!");
            } else {
                System.out.println("\nOpción no válida. Intente de nuevo.\n");
            }
        }
      sc.close();
      }
      

    }
  
    


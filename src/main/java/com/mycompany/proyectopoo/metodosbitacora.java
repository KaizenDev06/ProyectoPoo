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
public class metodosbitacora {
    //metodos para las opciones de la bitacora
public void crearPerfil(Scanner sc, ArrayList<Entrenador> entrenadores) {
        System.out.println("=".repeat(30));
        System.out.println("Creacion de perfil para entrenador");
        System.out.println("=".repeat(30));
        System.out.println("Ingrese nombre del Entrenador: ");
        String nombrenuevo = sc.nextLine();
        
        System.out.println("Ingrese usuario del entrenador: ");
        String usuarionuevo = sc.nextLine();
        
        System.out.println("Ingrese email del entrenador: ");
        String emailnuevo = sc.nextLine();
        
        Entrenador trainer = new Entrenador(nombrenuevo, usuarionuevo, emailnuevo, new ArrayList<>());
        entrenadores.add(trainer);
        
        System.out.println("\n¡Perfil creado con éxito!");
        System.out.println("----------------------------------------");
        System.out.println(trainer.getCodigo() + " " + trainer.getNombre() + " " + trainer.getUsuario() + " " + trainer.getEmail());
        System.out.println("----------------------------------------\n");
    }
//metodo para seleccionar perfil
public void seleccionarPerfil(Scanner sc, ArrayList<Entrenador> entrenadores, ArrayList<Equipo> listaEquipos) {
   System.out.println("\n--- LISTA DE ENTRENADORES REGISTRADOS ---");
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados todavía.\n");
        } else {
            for (int i = 0; i < entrenadores.size(); i++) {
                Entrenador t = entrenadores.get(i);
                int cantidadPokebolas = t.getMochila().size();
                System.out.println((i + 1) + ". " + t.getCodigo() + " " + t.getNombre() + " (@" + t.getUsuario() + ") Equipo: " + t.getEquipo() + " | Pokebolas: " + cantidadPokebolas);
            }
            System.out.print("\nIngrese el número del perfil que desea seleccionar (0 para regresar): ");
            int seleccion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            // Validamos que la opción esté dentro del rango de la lista
            if (seleccion > 0 && seleccion <= entrenadores.size()) {
                Entrenador entrenadorSeleccionado = entrenadores.get(seleccion - 1);
                
                System.out.println("\n¡Has seleccionado a " + entrenadorSeleccionado.getNombre() + "!");

                // Pasamos ese objeto exacto al menú de administración
                menuAdministracionPerfil(sc, entrenadorSeleccionado, listaEquipos);
                
            } else if (seleccion != 0) {
                System.out.println("Selección inválida.");
            }
        } // <--- Cierre correcto del else de la lista
    } // <--- Cierre corre
//metodo para administrar perfil del administrador
public void menuAdministracionPerfil(Scanner sc, Entrenador entrenador, ArrayList<Equipo> listaEquipos){        
        int opcionesadm = 0;
        while (opcionesadm != 6){
        System.out.println("=".repeat(30));
        System.out.printf("1. Administrar informacion del entrenador \n 2. Administrar Pokémones\n 3. Administrar Gimnasios\n 4. Centros de Salud Pokémon\n 5. Administrar Equipos\n 6. Regresar a seleccion de perfil\n");
        System.out.print("Ingrese opcion: ");
        opcionesadm=sc.nextInt();
        sc.nextLine();
            switch(opcionesadm){
                case 1:
                  submenuentrenador(sc,entrenador);
                case 2:
                    
                }
            }
}
//submenu para opciones seleccionadas en seleccionarperfil
// Submenú para opciones de información del entrenador (Opción 1)
    public void submenuentrenador(Scanner sc, Entrenador entrenador) {
        int subopcion = 0;
        while (subopcion != 5) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("--- ADMINISTRAR INFORMACIÓN DE ENTRENADOR ---");
            System.out.println("=".repeat(40));
         System.out.printf("1. Modificar nombre del entrenador\n" + 
                            "2. Modificar email del entrenador\n" + 
                            "3. Agregar Pokebolas al inventario\n" + 
                            "4. Ver resumen del entrenador\n" +
                            "5. Regresar");
            System.out.print("Ingrese opcion: ");
            subopcion = sc.nextInt();
            sc.nextLine(); 
            if (subopcion == 1) {
                System.out.println("\nNombre actual: " + entrenador.getNombre());
                System.out.print("¿Desea modificarlo? (s/n): ");
                String respuesta = sc.nextLine();
                
                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    entrenador.setNombre(nuevoNombre);
                    System.out.println("¡Nombre actualizado con éxito!\n");
                }
                
            } else if (subopcion == 2) {
                System.out.println("\nEmail actual: " + entrenador.getEmail());
                System.out.print("¿Desea modificarlo? (s/n): ");
                String respuesta = sc.nextLine();
                
                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.print("Ingrese el nuevo email: ");
                    String nuevoEmail = sc.nextLine();
                    entrenador.setEmail(nuevoEmail);
                    System.out.println("¡Email actualizado con éxito!\n");
                }
                
            } else if (subopcion == 3) {
                System.out.println("\n[Módulo de Agregar Pokébolas en desarrollo]\n");
                
            } else if (subopcion == 4) {
                System.out.println("\n" + "=".repeat(35));
                System.out.println("     FICHA COMPLETA DEL ENTRENADOR");
                System.out.println("=".repeat(35));
                System.out.println("Código: " + entrenador.getCodigo());
                System.out.println("Nombre: " + entrenador.getNombre());
                System.out.println("Usuario: @" + entrenador.getUsuario());
                System.out.println("Email: " + entrenador.getEmail());
                System.out.println("Equipo: " + entrenador.getEquipo());
                System.out.println("Pokébolas en mochila: " + entrenador.getMochila().size());
                System.out.println("=".repeat(35) + "\n");
                
            } else if (subopcion == 5) {
                System.out.println("\nRegresando al menú anterior...\n");
            } else {
                System.out.println("\nOpción no válida. Intente de nuevo.\n");
            }
        }
    }
    
    
    //metodo para equipos
    // Método para administrar y ver los equipos oficiales
public void administrarEquipos(Scanner sc, ArrayList<Equipo> listaEquipos) {
    int opcionEquipo = 0;
    
    while (opcionEquipo != 2) {
        System.out.println("=".repeat(40));
        System.out.println("--- ADMINISTRAR EQUIPOS ---");
        System.out.println("=".repeat(40));
        System.out.println("1. Ver listado de Equipos");
        System.out.println("2. Regresar");
        System.out.print("Ingrese opción: ");
        
        opcionEquipo = sc.nextInt();
        sc.nextLine();

        if (opcionEquipo == 1) {
            System.out.println("\n" + "=".repeat(45));
            System.out.println("       LISTADO OFICIAL DE EQUIPOS");
            System.out.println("=".repeat(45));
            
            for (Equipo eq : listaEquipos) {
                System.out.println("Código: " + eq.getCodigo() + 
                                   " | Nombre: " + eq.getNombreEquipo() + 
                                   " | Color: " + eq.getColor());
                System.out.println("-".repeat(45));
            }
            System.out.println();
            
        } else if (opcionEquipo == 2) {
            System.out.println("\nRegresando...\n");
        } else {
            System.out.println("\nOpción no válida. Intente de nuevo.\n");
        }
    }
}

}


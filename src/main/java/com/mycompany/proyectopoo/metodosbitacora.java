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
    // ================= ADMINISTRAR POKÉMONES =================
    public void menuPokemones(Scanner sc, Entrenador entrenador) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- ADMINISTRAR POKEMONES ---");
            System.out.println("1. Registrar nuevo Pokemon en Pokebola vacía");
            System.out.println("2. Listar mis Pokemones");
            System.out.println("3. Liberar Pokemon (Eliminar de la Pokebola)");
            System.out.println("4. Regresar");
            opcion = leerEntero(sc, "Ingrese una opción: ", 1, 4);
            switch (opcion) {
                case 1: registrarPokemon(sc, entrenador); break;
                case 2: listarPokemones(entrenador); break;
                case 3: liberarPokemon(sc, entrenador); break;
                case 4: System.out.println("\nRegresando..."); break;
            }
        }
    }

    public void registrarPokemon(Scanner sc, Entrenador entrenador) {
        Pokebola vacia = buscarPokebolaVacia(entrenador);
        if (vacia == null) {
            System.out.println("\nNo tienes Pokebolas vacías. Agrega más en "
                    + "'Administrar Información del Entrenador'.");
            return;
        }
        System.out.println("\n--- REGISTRAR NUEVO POKEMON (escribe 0 en el nombre para cancelar) ---");
        String nombre = leerTexto(sc, "Nombre: ");
        if (nombre.equals("0")) {
            return;
        }
        String especie = leerTexto(sc, "Especie: ");
        String tipo = leerTexto(sc, "Tipo principal (Fuego, Agua, Planta, ...): ");
        int nivel = leerEntero(sc, "Nivel (1-100): ", 1, 100);
        int ps = leerEntero(sc, "Puntos de Salud PS (1-999): ", 1, 999);

        Pokemon nuevo = new Pokemon(nombre, especie, tipo, nivel, ps);
        vacia.guardarPokemon(nuevo);
        System.out.println("\n¡" + nombre + " fue guardado en la Pokebola " + vacia.getCodigo() + "!");
    }

    public void listarPokemones(Entrenador entrenador) {
        System.out.println("\n--- MIS POKEMONES ---");
        boolean hay = false;
        for (Pokebola pb : entrenador.getMochila()) {
            if (!pb.estaVacia()) {
                Pokemon p = pb.getPokemonContenido();
                System.out.println("Pokebola " + pb.getCodigo() + " | Cód: " + p.getCodigo()
                        + " | " + p.getNombre() + " (" + p.getEspecie() + ")"
                        + " | Tipo: " + p.getTipoPrincipal()
                        + " | Nv. " + p.getNivel()
                        + " | PS: " + p.getPuntosSalud());
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("Aún no has capturado ningún Pokémon.");
        }
    }

    public void liberarPokemon(Scanner sc, Entrenador entrenador) {
        listarPokemones(entrenador);
        if (obtenerPokemones(entrenador).isEmpty()) {
            return;
        }
        String codigo = leerTexto(sc, "\nCódigo de la Pokebola a liberar (ej. PB-001, 0 para regresar): ");
        if (codigo.equals("0")) {
            return;
        }
        for (Pokebola pb : entrenador.getMochila()) {
            if (pb.getCodigo().equalsIgnoreCase(codigo)) {
                if (pb.estaVacia()) {
                    System.out.println("Esa Pokebola ya está vacía.");
                } else {
                    Pokemon liberado = pb.liberarPokemon();
                    System.out.println("¡" + liberado.getNombre() + " fue liberado! La Pokebola "
                            + pb.getCodigo() + " quedó disponible.");
                }
                return;
            }
        }
        System.out.println("No existe una Pokebola con ese código.");
    }

    // ================= ADMINISTRAR GIMNASIOS =================
    public void menuGimnasios(Scanner sc, Entrenador entrenador, ArrayList<Gimnasio> gimnasios) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- ADMINISTRAR GIMNASIOS POKEMON ---");
            System.out.println("1. Listar Gimnasios");
            System.out.println("2. Registrar nuevo Gimnasio");
            System.out.println("3. Registrar Bitácora de Batalla / Visita a Gimnasio");
            System.out.println("4. Regresar");
            opcion = leerEntero(sc, "Ingrese una opción: ", 1, 4);
            switch (opcion) {
                case 1: listarGimnasios(gimnasios); break;
                case 2: registrarGimnasio(sc, gimnasios); break;
                case 3: registrarBatalla(sc, entrenador, gimnasios); break;
                case 4: System.out.println("\nRegresando..."); break;
            }
        }
    }

    public void listarGimnasios(ArrayList<Gimnasio> gimnasios) {
        System.out.println("\n--- GIMNASIOS ---");
        if (gimnasios.isEmpty()) {
            System.out.println("No hay gimnasios registrados.");
            return;
        }
        for (Gimnasio g : gimnasios) {
            System.out.println("Cód: " + g.getCodigo() + " | " + g.getNombre()
                    + " | Ciudad: " + g.getCiudad()
                    + " | Líder: " + g.getLider()
                    + " | Medalla: " + g.getMedalla());
        }
    }

    public void registrarGimnasio(Scanner sc, ArrayList<Gimnasio> gimnasios) {
        System.out.println("\n--- REGISTRAR GIMNASIO (escribe 0 en el nombre para cancelar) ---");
        String nombre = leerTexto(sc, "Nombre: ");
        if (nombre.equals("0")) {
            return;
        }
        String ciudad = leerTexto(sc, "Ciudad: ");
        String lider = leerTexto(sc, "Líder de gimnasio: ");
        String medalla = leerTexto(sc, "Tipo de medalla: ");
        Gimnasio g = new Gimnasio(nombre, ciudad, lider, medalla);
        gimnasios.add(g);
        System.out.println("\n¡Gimnasio registrado con código " + g.getCodigo() + "!");
    }

    public void registrarBatalla(Scanner sc, Entrenador entrenador, ArrayList<Gimnasio> gimnasios) {
        if (gimnasios.isEmpty()) {
            System.out.println("\nNo hay gimnasios registrados.");
            return;
        }
        ArrayList<Pokemon> pokemones = obtenerPokemones(entrenador);
        if (pokemones.isEmpty()) {
            System.out.println("\nNo tienes Pokémones para combatir.");
            return;
        }
        System.out.println("\n--- REGISTRAR BATALLA ---");
        for (int i = 0; i < gimnasios.size(); i++) {
            Gimnasio g = gimnasios.get(i);
            System.out.println((i + 1) + ". " + g.getNombre() + " (" + g.getCiudad() + ")");
        }
        System.out.println("0. Regresar");
        int gi = leerEntero(sc, "Seleccione gimnasio: ", 0, gimnasios.size());
        if (gi == 0) {
            return;
        }
        Gimnasio gimnasio = gimnasios.get(gi - 1);

        for (int i = 0; i < pokemones.size(); i++) {
            Pokemon p = pokemones.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " (Nv. " + p.getNivel()
                    + ", PS " + p.getPuntosSalud() + ")");
        }
        System.out.println("0. Regresar");
        int pi = leerEntero(sc, "Seleccione Pokémon: ", 0, pokemones.size());
        if (pi == 0) {
            return;
        }
        Pokemon pokemon = pokemones.get(pi - 1);

        System.out.println("1. Victoria");
        System.out.println("2. Derrota");
        int resultado = leerEntero(sc, "Resultado: ", 1, 2);

        System.out.println("\n" + "=".repeat(ANCHO));
        System.out.println("BITÁCORA DE BATALLA");
        System.out.println("Entrenador: " + entrenador.getNombre());
        System.out.println("Gimnasio: " + gimnasio.getNombre() + " (Líder: " + gimnasio.getLider() + ")");
        System.out.println("Pokémon: " + pokemon.getNombre());
        System.out.println("Resultado: " + (resultado == 1 ? "VICTORIA" : "DERROTA"));
        if (resultado == 1) {
            System.out.println("¡Ganaste la medalla " + gimnasio.getMedalla() + "!");
        }
        System.out.println("=".repeat(ANCHO));
    }

    // ================= ADMINISTRAR CENTROS DE SALUD =================
    public void menuCentrosSalud(Scanner sc, Entrenador entrenador, ArrayList<CentroSalud> centros) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- ADMINISTRAR CENTROS DE SALUD ---");
            System.out.println("1. Listar Centros de Salud");
            System.out.println("2. Registrar nuevo Centro de Salud");
            System.out.println("3. Registrar Visita / Curación de Pokemones");
            System.out.println("4. Regresar");
            opcion = leerEntero(sc, "Ingrese una opción: ", 1, 4);
            switch (opcion) {
                case 1: listarCentros(centros); break;
                case 2: registrarCentro(sc, centros); break;
                case 3: registrarVisita(sc, entrenador, centros); break;
                case 4: System.out.println("\nRegresando..."); break;
            }
        }
    }

    public void listarCentros(ArrayList<CentroSalud> centros) {
        System.out.println("\n--- CENTROS DE SALUD POKEMON ---");
        if (centros.isEmpty()) {
            System.out.println("No hay centros de salud registrados.");
            return;
        }
        for (CentroSalud c : centros) {
            System.out.println("Cód: " + c.getCodigo() + " | " + c.getNombre()
                    + " | Ciudad: " + c.getCiudad()
                    + " | Enfermera: " + c.getEnfermeraCargo());
        }
    }

    public void registrarCentro(Scanner sc, ArrayList<CentroSalud> centros) {
        System.out.println("\n--- REGISTRAR CENTRO DE SALUD (escribe 0 en el nombre para cancelar) ---");
        String nombre = leerTexto(sc, "Nombre: ");
        if (nombre.equals("0")) {
            return;
        }
        String ciudad = leerTexto(sc, "Ubicación/Ciudad: ");
        String enfermera = leerTexto(sc, "Nombre de la enfermera a cargo: ");
        CentroSalud c = new CentroSalud(nombre, ciudad, enfermera);
        centros.add(c);
        System.out.println("\n¡Centro de salud registrado con código " + c.getCodigo() + "!");
    }

    public void registrarVisita(Scanner sc, Entrenador entrenador, ArrayList<CentroSalud> centros) {
        if (centros.isEmpty()) {
            System.out.println("\nNo hay centros de salud registrados.");
            return;
        }
        ArrayList<Pokemon> pokemones = obtenerPokemones(entrenador);
        if (pokemones.isEmpty()) {
            System.out.println("\nNo tienes Pokémones para curar.");
            return;
        }
        System.out.println("\n--- REGISTRAR VISITA ---");
        for (int i = 0; i < centros.size(); i++) {
            CentroSalud c = centros.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " (" + c.getCiudad() + ")");
        }
        System.out.println("0. Regresar");
        int ci = leerEntero(sc, "Seleccione centro: ", 0, centros.size());
        if (ci == 0) {
            return;
        }
        CentroSalud centro = centros.get(ci - 1);

        System.out.println("\n1. Curar todos los Pokémones");
        System.out.println("2. Curar un Pokémon");
        System.out.println("3. Regresar");
        int modo = leerEntero(sc, "Ingrese una opción: ", 1, 3);
        if (modo == 3) {
            return;
        }

        ArrayList<Pokemon> aCurar = new ArrayList<>();
        if (modo == 1) {
            aCurar.addAll(pokemones);
        } else {
            for (int i = 0; i < pokemones.size(); i++) {
                Pokemon p = pokemones.get(i);
                System.out.println((i + 1) + ". " + p.getNombre() + " (PS " + p.getPuntosSalud()
                        + "/" + p.getPuntosSaludMaximos() + ")");
            }
            System.out.println("0. Regresar");
            int pi = leerEntero(sc, "Seleccione Pokémon: ", 0, pokemones.size());
            if (pi == 0) {
                return;
            }
            aCurar.add(pokemones.get(pi - 1));
        }

        System.out.println("\n" + "=".repeat(ANCHO));
        System.out.println("COMPROBANTE DE CURACIÓN");
        System.out.println("Centro: " + centro.getNombre() + " - " + centro.getCiudad());
        System.out.println("Enfermera a cargo: " + centro.getEnfermeraCargo());
        System.out.println("Entrenador: " + entrenador.getNombre());
        System.out.println("-".repeat(ANCHO));
        for (Pokemon p : aCurar) {
            int antes = p.getPuntosSalud();
            p.curar();
            System.out.println(p.getNombre() + ": PS " + antes + " -> " + p.getPuntosSalud());
        }
        System.out.println("=".repeat(ANCHO));
    }

    // ================= AUXILIARES =================
    private Pokebola buscarPokebolaVacia(Entrenador entrenador) {
        for (Pokebola pb : entrenador.getMochila()) {
            if (pb.estaVacia()) {
                return pb;
            }
        }
        return null;
    }

    private ArrayList<Pokemon> obtenerPokemones(Entrenador entrenador) {
        ArrayList<Pokemon> lista = new ArrayList<>();
        for (Pokebola pb : entrenador.getMochila()) {
            if (!pb.estaVacia()) {
                lista.add(pb.getPokemonContenido());
            }
        }
        return lista;
    }

    private int leerEntero(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Ingrese un número entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número.");
            }
        }
    }

    private String leerTexto(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }
}


package persistencia.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import persistencia.entidades.Persona;
import persistencia.servicios.ServiciosPersona;

public class GUI_Persona {
    private boolean running = true;
    private ServiciosPersona serviciosPersona;

    public GUI_Persona() {
        serviciosPersona = new ServiciosPersona();
    }

    public void iniciar() {
        System.out.println("Bienvenido al sistema de persistencia de personas");

        while (running) {
            System.out.println("1. Crear persona");
            System.out.println("2. Listar personas");
            System.out.println("3. Buscar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("6. Salir");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            seleccion(opcion);
        }

    }

    private void seleccion(int seleccion) {
        switch (seleccion) {
            case 1:
                crearPersona();
                break;
            case 2:
                listarPersonas();
                break;
            case 3:
                buscarPersona();
                break;
            case 4:
                eliminarPersona();
                break;
            case 6:
                salir();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    private void crearPersona() {
        System.out.println("Crear persona");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Identificacion: ");
        String identificacion = scanner.nextLine();
        System.out.println("Celular: ");
        String celular = scanner.nextLine();

        Persona persona = new Persona(nombre, apellido, edad, identificacion, celular);
        serviciosPersona.guardarPersona(persona);

    }

    private void listarPersonas() {
        System.out.println("Listando personas");
        List<Persona> personasEnBaseDatos = serviciosPersona.listarPersonas();

        for (Persona personaEnBaseDatos : personasEnBaseDatos) {
            System.out.println(personaEnBaseDatos.getNombre());
        }
    }

    private void buscarPersona() {
        System.out.println("Buscar persona");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Identificacion: ");
        String identificacion = scanner.nextLine();
        try {
            Persona encontrada = serviciosPersona.buscarPersona(identificacion);
            System.out.println("Persona encontrada: " + encontrada.getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eliminarPersona() {
        System.out.println("Eliminar persona");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Identificacion: ");
        String identificacion = scanner.nextLine();
        try {
            serviciosPersona.eliminarPersona(identificacion);
            System.out.println("Persona eliminada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void salir() {
        System.out.println("Salir");
        running = false;
    }

}

package persistencia;

import java.util.ArrayList;

import persistencia.entidades.Persona;
import persistencia.gui.GUI_Persona;
import persistencia.repositorio.PersonaBaseDatos;
import persistencia.repositorio.Repositorio;

public class main {
    public static void main(String[] args) {

        // Repositorio repositorioPersona = new PersonaBaseDatos();

        // Persona persona = new Persona("Pablo", "Perez", 25, "321654789",
        // "123456789");
        // Persona persona2 = new Persona("Maria", "Perez", 25, "987654321",
        // "123456789");
        // Persona persona3 = new Persona("Pedro", "Perez", 25, "123654987",
        // "123456789");

        // // ------ Guardar Persona ------

        // repositorioPersona.guardar(persona);
        // repositorioPersona.guardar(persona2);
        // repositorioPersona.guardar(persona3);

        // ------ Listar Personas ------

        // ArrayList<Persona> personasEnBaseDatos = (ArrayList<Persona>)
        // repositorioPersona.listar();

        // for (Persona personaEnBaseDatos : personasEnBaseDatos) {
        // System.out.println(personaEnBaseDatos.getNombre());
        // }

        // ------ Buscar Persona ------
        // Persona personaEncontrada = (Persona) repositorioPersona.buscar("987654321");

        // System.out.println("La persona encontrada es: " + personaEncontrada.getNombre());

        GUI_Persona gui = new GUI_Persona();
        gui.iniciar();
    }

}

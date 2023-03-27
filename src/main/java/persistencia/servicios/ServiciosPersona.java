package persistencia.servicios;

import java.util.List;

import persistencia.entidades.Persona;
import persistencia.repositorio.PersonaBaseDatos;
import persistencia.repositorio.Repositorio;

public class ServiciosPersona {

    private Repositorio repositorioPersona;

    public ServiciosPersona() {
        repositorioPersona = new PersonaBaseDatos();
    }

    public void guardarPersona(Persona newPerson) {
        repositorioPersona.guardar(newPerson);
    }

    public List<Persona> listarPersonas() {
        return (List<Persona>) repositorioPersona.listar();
    }

    public Persona buscarPersona(String identificador) throws Exception {
        Object persona = repositorioPersona.buscar(identificador);
        if(persona == null) {
            throw new Exception("No se encontro la persona");
        }
        return (Persona) persona;
    }

    public void eliminarPersona(String identificador) {
        repositorioPersona.eliminar(identificador);
    }

}

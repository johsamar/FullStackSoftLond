package persistencia.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidades.Persona;

public class PersonaBaseDatos implements Repositorio {

    private String cadenaConexion;

    public PersonaBaseDatos() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            cadenaConexion = "jdbc:sqlite:pruebas.db";
            crearTabla();
        } catch (SQLException e) {
            System.err.println("Error de conexión con la base de datos: " + e);
        }

    }

    private void crearTabla() {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {

            String sql = "CREATE TABLE IF NOT EXISTS personas (\n"
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + " nombre TEXT NOT NULL,\n"
                    + " apellido TEXT NOT NULL,\n"
                    + " edad INTEGER NOT NULL ,\n"
                    + " identificacion TEXT NOT NULL UNIQUE,\n"
                    + " celular TEXT\n"
                    + ");";

            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void guardar(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Persona persona = (Persona) objeto;
            String sentenciaSql = "INSERT INTO personas (nombre, apellido, edad, identificacion, celular) " +
                    " VALUES('" + persona.getNombre() + "', '" + persona.getApellido()
                    + "', " + persona.getEdad() + ", '" + persona.getIdentificacion()
                    + "', '" + persona.getCelular() + "');";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }

    }

    @Override
    public void eliminar(String identificacion) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "DELETE FROM personas WHERE identificacion = '" + identificacion + "';";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Object objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public Object buscar(String identificacion) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSQL = "SELECT * FROM personas WHERE identificacion = ?";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, identificacion);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (resultadoConsulta != null && resultadoConsulta.next()) {
                Persona persona = null;
                String nombre = resultadoConsulta.getString("nombre");
                String apellido = resultadoConsulta.getString("apellido");
                int edad = resultadoConsulta.getInt("edad");
                String identificacionResultado = resultadoConsulta.getString("identificacion");
                String celular = resultadoConsulta.getString("celular");

                persona = new Persona(nombre, apellido, edad, identificacionResultado, celular);
                return persona;
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public List<?> listar() {
        List<Persona> personas = new ArrayList<Persona>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM personas";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Persona persona = null;
                    String nombre = resultadoConsulta.getString("nombre");
                    String apellido = resultadoConsulta.getString("apellido");
                    int edad = resultadoConsulta.getInt("edad");
                    String identificacion = resultadoConsulta.getString("identificacion");
                    String celular = resultadoConsulta.getString("celular");

                    persona = new Persona(nombre, apellido, edad, identificacion, celular);
                    personas.add(persona);
                }
                return personas;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;

    }

}

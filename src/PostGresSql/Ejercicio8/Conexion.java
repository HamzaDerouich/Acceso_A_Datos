package PostGresSql.Ejercicio8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conexion {

    public static void CargarConexion() {

        try {
            // Cargamos el driver
            Class.forName("org.postgresql.Driver");

            // Establecemos la conexión
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mascotas", 
                    "postgres", 
                    "12345");

            InsertarVeterinarios(conexion); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void InsertarVeterinarios(Connection conexion) {

        String sql = "INSERT INTO veterinario (dni, nombre, direccion, numerocolegiado) VALUES (?,?,ROW(?,?,?),?)";
        List<Veterinario> veterinarios = new ArrayList<>();
        boolean insertadas = false;

        veterinarios.add(new Veterinario("12345678A", "Juan Pérez", new Direccion("Calle Falsa 123", "Madrid", 28001), 1111));
        veterinarios.add(new Veterinario("23456789B", "Ana Gómez", new Direccion("Avenida de la Paz 45", "Barcelona", 10000), 2222));
        veterinarios.add(new Veterinario("34567890C", "Luis López", new Direccion("Calle Mayor 15", "Sevilla", 41001), 3333));
        veterinarios.add(new Veterinario("45678901D", "Marta Sánchez", new Direccion("Calle del Sol 22", "Valencia", 46001), 4444));
        veterinarios.add(new Veterinario("56789012E", "Pedro Ruiz", new Direccion("Plaza de España 3", "Zaragoza", 50001), 5555));
        veterinarios.add(new Veterinario("67890123F", "Laura Martín", new Direccion("Avenida Libertad 10", "Bilbao", 48001), 6666));
        veterinarios.add(new Veterinario("78901234G", "Carlos García", new Direccion("Calle Alcalá 55", "Madrid", 28002), 7777));
        veterinarios.add(new Veterinario("89012345H", "Sofía Rodríguez", new Direccion("Calle de Serrano 28", "Madrid", 28006), 8888));
        veterinarios.add(new Veterinario("90123456I", "José Fernández", new Direccion("Calle del Carmen 8", "Valencia", 46002), 9999));
        veterinarios.add(new Veterinario("01234567J", "Isabel Gómez", new Direccion("Avenida de los Reyes 50", "Murcia", 30001), 10000));

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            for (Veterinario veterinario : veterinarios) {
                stmt.setString(1, veterinario.getDni());
                stmt.setString(2, veterinario.getNombre());
                
                Direccion direccion = veterinario.getDireccion();
               
                stmt.setString(3, direccion.getCalle());
                stmt.setString(4, direccion.getPoblacion());
                stmt.setInt(5, direccion.getCp());

                stmt.setLong(6, veterinario.getNumeroColegiado());

                int filas = stmt.executeUpdate();
                if (filas > 0) {
                    insertadas = true;
                }
            }

            if (insertadas) {
                System.out.println("Veterinarios insertados correctamente.");
            } else {
                System.out.println("No se insertaron veterinarios.");
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar veterinarios: " + e.getMessage());
        }
    }
}

package PostGresSql.Ejercicio12;

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

            ActualiarMascota(conexion); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void ActualiarMascota(Connection conexion) {
    	
       String sql = "UPDATE public.mascota\r\n"
       		+ "	SET dnipropietario=?, vacuna=?\r\n"
       		+ "	WHERE id = ? " ;
       try ( PreparedStatement stm = conexion.prepareStatement(sql)) {

        } catch (SQLException e) {
            System.err.println("Error al insertar veterinarios: " + e.getMessage());
        }
    }
}

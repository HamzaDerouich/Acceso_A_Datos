package PostGresSql.Ejercico4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	
	public static void MostrarDatosMascotas()
	{

		try {

			// Cargamos el driver

			Class.forName("org.postgresql.Driver");

			// Establecemos la conexión
			Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mascotas", // URL de la
																											// // base
																											// de //
																											// datos
					"postgres", // Nombre de usuario
					"12345" // Contraseña
			);
			
			
			String sql = "SELECT id, nombre, especie, raza\r\n"
					+ "	FROM public.mascota;";
			
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("***Datos_Mascotas****");
			int i = 0 ;
			while(rs.next())
			{
				System.out.println("________________________________");
				System.out.println("Mascota: [" + ( i + 1 )+"]");
				System.out.println("Nombre: " + rs.getString("nombre"));
				System.out.println("Especie: " + rs.getString("especie"));
				System.out.println("Raza: "+ rs.getString("raza"));
				System.out.println("________________________________");
				i++;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

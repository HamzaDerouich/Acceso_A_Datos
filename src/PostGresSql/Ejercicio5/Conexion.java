package PostGresSql.Ejercicio5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
	
	public static void ActualizarDireccionMascotas() {
		
		// Obtener la lista de direcciones
		List<Direccion> listadoDirecciones = listadoDireccion();
		
		try {
			// Cargar el driver
			Class.forName("org.postgresql.Driver");

			// Establecer la conexión
			Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mascotas", // URL de la base de datos
															  "postgres", // Nombre de usuario
															  "12345"); // Contraseña
			
			// Declarar la consulta SQL
			String sql = "UPDATE public.mascota "
					   + "SET direccion = ROW(?, ?, ?) "
					   + "WHERE id = ?";

			// Preparar la sentencia SQL
			PreparedStatement stmt = conexion.prepareStatement(sql);
			boolean insertadas = false;
			for (int i = 1; i < 5; i++) {
				Direccion direccion = listadoDirecciones.get(i);
				
				stmt.setString(1, direccion.getCalle());  
				stmt.setString(2, direccion.getPoblacion());  
				stmt.setInt(3, direccion.getCp());  
				stmt.setInt(4, i);  
				
				int filas = stmt.executeUpdate();
				if( filas > 0 )
				{
					insertadas = true;
				}
				
			}
			
			if(insertadas)
			{
				System.out.println("Filas insertadas correctamente!!");
			}
			else
			{
				System.out.println("Filas no insertadas!!");
			}
			
			conexion.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static List<Direccion> listadoDireccion() {
		List<Direccion> direcciones = new ArrayList<>();

		// Agregar 40 direcciones
        direcciones.add(new Direccion("Calle Falsa 123", "Madrid", 28001));
        direcciones.add(new Direccion("Avenida de la Paz 45", "Barcelona", 10000));
        direcciones.add(new Direccion("Calle Mayor 15", "Sevilla", 41001));
        direcciones.add(new Direccion("Calle del Sol 22", "Valencia", 46001));
        direcciones.add(new Direccion("Plaza de España 3", "Zaragoza", 50001));
        direcciones.add(new Direccion("Avenida Libertad 10", "Bilbao", 48001));
        direcciones.add(new Direccion("Calle Alcalá 55", "Madrid", 28002));
        direcciones.add(new Direccion("Calle de Serrano 28", "Madrid", 28006));
        direcciones.add(new Direccion("Calle del Carmen 8", "Valencia", 46002));
        direcciones.add(new Direccion("Avenida de los Reyes 50", "Murcia", 30001));
        direcciones.add(new Direccion("Calle de la Luna 12", "Vigo", 36201));
        direcciones.add(new Direccion("Calle del Mar 7", "Alicante", 03001));
        direcciones.add(new Direccion("Calle de la Paz 29", "Granada", 18001));
        direcciones.add(new Direccion("Avenida del Mediterráneo 100", "Málaga", 29001));
        direcciones.add(new Direccion("Calle de Ronda 8", "Córdoba", 14001));
        direcciones.add(new Direccion("Calle de los Álamos 13", "Toledo", 45001));
        direcciones.add(new Direccion("Calle Princesa 33", "Las Palmas", 35001));
        direcciones.add(new Direccion("Calle de la Estrella 19", "Palma de Mallorca", 07001));
        direcciones.add(new Direccion("Calle Bravo Murillo 71", "Madrid", 28020));
        direcciones.add(new Direccion("Calle de la Paz 20", "León", 24001));
        direcciones.add(new Direccion("Calle San Sebastián 11", "Oviedo", 33001));
        direcciones.add(new Direccion("Calle de la Candelaria 25", "Santa Cruz de Tenerife", 38001));
        direcciones.add(new Direccion("Calle del Príncipe 9", "Madrid", 28012));
        direcciones.add(new Direccion("Calle Fuencarral 88", "Madrid", 28004));
        direcciones.add(new Direccion("Calle de la Constitución 17", "Badajoz", 06001));
        direcciones.add(new Direccion("Avenida del Ejército 23", "Segovia", 40001));
        direcciones.add(new Direccion("Calle de la Virgen 30", "Salamanca", 37001));
        direcciones.add(new Direccion("Calle de la Vega 2", "Huesca", 22001));
        direcciones.add(new Direccion("Calle del Norte 18", "Gijón", 33201));
        direcciones.add(new Direccion("Calle de Cánovas 21", "Cádiz", 11001));
        direcciones.add(new Direccion("Calle Río 10", "Jaén", 23001));
        direcciones.add(new Direccion("Calle de la Fuente 5", "Huelva", 21001));
        direcciones.add(new Direccion("Calle del Árbol 60", "La Coruña", 15001));
        direcciones.add(new Direccion("Calle de la Sierra 28", "Lugo", 27001));
        direcciones.add(new Direccion("Calle del Ángel 40", "Santiago de Compostela", 15701));

        return direcciones;
	}
}

package base_de_datos.Ejercicio13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Properties;

public class Conexion {
	private static Properties propiedades = new Properties();
	private static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";
	private static String DRIVER_CLASS_NAME = "";

	private static void cargarPropiedades() throws IOException {
		try (FileInputStream fis = new FileInputStream("Properties" + File.separator + "datos_conexion3.properties")) {
			propiedades.load(fis);
			URL = propiedades.getProperty("db.url");
			USER = propiedades.getProperty("db.username");
			PASSWORD = propiedades.getProperty("db.password");
			DRIVER_CLASS_NAME = propiedades.getProperty("db.driverClassName");
		}
	}

	public static void EjecutarScript(String script_sql) {
		try {
			cargarPropiedades();
			System.out.println("Insertando datos en la tabla.....");
			try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD))
			{
			
				PreparedStatement prs = connection.prepareStatement(script_sql);
				int filas_insertadas = prs.executeUpdate();
				
				if( filas_insertadas > 0 )
				{
					System.out.println("Datos registrados en la tabla origen....");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

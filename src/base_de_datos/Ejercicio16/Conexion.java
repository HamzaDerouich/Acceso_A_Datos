package base_de_datos.Ejercicio16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexion {
	private static Properties propiedades = new Properties();
	private static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";
	private static String DRIVER_CLASS_NAME = "";

	private static void cargarPropiedades()  {
		try (FileInputStream fis = new FileInputStream("Properties" + File.separator + "datos_conexion.properties")) {
			propiedades.load(fis);
			URL = propiedades.getProperty("db.url");
			USER = propiedades.getProperty("db.username");
			PASSWORD = propiedades.getProperty("db.password");
			DRIVER_CLASS_NAME = propiedades.getProperty("db.driverClassName");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void EjecutarScript(String script) {
		cargarPropiedades();
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			Statement statement = connection.createStatement();
			statement.execute(script);
			System.out.println("Escript ejecutado correctamente.....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package base_de_datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MostrarMetaDatos {

	// Propiedades de configuración de la base de datos

	private static Properties propiedades = new Properties();

	// Configuraciones de la base de datos

	private static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";
	private static String DRIVER_CLASS_NAME = "";

	// Método para cargar las propiedades desde un archivo

	private static String[] cargarPropiedades() throws IOException {

		String[] datos_conexion = new String[3];

		try (FileInputStream fis = new FileInputStream("Properties" + File.separator + "datos_conexion.properties")) {
			propiedades.load(fis);

			// Cargar las propiedades específicas

			URL = propiedades.getProperty("db.url");
			USER = propiedades.getProperty("db.username");
			PASSWORD = propiedades.getProperty("db.password");
			DRIVER_CLASS_NAME = propiedades.getProperty("db.driverClassName");

			datos_conexion[0] = URL;
			datos_conexion[1] = USER;
			datos_conexion[2] = PASSWORD;

			return datos_conexion;

		}
	}

	// Método para obtener una conexión a la base de datos

	public static Connection conexion() {

		Connection conexion = null;

		try {
			// Cargar las propiedades

			cargarPropiedades();

			// Cargar el controlador JDBC

			Class.forName(DRIVER_CLASS_NAME);

			// Establecer la conexión usando DriverManager

			conexion = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (IOException e) {
			System.out.println("Error al cargar el archivo de propiedades: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión: " + e.getMessage());
		}

		return conexion;
	}

	public static Connection ProbarConexion() {

		Connection conn = conexion();

		if (conn != null) {
			try {
				System.out.println("Conexion Realizado con exito!!");
				System.out.println("Operaciones sobre la base de datos...");
				conn.close();

			} catch (SQLException e) {
				System.out.println("Error al trabajar con la conexión: " + e.getMessage());
			}
		}
		
		return conn;
	}

	public static void SelectMetaDatos() 
	{
		Connection conexion=conexion();
		
		DatabaseMetaData datos;
		try {
			datos = conexion.getMetaData();
		
		System.out.println("Producto BD: " + datos.getDatabaseProductName());
		// Obtener información de la tabla "persona"
		ResultSet tablas = datos.getTables(null, null, "PERSONA", null);
		while (tablas.next()) {
		System.out.println("Tabla: " + tablas.getString("TABLE_NAME"));
		}
		// Obtener y mostrar metadatos de los campos de la tabla "persona"
		ResultSet campos = datos.getColumns(null, null, "PERSONA", null);
		while (campos.next()) {
		System.out.println("Campo: " + campos.getString("COLUMN_NAME"));
		}
		// Obtener y mostrar metadatos de las claves de la tabla "persona"
		ResultSet clavePrimaria = datos.getPrimaryKeys(null, null, "PERSONA");
		while (clavePrimaria.next()) {
		System.out.println("Clave primaria: " + clavePrimaria.getString("COLUMN_NAME"));
		}
		ResultSet claveForanea = datos.getImportedKeys(null, null, "PERSONA");
		while (clavePrimaria.next()) {
		System.out.println("Clave foranea: " + claveForanea.getString("COLUMN_NAME"));
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args)
	{

		SelectMetaDatos();
	}
}

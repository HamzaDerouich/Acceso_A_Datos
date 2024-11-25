package base_de_datos.Ejercicio7;

import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import base_de_datos.Persona;

public class Ejercicio7 {

	// Propiedades de configuración de la base de datos

	private static Properties propiedades = new Properties();

	// Configuraciones de la base de datos

	private static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";
	private static String DRIVER_CLASS_NAME = "";
	private static List<Persona> listPersonas = new ArrayList<Persona>();

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

	// Método para obtener metadatos y datos de la tabla 'Modulo'

	public static void SelectMetaDatos() {
		try {
			// Obtener los metadatos de la base de datos
			
			DatabaseMetaData metaData = conexion().getMetaData();
			ResultSet columnas = metaData.getColumns(null, null, "modulo", null);

			System.out.println("TABLA: Modulo");
			System.out.println("INFORMACIÓN");

			// Número de columnas

			int numeroColumnas = 0;
			while (columnas.next()) {
				numeroColumnas++;
			}

			System.out.println("Número de columnas: " + numeroColumnas);
			System.out.println("COLUMNA\tTIPO");

			// Mostrar los nombres de las columnas y sus tipos

			columnas.beforeFirst();
			while (columnas.next()) {
				String nombreColumna = columnas.getString("COLUMN_NAME");
				String tipoColumna = columnas.getString("TYPE_NAME");
				System.out.println(nombreColumna + "\t" + tipoColumna);
			}

			// Obtener los datos de la tabla 'Modulo'

			Statement stmt = conexion().createStatement();
			ResultSet registros = stmt.executeQuery("SELECT * FROM modulo");

			System.out.println("\nDATOS");

			// Número de registros

			int numeroRegistros = 0;
			while (registros.next()) {
				numeroRegistros++;
			}

			System.out.println("Número de registros: " + numeroRegistros);
			System.out.println("CODIGO\tNOMBRE");

			
			MostrarDatosModulo();
	

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	private static void MostrarDatosModulo() 
	{
		try {

			String[] datos_coneString = cargarPropiedades();
			String consulta = "SELECT * FROM modulo";
			int indice = 1;
			try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1],
					datos_coneString[2]);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(consulta)) {
				while (resultSet.next()) 
				{
				   String codigo = resultSet.getString("Codigo");
				   String nombre = resultSet.getString("nombre");
				   
				   System.out.println("Nombre: " + nombre);
				   System.out.println("Codigo: " + codigo);
				 
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

		SelectMetaDatos();

	}
}

package base_de_datos.Ejercicio6;

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

public class Ejercicio6 {

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


	public static void SelectMetaDatos() 
	{
		Connection conexion=conexion();
		
		DatabaseMetaData datos;
		try {
			
			datos = conexion.getMetaData();
			String gestor = datos.getDatabaseProductName();
			String driver = datos.getDriverName();
			String url = datos.getURL();
			String usuario = datos.getUserName();
			ArrayList<String> listdo_tablas = new ArrayList<String>() ;
			
			try {

				String[] datos_coneString = cargarPropiedades();
				String consulta = "SHOW TABLES";
				int indice = 1;
				try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1],
						datos_coneString[2]);
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery(consulta)) {
					while (resultSet.next()) 
					{
					    listdo_tablas.add(resultSet.getString("TABLES_IN_PERSONAS"));
					    indice++;
					}
				} catch (SQLException e) {
					e.printStackTrace(); 
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		
			Metadatos meta_datos = new Metadatos(gestor, driver, url, usuario, listdo_tablas);
			
			MostrarDatos(meta_datos);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private static void MostrarDatos( Metadatos meta) 
	{
		System.out.println("____Metadatos_Base_De_Datos_______");
		System.out.println(meta);  
		System.out.println("Tablas:");

		for (String nombre : meta.getNombres_tablas()) {
		    System.out.println("\tNombre: " + nombre);  
		}
		System.out.println("________________________________________________");

	}

	public static void main(String[] args)
	{
			
		SelectMetaDatos();
		
	}
}

package base_de_datos;

import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConexionJdbc {

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

	public static void CargarConexion() {

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
	}

	public static void Select() {
		try {

			String[] datos_coneString = cargarPropiedades();
			String consulta = "SELECT dni, nombre, edad FROM Personas.PERSONA ";
			try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1],
					datos_coneString[2]);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(consulta)) {
				while (resultSet.next()) 
				{
						
					String dni = resultSet.getString("dni");
					String nombre = resultSet.getString("nombre");
					int edad = resultSet.getInt("edad");
					
					Persona persona = new Persona(dni, nombre, edad);
					
					listPersonas.add(persona);
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int Insert() {
		int filas = 0 ;
		try {

			
			String[] datos_coneString = cargarPropiedades();
			String consulta = "INSERT INTO Personas.PERSONA\n"
					+ "(dni, nombre, edad)\n"
					+ "VALUES(?, ?, ?); ";
			try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1],
					datos_coneString[2]))
			{
				PreparedStatement prepare = connection.prepareStatement(consulta);
				prepare.setString(1, "12345678F");
				prepare.setString(2, "Hamza");
				prepare.setInt(3, 22);
				
				filas = prepare.executeUpdate();
				
			} 
			catch (SQLException e) {
				e.printStackTrace(); 
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filas;

	}


	public static void main(String[] args) {

		conexion();
		CargarConexion();
		Select();
		for (Persona persona : listPersonas) 
		{
			System.out.println(persona);
		}
		if( Insert() == 0 )
		{
			System.out.println("No se ha insertado ninguna fila!!");
		}
		else 
		{
			System.out.println("Datos insertados, número de filas insertadas: " + Insert());
		}
		
	}
}

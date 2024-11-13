package base_de_datos;

import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Ejercicio9 {

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


	// Método para seleccionar alumnos
	
	public static void SelectAlumno() {
		try {
			String[] datos_coneString = cargarPropiedades();
			String consulta = "SELECT a.nombre, m.nombre AS Asignatura "
                    + "FROM alumno a " 
                    + "JOIN nota n ON a.id = n.alumno " 
                    + "JOIN modulo m ON m.codigo = n.modulo;"; 

			try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1],
					datos_coneString[2]);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(consulta)) {
				while (resultSet.next()) {
					String nombre = resultSet.getString("nombre");
					String asignatura = resultSet.getString("Asignatura");
					
					System.out.println("____Alumno:Asignatura_____");
					System.out.println("Nombre Alumno: " + nombre );
					System.out.println("Asignatura: " + asignatura );
					System.out.println("============================");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para seleccionar módulos
	public static void SelectModulo() {
		try {
			String[] datos_coneString = cargarPropiedades();
			String consulta = "SELECT * FROM modulo ";
			try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1],
					datos_coneString[2]);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(consulta)) {
				while (resultSet.next()) {
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para seleccionar notas
	public static void SelectNota() {
		try {
			String[] datos_coneString = cargarPropiedades();
			String consulta = "SELECT * FROM nota ";
			try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1],
					datos_coneString[2]);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(consulta)) {
				while (resultSet.next()) {
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para seleccionar tablas
	public static void SelectTablas() {
		try {
			String[] datos_coneString = cargarPropiedades();
			String consulta = "SHOW TABLES";
			try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1],
					datos_coneString[2]);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(consulta)) {
				while (resultSet.next()) {
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public static void main(String[] args) {
		SelectAlumno();
	}
}

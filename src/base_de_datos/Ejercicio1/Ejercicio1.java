package base_de_datos.Ejercicio1;

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

public class Ejercicio1 {

	// Propiedades de configuración de la base de datos
	private static Properties propiedades = new Properties();

	// Configuraciones de la base de datos
	private static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";
	private static String DRIVER_CLASS_NAME = "";
	private static List<Alumno> listado_alumnos = new ArrayList<>();
	private static List<Modulo> listado_modulos = new ArrayList<>();
	private static List<Nota> listado_notas = new ArrayList<>();
	private static List<Tabla> listado_tablas = new ArrayList<>();

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

	// Método para realizar la conexión y notificar
	public static void CargarConexion() {
		Connection conn = conexion();
		if (conn != null) {
			try {
				System.out.println("¡Conexión realizada con éxito!");
				System.out.println("Operaciones sobre la base de datos...");
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error al trabajar con la conexión: " + e.getMessage());
			}
		}
	}

	// Método para seleccionar alumnos
	public static void SelectAlumno() {
		try {
			String[] datos_coneString = cargarPropiedades();
			String consulta = "SELECT * FROM alumno ";
			try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1],
					datos_coneString[2]);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(consulta)) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nombre = resultSet.getString("nombre");
					String curso = resultSet.getString("curso");

					Alumno alumno = new Alumno(id, nombre, curso);
					listado_alumnos.add(alumno);
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
					String codigo = resultSet.getString("codigo");
					String nombre = resultSet.getString("nombre");

					Modulo modulo = new Modulo(codigo, nombre);
					listado_modulos.add(modulo);
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
					int id_alumno = resultSet.getInt("alumno");
					String codigo_modulo = resultSet.getString("modulo");
					int nota = resultSet.getInt("nota");

					Nota n = new Nota(id_alumno, codigo_modulo, nota);
					listado_notas.add(n);
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
					String nombre = resultSet.getString(1); // Aquí obtenemos el nombre de la tabla
					Tabla tabla = new Tabla(nombre);
					listado_tablas.add(tabla);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mostrarMenu() {
		Scanner scanner = new Scanner(System.in);

		CargarConexion();
		while (true) {
			System.out.println("\n--- Menú Principal ---");
			System.out.println("1. Mostrar Tablas");
			System.out.println("2. Cargar alumnos");
			System.out.println("3. Cargar modulos");
			System.out.println("4. Cargar notas");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");

			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				SelectTablas();
				System.out.println("Tablas:");
				listado_tablas.forEach(a -> System.out.println(a));
				break;
			case 2:
				SelectAlumno();
				System.out.println("Alumnos:");
				listado_alumnos.forEach(a -> System.out.println(a));
				break;
			case 3:
				SelectModulo();
				System.out.println("Módulos:");
				listado_modulos.forEach(m -> System.out.println(m));
				break;
			case 4:
				SelectNota();
				System.out.println("Notas:");
				listado_notas.forEach(n -> System.out.println(n));
				break;
			case 5:
				System.out.println("Saliendo del programa...");
				scanner.close();
				return;
			default:
				System.out.println("Opción no válida. Intenta de nuevo.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		mostrarMenu();
	}
}

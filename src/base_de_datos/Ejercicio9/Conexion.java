package base_de_datos.Ejercicio9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexion {

	// Propiedades de configuración de la base de datos

	private static Properties propiedades = new Properties();

	// Configuraciones de la base de datos
	static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";
	private static String DRIVER_CLASS_NAME = "";

	// Método para cargar las propiedades desde un archivo

	private static void cargarPropiedades() {
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


	public static void SelectAlumno() {

		cargarPropiedades();
		String consulta = "SELECT a.nombre, m.nombre AS Asignatura " + "FROM alumno a "
				+ "JOIN nota n ON a.id = n.alumno " + "JOIN modulo m ON m.codigo = n.modulo;";

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(consulta);

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String asignatura = resultSet.getString("Asignatura");

				System.out.println("____Alumno:Asignatura_____");
				System.out.println("Nombre Alumno: " + nombre);
				System.out.println("Asignatura: " + asignatura);
				System.out.println("============================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void SelectAsignaturaNota(int id) {

		cargarPropiedades();
		String consulta = " SELECT M.nombre , N.nota\r\n" + "FROM modulo M , nota N\r\n"
				+ "INNER JOIN alumno A ON A.id = N.alumno \r\n" + "WHERE A.id = " + id;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(consulta);
			System.out.println("Calificaciones Alumno con id: " + id);
			while (resultSet.next()) {
				String nombre_asignatura = resultSet.getString("nombre");
				int nota = resultSet.getInt("nota");
				System.out.println("Asignatura: " + nombre_asignatura);
				System.out.println("Nota: " + nota);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void InsertarAlumno(Alumno alumno) {

		cargarPropiedades();
		String consulta = "INSERT INTO alumno (nombre, curso) VALUES (?, ?)";
		;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			PreparedStatement prs = connection.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS);

			prs.setString(1, alumno.getNombre());
			prs.setString(2, alumno.getCurso());

			int filasInsertadas = prs.executeUpdate();
			if (filasInsertadas > 0)
				System.out.println("Alumno registrado con éxito!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public static void InsertarColumnaTelefono() 
	{
		cargarPropiedades();
		String consulta = " ALTER TABLE alumno ADD COLUMN telefono VARCHAR(20)";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			PreparedStatement prs = connection.prepareStatement(consulta);
			prs.executeUpdate();
			System.out.println("Campo 'telefono' añadido correctamente!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void InsertarTelefono(String telefono , int id)
	{
		cargarPropiedades();
		String consulta = "UPDATE alumno SET telefono =" +  telefono + " WHERE id = " + id ;
		try( Connection connection = DriverManager.getConnection(URL,USER,PASSWORD) )
		{
			
			PreparedStatement prs = connection.prepareStatement(consulta);
			
			int filas_actualizadas = prs.executeUpdate();
			if( filas_actualizadas > 0 )
			{
				System.out.println("Teléfono registrado correctamente!!");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

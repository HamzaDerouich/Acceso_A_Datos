package base_de_datos.EjercicioAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	public Conexion() 
	{
		
	}

	private static Connection CargarConexion() {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			Connection conexion = DriverManager
					.getConnection("jdbc:ucanaccess://home//camacho//git//Acceso_A_Datos//BaseDatosAcces//biblioteca.mdb");
			System.out.println("Conexión exitosa.");
			
			return conexion;
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el Driver");
			return null;
		} catch (Exception e) {
			System.out.println("No se puede establecer conexión con la BD");
			return null;
		}

		
	}

	public static void mostrarLibrosFantasia() {
		Connection conexion = CargarConexion();
		String query = "SELECT * FROM libros WHERE genero = 'Fantasia'";
		try (PreparedStatement stmt = conexion.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Título: " + rs.getString("titulo") + ", Autor: "
						+ rs.getString("autor"));
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener los libros: " + e.getMessage());
		}
	}

	public static void añadirTemaComic() {
		Connection conexion = CargarConexion();
		String query = "INSERT INTO temas (nombre) VALUES (?)";
		try (PreparedStatement stmt = conexion.prepareStatement(query)) {
			stmt.setString(1, "comic");
			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Tema 'comic' añadido exitosamente.");
			}
		} catch (SQLException e) {
			System.out.println("Error al añadir el tema: " + e.getMessage());
		}
	}

	public static void añadirAutor() {
		Connection conexion = CargarConexion();
		String query = "INSERT INTO autores (nombre) VALUES (?)";
		try (PreparedStatement stmt = conexion.prepareStatement(query)) {
			stmt.setString(1, "Antonio Luis Sánchez Adalid");
			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Autor 'Antonio Luis Sánchez Adalid' añadido exitosamente.");
			}
		} catch (SQLException e) {
			System.out.println("Error al añadir el autor: " + e.getMessage());
		}
	}

	public static void añadirCampoEditorial() {
		Connection conexion = CargarConexion();
		String query = "ALTER TABLE editorial ADD COLUMN operativa VARCHAR(3) DEFAULT 'si'";
		try (PreparedStatement stmt = conexion.prepareStatement(query)) {
			stmt.executeUpdate();
			System.out.println("Campo 'operativa' añadido exitosamente.");
		} catch (SQLException e) {
			System.out.println("Error al añadir el campo: " + e.getMessage());
		}
	}

	public static void cambiarEditorial(int libroId, String nuevaEditorial) {
		Connection conexion = CargarConexion();
		String query = "UPDATE libros SET editorial = ? WHERE id = ?";
		try (PreparedStatement stmt = conexion.prepareStatement(query)) {
			stmt.setString(1, nuevaEditorial);
			stmt.setInt(2, libroId);
			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Editorial cambiada exitosamente.");
			}
		} catch (SQLException e) {
			System.out.println("Error al cambiar la editorial: " + e.getMessage());
		}
	}

	public static void cambiarOperativaFalse() {
		Connection conexion = CargarConexion();
		String query = "UPDATE editorial SET operativa = 'no' WHERE nombre = 'Meridian'";
		try (PreparedStatement stmt = conexion.prepareStatement(query)) {
			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("La editorial 'Meridian' ha sido marcada como no operativa.");
			}
		} catch (SQLException e) {
			System.out.println("Error al cambiar el estado de operativa: " + e.getMessage());
		}
	}

}

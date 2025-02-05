package PostGresSql.Ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conexion {

	public static void CargarConexion() {

		try {

			// Cargamos el driver

			Class.forName("org.postgresql.Driver");

			// Establecemos la conexión
			Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mascotas", // URL de la
																											// // base
																											// de //
																											// datos
					"postgres", // Nombre de usuario
					"12345" // Contraseña
			);

			InsertarMascota(conexion);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void InsertarMascota(Connection conexion) {

		String sql = "INSERT INTO mascota (nombre, especie, raza) VALUES (?, ?, ?)";
		List<Mascota> mascotas = new ArrayList<>();

		mascotas.add(new Mascota("Luna", "Perro", "Labrador"));
		mascotas.add(new Mascota("Rocky", "Perro", "Pitbull"));
		mascotas.add(new Mascota("Bella", "Gato", "Siames"));
		mascotas.add(new Mascota("Max", "Perro", "Bulldog"));
		mascotas.add(new Mascota("Oliver", "Gato", "Persa"));
		mascotas.add(new Mascota("Charlie", "Perro", "Golden Retriever"));
		mascotas.add(new Mascota("Milo", "Conejo", "Enano"));
		mascotas.add(new Mascota("Simba", "Gato", "Maine Coon"));
		mascotas.add(new Mascota("Coco", "Perro", "Chihuahua"));
		mascotas.add(new Mascota("Sasha", "Perro", "Pastor Alemán"));
		mascotas.add(new Mascota("Lily", "Conejo", "Himalayo"));
		mascotas.add(new Mascota("Buddy", "Perro", "Beagle"));
		mascotas.add(new Mascota("Chester", "Gato", "Bengalí"));
		mascotas.add(new Mascota("Maggie", "Perro", "Cocker Spaniel"));
		mascotas.add(new Mascota("Daisy", "Gato", "Ragdoll"));
		mascotas.add(new Mascota("Shadow", "Perro", "Doberman"));
		mascotas.add(new Mascota("Toby", "Perro", "Poodle"));
		mascotas.add(new Mascota("Penny", "Conejo", "Angora"));
		mascotas.add(new Mascota("Nala", "Gato", "Sphynx"));
		mascotas.add(new Mascota("Gizmo", "Perro", "Yorkshire Terrier"));

		try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
			for (Mascota mascota : mascotas) {

				stmt.setString(1, mascota.getNombre());
				stmt.setString(2, mascota.getEspecie());
				stmt.setString(3, mascota.getRaza());

				stmt.executeUpdate();
			}
			System.out.println("Mascotas insertadas correctamente");
		} catch (SQLException e) {
			System.err.println("Error al insertar mascotas: " + e.getMessage());
		}

	}

	public static void InsertarMascota() {

		Scanner sc = new Scanner(System.in);

		try {

			// Cargamos el driver

			Class.forName("org.postgresql.Driver");

			// Establecemos la conexión
			Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mascotas", // URL de la
																											// // base
																											// de //
																											// datos
					"postgres", // Nombre de usuario
					"12345" // Contraseña
			);

			String nombre = "";
			String especie = "";
			String raza = "";

			System.out.println("*****-INSERTAR-MASCOTA********");
			System.out.print("Digite el nombre de la mascota: ");
			nombre = sc.nextLine();
			System.out.print("Digite la especie de la mascota: ");
			especie = sc.nextLine();
			System.out.println("Digite la raza de la mascota: ");
			raza = sc.nextLine();

			Mascota mascota = new Mascota(nombre, especie, raza);

			try {

				String sql = "INSERT INTO mascota (nombre, especie, raza) VALUES ('" + nombre + "', '" + especie
						+ "', '" + raza + "')";
				Statement stmt = (Statement) conexion.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

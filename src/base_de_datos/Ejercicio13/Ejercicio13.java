package base_de_datos.Ejercicio13;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio13 {
	public static Conexion conexion = new Conexion();

	public static void InsertarIngredientes() {
		File ruta = new File("ficheros/Script_Sql/script3.sql");
		Path ruta1 = ruta.toPath();
		String sql = "";
		try {
			sql = new String(Files.readAllBytes(ruta1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		conexion.EjecutarScript(sql);
	}

	public static  void InsertarRecetas() {
		File ruta = new File("ficheros/Script_Sql/script2.sql");
		Path ruta1 = ruta.toPath();
		String sql = "";
		try {
			sql = new String(Files.readAllBytes(ruta1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		conexion.EjecutarScript(sql);
	}

	public static void InsertarOrigen() {
		File ruta = new File("ficheros/Script_Sql/script1.sql");
		Path ruta1 = ruta.toPath();
		String sql = "";
		try {
			sql = new String(Files.readAllBytes(ruta1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		conexion.EjecutarScript(sql);
	}

	public static void main(String[] args) 
	{


		System.out.println("Ejeuctando script 1, (ORIGEN).....");
		InsertarOrigen();

		
		System.out.println("Ejeuctando script 2, (Recetas).....");
		InsertarRecetas();
		
		
		System.out.println("Ejeuctando script 3, (Ingrediente).....");
		InsertarIngredientes();
		
		
		
		
		
	}
}

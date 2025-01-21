package base_de_datos.Ejercicio16;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio16 
{
	
	public static void CrearTablaProfesor()
	{
		Conexion conexion = new Conexion();
		try {
			File file = new File("ficheros\\Script_Sql\\CrearTablaProfesor.sql");
			String script = new String(Files.readAllBytes(file.toPath()));
			conexion.EjecutarScript(script);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void CrearTablaImparte()
	{
		Conexion conexion = new Conexion();
		try {
			File file = new File("ficheros\\Script_Sql\\CrearTablaImparte.sql");
			String script = new String(Files.readAllBytes(file.toPath()));
			conexion.EjecutarScript(script);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void InsertarProfesores()
	{
		Conexion conexion = new Conexion();
		try {
			File file = new File("ficheros\\Script_Sql\\InsertarProfesores.sql");
			String script = new String(Files.readAllBytes(file.toPath()));
			conexion.EjecutarScript(script);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void InsertarDatosImparte()
	{
		Conexion conexion = new Conexion();
		try {
			File file = new File("ficheros\\Script_Sql\\InsertarImparte.sql");
			String script = new String(Files.readAllBytes(file.toPath()));
			conexion.EjecutarScript(script);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
	    try {
	    	
	        System.out.println("Iniciando la configuración de la base de datos...");

	        // Crear tablas
	        
	        System.out.println("Creando tabla 'profesor'...");
	        CrearTablaProfesor();
	        System.out.println("Tabla 'profesor' creada con éxito.");

	        System.out.println("Creando tabla 'imparte'...");
	        CrearTablaImparte();
	        System.out.println("Tabla 'imparte' creada con éxito.");

	        // Insertar datos
	        
	        System.out.println("Insertando datos en la tabla 'profesor'...");
	        InsertarProfesores();
	        System.out.println("Datos insertados en la tabla 'profesor' con éxito.");

	        System.out.println("Insertando datos en la tabla 'imparte'...");
	        InsertarDatosImparte();
	        System.out.println("Datos insertados en la tabla 'imparte' con éxito.");

	        System.out.println("Configuración de la base de datos completada exitosamente.");
	    } catch (Exception e) {
	        System.err.println("Ocurrió un error durante la configuración de la base de datos:");
	        e.printStackTrace();
	    }
	}

}

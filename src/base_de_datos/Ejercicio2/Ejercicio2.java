package base_de_datos.Ejercicio2;

import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;

public class Ejercicio2 {

	// Propiedades de configuración de la base de datos
	private static Properties propiedades = new Properties();

	// Configuraciones de la base de datos
	private static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";
	private static String DRIVER_CLASS_NAME = "";
	private static List<Alumno> listado_alumnos = new ArrayList<Alumno>();
	private static HashMap<String, List<Integer>> listado_notas_alumno = new HashMap<>() ;
	private static HashMap<Integer,Alumno> alumnos = new HashMap<>() ;


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
		 CargarConexion();
	        try {
	            String[] datos_coneString = cargarPropiedades(); 
	            String consulta = "SELECT a.id, a.nombre, a.curso, m.nombre AS modulo_nombre, n.nota "
	                            + "FROM alumno a "
	                            + "JOIN nota n ON a.id = n.alumno "
	                            + "JOIN modulo m ON m.codigo = n.modulo;";
	            
	            try (Connection connection = DriverManager.getConnection(datos_coneString[0], datos_coneString[1], datos_coneString[2]);
	                 Statement statement = connection.createStatement();
	                 ResultSet resultSet = statement.executeQuery(consulta)) {

	                while (resultSet.next()) {
	                    int id = resultSet.getInt("id");
	                    String nombre = resultSet.getString("nombre");
	                    String curso = resultSet.getString("curso");
	                    String moduloNombre = resultSet.getString("modulo_nombre");
	                    int nota = resultSet.getInt("nota");
	                   
	                    // Añadimos notas 
	                    
	                    if (!listado_notas_alumno.containsKey(moduloNombre)) {
	                        listado_notas_alumno.put(moduloNombre, new ArrayList<>());
	                    }

	                    listado_notas_alumno.get(moduloNombre).add(nota);
	                    Alumno alumno = new Alumno(id, nombre , curso, listado_notas_alumno);
	                    
	                    if( listado_notas_alumno.containsKey(moduloNombre) )
	                    {
	                    	
	                    }
	                    
	                    // Añadimos alumnos 
	                    
	                    if(!alumnos.containsKey(alumno.getId()))
	                    {
	                    	alumnos.put(alumno.getId(), alumno);
	                    }
	                    alumnos.put(alumno.getId(), alumno);
	                    
	                    
	                }
	                
	            } catch (SQLException e) {
	                System.err.println("Database error: " + e.getMessage());
	                e.printStackTrace(); 
	            }

	        } catch (IOException e) {
	            System.err.println("Error al cargar el fichero de propiedades: " + e.getMessage());
	            e.printStackTrace(); 
	        }
	    }
	
	 public static void imprimirDatosAlumnos() {
		    for (Alumno alumno : alumnos.values()) {
		        System.out.println("_________Datos_Alumno_______");
		        System.out.println("Identificador: " + alumno.getId());
		        System.out.println("Nombre: " + alumno.getNombre());
		        System.out.println("Curso: " + alumno.getCurso());
		        System.out.println("--------------------------------");
		        
		        for (Entry<String, List<Integer>> entry : alumno.getModulos_notas().entrySet()) {
		            String modulo = entry.getKey(); 
		            List<Integer> notas = entry.getValue(); 
		            System.out.println("Módulo: " + modulo);
		            for (Integer nota : notas) {
		                System.out.println("  Nota: " + nota);
		            }
		            System.out.println("--------------------------------");
		        }
		        
		        System.out.println("========================================");
		    }
		}
	 
	 
	public static void main(String[] args)
	{
		SelectAlumno();
		imprimirDatosAlumnos();
	}
}

package base_de_datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Ejercicio8 {

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

		try (FileInputStream fis = new FileInputStream("Properties" + File.separator + "datos_conexion2.properties")) {
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

	public static Connection ProbarConexion() {

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

		return conn;
	}

	public static void SelectMetaDatos() {
	    Connection conexion = conexion();

	    DatabaseMetaData datos;
	    ResultSetMetaData datosConsulta;
	    Statement st = null;
	    ResultSet rs = null;
	    ResultSet tablas = null;
	    ResultSet campos = null;
	    ResultSet clavePrimaria = null;
	    ResultSet claveForanea = null;
	    
	    try {
	       
	    	
	        ProbarConexion();

	        // Retrieve metadata about the database
	        datos = conexion.getMetaData();
	        System.out.println("\n--- Metadata de la Base de Datos ---");
	        System.out.println("Producto BD: " + datos.getDatabaseProductName());
	        System.out.println("Driver: " + datos.getDriverName());
	        System.out.println("URL BD: " + datos.getURL());
	        System.out.println();

	        // Obtener información de las tablas
	        
	        System.out.println("--- Tablas en la Base de Datos ---");
	        tablas = datos.getTables(null, null, "PRODUCTO", null);
	        while (tablas.next()) {
	            System.out.println("Tabla: " + tablas.getString("TABLE_NAME"));
	        }
	        System.out.println();

	        // Obtener información de los registros de la tabla PRODUCTO
	        
	        String sql = "SELECT * FROM PRODUCTO";
	        st = conexion.createStatement();
	        rs = st.executeQuery(sql);
	        datosConsulta = rs.getMetaData();
	        System.out.println("--- Metadatos de la Tabla 'PRODUCTO' ---");
	        System.out.println("Número de columnas en la tabla 'PRODUCTO': " + datosConsulta.getColumnCount());
	        System.out.println();

	        // Obtener y mostrar metadatos de los campos de la tabla PRODUCTO
	        
	        System.out.println("--- Metadatos de los Campos de la Tabla 'PRODUCTO' ---");
	        campos = datos.getColumns(null, null, "PRODUCTO", null);
	        while (campos.next()) {
	            System.out.println("Campo: " + campos.getString("COLUMN_NAME"));
	            System.out.println("  Tipo: " + campos.getString("TYPE_NAME"));
	            System.out.println("  Tamaño: " + campos.getInt("COLUMN_SIZE"));
	            System.out.println("  Permite Nulos: " + campos.getString("IS_NULLABLE"));
	            System.out.println("  Predeterminado: " + campos.getString("COLUMN_DEF"));
	            System.out.println();
	        }

	        // Obtener y mostrar metadatos de las claves primarias de la tabla
	        
	        System.out.println("--- Claves Primarias de la Tabla 'PRODUCTO' ---");
	        clavePrimaria = datos.getPrimaryKeys(null, null, "PRODUCTO");
	        while (clavePrimaria.next()) {
	            System.out.println("Clave Primaria: " + clavePrimaria.getString("COLUMN_NAME"));
	        }
	        System.out.println();

	        

	    } catch (SQLException e) {
	        System.err.println("Error al obtener los metadatos de la base de datos.");
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (tablas != null) tablas.close();
	            if (campos != null) campos.close();
	            if (clavePrimaria != null) clavePrimaria.close();
	            if (claveForanea != null) claveForanea.close();
	            if (st != null) st.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static void main(String[] args) {
		SelectMetaDatos();
	}

}

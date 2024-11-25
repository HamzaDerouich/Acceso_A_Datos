package base_de_datos.Ejercicio5;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Conexion {

	static String URL = "";
	static String USER = "";
	static String PASSWORD = "";
	static String DRIVER = "";
	static Properties properties = new Properties();

	public static void CargarPropiedades() {
		String ruta_fichero_propiedades = "Properties/datos_conexion2.properties";
		try (FileInputStream fs = new FileInputStream(new File(ruta_fichero_propiedades))) {
			properties.load(fs);

			URL = properties.getProperty("db.url");
			USER = properties.getProperty("db.username");
			PASSWORD = properties.getProperty("db.password");
			DRIVER = properties.getProperty("db.driverClassName");

		} catch (IOException e) {
			System.out.println("Error en la lectura del fichero propiedades!!");
			e.printStackTrace();
		}
	}

	public static List<String> MostrarTablas() {
		CargarPropiedades();
		String consulta = "SHOW TABLES";
		List<String> tablas = new ArrayList<String>();
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			int i = 1;
			while (rs.next()) {
				String nombre = rs.getString("Tables_in_navavinted").toUpperCase();
				tablas.add(nombre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tablas;
	}

	public static void MostrarTabla(String consulta) {
	    CargarPropiedades();
	    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

	        System.out.println("Ejecutando consulta: " + consulta);

	        Statement st = connection.createStatement();
	        ResultSet rs = st.executeQuery(consulta.toLowerCase());

	        // Obtener metadatos
	        
	        ResultSetMetaData resultSetMetaData = rs.getMetaData();
	        int columnas = resultSetMetaData.getColumnCount();

	        // Encabezados de la tabla
	        
	        for (int i = 1; i <= columnas; i++) {
	            System.out.print(resultSetMetaData.getColumnName(i) + "\t");
	        }
	        System.out.println("\n" + "-".repeat(50)); // Línea separadora

	        // Imprimir valores de cada fila
	        
	        while (rs.next()) {
	            for (int i = 1; i <= columnas; i++) {
	            	System.out.println(i);
	                System.out.print(rs.getString(i) + "\t");
	            }
	            System.out.println(); 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}

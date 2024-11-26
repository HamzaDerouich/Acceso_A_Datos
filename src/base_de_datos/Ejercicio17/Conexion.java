package base_de_datos.Ejercicio17;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Properties;

public class Conexion {
	private static Properties propiedades = new Properties();
	private static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";
	private static String DRIVER_CLASS_NAME = "";

	private static void cargarPropiedades() throws IOException {
		try (FileInputStream fis = new FileInputStream("Properties" + File.separator + "datos_conexion2.properties")) {
			propiedades.load(fis);
			URL = propiedades.getProperty("db.url");
			USER = propiedades.getProperty("db.username");
			PASSWORD = propiedades.getProperty("db.password");
			DRIVER_CLASS_NAME = propiedades.getProperty("db.driverClassName");
		}
	}

	public static int Insert(Producto producto) {
		int filas = 0;
		try {
			cargarPropiedades();
			String consulta = "INSERT INTO PRODUCTO (nombre_Producto, id_categoria, id_Talla, id_Color, id_Material, stock, precio, costo, estado, descuento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement prs = connection.prepareStatement(consulta)) {
				prs.setString(1, producto.getNombreProducto());
				prs.setInt(2, producto.getIdCategoria());
				prs.setInt(3, producto.getIdTalla());
				prs.setInt(4, producto.getIdColor());
				prs.setInt(5, producto.getIdMaterial());
				prs.setInt(6, producto.getStock());
				prs.setDouble(7, producto.getPrecio());
				prs.setDouble(8, producto.getCosto());
				prs.setString(9, producto.getEstado());
				prs.setDouble(10, producto.getDescuento());
				filas = prs.executeUpdate();
				
				if( filas != -1)
				{
					System.out.println("Producto registrado correctamente!!");
				}
				else 
				{
					System.out.println("Producto no registrado!!");
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filas;
	}

}

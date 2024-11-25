package base_de_datos.Ejercicio11;

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

    public static Connection conexion() {
        Connection conexion = null;
        try {
            cargarPropiedades();
            Class.forName(DRIVER_CLASS_NAME);
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

    public static int UpdateStock(int cantidad_vendida, int id) {
        int filas = 0;
        try {
            cargarPropiedades();
            String consulta = "UPDATE PRODUCTO SET stock = stock - ? WHERE id_Producto = ?";
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement prs = connection.prepareStatement(consulta)) {
                prs.setInt(1, cantidad_vendida);
                prs.setInt(2, id);
                filas = prs.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filas;
    }

    public static void SelectCalcularDescuento(int id_producto) {
        try {
            cargarPropiedades();
            String consulta = "SELECT precio, descuento FROM PRODUCTO WHERE id_Producto = ?";
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement prs = connection.prepareStatement(consulta)) {
                prs.setInt(1, id_producto);
                ResultSet resultSet = prs.executeQuery();
                while (resultSet.next()) {
                    double precio = resultSet.getDouble("precio");
                    double descuento = resultSet.getDouble("descuento");
                    DecimalFormat formatDecimalFormat = new DecimalFormat("##.##");
                    double total = precio - ((precio * descuento) / 100);
                    System.out.println("Precio final con el descuento del producto: " + formatDecimalFormat.format(total));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filas;
    }

    public static void SelectProductosCategoria0(int categoria) {
        try {
            cargarPropiedades();
            String consulta = "SELECT * FROM PRODUCTO WHERE id_categoria = ?";
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement prs = connection.prepareStatement(consulta)) {
                prs.setInt(1, categoria);
                ResultSet rs = prs.executeQuery();
                while (rs.next()) {
                    System.out.println("Id Producto:" + rs.getString("id_producto"));
                    System.out.println("Nombre producto: " + rs.getString("nombre_producto"));
                    System.out.println("Estado " + rs.getString("estado"));
                    System.out.println("Precio: " + rs.getString("precio"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void SelectProductosCategoria(int categoria) {
        try {
            cargarPropiedades();
            String consulta = "SELECT * FROM PRODUCTO WHERE id_categoria = ?";
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement prs = connection.prepareStatement(consulta)) {
                prs.setInt(1, categoria);
                ResultSet rs = prs.executeQuery();
                while (rs.next()) {
                    System.out.println("Id Producto:" + rs.getString("id_producto"));
                    System.out.println("Nombre producto: " + rs.getString("nombre_producto"));
                    System.out.println("Estado " + rs.getString("estado"));
                    System.out.println("Precio: " + rs.getString("precio"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void SelectProductosCategoriaTalla(String talla) {
        try {
            cargarPropiedades();
            String consulta = "SELECT PRODUCTO.precio, PRODUCTO.estado, PRODUCTO.nombre_Producto FROM PRODUCTO INNER JOIN TALLA T ON T.id_Talla = PRODUCTO.id_Talla WHERE T.talla = ?";
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement prs = connection.prepareStatement(consulta)) {
                prs.setString(1, talla);
                ResultSet rs = prs.executeQuery();
                while (rs.next()) {
                    System.out.println("Nombre producto: " + rs.getString("nombre_producto"));
                    System.out.println("Estado " + rs.getString("estado"));
                    System.out.println("Precio: " + rs.getString("precio"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

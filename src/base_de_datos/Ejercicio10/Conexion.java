package base_de_datos.Ejercicio10;

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
            String consulta = "UPDATE PRODUCTO SET stock = stock -" + cantidad_vendida + " WHERE id_Producto = " + id;
            System.out.println(consulta);
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                Statement statement = connection.createStatement();
                filas = statement.executeUpdate(consulta);
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
            String consulta = "SELECT PRODUCTO.precio, PRODUCTO.descuento FROM PRODUCTO WHERE PRODUCTO.id_Producto = " + id_producto;
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(consulta)) {
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
            String consulta = "INSERT INTO `PRODUCTO`(`nombre_Producto`, `id_categoria`, `id_Talla`, `id_Color`, `id_Material`, `stock`, `precio`, `costo`, `estado`, `descuento`) VALUES ('"
                    + producto.getNombreProducto() + "', "
                    + producto.getIdCategoria() + ", "
                    + producto.getIdTalla() + ", "
                    + producto.getIdColor() + ", "
                    + producto.getIdMaterial() + ", "
                    + producto.getStock() + ", "
                    + producto.getPrecio() + ", "
                    + producto.getCosto() + ", '"
                    + producto.getEstado() + "', "
                    + producto.getDescuento() + ");";
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                Statement statement = connection.createStatement();
                filas = statement.executeUpdate(consulta);
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
            String consulta = "SELECT * FROM PRODUCTO WHERE id_categoria =" + categoria;
            System.out.println("Ejecutando consulta: " + consulta);
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement st = connection.createStatement();
                 ResultSet rs = st.executeQuery(consulta)) {
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
            String consulta = "SELECT * FROM PRODUCTO WHERE id_categoria = ?; ";
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                PreparedStatement prepare = connection.prepareStatement(consulta);
                prepare.setInt(1, categoria);
                ResultSet rs = prepare.executeQuery();
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
            String consulta = "SELECT PRODUCTO.precio, PRODUCTO.estado, PRODUCTO.nombre_Producto FROM PRODUCTO INNER JOIN TALLA T ON T.id_Talla = PRODUCTO.id_Talla WHERE T.talla = '" + talla + "'";
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(consulta)) {
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

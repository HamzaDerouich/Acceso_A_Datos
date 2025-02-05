package PostGresSql.Ejercicio6;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conexion {

    public static void ActualizarCartillasMascotas() {

        // Obtener la lista de cartillas
        List<Cartilla> listadoCartillas = listadoCartillas();

        try {
            // Cargar el driver
            Class.forName("org.postgresql.Driver");

            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Mascotas", // URL de la base de datos
                    "postgres", // Nombre de usuario
                    "12345"); // Contraseña

            // Declarar la consulta SQL
            String sql = "UPDATE public.mascota "
                    + "SET cartilla = ROW(?, ?, ?) "
                    + "WHERE id = ?";

            // Preparar la sentencia SQL
            PreparedStatement stmt = conexion.prepareStatement(sql);
            boolean actualizadas = false;
            for (int i = 1; i <= 36; i++) { // Iterar sobre las 36 cartillas
                Cartilla cartilla = listadoCartillas.get(i - 1);

                stmt.setString(1, cartilla.getNombreVacuna()); // Establecer el nombre de la vacuna
                stmt.setLong(2, cartilla.getNumeroColegiado()); // Establecer el número de colegiado
                stmt.setDate(3, cartilla.getFechaAplicacion()); // Establecer la fecha de aplicación
                stmt.setInt(4, i); // Establecer el ID de la mascota (suponiendo que se corresponde con el índice)

                int filas = stmt.executeUpdate();
                if (filas > 0) {
                    actualizadas = true;
                }
            }

            // Verificar si se actualizaron filas
            if (actualizadas) {
                System.out.println("Cartillas actualizadas correctamente!");
            } else {
                System.out.println("No se actualizó ninguna cartilla.");
            }

            // Cerrar la conexión
            conexion.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Cartilla> listadoCartillas() {
        List<Cartilla> cartillas = new ArrayList<>();

        // Agregar 36 cartillas (Nombre de vacuna, número de colegiado, fecha de aplicación)
        cartillas.add(new Cartilla("Rabia", 12345, Date.valueOf("2024-01-01")));
        cartillas.add(new Cartilla("Parvovirus", 67890, Date.valueOf("2024-02-01")));
        cartillas.add(new Cartilla("Leishmaniasis", 13579, Date.valueOf("2024-03-01")));
        cartillas.add(new Cartilla("Distemper", 24680, Date.valueOf("2024-04-01")));
        cartillas.add(new Cartilla("Hepatitis", 11223, Date.valueOf("2024-05-01")));
        cartillas.add(new Cartilla("Tétanos", 44556, Date.valueOf("2024-06-01")));
        cartillas.add(new Cartilla("Adenovirus", 78901, Date.valueOf("2024-07-01")));
        cartillas.add(new Cartilla("Parainfluenza", 12312, Date.valueOf("2024-08-01")));
        cartillas.add(new Cartilla("Bordetella", 33445, Date.valueOf("2024-09-01")));
        cartillas.add(new Cartilla("Coronavirus", 66789, Date.valueOf("2024-10-01")));
        cartillas.add(new Cartilla("Leptospirosis", 89012, Date.valueOf("2024-11-01")));
        cartillas.add(new Cartilla("Feline Leukemia", 34567, Date.valueOf("2024-12-01")));
        cartillas.add(new Cartilla("Feline Calicivirus", 56789, Date.valueOf("2025-01-01")));
        cartillas.add(new Cartilla("Feline Herpesvirus", 89123, Date.valueOf("2025-02-01")));
        cartillas.add(new Cartilla("Pif", 67890, Date.valueOf("2025-03-01")));
        cartillas.add(new Cartilla("FIV", 12345, Date.valueOf("2025-04-01")));
        cartillas.add(new Cartilla("Chlamydia", 67892, Date.valueOf("2025-05-01")));
        cartillas.add(new Cartilla("Bovine Tuberculosis", 33456, Date.valueOf("2025-06-01")));
        cartillas.add(new Cartilla("Parvo Canino", 11234, Date.valueOf("2025-07-01")));
        cartillas.add(new Cartilla("Rinotraqueitis", 44322, Date.valueOf("2025-08-01")));
        cartillas.add(new Cartilla("FIP", 55533, Date.valueOf("2025-09-01")));
        cartillas.add(new Cartilla("Rabia Felina", 66644, Date.valueOf("2025-10-01")));
        cartillas.add(new Cartilla("Herpesvirus Felino", 77755, Date.valueOf("2025-11-01")));
        cartillas.add(new Cartilla("Parvovirus Canino", 88866, Date.valueOf("2025-12-01")));
        cartillas.add(new Cartilla("Leishmaniosis Canina", 99977, Date.valueOf("2026-01-01")));
        cartillas.add(new Cartilla("Ehrlichiosis", 12324, Date.valueOf("2026-02-01")));
        cartillas.add(new Cartilla("Giardiasis", 32456, Date.valueOf("2026-03-01")));
        cartillas.add(new Cartilla("Feline Immunodeficiency Virus", 98765, Date.valueOf("2026-04-01")));
        cartillas.add(new Cartilla("Parvo Felino", 65432, Date.valueOf("2026-05-01")));
        cartillas.add(new Cartilla("Dirofilaria", 87654, Date.valueOf("2026-06-01")));
        cartillas.add(new Cartilla("Feline Panleukopenia", 54321, Date.valueOf("2026-07-01")));
        cartillas.add(new Cartilla("Enfermedad Respiratoria Canina", 67834, Date.valueOf("2026-08-01")));
        cartillas.add(new Cartilla("Feline Bordetella", 23456, Date.valueOf("2026-09-01")));
        cartillas.add(new Cartilla("Leishmaniasis Canina", 56783, Date.valueOf("2026-10-01")));
        cartillas.add(new Cartilla("Anaplasmosis", 90876, Date.valueOf("2026-11-01")));
        cartillas.add(new Cartilla("Brucelosis Canina", 12398, Date.valueOf("2026-12-01")));

        return cartillas;
    }
}

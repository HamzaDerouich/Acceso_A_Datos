package MapeoOR.EjercicioPrestamos;

public class Main {
	
	public static void main( String [] args )
	{
		Crud crud = new Crud();
		
		 // Crear tres libros
        Libro libro1 = new Libro(123456, 1, "Cien Años de Soledad", "Gabriel García Márquez");
        Libro libro2 = new Libro(789012, 2, "Don Quijote de la Mancha", "Miguel de Cervantes");
        Libro libro3 = new Libro(345678, 1, "1984", "George Orwell");

        // Crear tres socios
        
        Socio socio1 = new Socio("12345678A", "Juan Pérez", "123456789");
        Socio socio2 = new Socio("23456789B", "Ana Gómez", "987654321");
        Socio socio3 = new Socio("34567890C", "Carlos Sánchez", "112233445");

       

        // Crear tres préstamos
        //	public Prestamo(boolean prestado, Libro libro , Socio socio)
        Prestamo prestamo_1 = new Prestamo(true, libro1, socio1);
        Prestamo prestamo_2 = new Prestamo(true, libro2, socio2);
        Prestamo prestamo_3 = new Prestamo(true, libro3, socio1);
        
        
        //crud.guardarLibro(libro3);
        //crud.guardarLibro(libro2);
        //crud.guardarLibro(libro1);
        
        //crud.guardarSocio(socio3);
        //crud.guardarSocio(socio2);
        //crud.guardarSocio(socio1);

        crud.guardarPrestamo(prestamo_3);
        crud.guardarPrestamo(prestamo_2);
        crud.guardarPrestamo(prestamo_1);
        
    
	}

}

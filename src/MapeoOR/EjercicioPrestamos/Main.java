package MapeoOR.EjercicioPrestamos;

import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static Crud crud = new Crud();

	
	public static void main( String[] args )
	{
		
		Libro libro_1 = new Libro(106, 10, "Crónica de una muerte anunciada", "Gabriel García Márquez");
		Libro libro_2 = new Libro(107, 5, "Los pilares de la Tierra", "Ken Follett");
		Libro libro_3 = new Libro(108, 9, "La sombra del viento", "Carlos Ruiz Zafón");
		
		Socio socio_1 = new Socio(1007, "Juan Pérez", "123456789");
		Socio socio_2 = new Socio(1008, "María García", "987654321");
		Socio socio_3 = new Socio(1009, "Carlos López", "456789123");
		
		Prestamos prestamo_1 = new Prestamos(0, true, libro_1, socio_3);
		Prestamos prestamo_2 = new Prestamos(0, false, libro_2, socio_1);
		Prestamos prestamo_3 = new Prestamos(0, false, libro_3, socio_2 );

		
		//crud.GuardarLibro(libro_3);
		//crud.GuardarLibro(libro_2);
		//crud.GuardarLibro(libro_1);
		
		
		//crud.GuardarSocio(socio_3);
		//crud.GuardarSocio(socio_2);
		//crud.GuardarSocio(socio_1);
		
		
		//crud.GuardarPrestamo(prestamo_1);
		//crud.GuardarPrestamo(prestamo_2);
		//crud.GuardarPrestamo(prestamo_3);
		
		
		MenuOpciones();

	}

	private static void MenuOpciones()
	{
		int opcion = 0 ;
		do 
		{
			System.out.println("[1]Actualizar número telefono propietario: ");
			System.out.println("[2]Consultar libros prestados: ");
			System.out.println("[3]Total de prestamos realizados: ");
			System.out.println("[4]Salir");
			
			System.out.println("Digite la opcion deseada!!");
			opcion = Integer.parseInt(sc.nextLine());
			
			GestionOpcionesMenu(opcion);
			
			
		} while (opcion > 0 && opcion > 5 );
	}

	private static void GestionOpcionesMenu(int opcion) 
	{
		switch (opcion) {
		case 1:
			ActualizarNumeroTelefono();
			break;
		case 2:
			ConsultarLibrosPrestados();
			break;
		case 3:
			TotalNumerosDePrestamosRealizados();
			break;
		default:
			System.out.println("Datos no validos!!");
			break;
		}
		
	}

	private static void TotalNumerosDePrestamosRealizados()
	{
		System.out.println("Total de prestamos: " +  crud.TotalPrestamos());
		
	}

	private static void ConsultarLibrosPrestados() 
	{
		for (Socio socio : crud.ListadoSociosQueHanPrestadoLibros()) {
			System.out.println(socio);
		}
		
	}

	private static void ActualizarNumeroTelefono() 
	{
		int id = 0 ;
		String numero_telefono = "" ;
		
		System.out.println("Digite el dni del socio: ");
		id = Integer.parseInt(sc.nextLine());
		
		System.out.println("Digite el número de telefono: ");
		numero_telefono  = sc.nextLine();
		
		while(numero_telefono.length() >= 15)
		{
			System.out.println("Número de telefono incorrecto");
			System.out.println("Digite el número de telefono: ");
			numero_telefono  = sc.nextLine();
		}
		
		System.out.println(crud.actualizarNumeroSocio(id, numero_telefono));
			
	}
	
}

package base_de_datos.Ejercicio10;

import java.util.Scanner;

public class Ejercicio10 
{

	public static Conexion conexion = new Conexion();
	public static Scanner scanner = new Scanner(System.in);
	
	public static void Menu()
	{
		
		int opcion = 0 ;
		do
		{
			System.out.println("********Gestión_Navavinted*******");
			System.out.println("1.Mostrar las categoria de los producto");
			System.out.println("2.Mostrar productos por talla.");
			System.out.println("3.Agregar producto: ");
			System.out.println("4.Calcular precio producto: ");
			System.out.println("5.Vender producto");
			System.out.println("6.Salir");

			
			System.out.print("Ingres la opcion deseada: ");
			opcion = scanner.nextInt();
			
			
			OpcionesMenu(opcion);
			
		}while( opcion < 6 && opcion > 0 );
		
	}
	
	
	private static void OpcionesMenu(int opcion) 
	{
	
		switch (opcion) {
		case 1:
			MostrarProductosCategoria();
			break;
		case 2:
			MostrarProductoTalla();
			break;
		case 3:
			InsertarProductos();
			break;
		case 4:
			CalcularPrecioProducto();
			break;
		case 5:
			VenderProducto();
			break;
		case 6:
			System.out.println("Saliendo....");
			break;
		default:
			System.out.println("Datos no validos!!.");
			break;
		}
	}


	private static void VenderProducto() 
	{
		System.out.println("Digite el id del producto: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Digite la cantidad de productos: ");
		int cantidad_productos = scanner.nextInt();
		
		if( conexion.UpdateStock(cantidad_productos, id) == 0 )
		{
			System.out.println("No se ha modificado el stock!!");
		}
		else
		{
			System.out.println("EL stock se ha modificado!!");
		}
		
	}


	private static void CalcularPrecioProducto() 
	{
		System.out.println("Digite el id del producto: ");
		int id = scanner.nextInt();
		conexion.SelectCalcularDescuento(id);
	}


	private static void InsertarProductos() 
	{
		 	String nombreProducto = "";

	        System.out.println("Ingrese los datos del producto:");

	        // Solicitar cada dato
	        System.out.print("Nombre del Producto: ");
	        nombreProducto = scanner.nextLine();
	      

	        scanner.nextLine();
	        System.out.print("ID Categoría: ");
	        int idCategoria = Integer.parseInt(scanner.nextLine());

	        System.out.print("ID Talla: ");
	        int idTalla = scanner.nextInt();

	        System.out.print("ID Color: ");
	        int idColor = scanner.nextInt();

	        System.out.print("ID Material: ");
	        int idMaterial = scanner.nextInt();

	        System.out.print("Stock: ");
	        int stock = scanner.nextInt();

	        System.out.print("Precio: ");
	        double precio = scanner.nextDouble();

	        System.out.print("Costo: ");
	        double costo = scanner.nextDouble();

	        scanner.nextLine();  
	        System.out.print("Estado: ");
	        String estado = scanner.nextLine();

	        System.out.print("Descuento: ");
	        double descuento = scanner.nextDouble();
	        
	        Producto producto = new Producto(0, nombreProducto, idCategoria, idTalla, idColor, idMaterial, stock, precio, costo, estado, descuento);

	       int filas_insertadas = conexion.Insert(producto);
	       if( filas_insertadas == 0 )
	       {
	    	   System.out.println("No se ha insertado ninguna fila");
	       }
	       else 
	       {
	    	   System.out.println("Datos insertados correctamente!!");
	       }
	    }
		
	


	private static void MostrarProductoTalla() 
	{
		scanner.nextLine();
		System.out.println("Digite la talla del producto: ");
		String talla = scanner.nextLine().toUpperCase();
		conexion.SelectProductosCategoriaTalla(talla);
	}


	private static void MostrarProductosCategoria() {
		System.out.print("Digite la categoria: ");
		int categoria = scanner.nextInt();
		while( categoria > 2 )
		{
			System.out.println("Categoria no valida!!");
			System.out.print("Digite la categoria: ");
			categoria = scanner.nextInt();
		}
		
		conexion.SelectProductosCategoria0(categoria);
	}

	public static void main(String [] args)
	{
		Menu();
	}
	
}

package MapeoOR.CrudProductos;

import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static Crud crud = new Crud();

	public static void mostrarMenu() {
		System.out.println("1. Insertar producto");
		System.out.println("2. Listar productos");
		System.out.println("3. Buscar producto");
		System.out.println("4. Actualizar producto");
		System.out.println("5. Eliminar producto");
		System.out.println("6. Salir");
	}

	public static void gestionarMenu() {
		int opcion;

		do {
			mostrarMenu();
			System.out.print("Elige una opción: ");
			opcion = Integer.parseInt(scanner.nextLine());
			gestionarOpcion(opcion);
		} while (opcion != 6);
	}

	public static void gestionarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			insertarProducto();
			break;
		case 2:
			listarProductos();
			break;
		case 3:
			buscarProducto();
			break;
		case 4:
			actualizarProducto();
			break;
		case 5:
			eliminarProducto();
			break;
		case 6:
			System.out.println("¡Hasta luego!");
			break;
		default:
			System.out.println("Opción no válida.");
			break;
		}
	}

	public static void insertarProducto() {

		String nombre = "";
		double precio = 0;

		System.out.println("Insertando producto...");

		try {

			System.out.println("Digite el nombre del producto: ");
			nombre = scanner.nextLine();

			System.out.println("Digite el precio del producto: ");
			precio = Double.parseDouble(scanner.nextLine());
			
			crud.crearProducto(new Producto(0,nombre,precio));
			

		} catch (NumberFormatException e) {
			System.out.println("Digite datos validos!!");
			e.printStackTrace();
		}

	}

	private static void listarProductos() {
		System.out.println("Listando productos...");
		List<Producto> listado_productos = crud.listarProductos();
		System.out.println("Listado productos......");
		for (Producto producto : listado_productos)
		{
			System.out.println(producto);
		}
	}

	private static void buscarProducto() {
		System.out.println("Buscando producto...");
		int id_producto = 0 ;
		System.out.println("Digite el id del producto deseado: ");
		id_producto = Integer.parseInt(scanner.nextLine());
		Producto p = null ;
		if( ( p = crud.obtenerProducto(id_producto)) != null)
		{
			System.out.println(p);
		}
		else 
		{
			System.out.println("Error: producto no encontrado!!");
		}
		
	}

	private static void actualizarProducto() 
	{
		System.out.println("Actualizando producto...");
		int id_producto = 0;
		String nombre = "";
		double precio = 0;

		System.out.println("Insertando producto...");

		try {

			System.out.println("Digite el id del producto:");
			id_producto = Integer.parseInt(scanner.nextLine());
			
			System.out.println("Digite el nombre del producto: ");
			nombre = scanner.nextLine();

			System.out.println("Digite el precio del producto: ");
			precio = Double.parseDouble(scanner.nextLine());
			
			crud.actualizarProducto(new Producto(id_producto,nombre,precio));
			

		} catch (NumberFormatException e) {
			System.out.println("Digite datos validos!!");
			e.printStackTrace();
		}
		
	}

	private static void eliminarProducto() 
	{
		System.out.println("Eliminando producto...");
		int id_producto = 0 ;
		System.out.println("Digite el id del producto deseado: ");
		id_producto = Integer.parseInt(scanner.nextLine());
		crud.eliminarProducto(id_producto);
		
	}

	public static void main(String[] args) {
		gestionarMenu();
	}
}

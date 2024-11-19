package base_de_datos.Ejercicio10;

import java.util.Scanner;

public class Ejercicio10 
{

	public static Conexion conexion = new Conexion();
	public static Scanner sc = new Scanner(System.in);
	
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
			opcion = sc.nextInt();
			
			
			OpcionesMenu(opcion);
			
		}while( opcion < 6 && opcion > 0 );
		
	}
	
	
	private static void OpcionesMenu(int opcion) 
	{
	
		switch (opcion) {
		case 1:
			MostrarProductosCategoria();
			break;

		default:
			break;
		}
	}


	private static void MostrarProductosCategoria() {
		System.out.print("Digite la categoria: ");
		int categoria = sc.nextInt();
		while( categoria > 2 )
		{
			System.out.println("Categoria no valida!!");
			System.out.print("Digite la categoria: ");
			categoria = sc.nextInt();
		}
		
		conexion.SelectProductosCategoria0(categoria);
	}

	public static void main(String [] args)
	{
		Menu();
	}
	
}

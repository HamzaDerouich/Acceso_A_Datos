package base_de_datos.Ejercicio5;

import java.util.List;
import java.util.Scanner;

import javax.print.DocPrintJob;

public class Ejercicio5 {

	static Scanner sc = new Scanner(System.in);
	static Conexion conexion = new Conexion();
	static List<String> listado_tablas = conexion.MostrarTablas();
	public static void MostrarTablas() 
	{
		System.out.println("Mostrar tablas: ");
		int tablas = 0 ;
		for (String t : listado_tablas)
		{
			System.out.println("(" + tablas + "): " + t);
			tablas++;
		}
	}
	
	public static void Menu()
	{
		int opcion = 0 ;
		int salir = listado_tablas.size();
		do {
			MostrarTablas();
			System.out.println("Para salir digite el número  " + salir );
			System.out.println("Digite el número de la tabla: ");
			opcion = sc.nextInt();
			
			if( opcion < salir )
			{
				String generar_consulta = GenerarConsulta(opcion);
				System.out.println(generar_consulta);
				conexion.MostrarTabla(generar_consulta);
			}
			else
			{
				System.out.println("Error: digite una opción valida!!");
				System.out.println("Para salir digite el número  " + salir );

			}
			
		} while ( opcion != salir  );
		
	}
	
	

	private static String GenerarConsulta(int opcion) 
	{
		String nombre_tabla = listado_tablas.get(opcion);
		String consulta = "SELECT * FROM " + nombre_tabla.toLowerCase() ;
		return consulta;
	}

	public static void main(String[] args) 
	{
		Menu();
	}
}

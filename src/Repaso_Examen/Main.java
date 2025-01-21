package Repaso_Examen;

import java.util.Scanner;

public class Main 
{
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main( String [] args )
	{
		
		// Inicalizamos la gasolinera
		
		Deposito deposito_1 = new Deposito(Tipo.DIESEL,1000,100);
		Deposito deposito_2 = new Deposito(Tipo.GASOLINA,1000,100);
		Deposito deposito_3 = new Deposito(Tipo.DIESEL_EXECELENT,1000,100);
		Deposito deposito_4 = new Deposito(Tipo.GASOLINA_98,1000,100);
		Deposito[] depositos_gasolinera = {deposito_1,deposito_2,deposito_3,deposito_4};
		Gasolinera gasolinera_la_vera = new Gasolinera(depositos_gasolinera);
		
		
		// Creo un nuevo usuario 
		
		Usuario usuario = new Usuario("CARLOS", "carlos@educarex.es", 0, 0);
		
		// Crear Menu
		
		loginUsuario();
		
	}

	private static void loginUsuario() 
	{
		boolean registrado = false;
		String nombre ;
		String contaseña;
		while( !registrado )
		{
			System.out.println("Digite tu nombre: ");
			nombre = sc.nextLine();
			
			System.out.println("Digete tu contraseña: ");
			contaseña = sc.nextLine();
			
			if( nombre.equals("CARLOS") && contaseña.equals("carlos@educarex.es")   )
			{
				System.out.println("Registrado");
				
			}
			else
			{
				System.out.println("No registrado, adios");
				registrado = true;
			}
		}
		
	}
	
	private static void MenuUsuario()
	{
		
	}
	
}

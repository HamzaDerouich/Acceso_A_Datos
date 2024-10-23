package ficheros.ejercicios;
import java.io.*;
import java.util.Scanner;

public class Ejercicio33 {

    static Scanner scanner = new Scanner(System.in);

    public static void Menu()
    {
        char opcion = '0';
        System.out.print("_______Gestion_Productos______");
        while ( opcion < '5' )
        {
            System.out.println(
                    "\n[1]Dar de alta un producto " +
                            "\n[2]Mostrar una lista de todos los productos " +
                            "\n[3]Modificar el stock de un producto " +
                            "\n[4]Borrar un producto " +
                            "\n[5]Salir "
            );

            System.out.print("Digite el la opción: ");
            opcion = scanner.nextLine().charAt(0);

            if( opcion >= '5' )
            {
                System.out.println("Saliendo del programa...");
            }
            else
            {
                OpcionesMenu(opcion);
            }

        }
    }

    private static void OpcionesMenu(char opcion)
    {
        switch (opcion)
        {
            case '1':
                DarAltaProducto();
                break;
            case '2':
                MostrarListaProductos();
                break;
            case '3':
                ModificarStockProducto();
                break;
            case '4':
                BorrarProducto();
                break;
            default:
                System.out.println("Datos no validos!!");
        }
    }

    private static void BorrarProducto() 
    {
    	int codigo;
        int codigo_buscado;
        int contador_eliminados = 0;
        double precio = 0 ;
        int stock = 0 ;
        
        System.out.println("Digite el codigo del producto: ");
        codigo_buscado = Integer.parseInt(scanner.nextLine());


        try(RandomAccessFile file = new RandomAccessFile("ficheros/productos.dat","r"))
        {
        	RandomAccessFile escritor = new RandomAccessFile("ficheros/productos.dat","rw");
        	file.seek(0);
            while (file.getFilePointer() < file.length())
            {
            	codigo = file.readInt();
       		 	byte[] nombreBytes = new byte[20];
       		 	file.read(nombreBytes);
                precio = file.readDouble();
                stock = file.readInt();
                
                if( codigo == codigo_buscado )
                {
                	file.seek(file.getFilePointer() - 4);
                    escritor.writeInt(contador_eliminados);
                    contador_eliminados--;
                    return ;
                }
            }
            escritor.close();

        }catch (EOFException e)
        {
            System.out.println("Fin del fichero!!");
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        private static void ModificarStockProducto()
    {

        int codigo;
        int codigo_buscado;
        int nueva_cantidad;

        System.out.println("Digite el codigo del producto: ");
        codigo_buscado = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite la nueva cantidad de stock: ");
        nueva_cantidad = Integer.parseInt(scanner.nextLine());

        try(RandomAccessFile file = new RandomAccessFile("ficheros/productos.dat","rw"))
        {
            while (file.getFilePointer() < file.length())
            {
                file.seek(file.getFilePointer());
                codigo = file.readInt();
                if( codigo == codigo_buscado )
                {
                    file.skipBytes(28);
                    file.writeInt(nueva_cantidad);
                    
                    
                }
            }

        }catch (EOFException e)
        {
            System.out.println("Fin del fichero!!");
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        private static void MostrarListaProductos() {
        	
        	int codigo = 0 ;
        	double precio = 0;
        	int stock = 0;
            try (RandomAccessFile file = new RandomAccessFile("ficheros/productos.dat", "rw")) {
                
        		file.seek(0);

            	while (file.getFilePointer() < file.length()) {	
            		
            		 codigo = file.readInt();
            		 byte[] nombreBytes = new byte[20];
                	 file.read(nombreBytes);
                     precio = file.readDouble();
                     stock = file.readInt();
                	
            		
                   
                    String nombre = new String(nombreBytes).trim();
                    
                    if( codigo >= 1 )
                    { 	
                    	 System.out.println("_____Info_Productos____");
                         System.out.println("Producto -> " + codigo);
                         System.out.println("Nombre -> " + nombre);
                         System.out.println("Precio -> " + precio);
                         System.out.println("Cantidad en Stock -> " + stock);
                         System.out.println("_________________________________");
                         
                    }
                }
            } catch (EOFException e) {
                System.out.println("Fin del fichero!!");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        
    private static void DarAltaProducto(){

        int codigo;
        String nombre ;
        double precio;
        int stock;

        System.out.println("Ingrese el codigo del producto: ");
        codigo = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nombre del producto: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Ingrese el stock del producto: ");
        stock = Integer.parseInt(scanner.nextLine());

        if( nombre.length() <= 20 )
        {
        	for( int i = nombre.length() ; i < 20 ; i++ )
        	{
        		nombre += " ";
        	}
        }
        

        try(RandomAccessFile file = new RandomAccessFile("ficheros/productos.dat","rw"))
        {
        	file.seek(file.length());
        	
            file.writeInt(codigo);
            file.writeBytes(nombre);
            file.writeDouble(precio);
            file.writeInt(stock);

        }catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main( String [] args )
    {
        Menu();
    }
}

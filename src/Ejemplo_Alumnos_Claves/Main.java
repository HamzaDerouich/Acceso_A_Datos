package Ejemplo_Alumnos_Claves;

public class Main 
{
	public static void main( String[] args )
	{
		Crud  crud = new Crud();
		Alumno alumno = crud.obtenerAlumno(2);
	    System.out.println("Datos del alumno: ");
	    System.out.println("Nombre: " + alumno.getNombre());
	    System.out.println("Curso: " + alumno.getCurso());
	    System.out.println("Telefono: " + alumno.getTelefono());
	    System.out.println("Notas: ");
		for (Nota nota : alumno.getNotas()) {
			System.out.println("Modulo: " + nota.getId().getModulo().getNombre());
			System.out.println("Nota: " + nota.getNota());
		}
		
	}
}

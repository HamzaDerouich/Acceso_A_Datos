package MapeoOR.ClaveCompuesta;

public class Main 
{
	public static void main( String[] args )
	{
		NotaId notaId = new NotaId(1, "REDES");
		Nota nota = new Nota(notaId, 2);
		Crud  crud = new Crud();
		crud.InsertarNota(nota);
	}
}

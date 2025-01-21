package Ejercicio_Final;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crud {
	
	
	public static void CrearEntidades()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPPrestamos");
		EntityManager em = emf.createEntityManager();
			
		em.getTransaction().begin();
		
		Libro libro = new Libro(1, 10,  "El señor de los anillos", "J.R.R Tolkien");
		Socio socio = new Socio("123456789A", "Ramon Sanchez", "600123456");
		Prestamo prestamo = new Prestamo(true, socio, libro);
		
		
		em.persist(socio);
		em.persist(libro);
		em.persist(prestamo);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
}

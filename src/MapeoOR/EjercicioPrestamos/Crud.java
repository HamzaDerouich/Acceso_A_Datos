package MapeoOR.EjercicioPrestamos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crud {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPPrestamos");
	static EntityManager em = emf.createEntityManager();

	public static String guardarLibro(Libro libro) {
		em.getTransaction().begin();
		em.persist(libro);
		em.getTransaction().commit();

		return "Libro registrado en la base de datos!!";
	}
	
	public static String guardarSocio(Socio socio) {
		em.getTransaction().begin();
		em.persist(socio);
		em.getTransaction().commit();

		return "Socio registrado en la base de datos!!";
	}
	
	public static String guardarPrestamo(Prestamo prestamo) {
		em.getTransaction().begin();
		em.persist(prestamo);
		em.getTransaction().commit();

		return "Prestamo registrado en la base de datos!!";
	}

}

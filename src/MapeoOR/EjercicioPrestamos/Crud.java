/*
package MapeoOR.EjercicioPrestamos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Crud {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPPrestamos");
	static EntityManager em = emf.createEntityManager();

	// Mapeo Objeto Relacional

	public void GuardarLibro(Libro libro) {

	public static String guardarLibro(Libro libro) {
		em.getTransaction().begin();
		em.persist(libro);
		em.getTransaction().commit();

	}

	public void GuardarSocio(Socio socio) {

		return "Libro registrado en la base de datos!!";
	}
	
	public static String guardarSocio(Socio socio) {
		em.getTransaction().begin();
		em.persist(socio);
		em.getTransaction().commit();

	}

	public void GuardarPrestamo(Prestamos prestamo) {

		return "Socio registrado en la base de datos!!";
	}
	
	public static String guardarPrestamo(Prestamo prestamo) {
		em.getTransaction().begin();
		em.persist(prestamo);
		em.getTransaction().commit();

	}

	public Libro obtenerPrestamo(int id) {
		return em.find(Libro.class, id);
	}

	public String actualizarNumeroSocio(int id, String telefono) {
		Socio socio_base_datos = em.find(Socio.class, id);
		if (socio_base_datos != null) {
			em.getTransaction().begin();
			socio_base_datos.setNumTelefono(telefono);
			em.merge(socio_base_datos);
			em.getTransaction().commit();
		} else {
			return "No se ha podido actulizar el número de telefono";
		}

		return "Número de telefono actualizado correctamente!!";
	}

	// Consultas Dinamicas

	public List<Socio> ListadoSociosQueHanPrestadoLibros() {
		String jpql = "SELECT DISTINCT s FROM Socio s JOIN s.listado_prestamos p WHERE p.prestado = true";
		Query query = em.createQuery(jpql, Socio.class);
		List<Socio> resultado = query.getResultList();

		return resultado;
	}

	// Consultas Estaticas

	public int TotalPrestamos() {
		Query query = em.createNamedQuery("Prestamos.TotalPrestamos");
		return query.getResultList().size();

		return "Prestamo registrado en la base de datos!!";
	}

}
*/
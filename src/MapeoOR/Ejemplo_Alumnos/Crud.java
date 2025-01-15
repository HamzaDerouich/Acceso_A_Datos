package MapeoOR.Ejemplo_Alumnos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import MapeoOR.CrudProductos.Producto;


public class Crud {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPPersonas");
	static EntityManager em = emf.createEntityManager();

	// Insert Score

	public void InsertarNota(Nota nota) {
		em.getTransaction().begin();
		em.persist(nota);
		em.getTransaction().commit();
	}
	
	// Obtener alumno
	
	public Alumno obtenerAlumno(int id) {
		return em.find(Alumno.class, id); 
	}


}

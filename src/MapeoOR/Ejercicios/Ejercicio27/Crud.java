package MapeoOR.Ejercicios.Ejercicio27;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Crud {

	public List<Alumno> obtenerAlumnos(String curso) {
		
		List<Alumno> alumnos = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPAlumnos_ej25");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Alumno.findByCurso");
		query.setParameter("curso", curso);
		alumnos = query.getResultList();

		return alumnos;

	}

}

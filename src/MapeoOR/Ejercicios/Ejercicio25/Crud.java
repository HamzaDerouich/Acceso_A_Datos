package MapeoOR.Ejercicios.Ejercicio25;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Crud {

	public List<Alumno> obtenerAlumnos(String curso) {
		
		List<Alumno> alumnos = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPAlumnos_ej_jpql_25");
		EntityManager em = emf.createEntityManager();
		String jpql = "SELECT a FROM Alumno a WHERE a.curso = :curso";
		Query query = em.createQuery(jpql);
		query.setParameter("curso", curso);
		alumnos = query.getResultList();
		
		return alumnos;

	}

}

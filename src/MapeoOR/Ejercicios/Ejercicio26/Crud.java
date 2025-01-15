package MapeoOR.Ejercicios.Ejercicio26;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Crud {

	public List<Alumno> obtenerAlumnos(String curso) {
		
		List<Alumno> alumnos = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPAlumnos_ej26");
		EntityManager em = emf.createEntityManager();
		
		String sql = "SELECT * FROM alumno Where curso = ? ";
		
		Query query = em.createNativeQuery(sql,Alumno.class);
		query.setParameter(1, curso);
		alumnos = query.getResultList();
		return alumnos;

	}

}

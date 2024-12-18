package MapeoOR.ClaveCompuesta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crud {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPPersonas2");
	static EntityManager em = emf.createEntityManager();

	public void InsertarNota(Nota nota) {
		em.getTransaction().begin();
		em.persist(nota);
		em.getTransaction().commit();
	}

	

	


}

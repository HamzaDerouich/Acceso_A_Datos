package MapeoOR.Ejercicio1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EjemploPersona 
{
	
	public static void main(String [] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPPersonas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
		tx.begin();
		
		Persona persona = new Persona("92345678F","Raul",45,"669778964");
		
		em.persist(persona); // em es un EntityManager
		
		tx.commit();
		// Confirma los cambios
		} catch (Exception e) {
		tx.rollback(); // Revertir en caso de error
		e.printStackTrace();
		}
		
	}
	
}

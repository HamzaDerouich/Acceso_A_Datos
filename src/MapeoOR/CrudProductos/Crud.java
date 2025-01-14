package MapeoOR.CrudProductos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crud {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPProductos");
	static EntityManager em = emf.createEntityManager();

	public void crearProducto(Producto producto) 
	{
		em.getTransaction().begin();
		em.persist(producto);
		em.getTransaction().commit();
	}

	public Producto obtenerProducto(int id) {
		return em.find(Producto.class, id); // Busca el producto por su id
	}

	public void actualizarProducto(Producto producto) {
		Producto producto_buscado = em.find(Producto.class, producto.getId());
		if (producto_buscado != null) {
			em.getTransaction().begin();
			producto.setNombre(producto.getNombre());
			producto.setPrecio(producto.getPrecio());
			em.merge(producto); // Actualiza el producto en la base de datos
			em.getTransaction().commit();
		} else {
			System.out.println("Producto no encotrado!!");
		}
	}

	public void eliminarProducto(int id) {
		Producto producto = em.find(Producto.class, id);
		if (producto != null) {
			em.getTransaction().begin();
			em.remove(producto); // Elimina el producto de la base de datos
			em.getTransaction().commit();
		} else {
			System.out.println("Producto no encontrado");
		}

	}

	public List<Producto> listarProductos() {
	    List<Producto> productos = em.createQuery("SELECT p FROM Producto p", Producto.class)
	                                  .getResultList();

	    return productos;
	}


}

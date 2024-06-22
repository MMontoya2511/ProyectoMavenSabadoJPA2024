package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.ICliente;
import model.TblCliente;

public class ClassClienteImp implements ICliente {

	@Override
	public void RegistrarCliente(TblCliente cliente) {
		// establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");

		// permitir gestionar entidades
		EntityManager em = fabr.createEntityManager();

		// iniciar transaccion
		em.getTransaction().begin();

		// registrarnos
		em.persist(cliente);

		// mensaje consola
		System.out.println("cliente REGISTRADO en la BD");

		// confirmamos
		em.getTransaction().commit();

		// cerramos la transaccion
		em.close();

	} // fin registrar

	@Override
	public void ActualizarCliente(TblCliente cliente) {
		// establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");

		// permitir gestionar entidades
		EntityManager em = fabr.createEntityManager();

		// iniciar transaccion
		em.getTransaction().begin();

		// actualizamos
		em.merge(cliente);

		// mensaje consola
		System.out.println("cliente ACTUALIZADO en la BD");

		// confirmamos
		em.getTransaction().commit();

		// cerramos
		em.close();

	} // fin actualizar

	@Override
	public void EliminarCliente(TblCliente cliente) {
		// establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");

		// permitir gestionar entidades
		EntityManager em = fabr.createEntityManager();

		// iniciar transaccion
		em.getTransaction().begin();

		// recuperamos el codigo e eliminar
		TblCliente elim = em.merge(cliente);

		// procedemos a eliminar registro
		em.remove(elim);

		// mensaje consola
		System.out.println("cliente ELIMINADO en la BD");

		// confirmamos
		em.getTransaction().commit();

		// cerramos
		em.close();

	} // fin eliminar

	@Override
	public TblCliente BuscarCliente(TblCliente cliente) {
		// establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");

		// permitir gestionar entidades
		EntityManager em = fabr.createEntityManager();

		// iniciar transaccion
		em.getTransaction().begin();

		// recuperamos el codigo a buscar
		TblCliente buscarcliente = em.find(TblCliente.class, cliente.getIdcliente());

		// confirmamos
		em.getTransaction().commit();

		// cerramos
		em.close();

		return buscarcliente;
	} // fin buscar

	@Override
	public List<TblCliente> ListadoCliente() {
		// establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");

		// gestionamos las entidades
		EntityManager em = fabr.createEntityManager();

		// iniciar transaccion
		em.getTransaction().begin();

		// recuperamos los clientes de la base de datos
		List<TblCliente> listadoclientes=em.createQuery("select c from TblCliente c", TblCliente.class).getResultList();

		// confirmamos la transaccion
		em.getTransaction().commit();

		// cerramos
		em.close();

		return listadoclientes;
	} // fin listar

}

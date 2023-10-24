package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProductocl2;

public class ClassCrudProductoImp implements IProducto{

	@Override
	public void RegistrarProducto(TblProductocl2 tblProductocl2) {
		// establecemos con la unidad de persistencia
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CL2_Maven");		
		EntityManager manager=factory.createEntityManager();		
		manager.getTransaction().begin();
		manager.persist(manager);
		manager.getTransaction().commit();
		manager.close();
	} 

	@Override
	public void ActualizarProducto(TblProductocl2 tblProductocl2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarProducto(TblProductocl2 tblProductocl2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TblProductocl2> Listadoproductocl2() {
		// establecemos unidad de persistencia
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("CL2_Maven");
		EntityManager manager=factory.createEntityManager();
		//iniciamos la transaccion
		manager.getTransaction().begin();
		List<TblProductocl2> ListaProducto=manager.createQuery("select a from TblProductocl2 a"
				,TblProductocl2.class).getResultList();
		
		manager.getTransaction().commit();
		manager.close();
		return ListaProducto;
		
	}

	@Override
	public TblProductocl2 BuscarProducto() {
		// TODO Auto-generated method stub
		return null;
	}

}

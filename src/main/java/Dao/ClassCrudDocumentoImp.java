package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IDocumentoable;
import model.TblDocumento;

public class ClassCrudDocumentoImp implements 	IDocumentoable {

	@Override
	public void RegistrarDocumento(TblDocumento tbdocum) {
		       //establecemo conexion con la unidad de persistencia...
				EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
				//permite gestionar entidades..
				EntityManager eman=fabri.createEntityManager();
				//iniciar transaccion...
				eman.getTransaction().begin();
				//registramos
				eman.persist(tbdocum);
				//confirmamos
				eman.getTransaction().commit();
				//cerramos la transaccion...
				eman.close();
		
	}    //fin del metodo registrar documento...

	@Override
	public void ActualizarDocumento(TblDocumento tbldocum) {
		 //establecemo conexion con la unidad de persistencia...
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//permite gestionar entidades..
		EntityManager eman=fabri.createEntityManager();
		//iniciar transaccion...
		eman.getTransaction().begin();
		//actualizamos
		eman.merge(tbldocum);
		//confirmamos
		eman.getTransaction().commit();
		//cerramos  la transaccion.
		eman.close();
		
	}   //fin del metodo actualizar documento

	@Override
	public void EliminarDocumento(TblDocumento tbldocum) {
		// TODO Auto-generated method stub
		
	}   //fin del metodo eliminar documento...

	@Override
	public List<TblDocumento> ListadoDocumentos() {
		 //establecemo conexion con la unidad de persistencia...
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//permite gestionar entidades..
		EntityManager eman=fabri.createEntityManager();
		//iniciar transaccion...
		eman.getTransaction().begin();
		List<TblDocumento> listado=eman.createQuery("select docu from TblDocumento docu",TblDocumento.class).getResultList();
		//retornamos el listado
		return listado;
	}  //fin del metodo listado documentos... 

	@Override
	public TblDocumento BuscarDocumento(TblDocumento tbldocum) {
		 //establecemo conexion con la unidad de persistencia...
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//permite gestionar entidades..
		EntityManager eman=fabri.createEntityManager();
		//iniciar transaccion...
		eman.getTransaction().begin();
		TblDocumento buscadoc=eman.find(TblDocumento.class,tbldocum.getIddocument());
         //retornamos el documento buscado por codigo  
		return buscadoc;
	}   //fin del metodo buscar documentos..

}

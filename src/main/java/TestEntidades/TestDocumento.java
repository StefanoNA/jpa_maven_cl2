package TestEntidades;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblDocumento;
import model.TblTipodocumento;

public class TestDocumento {

	public static void main(String[] args) {
		//establecemo conexion con la unidad de persistencia...
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//permite gestionar entidades..
		EntityManager eman=fabri.createEntityManager();
		//iniciar transaccion...
		eman.getTransaction().begin();
		//instanciar las respectivas entidades...
		TblTipodocumento tipodocu=new TblTipodocumento();
		TblDocumento docum=new TblDocumento();
		//******************registrar...
		//ingresamos nuevos valores..
	/*	tipodocu.setNomdocum("factura");
		tipodocu.setDescripdocum("comprobante de pago");
		eman.persist(tipodocu);
		docum.setNrodocument("66644443");
		docum.setProvedocument("pc leticia e.i.r.l");
		docum.setRucdocumen("45789687942");
		Date fecha=new Date();
		Date fechasql=new Date();
		docum.setFecha(fechasql);
		docum.setDescridocument("recolectar IGV para la sunat");
		docum.setTblTipodocumento(tipodocu);
		eman.persist(docum);
		//emitimos un mensaje por consola
		System.out.println("Dato registrado");
		//confirmamos
		eman.getTransaction().commit();
		//cerramos
		eman.close();*/
		//ejemplo de actualizar**********************actualizar..
		
		tipodocu.setIdtipodocum(3);
		tipodocu.setNomdocum("otros");
		tipodocu.setDescripdocum("para llevar solo control de ingreso");
		eman.merge(tipodocu);
		docum.setIddocument(3);
		docum.setNrodocument("555444");
		docum.setProvedocument("distribuidora de bebidas s.a.c.");
		docum.setRucdocumen("202457895");
		Date fecha=new Date();
		Date fechaact=new Date(fecha.getTime());
		docum.setFecha(fechaact);
		docum.setDescridocument("comprobante de control");
		docum.setTblTipodocumento(tipodocu);
		eman.merge(docum);
		//emitimos mensaje por pantalla
		System.out.println("dato actualizado");
		//confirmamos
		eman.getTransaction().commit();
		//cerramos 
		eman.close();
		
       
	}    //fin del metodo principal...

}    //fin del test documento...

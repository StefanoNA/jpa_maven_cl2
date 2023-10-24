package TestEntidades;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblCategoria;
import model.TblDocumento;
import model.TblProducto;

public class TestProducto {

	public static void main(String[] args) {
		//establecer conexion con la unidad de persistencia..
		EntityManagerFactory facto=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades...
		EntityManager eman=facto.createEntityManager();
		//procesos : registrar ,actualizar,listar,etc...
		//iniciamos transaccion...
		eman.getTransaction().begin();
		//instanciamos las respectivas entidades..
		TblCategoria tblcat=new TblCategoria();
		TblProducto tblprod=new TblProducto();
		
		//***************registrar....
		/*tblcat.setNomcateg("Otros");
		tblcat.setDescrip("producto de alto y bajo precio");
		
		//****ingresamos datos a la tabla producto...
		tblprod.setNomprod("cetirizina");
		tblprod.setPrecio(14);
		Date fech=new Date();
		Date fechasql=new Date(fech.getTime());
		tblprod.setFechavenc(fechasql);
		tblprod.setCodbarras("775896");
		tblprod.setNrolote("L33456");
		//asignamos el objeto tblcat
		tblprod.setTblCategoria(tblcat);
		eman.persist(tblprod);
		//emitimos mensaje por pantalla
		System.out.println("Dato Registrado");
		//confirmamos
		eman.getTransaction().commit();
		//cerramos
		eman.close();
		*/
		//******************actualizar
		/*tblcat.setIdcategoria(1);
		tblcat.setNomcateg("Generico");
		tblcat.setDescrip("Recomendando por el ministerio de Salud");
		tblprod.setIdproducto(1);
		tblprod.setNomprod("paracetamol");
		tblprod.setPrecio(8);
		Date fech=new Date();
		Date fechasql=new Date(fech.getTime());
		tblprod.setFechavenc(fechasql);
		tblprod.setCodbarras("77557");
		tblprod.setNrolote("L33333");
		tblprod.setTblCategoria(tblcat);
		eman.merge(tblprod);
		System.out.println("Dato Actualizado");
		//confirmamos
		eman.getTransaction().commit();
		//cerramos
		eman.close();*/
		//**********************listado
		
	/*	List<TblDocumento> listado=eman.createQuery("select docu from TblDocumento docu",TblDocumento.class).getResultList();
		
		//aplicamos un bucle for...
		for(TblDocumento lis:listado){
			//imprimimos por pantalla
			System.out.println("codigo "+lis.getIddocument()+" nro de documento "+lis.getNrodocument()
			+" nombre proveedor "+lis.getProvedocument()+" ruc de docum "+lis.getRucdocumen()+
			" fecha "+lis.getFecha()+" descrip document "+lis.getDescridocument()+" codigo tipo documento "+
			lis.getTblTipodocumento().getIdtipodocum()+" nombre documento "+lis.getTblTipodocumento().getNomdocum()
			+"descrip tipo documento "+lis.getTblTipodocumento().getDescripdocum());
			
		}   //fin del bucle for...
		*/
		//*******************buscar por codigo...
		
		TblDocumento buscarcodigo=eman.find(TblDocumento.class,2);
		//imprimimos mensaje por pantalla....
		System.out.println("codigo documento "+buscarcodigo.getIddocument()+
				" nro de documento "+buscarcodigo.getNrodocument()+" nombre proveedor "
				+buscarcodigo.getProvedocument()+" ruc de documento  "+buscarcodigo.getRucdocumen()+
				" fecha documento "+buscarcodigo.getFecha()+" descrip.. documento "
				+buscarcodigo.getDescridocument()+" codigo tipo documento "
				+buscarcodigo.getTblTipodocumento().getIdtipodocum()+" nombre tipo de documento "
				+buscarcodigo.getTblTipodocumento().getNomdocum()+" descripcion tipo de documento "
				+buscarcodigo.getTblTipodocumento().getDescripdocum());

	}   //fin del metodo main....

}   //fin de la clase testproducto...

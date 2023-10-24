package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblProductocl2;


public class TestProductocl2 {public static void main(String[] args) {
	//establecemos la conexion  con la unidad de persistencia....
	EntityManagerFactory conex=Persistence.createEntityManagerFactory("CL2_Maven");
	//gestionar  entidades como registrar,actualizar,eliminar,listar,buscar....
	EntityManager emanager=conex.createEntityManager();
	//iniciamos transaccion...(iniciar la operacion como el crud...)
	emanager.getTransaction().begin();

	//realizamos una instancia...
	TblProductocl2 auto=new TblProductocl2();	
	//aplicamos  un switch.....	
	String accion=JOptionPane.showInputDialog("Ingrese la Accion");
	switch(accion){
	
	case "Registrar":
		//ingresamos valores a enviar a la base de datos...
		auto.setNombrecl2("leche");
		auto.setPreciocompcl2((int) 2.50);
		auto.setPrecioventacl2((int) 3.70);
		auto.setEstadocl2("agotado");
		auto.setDescripcl2("espumosa");	
		//registramos los datos con persist...
		//persist... (insert into tbl_auto values(......)
		emanager.persist(auto);
		//emitimos un mensaje por consola
		System.out.println("Datos registrados en la BD");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos la transaccion..
		emanager.close();
		//salimos
		break;
	case "Actualizar":
		auto.setIdproductocl2(8);
		auto.setNombrecl2("azucar");
		auto.setPreciocompcl2(4);
		auto.setPrecioventacl2(5);
		auto.setEstadocl2("disponible");
		auto.setDescripcl2("deslactosada");
		//realizamos la actualizacion
		//update tbl_auto set color="marron",modelo="deportivos",..... where idauto=5;..........
		emanager.merge(auto);
		//emitimos un mensaje ...
		System.out.println("datos actualizado correcmente");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
	case "Eliminar":
		//codigo a eliminar...
		auto.setIdproductocl2(4);
		TblProductocl2 elim=emanager.merge(auto);
		//realizamo la eliminacion...
		//en jdbc delete from tbl_auto where idauto.....
		emanager.remove(elim);
	    //imprimimos el mensaje por pantalla...
		System.out.println("dato eliminado de la base de datos");
		//confirmamos 
		emanager.getTransaction().commit();
		//cerramos 
		emanager.close();
		//salir
		break;
	case "Buscar":
		//en jdbc : select * fromt tbl_auto where idauto=3;....
		TblProductocl2 busc=emanager.find(TblProductocl2.class,2	);	
		//aplicamos una condicion....
		if(busc==null){
			//emitimos un mensaje por pantalla
			System.out.println("Registro no encontrado");
		}else{
			System.out.println("Registro encontrado");
			//imprimimos por pantalla las caracteristicas del registro
			System.out.println("producto "+busc.getIdproductocl2()+" nombre "
			+busc.getNombrecl2()+" precio "+busc.getPreciocompcl2()+" fechaven "
					+busc.getPrecioventacl2()+" estado "+busc.getEstadocl2()+" descripcion "
			+busc.getDescripcl2());
		}
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		//salimos
		break;
		
	case "Listar":
		//en SQL select * from tbl_auto aut.....
		//TblAuto a =new TblAuto();
		//en JPQL select a from TblAuto a entonces la programacion en JPQL es
		//con las entidades
		
	List<TblProductocl2> listado=emanager.createQuery("select a from TblAuto a",TblProductocl2.class).getResultList();
	//mostramos los datos por consola...
	for(TblProductocl2 lis:listado){
		//imprimimos dentro del bucle...
		System.out.println("producto "+lis.getIdproductocl2()+" nombre "
				+lis.getNombrecl2()+" precio "+lis.getPreciocompcl2()+" fechaven "
						+lis.getPrecioventacl2()+" estado "+lis.getEstadocl2()+" descripcion "
				+lis.getDescripcl2());
	}   //fin del bucle for...
	 
     //confirmamos
	emanager.getTransaction().commit();
	//cerramos 
	emanager.close();
	//salimos
	break;
	//otra forma de eliminar en JPA...
	case "EliminarII":
		//eliminado el codigo numero "3"
		TblProductocl2 elimII=emanager.find(TblProductocl2.class,4);
		//aplicamos una condicion...
		if(elimII==null){
			//emitimos un mensaje...
			System.out.println("El codigo no existe en BD!!!!!!!!!!!!1");
			
		}else{
			//emitimos un mensaje por pantalla...
			System.out.println("Registro Encontrado");
			//eliminamos el registro...
			emanager.remove(elimII);
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();	
			//emitimos mensaje por consola..
			System.out.println("Codigo eliminado de la BD!!!!!!!!");
		}  //fin del else...
		
		//salimos
		break;
	
		
	default:
		//emitimos mensaje por pantalla
		System.out.println("Accion no encontrada");
		//salimos
		break;
	
	}   //fin del switch.....
	
	
}   //fin del metodo principal....

}   //fin de la clase....

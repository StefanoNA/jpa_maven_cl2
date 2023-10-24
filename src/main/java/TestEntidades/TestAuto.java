package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblAuto;

public class TestAuto {

	public static void main(String[] args) {
		//establecemos la conexion  con la unidad de persistencia....
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("CL2_Maven");
		//gestionar  entidades como registrar,actualizar,eliminar,listar,buscar....
		EntityManager emanager=conex.createEntityManager();
		//iniciamos transaccion...(iniciar la operacion como el crud...)
		emanager.getTransaction().begin();

		//realizamos una instancia...
		TblAuto auto=new TblAuto();	
		//aplicamos  un switch.....	
		String accion=JOptionPane.showInputDialog("Ingrese la Accion");
		switch(accion){
		
		case "Registrar":
			//ingresamos valores a enviar a la base de datos...
			auto.setColor("rojo");
			auto.setModelo("civic");
			auto.setMotor("1.2");
			auto.setPrecio(17000);
			auto.setMarca("honda");
			auto.setFabricacion("2022");		
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
			auto.setIdauto(4);
			auto.setColor("azul claro");
			auto.setModelo("f1");
			auto.setMotor("1.8");
			auto.setPrecio(30000);
			auto.setMarca("BMW");
			auto.setFabricacion("2023");
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
			auto.setIdauto(4);
			TblAuto elim=emanager.merge(auto);
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
			TblAuto busc=emanager.find(TblAuto.class,2	);	
			//aplicamos una condicion....
			if(busc==null){
				//emitimos un mensaje por pantalla
				System.out.println("Registro no encontrado");
			}else{
				System.out.println("Registro encontrado");
				//imprimimos por pantalla las caracteristicas del registro
				System.out.println("codigo "+busc.getIdauto()+" color "
				+busc.getColor()+" modelo "+busc.getModelo()+" motor "
						+busc.getMotor()+" precio "+busc.getPrecio()+" marca "
				+busc.getMarca()+" fabricacion  "+busc.getFabricacion());
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
			
		List<TblAuto> listado=emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
		//mostramos los datos por consola...
		for(TblAuto lis:listado){
			//imprimimos dentro del bucle...
			System.out.println("codigo "+lis.getIdauto()+" color "+
			lis.getColor()+" modelo "+lis.getModelo()+" motor "+lis.getMotor()+
			" precio "+lis.getPrecio()+" marca "+lis.getMarca()+" fabricacion "+lis.getFabricacion());
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
			TblAuto elimII=emanager.find(TblAuto.class,4);
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

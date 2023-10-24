package TestEntidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblCliente;

public class TestCliente {

	public static void main(String[] args) {
		//establecemos la conexion  con la unidad de persistencia....
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
				//gestionar  entidades como registrar,actualizar,eliminar,listar,buscar....
				EntityManager emanager=conex.createEntityManager();
				//iniciamos transaccion...(iniciar la operacion como el crud...)
				emanager.getTransaction().begin();
				//realizamos la respectiva instancia...
				TblCliente cliente=new TblCliente();
				//creamos una variable de tipo string de nombre accion
				String accion=JOptionPane.showInputDialog("Ingrese la accion");
				//aplicamos el switch....
				switch(accion){
				case "Registrar":
					cliente.setNombre("Patricia Evalin");
					cliente.setApellido("Macedo");
					cliente.setEmail("Patricia@hotmail.com");
					cliente.setDni("4578963");
					cliente.setSexo("F");
					//registramos en BD..
					emanager.persist(cliente);
					//emitimos mensaje
					System.out.println("Registrado en BD");
					//comfirmar
					emanager.getTransaction().commit();
					//cerramos
					emanager.close();		
					//salimos
					break;
				case "Actualizar":
					cliente.setIdcliente(1);
					cliente.setNombre("Marco Antonio");
					cliente.setApellido("Cardenas");
					cliente.setEmail("marca@gmail.com");
					cliente.setDni("10456789");
					cliente.setSexo("M");
					//actualizamos datos
					emanager.merge(cliente);
					//emitimos mensaje
					System.out.println("Datos actualizados");
					//confirmamos..
					emanager.getTransaction().commit();
					//cerramos
					emanager.close();
					//salimos
					break;
				case "Eliminar":
					//salimos 
					break;
				case "Buscar":
					//salimos
					break;
				case "Listar":
					//salimos
					break;
				case "EliminarII":
					//salimos
					break;
				default:
					//emitimos un mensaje por consola
					System.out.println("ACCION no encontrada");
					//salimos
					break;
				  }    //fin del switch....
				


	}    //fin del metodo principal...

}   //fin de la clase....

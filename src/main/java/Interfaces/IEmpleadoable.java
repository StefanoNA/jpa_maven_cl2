package Interfaces;

import java.util.List;

import model.TblEmpleado;

public interface IEmpleadoable {
	//creamos los respectivos metodos...
	public void RegistrarEmpleado(TblEmpleado tblemp);
	public void ActualizarEmpleado(TblEmpleado tblemp);
	public void EliminarEmpleado(TblEmpleado tblemp);
	public List<TblEmpleado> ListadoEmpleado();
	public TblEmpleado BuscarEmpleadoCodigo(TblEmpleado tblemp);
}    //fin de la interfaz iempleadoable....

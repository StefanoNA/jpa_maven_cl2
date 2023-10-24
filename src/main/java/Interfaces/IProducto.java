package Interfaces;

import java.util.List;

import model.TblProductocl2;

public interface IProducto {
	//declaramos metodos
	public void RegistrarProducto(TblProductocl2 tblProductocl2);
	public void ActualizarProducto(TblProductocl2 tblProductocl2);
	public void EliminarProducto(TblProductocl2 tblProductocl2);
	public List<TblProductocl2> Listadoproductocl2();
	public TblProductocl2 BuscarProducto();
	
} //fin de la declaracion

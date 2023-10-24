package Interfaces;

import java.util.List;

import model.TblDocumento;

public interface IDocumentoable {
	//declaramos sus metodos
	public void RegistrarDocumento(TblDocumento tbdocum);
	public void ActualizarDocumento(TblDocumento tbldocum);
	public void EliminarDocumento(TblDocumento tbldocum);
	public List<TblDocumento> ListadoDocumentos();
	public TblDocumento BuscarDocumento(TblDocumento tbldocum);
}  //fin de la interface...

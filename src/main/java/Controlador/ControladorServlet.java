package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassCrudProductoImp;
import model.TblProductocl2;

/**
 * Servlet implementation class ControladorServlet
 */
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/GestionarProducto").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String nombrecl2=request.getParameter("nombrecl2");
		double preciocompcl2=Double.parseDouble(request.getParameter("preciocompcl2"));
		double precioventacl2=Double.parseDouble(request.getParameter("precioventacl2"));
		String estadocl2=request.getParameter("estadocl2");
		String descripcl2=request.getParameter("descripcl2");
		//instaciamos las respectivas clases
		TblProductocl2 tblproducto=new TblProductocl2();
		ClassCrudProductoImp crud = new ClassCrudProductoImp();
		//asignamos los repectivos valores...
		tblproducto.setNombrecl2(nombrecl2);
		tblproducto.setPreciocompcl2((int) preciocompcl2);
		tblproducto.setPrecioventacl2((int) precioventacl2);
		tblproducto.setEstadocl2(estadocl2);
		tblproducto.setDescripcl2(descripcl2);
		//invocamos al metodo registrar
		crud.RegistrarProducto(tblproducto);
		//recuperamos el listado de autos...
		List<TblProductocl2> listadoproducto=crud.Listadoproductocl2();
		//enviamos a la vista
		request.setAttribute("listado", listadoproducto);
		//redireccionamos
		request.getRequestDispatcher("/GestionProducto.jsp").forward(request, response);
		
	}

}

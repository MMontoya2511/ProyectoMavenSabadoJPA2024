package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassClienteImp;
import model.TblCliente;

/**
 * Servlet implementation class ControladorCliente
 */
public class ControladorCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCliente() {
        super();
        // TODO Auto-generated constructor stub
    } //fin del controlador

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		TblCliente cliente=new TblCliente();
		ClassClienteImp crud=new ClassClienteImp();
		List<TblCliente> listadocliente=crud.ListadoCliente();
		
		//invocamos al listado del producto para la vista
		request.setAttribute("listadoclientes", listadocliente);
		
		//redireccionamos
		request.getRequestDispatcher("/ListadoClientes.jsp").forward(request, response);
	
	} //fin del metodo doget

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//recuperamos los valores del formulario...
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String dni=request.getParameter("dni");
		String email=request.getParameter("email");
		String telef=request.getParameter("telefono");
		String sexo=request.getParameter("sexo");
		String nacionalidad=request.getParameter("nacionalidad");
		
		//instanciando las respectivas entidades
		TblCliente cliente=new TblCliente();
		ClassClienteImp crud=new ClassClienteImp();
		
		//asignando valores
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setDni(dni);
		cliente.setEmail(email);
		cliente.setTelf(telef);
		cliente.setSexo(sexo);
		cliente.setNacionalidad(nacionalidad);
		
		//invocamos a registrar
		crud.RegistrarCliente(cliente);
		
		//actualizar listado de clientes
		List<TblCliente> listadocliente=crud.ListadoCliente();
		
		//invocamos al listado del producto para la vista
		request.setAttribute("listadoclientes", listadocliente);
		
		//redireccionamos
		request.getRequestDispatcher("/ListadoClientes.jsp").forward(request,response);
	
	} //fin del metodo do post

} //fin de la clase

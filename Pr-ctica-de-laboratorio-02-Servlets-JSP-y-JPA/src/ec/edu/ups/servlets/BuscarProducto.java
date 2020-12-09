package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;


/**
 * Servlet implementation class BuscarProducto
 */
@WebServlet("/BuscarProducto")
public class BuscarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String nomPro = request.getParameter("nomPro");
		int idEmpresa = Integer.parseInt(request.getParameter("idEmp"));
		Empresa empresa = DAOFactory.getFactory().getEmpresasDAO().read(idEmpresa);
		
		System.out.println("Este es el nombre: "+nomPro+" esta es la empresa: "+idEmpresa);
		System.out.println("Esta es la empresa "+empresa.getNombre());
		
		
		List<Producto> pro = DAOFactory.getFactory().getEmpresasDAO().productosEmpresa(nomPro, idEmpresa);
		
		String url = "/private/user/jsp/mostrarProductos.jsp";
		request.setAttribute("productos", pro);
		request.setAttribute("empresaBusca", empresa);
		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("Busqueda de producto pasado");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

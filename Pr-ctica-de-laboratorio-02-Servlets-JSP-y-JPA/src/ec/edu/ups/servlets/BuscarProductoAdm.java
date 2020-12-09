package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;


/**
 * Servlet implementation class BuscarProductoAdm
 */
@WebServlet("/BuscarProductoAdm")
public class BuscarProductoAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProductoAdm() {
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
		Empresa empesa = DAOFactory.getFactory().getEmpresaDAO().read(idEmpresa);
		String pagina = request.getParameter("pagina");
		ArrayList<Producto> pro = DAOFactory.getFactory().getEmpresaDAO().productosEmpresaTodos(nomPro, idEmpresa);
		
		String url = "/private/admin/jsp/mostrarProductosAdmin.jsp";
		request.setAttribute("productosAdmin", pro);
		request.setAttribute("empresaBusca", empesa);
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

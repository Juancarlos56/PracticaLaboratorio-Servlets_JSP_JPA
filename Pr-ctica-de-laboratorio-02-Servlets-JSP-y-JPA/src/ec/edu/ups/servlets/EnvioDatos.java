package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Usuario;


/**
 * Servlet implementation class EnvioDatos
 */
@WebServlet("/EnvioDatos")
public class EnvioDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvioDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		int idEmpresa = Integer.parseInt(request.getParameter("idEmp"));
		String pagina = request.getParameter("pagina");
		
		System.out.println("Este es el idUsu: "+idUsuario+" esta es la empresa: "+idEmpresa);
		Usuario usuario = DAOFactory.getFactory().getUsuariosDAO().read(idUsuario);
		System.out.println("Usuario: "+usuario.getNombre()+" de la empresa: "+usuario.getEmpresa().getNombre());
		
		//Empresa empresa = DAOFactory.getFactory().getEmpresasDAO().read(idEmpresa);
		//System.out.println("Empresa buscada: "+empresa.getNombre());
		
		
		String url = "/private/user/jsp/"+pagina;
		System.out.println("Pagina: "+url);
		
		request.setAttribute("usuario", usuario);
		//request.setAttribute("empresa", usuario.getEmpresa());
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

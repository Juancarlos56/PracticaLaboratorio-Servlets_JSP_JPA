package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidades.Administrador;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Usuario;


/**
 * Servlet implementation class InicioSesion
 */
@WebServlet("/InicioSesion")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = null;
		Empresa emp = null;
		HttpSession session = request.getSession(true);
	
		String us =   request.getParameter("correo");
		String pw =   request.getParameter("contrasena");
		
		Usuario usuario = DAOFactory.getFactory().getUsuariosDAO().control_logeo(pw, us);
		Administrador adm = DAOFactory.getFactory().getAdministradoresDAO().control_logeo_ad(pw, us);
		System.out.println("SERVLET INICIO DE SESION");
		
		if ((usuario == null) && (adm == null)) {
			response.sendRedirect("publico/index.html");
		}
		
		else {
			if (adm != null) {
				request.getSession().setAttribute("admin", "admin");
				//emp = DAOFactory.getFactory().getEmpresaDAO().empresa_de_un_admin(adm);
				//request.setAttribute("emp", emp);
				request.setAttribute("admin", adm);
				request.getRequestDispatcher("private/admin/jsp/sesionAdmin.jsp").forward(request, response);
				
			}
			if (usuario != null) {
				
				//out.println("<h1>Usuario: "+usuario.getNombre()+" Empresa: "+usuario.getEmpresa().getNombre()+"</h1>");
				request.getSession().setAttribute("usuario", "usuario");
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("private/user/jsp/sesionUsuario.jsp").forward(request, response);
			
			}
			
			
		}
	}

}

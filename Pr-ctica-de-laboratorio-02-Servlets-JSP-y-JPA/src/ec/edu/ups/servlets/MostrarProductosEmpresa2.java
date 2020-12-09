package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductosDAO;
import ec.edu.ups.entidades.Producto;


/**
 * Servlet implementation class MostrarProductosEmpresa2
 */
@WebServlet("/MostrarProductosEmpresa2")
public class MostrarProductosEmpresa2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductosDAO po;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductosEmpresa2() {
    	//po = DAOFactory.getFactory().getProductosDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("ESTOY EN EL SERVLET DE MostrarProductosEmpresa con JPA");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//List<Producto> productos = null;
		int emp =  Integer.parseInt(request.getParameter("idEmp"));
		System.out.println("hasta aqui llegamos>>>>>>>>>>>>");
		
		out.print("<h1>holaaaaaaaaaaaa</h1>>");
		
		getServletContext().getRequestDispatcher("/publico/login.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

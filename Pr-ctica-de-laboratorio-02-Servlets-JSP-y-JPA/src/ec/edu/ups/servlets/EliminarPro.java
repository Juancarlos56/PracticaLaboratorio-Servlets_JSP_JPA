package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidades.Producto;


/**
 * Servlet implementation class EliminarPro
 */
@WebServlet("/EliminarPro")
public class EliminarPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Producto producto=null;
		
		int codPro =  Integer.parseInt(request.getParameter("codPro"));
		
		producto = DAOFactory.getFactory().getProductosDao().read(codPro);
		producto.setEstado("Inactivo");
		DAOFactory.getFactory().getProductosDao().update(producto);
		
		out.println("<h3>El producto paso a inactivo, click en listar para ver el cambio</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package ec.edu.ups.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;


/**
 * Servlet implementation class NuevoPedido
 */
@WebServlet("/NuevoPedido")
public class NuevoPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Producto prod = null;
		Usuario us = null;
		
		int usu =  Integer.parseInt(request.getParameter("idUsuario"));
		int pro =  Integer.parseInt(request.getParameter("codPro"));
		int ca =  Integer.parseInt(request.getParameter("cantidad"));
		double tt =  Double.parseDouble(request.getParameter("total"));
		
		
		
		us = DAOFactory.getFactory().getUsuariosDAO().read(usu);
		prod = DAOFactory.getFactory().getProductosDao().read(pro);
		
		Pedido pedido = new Pedido(0, "Pendiente", ca, tt, us, prod);
		
		DAOFactory.getFactory().getPedidosDAO().create(pedido);
		out.println("<h3>El pedido ha sido creado</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

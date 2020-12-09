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

/**
 * Servlet implementation class aceptarPed
 */
@WebServlet("/aceptarPed")
public class aceptarPed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aceptarPed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estoy en el servlet aceptar pedido");
		PrintWriter out = response.getWriter();
		int idPedido = Integer.parseInt(request.getParameter("idPedido"));
		String estado = request.getParameter("estado");
		
		
		Pedido pedido = DAOFactory.getFactory().getPedidoDAO().read(idPedido);
		if (pedido.getEstado().equals("Pendiente") == false) {
			out.println("<h3>El pedido ya ha sido procesado</h3>");
		}else {
			
			pedido.setEstado(estado);
			DAOFactory.getFactory().getPedidoDAO().update(pedido);
			out.println("<h3>Se aprobo el pedido: "+pedido.getProducto().getNombre()+" click en listar para ver los cambios</h3>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

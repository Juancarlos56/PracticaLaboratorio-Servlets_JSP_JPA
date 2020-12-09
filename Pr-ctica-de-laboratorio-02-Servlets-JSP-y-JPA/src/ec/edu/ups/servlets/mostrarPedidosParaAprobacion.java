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
import ec.edu.ups.entidades.Pedido;

/**
 * Servlet implementation class mostrarPedidosParaAprobacion
 */
@WebServlet("/mostrarPedidosParaAprobacion")
public class mostrarPedidosParaAprobacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrarPedidosParaAprobacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("ESTOY EN EL SERVLET DE Mostrar todos los pedidos de la empresa");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int adm =  Integer.parseInt(request.getParameter("idAdmin"));
		int emp =  Integer.parseInt(request.getParameter("idEmp"));

		
		//aqui debe ser find by empresa 
		ArrayList<Pedido> pedidos = DAOFactory.getFactory().getPedidoDAO().findByAdminPedidosCodigoPendientes(emp);
		
		for (Pedido pedido : pedidos) {
			pedido.setUsuario(DAOFactory.getFactory().getUsuariosDAO().read(pedido.getCodUsu()));
		}
		
		for (Pedido pedido : pedidos) {
			pedido.setProducto(DAOFactory.getFactory().getProductosDao().read(pedido.getCodPro()));
		}
		
		System.out.println(pedidos.size());
		String tablaDatos="";
		String tablaIndex = "<table class='tg' id='tablaBuscar' style='width:95%'>"+
				"<tr>"+
					"<th class='tg-46ru'>Nombre del Producto</th>"+
					"<th class='tg-46ru'>Nombre del Usuario</th>"+
					"<th class='tg-46ru'>Cantidad Pedida</th>"+
					"<th class='tg-46ru'>Precio por Unidad</th>"+
					"<th class='tg-46ru'>Estado del Pedido</th>"+
					"<th class='tg-46ru'>Total</th>"+
				"</tr>";
		if(pedidos !=null){
			
			for (int i=0;i<pedidos.size();i++){
				Pedido ped=pedidos.get(i);
				
				tablaDatos = tablaDatos + "<tr>"+
						"<td>"+ped.getProducto().getNombre()+"</td>"+
						"<td>"+ped.getUsuario().getNombre()+"</td>"+
						"<td>"+ped.getCantidad()+"</td>"+
						"<td>"+ped.getProducto().getPrecio()+"</td>"+
						"<td>"+ped.getEstado()+"</td>"+
						"<td>"+ped.getTotal()+"</td>"+
						"<td><input type='button' id='pedidoA' name='pedidoSeleccionado' value='Aprobar' onclick=\"mostrarPedido("+ped.getCodigo_pedido()+", \'Aprobado\')\"></td>"+
						"<td><input type='button' id='pedidoSeleccionado' name='pedidoSeleccionado' value='Rechazar' onclick=\"mostrarPedido("+ped.getCodigo_pedido()+", \'Rechazado\')\"></td>"+
						"</tr>";	
			}
			
			tablaDatos = tablaDatos + "</table> ";
				
		}

		tablaIndex = tablaIndex + tablaDatos;
		out.println(tablaIndex);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

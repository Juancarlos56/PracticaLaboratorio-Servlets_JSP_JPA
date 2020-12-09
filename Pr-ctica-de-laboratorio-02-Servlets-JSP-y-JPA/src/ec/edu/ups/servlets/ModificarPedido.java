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
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Usuario;


/**
 * Servlet implementation class ModificarPedido
 */
@WebServlet("/ModificarPedido")
public class ModificarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				
				System.out.print("ESTOY EN EL SERVLET DE MODIFICAR PEDIDO ");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				Empresa empresa = null;
				Usuario usuario = null;

				int usu =  Integer.parseInt(request.getParameter("idUsuario"));
				int emp =  Integer.parseInt(request.getParameter("idEmp"));

				
				List<Pedido> pedidos = DAOFactory.getFactory().getPedidosDAO().findByUsuarioPedidosCodigo(usu);
			
				
				String tablaDatos="";
				String tablaIndex = "<table class='tg' id='tablaBuscar' style='width:95%'>"+
						"<tr>"+
							"<th class='tg-46ru'>Nombre del Producto</th>"+
							"<th class='tg-46ru'>Cantidad Pedida</th>"+
							"<th class='tg-46ru'>Precio por Unidad</th>"+
							"<th class='tg-46ru'>Estado del Pedido</th>"+
							"<th class='tg-46ru'>Total</th>"+
						"</tr>";
				if(pedidos !=null){
					
					for (int i=0;i<pedidos.size();i++){
						Pedido ped=pedidos.get(i);
						
						tablaDatos = tablaDatos + "<tr>"+
								"<td>"+ped.getPed_Product().getNombre()+"</td>"+
								"<td>"+ped.getCantidad()+"</td>"+
								"<td>"+ped.getPed_Product().getPrecio()+"</td>"+
								"<td>"+ped.getEstado()+"</td>"+
								"<td>"+ped.getTotal()+"</td>"+
								"<td><input type='button' id='pedidoSe' name='pedidoSe' value='Seleccionar' onclick='mostrarPedido("+ped.getCodigo_pedido()+",\""+ped.getPed_Product().getNombre()+"\",\""+ped.getEstado()+"\","+ped.getCantidad()+","+ped.getPed_Product().getIva()+","+ped.getPed_Product().getPrecio()+","+ped.getTotal()+")'></td>"+
								"</tr>";	
					}
					
					tablaDatos = tablaDatos + "</table> ";
						
				}

				tablaIndex = tablaIndex + tablaDatos;
				out.println(tablaIndex);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
 * Servlet implementation class MostrarProductosEmpresa
 */
@WebServlet("/MostrarProductosEmpresa")
public class MostrarProductosEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductosEmpresa() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("ESTOY EN EL SERVLET DE MostrarProductosEmpresa con JPA");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int emp =  Integer.parseInt(request.getParameter("idEmp"));;
		
		List<Producto> producto = DAOFactory.getFactory().getProductosDao().findProductosPorEmpresa(emp);
		
		System.out.println(producto.toString());
		
		String tablaDatos="";
		String tablaIndex = "<table class='tg' id='tablaBuscar' style='width:95%'>"+
				"<tr>"+
					"<th class='tg-46ru'>Nombre del Producto</th>"+
					"<th class='tg-46ru'>Precio</th>"+
					"<th class='tg-46ru'>Estado Producto</th>"+
					"<th class='tg-46ru'>Url imagen</th>"+
					"<th class='tg-46ru'>Descripcion</th>"+
					"<th class='tg-46ru'>Iva</th>"+
				"</tr>";
		if(producto !=null){
			
			for (int i=0;i<producto.size();i++){
				
				Producto pro=producto.get(i);
				
				tablaDatos = tablaDatos + "<tr>"+
						"<td>"+pro.getNombre()+"</td>"+
						"<td>"+pro.getPrecio()+"</td>"+
						"<td>"+pro.getEstado() +"</td>"+
						"<td> <img src=\""+pro.getUrl_imagen()+"\" width=\"200px\" height=\"200px\"></td>"+
						"<td>"+pro.getDescripcion()+"</td>"+
						"<td>"+pro.getIva()+"</td>"+
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

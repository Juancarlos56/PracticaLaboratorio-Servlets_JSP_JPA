package ec.edu.ups.jpa;


import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidosDAO;
import ec.edu.ups.dao.ProductosDAO;
import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;

public class JPAPedidosDAO extends JPAGenericDAO<Pedido, Integer> implements PedidosDAO{
	//private UsuariosDAO usuarioDAO;
	//private ProductosDAO productoDAO;
	
	
	public JPAPedidosDAO() {
		super(Pedido.class);
	//	usuarioDAO=DAOFactory.getFactory().getUsuariosDAO();
	//	productoDAO=DAOFactory.getFactory().getProductosDao();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findByUsuarioPedidosCodigo(Integer codigo_usu) {
		
		Usuario usu = DAOFactory.getFactory().getUsuariosDAO().read(codigo_usu);
		System.out.println("Estamos trabajando con los pedidos del usuario: "+usu.getNombre());
		String consulta = "SELECT  pe FROM Pedido pe WHERE pe.estado like 'Pendiente' AND pe.usu_pedido = :usuario ";
		try {
			
			em.clear();
			List<Pedido> pedidos = (List<Pedido>)em.createQuery(consulta).setParameter("usuario",usu).getResultList();		
			
			System.out.println("Pedido: "+pedidos.size());
			return pedidos;
		} catch (Exception e) {
			System.out.println(">>>WARNING (productosEmpresa EmpresaDAO): Esta mal " + e.getMessage());
			return null;
		}
				
	}
	
	
	
	
}

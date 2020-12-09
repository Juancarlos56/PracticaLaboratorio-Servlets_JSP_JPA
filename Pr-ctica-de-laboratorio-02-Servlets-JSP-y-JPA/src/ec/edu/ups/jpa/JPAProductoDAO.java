package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.CategoriasDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductosDAO;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;

public class JPAProductoDAO extends JPAGenericDAO<Producto, Integer> implements ProductosDAO{
	private CategoriasDAO categoriaDAO;
	private String consulta;
	public JPAProductoDAO() {
		super(Producto.class);
		categoriaDAO = DAOFactory.getFactory().getCategoriasDAO();
	}
	
	
	@Override
	public Producto findByPedidoProductoNombre(String nombre) {
		
		
				
		Producto p =  null;
		consulta ="Select * From Producto p Where p.nombre like :nombre";
		try {
			p = (Producto)em.createQuery(consulta).setParameter("nombre", "%"+nombre+"%").getSingleResult();
			System.out.println(p.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Revisar findByPedidoProductoNombre ERROR: ");
		}
		
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findProductosPorEmpresa(Integer cod_emp) {
		
		List<Producto> productos = new ArrayList<Producto>();
		//Consulta a la base de datos, retorna la empresa con el codigo de la empresa seleccionada
		Empresa emp = DAOFactory.getFactory().getEmpresasDAO().read(cod_emp);
		
		for (Producto producto : emp.getProductos()) {
			productos.add(producto);
		}
		
		return productos;
	}
}

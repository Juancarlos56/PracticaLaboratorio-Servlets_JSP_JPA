package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.CategoriasDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresasDAO;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;

public class JPACategoriasDAO extends JPAGenericDAO<Categoria, Integer> implements CategoriasDAO{
	
	
	public JPACategoriasDAO() {
		super(Categoria.class);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findCategoriasEmpresa(int codigoEmpresa) {
		
		
		List<Categoria> cats = new ArrayList<Categoria>();
		Empresa emp = DAOFactory.getFactory().getEmpresasDAO().read(codigoEmpresa);
		
		
		String consulta = "SELECT  c FROM Categoria c, Producto p WHERE p.pro_empresa = :empresa AND c.pro_categoria = p.pro_categoria  GROUP BY c.codigo_categoria ";
		try {
			em.clear();
			cats = (List<Categoria>)em.createQuery(consulta).setParameter("empresa", emp).getResultList();		
			em.refresh(cats);
			System.out.println("PRODUCTOS: "+cats.size());
		} catch (Exception e) {
			System.out.println(">>>WARNING (productosEmpresa EmpresaDAO): " + e.getMessage());
		}
		
		
		return cats;
	}
	
	
}

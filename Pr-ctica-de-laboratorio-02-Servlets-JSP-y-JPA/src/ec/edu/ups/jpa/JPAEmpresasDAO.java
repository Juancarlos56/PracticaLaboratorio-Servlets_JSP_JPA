package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresasDAO;
import ec.edu.ups.entidades.Administrador;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;

public class JPAEmpresasDAO extends JPAGenericDAO<Empresa, Integer> implements EmpresasDAO{
	private String consulta;
	public JPAEmpresasDAO() {
		super(Empresa.class);
	}
	@Override
	public Empresa empresa_de_un__usuario(Usuario usuario) {
		Empresa emp = null;
		Usuario us = null;
		
		consulta = "Select u From Usuario u Where u.codigo_usu= :codUsuario";
		String consulta2 = "Select e From Empresa e Where e.cod_emp = :cod_empresaUsu";
		try {
			us = (Usuario)em.createQuery(consulta).setParameter("codUsuario", usuario.getCod_usu()).getSingleResult();
			emp = (Empresa)em.createQuery(consulta2).setParameter("cod_empresaUsu", us.getEmpresa().getCod_emp()).getSingleResult();
			
		} catch (Exception e) {
			System.out.println(">>>WARNING (empresa_de_un__usuario EmpresaDAO): " + e.getMessage());
		}
		return emp;
	}
	
	
	@Override
	public Empresa findByNombreEmpresa(String nombre) {
		Empresa emp = null;
		
		consulta = "SELECT * FROM Empresa WHERE nombre LIKE\" + nombre + \"%\"";
		
		try {
			emp = (Empresa)em.createQuery(consulta).setParameter("nombre", nombre).getSingleResult();
		} catch (Exception e) {
			System.out.println(">>>WARNING (EmpresaDAO:findByNombreEmpresa):" + e.getMessage());
		}
		
		return emp;
	}
	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> productosEmpresa(String nombreProducto, int idEmpresa) {
		List<Producto> prod = new ArrayList<Producto>();
		Empresa emp = DAOFactory.getFactory().getEmpresasDAO().read(idEmpresa);
		
		System.out.println("Nombre producto: "+nombreProducto+" id Empresa: "+idEmpresa);
		
		consulta = "SELECT  p FROM Producto p WHERE p.nombre LIKE :nombreProducto AND p.estado LIKE 'ACTIVO' AND p.pro_empresa = :empresa ";
		try {
			em.clear();
			prod = (List<Producto>)em.createQuery(consulta).setParameter("nombreProducto", "%"+nombreProducto+"%").setParameter("empresa", emp).getResultList();		
			em.refresh(prod);
			System.out.println("PRODUCTOS: "+prod.size());
		} catch (Exception e) {
			System.out.println(">>>WARNING (productosEmpresa EmpresaDAO): " + e.getMessage());
		}
		
		return prod;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Producto> productosEmpresaTodos(String nombreProducto, int idEmpresa) {
		ArrayList<Producto> prod = new ArrayList<Producto>();
		
		System.out.println("Nombre producto: "+nombreProducto+" id Empresa: "+idEmpresa);
		
		consulta = "SELECT  p.cod_pro, p.nombre, p.precio, p.porcentajeIva, p.url_imagen, p.descripcion, p.estado \r\n"
				+ "            FROM Producto p, Categoria c, Empresa e \r\n"
				+ "            WHERE p.nombre LIKE '%nombreProducto%' AND c.cod_cat = p.cod_categoria AND c.cod_empresa = idEmpresaCat AND e.cod_emp = idEmpresa\r\n"
				+ ";";
		try {
			prod = (ArrayList<Producto>)em.createQuery(consulta).setParameter("nombreProducto", nombreProducto).setParameter("idEmpresaCat", idEmpresa ).setParameter("idEmpresa", idEmpresa).getResultList();		
		} catch (Exception e) {
			System.out.println(">>>WARNING (productosEmpresa EmpresaDAO): " + e.getMessage());
		}
		
		return prod;

	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Producto> todosLosProductosEmpresa(int idEmpresa) {
			
		ArrayList<Producto> prod = new ArrayList<Producto>();
			
			
		Producto p = null;
		
		System.out.println("id Empresa: "+idEmpresa);
		
		consulta = "SELECT  p.cod_pro, p.nombre, p.precio, p.porcentajeIva, p.url_imagen, p.descripcion, p.estado,p.cod_categoria \r\n"
				+ "            FROM Producto p, Categoria c, Empresa e \r\n"
				+ "            WHERE (e.cod_emp = idEmpresa) AND (c.cod_empresa = idEmpresaCat)";
		try {
			prod = (ArrayList<Producto>)em.createQuery(consulta).setParameter("idEmpresa", idEmpresa).setParameter("idEmpresaCat", idEmpresa ).getResultList();		
		} catch (Exception e) {
			System.out.println(">>>WARNING (todosLosProductosEmpresa EmpresaDAO): " + e.getMessage());
		}
		
		return prod;
	}


	@Override
	public Empresa empresa_de_un_admin(Administrador adm) {
		Empresa emp = null;
		Administrador admin = null;
		consulta = "Select * From Administrador Where cod_amd=codAdmin";
		String consulta2 = "Select * From Empresa Where cod_emp = cod_empresaUsu";
		try {
			adm = (Administrador)em.createQuery(consulta).setParameter("codUsuario", admin.getAdm_id()).getSingleResult();
			//emp = (Empresa)em.createQuery(consulta2).setParameter("cod_empresaUsu", admin.getEmpresa().getCod_emp()).getSingleResult();
			
		} catch (Exception e) {
			System.out.println(">>>WARNING (empresa_de_un_admin EmpresaDAO): " + e.getMessage());
		}
		return emp;
		
	}
}

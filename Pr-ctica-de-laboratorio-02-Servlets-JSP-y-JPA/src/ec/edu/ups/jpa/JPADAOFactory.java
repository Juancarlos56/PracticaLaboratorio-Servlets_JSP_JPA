package ec.edu.ups.jpa;

import ec.edu.ups.dao.AdministradoresDAO;
import ec.edu.ups.dao.CategoriasDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresasDAO;
import ec.edu.ups.dao.PedidosDAO;
import ec.edu.ups.dao.ProductosDAO;
import ec.edu.ups.dao.UsuariosDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public ProductosDAO getProductosDao() {
		// TODO Auto-generated method stub
		return new JPAProductoDAO();
	}

	@Override
	public UsuariosDAO getUsuariosDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuariosDAO();
	}

	@Override
	public CategoriasDAO getCategoriasDAO() {
		// TODO Auto-generated method stub
		return new JPACategoriasDAO();
	}

	@Override
	public AdministradoresDAO getAdministradoresDAO(){
		// TODO Auto-generated method stub
		return new JPAAdministradoresDAO();
	}

	@Override
	public EmpresasDAO getEmpresasDAO() {
		// TODO Auto-generated method stub
		return new JPAEmpresasDAO();
	}

	@Override
	public PedidosDAO getPedidosDAO() {
		// TODO Auto-generated method stub
		return new JPAPedidosDAO();
	}



	

}

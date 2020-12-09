package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPADAOFactory;

public abstract class DAOFactory {
	
	protected static DAOFactory factory = new JPADAOFactory();

	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract ProductosDAO getProductosDao();
	
	public abstract UsuariosDAO getUsuariosDAO();
	
	public abstract CategoriasDAO getCategoriasDAO();
	
	public abstract AdministradoresDAO getAdministradoresDAO();
	
	public abstract EmpresasDAO getEmpresasDAO();
	
	public abstract PedidosDAO getPedidosDAO();
	
}

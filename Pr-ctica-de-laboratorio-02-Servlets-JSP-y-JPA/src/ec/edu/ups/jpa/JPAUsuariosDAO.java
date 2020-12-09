package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresasDAO;
import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.entidades.Usuario;

public class JPAUsuariosDAO extends JPAGenericDAO<Usuario, Integer> implements UsuariosDAO{

	public JPAUsuariosDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario control_logeo(String pw, String us) {
		Usuario u = null;
		String consulta = "Select u From Usuario u Where u.correo like :correo AND u.password like :password";
		try {
			em.clear();
			u = (Usuario)em.createQuery(consulta).setParameter("correo", us).setParameter("password",pw).getSingleResult();
			em.refresh(u);
			System.out.println("Usuario que estamos buscando: "+u.getNombre());
			return u;
		} catch (Exception e) {
			return null;
		}
		
	}
}

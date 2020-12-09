package ec.edu.ups.jpa;

import ec.edu.ups.dao.AdministradoresDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresasDAO;
import ec.edu.ups.entidades.Administrador;
import ec.edu.ups.entidades.Usuario;

public class JPAAdministradoresDAO extends JPAGenericDAO<Administrador, Integer> implements AdministradoresDAO{
	
	public JPAAdministradoresDAO() {
		super(Administrador.class);
	}
	
	
	@Override
	public Administrador control_logeo_ad(String pw, String us) {
		Administrador a = null;
		String consulta = "Select a From Administrador a Where a.correo like :correo AND a.password like :password";
		try {
			em.clear();
			a = (Administrador)em.createQuery(consulta, Administrador.class).setParameter("correo", us).setParameter("password",pw).getSingleResult();
			em.refresh(a);
			System.out.println("Admin: "+a.getNombre());
			return a;
			
		} catch (Exception e) {
			return null;
		}
	}
}

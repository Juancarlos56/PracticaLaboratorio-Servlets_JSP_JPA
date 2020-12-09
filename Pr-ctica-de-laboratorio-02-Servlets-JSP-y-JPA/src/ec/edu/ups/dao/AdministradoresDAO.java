package ec.edu.ups.dao;

import ec.edu.ups.entidades.Administrador;

public interface AdministradoresDAO extends GenericDAO<Administrador, Integer>{

	public abstract Administrador control_logeo_ad(String pw, String us);

}

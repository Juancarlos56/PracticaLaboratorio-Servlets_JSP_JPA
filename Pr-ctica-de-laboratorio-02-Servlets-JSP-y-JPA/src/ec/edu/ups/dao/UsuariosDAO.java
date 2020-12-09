package ec.edu.ups.dao;

import ec.edu.ups.entidades.Usuario;

public interface UsuariosDAO extends GenericDAO<Usuario, Integer>{

	public abstract Usuario control_logeo(String pw, String us);

}

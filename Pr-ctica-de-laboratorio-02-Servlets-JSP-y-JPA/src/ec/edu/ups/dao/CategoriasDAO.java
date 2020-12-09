package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Categoria;

public interface CategoriasDAO extends GenericDAO<Categoria, Integer>{

	public abstract List<Categoria> findCategoriasEmpresa(int codigoEmpresa);
}

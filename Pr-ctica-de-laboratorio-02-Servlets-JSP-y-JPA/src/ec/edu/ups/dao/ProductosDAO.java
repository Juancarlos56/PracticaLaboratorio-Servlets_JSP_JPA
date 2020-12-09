package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Producto;

public interface ProductosDAO extends GenericDAO<Producto, Integer>{
	public abstract Producto findByPedidoProductoNombre(String nombre);
	public abstract List<Producto> findProductosPorEmpresa(Integer idEmp);
}

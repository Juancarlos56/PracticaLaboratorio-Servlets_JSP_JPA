package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Pedido;

public interface PedidosDAO extends GenericDAO<Pedido, Integer>{

	public abstract List<Pedido> findByUsuarioPedidosCodigo(Integer codigo_usu);

}

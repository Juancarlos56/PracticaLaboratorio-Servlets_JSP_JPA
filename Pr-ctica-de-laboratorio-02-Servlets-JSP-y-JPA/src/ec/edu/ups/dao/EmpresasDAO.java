package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Administrador;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;

public interface EmpresasDAO extends GenericDAO<Empresa, Integer>{
	public abstract Empresa empresa_de_un__usuario(Usuario usuario);

    public abstract Empresa findByNombreEmpresa(String nombre);


    public abstract List<Producto> productosEmpresa(String nombreProducto, int idEmpresa);

    public abstract List<Producto> productosEmpresaTodos(String nombreProducto, int idEmpresa);

    public abstract List<Producto> todosLosProductosEmpresa(int idEmpresa);

    public abstract Empresa empresa_de_un_admin(Administrador adm);

}

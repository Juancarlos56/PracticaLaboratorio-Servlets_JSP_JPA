package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Empresa
 *
 */
@Entity
@Table(name="Empresa")
public class Empresa implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
    private int cod_emp;
	
	@Column(name="emp_nombre", length=255, nullable=false, unique=true)
	private String nombre;
	@Column(name="emp_horario", length=255, nullable=false, unique=false)
	private String horario;
	@Column(name="emp_descripcion", length=255, nullable=false, unique=false)
    private String descripcion;
	@Column(name="emp_url", length=255, nullable=false, unique=false)
    private String logo_url;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usu_empresa")
    private List<Usuario> usuarios=new ArrayList<Usuario>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adm_empresa")
    private List<Administrador> administradores=new ArrayList<Administrador>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pro_empresa")
    private List<Producto> productos=new ArrayList<Producto>();
    
    
	

	public Empresa(int cod_emp, String nombre, String horario, String descripcion, String logo_url) {
		super();
		this.cod_emp = cod_emp;
		this.nombre = nombre;
		this.horario = horario;
		this.descripcion = descripcion;
		this.logo_url = logo_url;
	}


	public Empresa() {
		super();
	}


	public int getCod_emp() {
		return cod_emp;
	}


	public void setCod_emp(int cod_emp) {
		this.cod_emp = cod_emp;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getLogo_url() {
		return logo_url;
	}


	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void addUsuarios(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public List<Administrador> getAdministradores() {
		return administradores;
	}


	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public void addAdministradores(Administrador administrador) {
		this.administradores.add(administrador);
	}
	
	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProductos(Producto producto) {
		this.productos.add(producto);
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((administradores == null) ? 0 : administradores.hashCode());
		result = prime * result + cod_emp;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + ((logo_url == null) ? 0 : logo_url.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (administradores == null) {
			if (other.administradores != null)
				return false;
		} else if (!administradores.equals(other.administradores))
			return false;
		if (cod_emp != other.cod_emp)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (logo_url == null) {
			if (other.logo_url != null)
				return false;
		} else if (!logo_url.equals(other.logo_url))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Empresa [cod_emp=" + cod_emp + ", nombre=" + nombre + ", horario=" + horario + ", descripcion="
				+ descripcion + ", logo_url=" + logo_url + ", usuarios=" + usuarios + ", administradores="
				+ administradores + ", productos=" + productos + "]";
	}

	
	
   
}

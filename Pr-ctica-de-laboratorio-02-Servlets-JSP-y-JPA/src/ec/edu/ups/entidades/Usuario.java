package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usu_id")
    private int cod_usu;
	
	@Column(name="usu_email", length=255, nullable=false, unique=true)
    private String correo;
	@Column(name="usu_password", length=255, nullable=false, unique=false)
    private String password;
	@Column(name="usu_nombre", length=255, nullable=false)
    private String nombre;
	@Column(name="usu_role", length=255, nullable=false)
    private String rol;
	
	
    @ManyToOne 
    @JoinColumn
    private Empresa usu_empresa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usu_pedido")
    private List<Pedido> pedidos= new ArrayList<Pedido>();
    
    
    
	public Usuario(int cod_usu, String correo, String password, String nombre, String rol, Empresa usu_empresa) {
		super();
		this.cod_usu = cod_usu;
		this.correo = correo;
		this.password = password;
		this.nombre = nombre;
		this.rol = rol;
		this.usu_empresa = usu_empresa;
	}

	public Usuario() {
		super();
	}

	public int getCod_usu() {
		return cod_usu;
	}

	public void setCod_usu(int cod_usu) {
		this.cod_usu = cod_usu;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Empresa getEmpresa() {
		return usu_empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.usu_empresa = empresa;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void addPedidos(Pedido pedidos) {
		this.pedidos.add(pedidos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod_usu;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		result = prime * result + ((usu_empresa == null) ? 0 : usu_empresa.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cod_usu != other.cod_usu)
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (usu_empresa == null) {
			if (other.usu_empresa != null)
				return false;
		} else if (!usu_empresa.equals(other.usu_empresa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [cod_usu=" + cod_usu + ", correo=" + correo + ", password=" + password + ", nombre=" + nombre
				+ ", rol=" + rol + ", usu_empresa=" + usu_empresa + ", pedidos=" + pedidos + "]";
	}
	
	
   
}

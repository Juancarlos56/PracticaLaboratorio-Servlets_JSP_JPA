package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity
@Table(name="Administrador")
public class Administrador implements Serializable {

	
	private static final long serialVersionUID = 1L;
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="adm_id")
    private int adm_id;
	
	
	@Column(name="adm_email", length=255, nullable=false, unique=true)
    private String correo;
	@Column(name="adm_password", length=255, nullable=false, unique=false)
    private String password;
	@Column(name="adm_nombre", length=255, nullable=false)
    private String nombre;
	@Column(name="adm_role", length=255, nullable=false)
    private String rol;
    
	
	@ManyToOne 
    @JoinColumn
    private Empresa adm_empresa;
    
    
	
	public Administrador(int cod_usu, String correo, String password, String nombre, String rol, Empresa adm_empresa) {
		super();
		this.adm_id = cod_usu;
		this.correo = correo;
		this.password = password;
		this.nombre = nombre;
		this.rol = rol;
		this.adm_empresa = adm_empresa;
	}

	public Administrador() {
		super();
	}

	
	
	public int getAdm_id() {
		return adm_id;
	}

	public void setAdm_id(int adm_id) {
		this.adm_id = adm_id;
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
		return adm_empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.adm_empresa = empresa;
	}

	public Empresa getAdm_empresa() {
		return adm_empresa;
	}

	public void setAdm_empresa(Empresa adm_empresa) {
		this.adm_empresa = adm_empresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adm_empresa == null) ? 0 : adm_empresa.hashCode());
		result = prime * result + adm_id;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
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
		Administrador other = (Administrador) obj;
		if (adm_empresa == null) {
			if (other.adm_empresa != null)
				return false;
		} else if (!adm_empresa.equals(other.adm_empresa))
			return false;
		if (adm_id != other.adm_id)
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
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}

	
	
   
}

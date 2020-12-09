package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
@Table(name="Producto")
public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
    private int codigo_pro;
	
	@Column(name = "pro_nombre", length = 255, nullable = false)
    private String nombre;
	@Column(name = "pro_precio", precision = 12, scale = 2, nullable = false)
    private Double precio;
	@Column(name = "pro_iva" , nullable = false)
    private int iva;
	@Column(name = "pro_url_imagen", length = 255, nullable = false)
    private String url_imagen;
	@Column(name = "pro_descripcion", length = 255, nullable = false)
    private String descripcion;
	@Column(name = "pro_estado", length = 10, nullable = false)
    private String estado;
    
	
    @ManyToOne
    @JoinColumn
    private Categoria pro_categoria;
   
    @ManyToOne
	@JoinColumn
	private Empresa pro_empresa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ped_Product")
	private List<Pedido> proPedidos;
   
    
	public Producto() {
		super();
	}


	

	public Producto(int codigo_pro, String nombre, Double precio, int iva, String url_imagen, String descripcion,
			String estado, Categoria pro_categoria, Empresa pro_empresa) {
		super();
		this.codigo_pro = codigo_pro;
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
		this.url_imagen = url_imagen;
		this.descripcion = descripcion;
		this.estado = estado;
		this.pro_categoria = pro_categoria;
		this.pro_empresa = pro_empresa;
	}




	public int getCodigo_pro() {
		return codigo_pro;
	}



	public void setCodigo_pro(int codigo_pro) {
		this.codigo_pro = codigo_pro;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public int getIva() {
		return iva;
	}



	public void setIva(int iva) {
		this.iva = iva;
	}



	public String getUrl_imagen() {
		return url_imagen;
	}



	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Categoria getPro_categoria() {
		return pro_categoria;
	}

	public void setPro_categoria(Categoria pro_categoria) {
		this.pro_categoria = pro_categoria;
	}

	public List<Pedido> getProPedidos() {
		return proPedidos;
	}

	public void setProPedidos(List<Pedido> proPedidos) {
		this.proPedidos = proPedidos;
	}

	public void addProPedidos(Pedido proPedido) {
		this.proPedidos.add(proPedido);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo_pro;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + iva;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((proPedidos == null) ? 0 : proPedidos.hashCode());
		result = prime * result + ((pro_categoria == null) ? 0 : pro_categoria.hashCode());
		result = prime * result + ((url_imagen == null) ? 0 : url_imagen.hashCode());
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
		Producto other = (Producto) obj;
		if (codigo_pro != other.codigo_pro)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (iva != other.iva)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (proPedidos == null) {
			if (other.proPedidos != null)
				return false;
		} else if (!proPedidos.equals(other.proPedidos))
			return false;
		if (pro_categoria == null) {
			if (other.pro_categoria != null)
				return false;
		} else if (!pro_categoria.equals(other.pro_categoria))
			return false;
		if (url_imagen == null) {
			if (other.url_imagen != null)
				return false;
		} else if (!url_imagen.equals(other.url_imagen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [codigo_pro=" + codigo_pro + ", nombre=" + nombre + ", precio=" + precio + ", iva=" + iva
				+ ", url_imagen=" + url_imagen + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", pro_categoria=" + pro_categoria + ", proPedidos=" + proPedidos + "]";
	}

	
   
}

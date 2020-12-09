package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity
@Table(name="Categoria")
public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cat_id")
    private int codigo_categoria;
	
	@Column(name="cat_nombre", length=255, nullable=false, unique=true)
    private String nombre;
	@Column(name="cat_url", length=255, nullable=false, unique=false)
    private String url;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pro_categoria")
    private List<Producto> productos=new ArrayList<Producto>();
    
    public Categoria(int codigo_categoria, String nombre, String url) {
    	this.setCodigo_categoria(codigo_categoria);
    	this.setNombre(nombre);
    	this.setUrl(url);
    }
    
	public Categoria() {
		super();
	}

	public int getCodigo_categoria() {
		return codigo_categoria;
	}

	public void setCodigo_categoria(int codigo_categoria) {
		this.codigo_categoria = codigo_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void setProductos(Producto productos) {
		this.productos.add(productos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo_categoria;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Categoria other = (Categoria) obj;
		if (codigo_categoria != other.codigo_categoria)
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
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [codigo_categoria=" + codigo_categoria + ", nombre=" + nombre + ", url=" + url
				+ ", productos=" + productos + "]";
	}
   
	
	
}

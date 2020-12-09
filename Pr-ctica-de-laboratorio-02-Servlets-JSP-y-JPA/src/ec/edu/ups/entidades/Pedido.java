package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity
@Table(name="Pedido")
public class Pedido implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ped_id")
    private int codigo_pedido;
	
	@Column(name = "ped_estado", columnDefinition = "VARCHAR(10) DEFAULT 'Pendiente'")
    private String estado;
    @Column(name = "ped_cantidad")
    private int cantidad;
    @Column(name = "ped_total")
    private Double total;
    
    @ManyToOne 
    @JoinColumn
    private Usuario usu_pedido;
    
    @OneToOne
	@JoinColumn
	private Producto ped_Product;
    
	public Pedido() {
		super();
	}

	
	
	
	public Pedido(int codigo_pedido, String estado, int cantidad, Double total, Usuario usu_pedido,
			Producto ped_Product) {
		super();
		this.codigo_pedido = codigo_pedido;
		this.estado = estado;
		this.cantidad = cantidad;
		this.total = total;
		this.usu_pedido = usu_pedido;
		this.ped_Product = ped_Product;
	}




	public int getCodigo_pedido() {
		return codigo_pedido;
	}


	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}

	public Usuario getUsu_pedido() {
		return usu_pedido;
	}

	public void setUsu_pedido(Usuario usu_pedido) {
		this.usu_pedido = usu_pedido;
	}

	public Producto getPed_Product() {
		return ped_Product;
	}

	public void setPed_Product(Producto ped_Product) {
		this.ped_Product = ped_Product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   
}

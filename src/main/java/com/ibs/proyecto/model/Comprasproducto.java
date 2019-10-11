package com.ibs.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the comprasproductos database table.
 * 
 */
@Entity
@Table(name="comprasproductos")
@NamedQuery(name="Comprasproducto.findAll", query="SELECT c FROM Comprasproducto c")
public class Comprasproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idComprasProductos;

	private BigInteger cantidad;

	private String estado;

	private float precioCompra;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="idCompra")
	private Compra compras;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="idProducto")
	private Producto productos;

	public Comprasproducto() {
	}

	public Long getIdComprasProductos() {
		return this.idComprasProductos;
	}

	public void setIdComprasProductos(Long idComprasProductos) {
		this.idComprasProductos = idComprasProductos;
	}

	public BigInteger getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigInteger cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getPrecioCompra() {
		return this.precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Compra getCompras() {
		return this.compras;
	}

	public void setCompras(Compra compras) {
		this.compras = compras;
	}

	public Producto getProductos() {
		return this.productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}

}
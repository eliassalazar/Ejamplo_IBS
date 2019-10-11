package com.ibs.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the inventariosproductos database table.
 * 
 */
@Entity
@Table(name="inventariosproductos")
@NamedQuery(name="Inventariosproducto.findAll", query="SELECT i FROM Inventariosproducto i")
public class Inventariosproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInventariosProductos;

	private BigInteger cantidad;

	//bi-directional many-to-one association to InventarioController
	@ManyToOne
	@JoinColumn(name="idInventario")
	private Inventario inventarios;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="idProducto")
	private Producto productos;

	public Inventariosproducto() {
	}

	public Long getIdInventariosProductos() {
		return this.idInventariosProductos;
	}

	public void setIdInventariosProductos(Long idInventariosProductos) {
		this.idInventariosProductos = idInventariosProductos;
	}

	public BigInteger getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigInteger cantidad) {
		this.cantidad = cantidad;
	}

	public Inventario getInventarios() {
		return this.inventarios;
	}

	public void setInventarios(Inventario inventarios) {
		this.inventarios = inventarios;
	}

	public Producto getProductos() {
		return this.productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}

}
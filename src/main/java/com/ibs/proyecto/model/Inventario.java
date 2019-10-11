package com.ibs.proyecto.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.List;



/**
 * The persistent class for the inventarios database table.
 * 
 */
@Entity
@Table(name="inventarios")
@NamedQuery(name="InventarioController.findAll", query="SELECT i FROM Inventario i")
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInventario;

	private String descripcion;

	private Timestamp fecha;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="idCompra")
	private Compra compras;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="idVenta")
	private Venta ventas;

	//bi-directional many-to-one association to Inventariosproducto
	@OneToMany(mappedBy="inventarios", fetch=FetchType.LAZY)
	private List<Inventariosproducto> inventariosproductos;

	public Inventario() {
	}

	public Long getIdInventario() {
		return this.idInventario;
	}

	public void setIdInventario(Long idInventario) {
		this.idInventario = idInventario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Compra getCompras() {
		return this.compras;
	}

	public void setCompras(Compra compras) {
		this.compras = compras;
	}

	public Venta getVentas() {
		return this.ventas;
	}

	public void setVentas(Venta ventas) {
		this.ventas = ventas;
	}

	public List<Inventariosproducto> getInventariosproductos() {
		return this.inventariosproductos;
	}

	public void setInventariosproductos(List<Inventariosproducto> inventariosproductos) {
		this.inventariosproductos = inventariosproductos;
	}

	public Inventariosproducto addInventariosproducto(Inventariosproducto inventariosproducto) {
		getInventariosproductos().add(inventariosproducto);
		inventariosproducto.setInventarios(this);

		return inventariosproducto;
	}

	public Inventariosproducto removeInventariosproducto(Inventariosproducto inventariosproducto) {
		getInventariosproductos().remove(inventariosproducto);
		inventariosproducto.setInventarios(null);

		return inventariosproducto;
	}

}
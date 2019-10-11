package com.ibs.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;
import java.util.List;

/**
 * The persistent class for the compras database table.
 * 
 */
@Entity
@Table(name="compras")
@NamedQuery(name="Compra.findAll", query="SELECT c FROM Compra c")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCompra;

	private String fechaCompra;

	private Timestamp fechaIngreso;

	private BigInteger numeroFactura;

	private String tipoCompra;

	private String totalCompra;

	//bi-directional many-to-one association to Proveedore
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private Proveedore proveedores;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuarios;

	//bi-directional many-to-one association to Comprasproducto
	@OneToMany(mappedBy="compras", fetch=FetchType.LAZY)
	private List<Comprasproducto> comprasproductos;

	//bi-directional many-to-one association to InventarioController
	@OneToMany(mappedBy="compras", fetch=FetchType.LAZY)
	private List<Inventario> inventarios;

	public Compra() {
	}

	public Long getIdCompra() {
		return this.idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public String getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public BigInteger getNumeroFactura() {
		return this.numeroFactura;
	}

	public void setNumeroFactura(BigInteger numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getTipoCompra() {
		return this.tipoCompra;
	}

	public void setTipoCompra(String tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

	public String getTotalCompra() {
		return this.totalCompra;
	}

	public void setTotalCompra(String totalCompra) {
		this.totalCompra = totalCompra;
	}

	public Proveedore getProveedores() {
		return this.proveedores;
	}

	public void setProveedores(Proveedore proveedores) {
		this.proveedores = proveedores;
	}

	public Usuario getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public List<Comprasproducto> getComprasproductos() {
		return this.comprasproductos;
	}

	public void setComprasproductos(List<Comprasproducto> comprasproductos) {
		this.comprasproductos = comprasproductos;
	}

	public Comprasproducto addComprasproducto(Comprasproducto comprasproducto) {
		getComprasproductos().add(comprasproducto);
		comprasproducto.setCompras(this);

		return comprasproducto;
	}

	public Comprasproducto removeComprasproducto(Comprasproducto comprasproducto) {
		getComprasproductos().remove(comprasproducto);
		comprasproducto.setCompras(null);

		return comprasproducto;
	}

	public List<Inventario> getInventarios() {
		return this.inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	public Inventario addInventario(Inventario inventario) {
		getInventarios().add(inventario);
		inventario.setCompras(this);

		return inventario;
	}

	public Inventario removeInventario(Inventario inventario) {
		getInventarios().remove(inventario);
		inventario.setCompras(null);

		return inventario;
	}

}
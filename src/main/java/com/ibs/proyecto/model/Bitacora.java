package com.ibs.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the bitacoras database table.
 * 
 */
@Entity
@Table(name="bitacoras")
@NamedQuery(name="Bitacora.findAll", query="SELECT b FROM Bitacora b")
public class Bitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBitacora;

	private String evento;

	private Timestamp fecha;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuarios;

	public Bitacora() {
	}

	public Long getIdBitacora() {
		return this.idBitacora;
	}

	public void setIdBitacora(Long idBitacora) {
		this.idBitacora = idBitacora;
	}

	public String getEvento() {
		return this.evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

}
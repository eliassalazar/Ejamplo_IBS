package com.ibs.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.proyecto.model.Compra;
import com.ibs.proyecto.model.Inventario;
import com.ibs.proyecto.model.Producto;
import com.ibs.proyecto.model.Venta;
import com.ibs.proyecto.repository.ICompraRepository;
import com.ibs.proyecto.repository.IInventarioProductoRepository;
import com.ibs.proyecto.repository.IInventarioRepository;
import com.ibs.proyecto.repository.IProductoRepository;
import com.ibs.proyecto.repository.IVentaRepository;

@Service
public class InventarioService {

	@Autowired
	IInventarioRepository ir;

	@Autowired
	ICompraRepository cr;

	@Autowired
	IVentaRepository vr;

	@Autowired
	IProductoRepository pr;

	// LISTAR
	public List<Inventario> listar() {
		return (List<Inventario>) ir.findAll();
	}

	// GUARDAR
	public Boolean guardar(Inventario inventario) {
		try {
			ir.save(inventario);
			return true;
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			return false;
		}
	}

	// ELIMINAR
	public Boolean eliminar(Inventario inventario) {
		try {
			ir.delete(inventario);
			return true;
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			return false;
		}
	}

	// OBTENER COMPRA
	public Compra getCompra(Long id) {
		return cr.findById(id).get();
	}

	// OBTENER COMPRA
	public Venta getVenta(Long id) {
		return vr.findById(id).get();
	}

	// OBTENER PRODUCTO
	public Producto getProducto(Long id) {
		return pr.findById(id).get();
	}

}

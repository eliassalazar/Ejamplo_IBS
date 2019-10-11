package com.ibs.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibs.proyecto.model.Producto;
import com.ibs.proyecto.repository.IProductoRepository;

@Controller
@RequestMapping("/inventario")
public class InventarioController {
	
	@Autowired
	IProductoRepository pr;
	
	// LISTAR INVENTARIO
		@GetMapping("/index")
		public String listarInventario(Model m  /*ModelMap mp */) {
			List<Producto> nombreProductos = (List<Producto>) pr.findAll();
			m.addAttribute("nombreProductos", nombreProductos);

			return "vistas/Inventario/ListarInventario";
		}
	
}

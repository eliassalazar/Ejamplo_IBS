package com.ibs.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.ibs.proyecto.repository.IClienteRepository;
import com.ibs.proyecto.repository.IUsuarioRepository;
import com.ibs.proyecto.repository.IVentaRepository;

@Controller
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	IVentaRepository vr;

	@Autowired
	IUsuarioRepository ur;
	
	@Autowired
	IClienteRepository cr;
	
	@GetMapping("/index")
	public String listarVenta() {
		/*List<Usuario> nombreUsuarios = (List<Usuario>) ur.findAll();
		m.addAttribute("nombreUsuarios", nombreUsuarios);
		
		List<Cliente> nombreCliente = (List<Cliente>) cr.findAll();
		m.addAttribute("nombreCliente", nombreCliente);
		m.addAttribute("items", vr.findAll());*/
		
		return new String("vistas/ventas/ListarVenta");  
		  
	}
	
	@PostMapping("/agregar")
	public String guardarVenta(@RequestParam(value = "numeroFactura", required = false) String numeroFacura,
			@RequestParam(value = "tipoVenta", 	required = false) String tipoVenta,
			@RequestParam(value = "totalVenta", required = false) String totalVenta,
			@RequestParam(value = "nombre", 	required = false) String nombre,
			@RequestParam(value = "fechaVenta", required = false) String fechaVneta,
			@RequestParam(value = "estado", 	required = false) String estado,
			@RequestParam(value = "idUsuario", 	required = false) String idUsuario,
			@RequestParam(value = "idCliente",	required = false) String idCliente) {
		
		return new String("redirect:/ventas/index");
		  
	}
	
	
		
	}
	
	



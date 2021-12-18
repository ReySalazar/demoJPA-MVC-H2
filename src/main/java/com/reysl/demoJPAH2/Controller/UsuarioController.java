package com.reysl.demoJPAH2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reysl.demoJPAH2.entity.Usuario;
import com.reysl.demoJPAH2.repository.RolRepository;
import com.reysl.demoJPAH2.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RolRepository rolRepository;
	
	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		modelo.addAttribute("roles", rolRepository.findAll());
		
		return "index";
	}
	
	@PostMapping("/crearUsuario")
	public String crearUsuario(Model modelo, Usuario usuario) {

		usuarioRepository.save(usuario);
		
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		modelo.addAttribute("roles", rolRepository.findAll());
		
		return "index";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String editarUsuario(Model modelo, @PathVariable(name = "id") Long id) {

		Usuario usuarioEditable = usuarioRepository.findById(id).get();
		
		modelo.addAttribute("usuario", usuarioEditable);
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		modelo.addAttribute("roles", rolRepository.findAll());
		
		return "index";
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model modelo, @PathVariable(name = "id") Long id) {

		Usuario usuarioEliminable = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuarioEliminable);
		
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		modelo.addAttribute("roles", rolRepository.findAll());
		
		return "index";
	}
	
	
}

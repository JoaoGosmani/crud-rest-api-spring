package br.com.joaogosmani.crudrestapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.joaogosmani.crudrestapi.models.Usuario;
import br.com.joaogosmani.crudrestapi.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/search")
	public ResponseEntity<Usuario> findById(@RequestParam Long id) {
		Usuario usuario = service.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarios = service.findAll();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@PostMapping 
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
		Usuario novoUsuario = service.insert(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") 
				.buildAndExpand(novoUsuario.getId()).toUri(); 
		return ResponseEntity.created(uri).body(novoUsuario);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteById(@RequestParam Long id) {
		service.deleteById(id);
		return ResponseEntity.ok().body("Usuário deletado com sucesso!");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario novoUsuario = usuario;
		novoUsuario.setId(id);
		service.update(novoUsuario);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/nome")
	public ResponseEntity<List<Usuario>> findByNome(@RequestParam(value = "nome", defaultValue = "") String nome) {
		List<Usuario> usuarios = service.findByNome(nome.trim().toUpperCase());
		return ResponseEntity.ok().body(usuarios);
	}
	
}

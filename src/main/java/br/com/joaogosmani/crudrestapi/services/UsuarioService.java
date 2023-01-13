package br.com.joaogosmani.crudrestapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaogosmani.crudrestapi.models.Usuario;
import br.com.joaogosmani.crudrestapi.repositories.UsuarioRepository;
import br.com.joaogosmani.crudrestapi.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Usuario insert(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Usuario update(Usuario usuario) {
		Usuario novoUsuario = findById(usuario.getId());
		updateData(novoUsuario, usuario);
		return repository.save(novoUsuario);
	}
	
	private void updateData(Usuario novoUsuario, Usuario usuario) {
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setIdade(usuario.getIdade());
	}
	
	public List<Usuario> findByNome(String nome) {
		return repository.findByNome(nome);
	}
	
}

package br.com.joaogosmani.crudrestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.joaogosmani.crudrestapi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "select u from Usuario u where u.nome like %?1%")
	List<Usuario> findByNomeContainingIgnoreCase(String nome);
	
}

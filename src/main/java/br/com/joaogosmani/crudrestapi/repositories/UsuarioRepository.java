package br.com.joaogosmani.crudrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaogosmani.crudrestapi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

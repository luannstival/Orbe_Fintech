package br.com.fiap.orbefintech.repository;

import br.com.fiap.orbefintech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByNrCpf(String nrCpf);

}
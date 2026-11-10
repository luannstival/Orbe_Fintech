package br.com.fiap.orbefintech.service;

import br.com.fiap.orbefintech.model.Usuario;
import br.com.fiap.orbefintech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service //avisa ao Spring: “esta classe faz parte do sistema, cuide dela”
public class UsuarioService {

    @Autowired //“preciso de um UsuarioRepository, entregue um pronto”
    private UsuarioRepository usuarioRepository;

    public Usuario consultarUsuario(Integer idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }
    }

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getNrCpf() != null && usuarioRepository.existsByNrCpf(usuario.getNrCpf())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado.");
        }
        try {
            return usuarioRepository.save(usuario);
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com esses dados.", ex);
        }
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuario.getIdUsuario());
        if (usuarioExistente.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }
    }

    public void deletarUsuario(Integer idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            usuarioRepository.deleteById(idUsuario);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
package br.com.fiap.orbefintech.controller;

import br.com.fiap.orbefintech.model.Usuario;
import br.com.fiap.orbefintech.service.UsuarioService;
import br.com.fiap.orbefintech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario consultarUsuario(@PathVariable Integer idUsuario) {
        return usuarioService.consultarUsuario(idUsuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @PutMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(idUsuario);
        return usuarioService.atualizarUsuario(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Integer idUsuario) {
        usuarioService.deletarUsuario(idUsuario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}

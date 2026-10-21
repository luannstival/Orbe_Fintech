package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TesteUsuario {
    public static void main(String[] args) {
        try {
            UsuarioDao dao = new UsuarioDao();

            Usuario usuario1 = new Usuario("Camila Rocha Andrade", "11111111111", "camila.andrade@example.com", "password1", LocalDate.of(2000, 9, 9));
            dao.insert(usuario1);
            System.out.println("Usuário cadastrado com sucesso!");

            Usuario usuario2 = new Usuario("Helena Marques Prado", "22222222222", "helena.prado@example.com", "password2", LocalDate.of(1992, 3, 14));
            dao.insert(usuario2);
            System.out.println("Usuário cadastrado com sucesso!");

            Usuario usuario3 = new Usuario("Rafael Teixeira Lima", "33333333333", "rafael.lima@example.com", "password3", LocalDate.of(1988, 11, 2));
            dao.insert(usuario3);
            System.out.println("Usuário cadastrado com sucesso!");

            Usuario usuario4 = new Usuario("Beatriz Nogueira Costa", "44444444444", "beatriz.costa@example.com", "password4", LocalDate.of(1995, 7, 21));
            dao.insert(usuario4);
            System.out.println("Usuário cadastrado com sucesso!");

            Usuario usuario5 = new Usuario("Gustavo Ferraz Neves", "55555555555", "gustavo.neves@example.com", "password5", LocalDate.of(1985, 1, 30));
            dao.insert(usuario5);
            System.out.println("Usuário cadastrado com sucesso!");

            List<Usuario> usuarios = dao.getAll();
            for (Usuario u : usuarios) {
                System.out.println(u.getIdUsuario() +
                        " - " + u.getNmUsuario() +
                        " - " + u.getNrCpf() +
                        " - " + u.getDsEmail() +
                        " - " + u.getDtNascimento());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
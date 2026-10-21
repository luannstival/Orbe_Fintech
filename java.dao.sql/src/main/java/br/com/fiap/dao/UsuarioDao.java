package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private Connection conexao;

    public UsuarioDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    private Usuario parseUsuario(ResultSet result) throws SQLException {
        Integer idUsuario = result.getInt("id_usuario");
        String nmUsuario = result.getString("nm_usuario");
        String nrCpf = result.getString("nr_cpf");
        String dsEmail = result.getString("ds_email");
        String dsSenha = result.getString("ds_senha");
        java.sql.Date dtNascimento = result.getDate("dt_nascimento");
        LocalDate localDate = null;
        if (dtNascimento != null) {
            localDate = dtNascimento.toLocalDate();
        }
        return new Usuario(idUsuario, nmUsuario, nrCpf, dsEmail, dsSenha, localDate);
    }

    public void insert(Usuario usuario) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO t_usuario (nm_usuario, nr_cpf, ds_email, ds_senha, dt_nascimento) VALUES (?, ?, ?, ?, ?)");
        stm.setString(1, usuario.getNmUsuario());
        stm.setString(2, usuario.getNrCpf());
        stm.setString(3, usuario.getDsEmail());
        stm.setString(4, usuario.getDsSenha());
        stm.setDate(5, usuario.getDtNascimento() != null ? java.sql.Date.valueOf(usuario.getDtNascimento()) : null);
        stm.executeUpdate();
        stm.close();
    }

    public List<Usuario> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_usuario ORDER BY id_usuario");
        ResultSet result = stm.executeQuery();
        List<Usuario> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseUsuario(result));
        }
        result.close();
        stm.close();
        return lista;
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.InstituicaoBancaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstituicaoBancariaDao {
    private Connection conexao;

    public InstituicaoBancariaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    private InstituicaoBancaria parseInstituicaoBancaria(ResultSet result) throws SQLException {
        Integer idInstituicao = result.getInt("id_instituicao");
        String cdCompe = result.getString("cd_compe");
        String nmInstituicao = result.getString("nm_instituicao");
        return new InstituicaoBancaria(idInstituicao, cdCompe, nmInstituicao);
    }

    public void insert(InstituicaoBancaria instituicaoBancaria) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO t_instituicao_bancaria (cd_compe, nm_instituicao) VALUES (?, ?)");
        stm.setString(1, instituicaoBancaria.getCdCompe());
        stm.setString(2, instituicaoBancaria.getNmInstituicao());
        stm.executeUpdate();
        stm.close();
    }

    public List<InstituicaoBancaria> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_instituicao_bancaria ORDER BY id_instituicao");
        ResultSet result = stm.executeQuery();
        List<InstituicaoBancaria> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseInstituicaoBancaria(result));
        }
        result.close();
        stm.close();
        return lista;
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}

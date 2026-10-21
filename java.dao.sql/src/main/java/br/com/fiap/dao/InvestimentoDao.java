package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Investimento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDao {

    private Connection conexao;

    public InvestimentoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    private Investimento parseInvestimento(ResultSet result) throws SQLException {
        Integer idInvestimento = result.getInt("id_investimento");
        Integer idUsuario = result.getInt("id_usuario");
        String nmInvestimento = result.getString("nm_investimento");
        String tpInvestimento = result.getString("tp_investimento");
        double vlInvestido = result.getDouble("vl_investido");
        Double vlAtual = result.getDouble("vl_atual");
        if (result.wasNull()) {
            vlAtual = null;
        }
        java.sql.Date dtInvestimento = result.getDate("dt_investimento");
        LocalDate localDate = null;
        if (dtInvestimento != null) {
            localDate = dtInvestimento.toLocalDate();
        }
        return new Investimento(idInvestimento, idUsuario, nmInvestimento, tpInvestimento, vlInvestido, vlAtual, localDate);
    }

    public void insert(Investimento investimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO t_investimento (id_usuario, nm_investimento, tp_investimento, vl_investido, vl_atual, dt_investimento) VALUES (?, ?, ?, ?, ?, ?)");
        stm.setInt(1, investimento.getIdUsuario());
        stm.setString(2, investimento.getNmInvestimento());
        stm.setString(3, investimento.getTpInvestimento());
        stm.setDouble(4, investimento.getVlInvestido());

        if (investimento.getVlAtual() == null) {
            stm.setNull(5, java.sql.Types.NUMERIC);
        } else {
            stm.setDouble(5, investimento.getVlAtual());
        }

        stm.setDate(6, java.sql.Date.valueOf(investimento.getDtInvestimento()));
        stm.executeUpdate();
        stm.close();
    }

    public List<Investimento> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_investimento ORDER BY id_investimento");
        ResultSet result = stm.executeQuery();
        List<Investimento> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseInvestimento(result));
        }
        result.close();
        stm.close();
        return lista;
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}

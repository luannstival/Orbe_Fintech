package br.com.fiap.view;

import br.com.fiap.dao.InvestimentoDao;
import br.com.fiap.model.Investimento;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class TesteInvestimento {
    public static void main(String[] args) {

        try {
            InvestimentoDao dao = new InvestimentoDao();

            // idUsuario 1 a 4 são usuários originais do banco: existem sempre, então a FK nunca falha.
            Investimento investimento1 = new Investimento(1, "Renda Fixa Premium Alfa", "CDB", 15000.00, null, LocalDate.of(2022, 3, 14));
            dao.insert(investimento1);
            System.out.println("Investimento cadastrado com sucesso!");

            Investimento investimento2 = new Investimento(2, "Fundo Horizons Tech", "Ações", 8500.50, null, LocalDate.of(2020, 6, 1));
            dao.insert(investimento2);
            System.out.println("Investimento cadastrado com sucesso!");

            Investimento investimento3 = new Investimento(3, "Tesouro IPCA+ Protector", "Tesouro Direto", 22300.00, null, LocalDate.of(2021, 9, 15));
            dao.insert(investimento3);
            System.out.println("Investimento cadastrado com sucesso!");

            Investimento investimento4 = new Investimento(4, "FII Real Estate Apex", "Fundo Imobiliário", 12450.00, 12450.00, LocalDate.of(2021, 9, 15));
            dao.insert(investimento4);
            System.out.println("Investimento cadastrado com sucesso!");

            Investimento investimento5 = new Investimento(4, "Crypto Eth Block", "Criptoativo", 4100.20, 4100.20, LocalDate.of(2026, 9, 2));
            dao.insert(investimento5);
            System.out.println("Investimento cadastrado com sucesso!");

            List<Investimento> investimentos = dao.getAll();
            // vlAtual pode ser null no banco: mostramos uma mensagem em vez de imprimir "null".
            for (Investimento i : investimentos) {
                System.out.println(i.getIdInvestimento() +
                        " - " + i.getIdUsuario() +
                        " - " + i.getNmInvestimento() +
                        " - " + i.getTpInvestimento() +
                        " - " + i.getVlInvestido() +
                        " - " + (i.getVlAtual() == null ? "Valor Atual ainda não calculado!" : i.getVlAtual()) +
                        " - " + i.getDtInvestimento());
            }
            // O DAO não fecha a conexão sozinho: quem criou o DAO fecha ao terminar.
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
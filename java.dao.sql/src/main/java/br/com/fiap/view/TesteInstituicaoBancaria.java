package br.com.fiap.view;

import br.com.fiap.dao.InstituicaoBancariaDao;
import br.com.fiap.model.InstituicaoBancaria;

import java.sql.SQLException;
import java.util.List;

public class TesteInstituicaoBancaria {
    public static void main(String[] args) {
        try {
            InstituicaoBancariaDao dao = new InstituicaoBancariaDao();

            InstituicaoBancaria instituicaoBancaria1 = new InstituicaoBancaria("906", "Banco Meridiano");
            dao.insert(instituicaoBancaria1);
            System.out.println("Instituição Bancária cadastrada com sucesso!");

            InstituicaoBancaria instituicaoBancaria2 = new InstituicaoBancaria("907", "Banco Saturno");
            dao.insert(instituicaoBancaria2);
            System.out.println("Instituição Bancária cadastrada com sucesso!");

            InstituicaoBancaria instituicaoBancaria3 = new InstituicaoBancaria("908", "Banco Cascata");
            dao.insert(instituicaoBancaria3);
            System.out.println("Instituição Bancária cadastrada com sucesso!");

            InstituicaoBancaria instituicaoBancaria4 = new InstituicaoBancaria("909", "Banco Orion Digital");
            dao.insert(instituicaoBancaria4);
            System.out.println("Instituição Bancária cadastrada com sucesso!");

            InstituicaoBancaria instituicaoBancaria5 = new InstituicaoBancaria("910", "Banco Vértice");
            dao.insert(instituicaoBancaria5);
            System.out.println("Instituição Bancária cadastrada com sucesso!");

            List<InstituicaoBancaria> instituicoes = dao.getAll();
            for (InstituicaoBancaria i : instituicoes) {
                System.out.println(i.getIdInstituicao() +
                        " - " + i.getCdCompe() +
                        " - " + i.getNmInstituicao());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}


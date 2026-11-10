package br.com.fiap.orbefintech.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_INSTITUICAO_BANCARIA")
public class InstituicaoBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInstituicao;

    private String cdCompe;
    private String nmInstituicao;

    public Integer getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getCdCompe() {
        return cdCompe;
    }

    public void setCdCompe(String cdCompe) {
        this.cdCompe = cdCompe;
    }

    public String getNmInstituicao() {
        return nmInstituicao;
    }

    public void setNmInstituicao(String nmInstituicao) {
        this.nmInstituicao = nmInstituicao;
    }
}

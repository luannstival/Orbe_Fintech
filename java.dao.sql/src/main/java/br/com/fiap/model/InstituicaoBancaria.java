package br.com.fiap.model;

public class InstituicaoBancaria {

    private Integer idInstituicao;
    private String cdCompe;
    private String nmInstituicao;

    public InstituicaoBancaria() {
    }

    public InstituicaoBancaria(String cdCompe, String nmInstituicao) {
        this.cdCompe = cdCompe;
        this.nmInstituicao = nmInstituicao;
    }

    public InstituicaoBancaria(Integer idInstituicao, String cdCompe, String nmInstituicao) {
        this.idInstituicao = idInstituicao;
        this.cdCompe = cdCompe;
        this.nmInstituicao = nmInstituicao;
    }

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

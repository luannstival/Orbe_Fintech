import java.time.LocalDateTime;

public class SituacaoFinanceira {

    private Integer idSituacao;
    private Usuario usuario;
    private Double rendaFixa;
    private Double rendaVariavel;
    private Double gastosEstimados;
    private Double dividasAtuais;
    private LocalDateTime dataAtualizacao;


    public SituacaoFinanceira() {
    }
    public SituacaoFinanceira(Integer idSituacao, Usuario usuario, Double rendaFixa, Double rendaVariavel, Double gastosEstimados, Double dividasAtuais, LocalDateTime dataAtualizacao) {
        this.idSituacao = idSituacao;
        this.usuario = usuario;
        this.rendaFixa = rendaFixa;
        this.rendaVariavel = rendaVariavel;
        this.gastosEstimados = gastosEstimados;
        this.dividasAtuais = dividasAtuais;
        this.dataAtualizacao = dataAtualizacao;
    }

    public void exibirSituacaoFinanceira() {
        System.out.println("O método 'exibirSituacaoFinanceira' foi executado com sucesso!");
    }
    public void calcularRendaTotal() {
        System.out.println("O método 'calcularRendaTotal' foi executado com sucesso!");
    }

    public Integer getIdSituacao() {
        return idSituacao;
    }
    public void setIdSituacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }


    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Double getRendaFixa() {
        return rendaFixa;
    }
    public void setRendaFixa(Double rendaFixa) {
        this.rendaFixa = rendaFixa;
    }


    public Double getRendaVariavel() {
        return rendaVariavel;
    }
    public void setRendaVariavel(Double rendaVariavel) {
        this.rendaVariavel = rendaVariavel;
    }


    public Double getGastosEstimados() {
        return gastosEstimados;
    }
    public void setGastosEstimados(Double gastosEstimados) {
        this.gastosEstimados = gastosEstimados;
    }


    public Double getDividasAtuais() {
        return dividasAtuais;
    }
    public void setDividasAtuais(Double dividasAtuais) {
        this.dividasAtuais = dividasAtuais;
    }


    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}

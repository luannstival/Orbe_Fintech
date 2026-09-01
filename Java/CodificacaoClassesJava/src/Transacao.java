import java.time.LocalDateTime;

public class Transacao {

    private Integer idTransacao;
    private ContaBancaria contaBancaria;
    private Double valorTransacao;
    private LocalDateTime dataTransacao;
    private String tipoTransacao;

    public Transacao() {
    }
    public Transacao(Integer idTransacao, ContaBancaria contaBancaria, Double valorTransacao, LocalDateTime dataTransacao, String tipoTransacao) {

        this.idTransacao = idTransacao;
        this.contaBancaria = contaBancaria;
        this.valorTransacao = valorTransacao;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
    }

    public void registrarTransacao() {
        System.out.println("O método 'registrarTransacao' foi executado com sucesso!");
    }
    public void exibirDadosTransacao() {
        System.out.println("O método 'exibirDadosTransacao' foi executado com sucesso!");
    }
    public Integer getIdTransacao() {
        return idTransacao;
    }
    public void setIdTransacao(Integer idTransacao) {
        this.idTransacao = idTransacao;
    }
    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }
    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
    public Double getValorTransacao() {
        return valorTransacao;
    }
    public void setValorTransacao(Double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }
    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }
    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
    public String getTipoTransacao() {
        return tipoTransacao;
    }
    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}

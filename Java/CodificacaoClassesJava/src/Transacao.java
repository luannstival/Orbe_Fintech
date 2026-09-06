import java.time.LocalDateTime;

public abstract class Transacao {

    private Integer idTransacao;
    private ContaBancaria contaBancaria;
    private Double valorTransacao;
    private LocalDateTime dataTransacao;

    public Transacao() {
    }
    public Transacao(Integer idTransacao, ContaBancaria contaBancaria, Double valorTransacao, LocalDateTime dataTransacao) {

        this.idTransacao = idTransacao;
        this.contaBancaria = contaBancaria;
        this.valorTransacao = valorTransacao;
        this.dataTransacao = dataTransacao;
    }

    //determinação da classe pai. Classes filhas: vou executar esse método, mas do meu jeito.
    public abstract boolean processarTransacao();

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


    }



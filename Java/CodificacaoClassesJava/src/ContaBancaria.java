public class ContaBancaria {

    private Integer idConta;
    private Usuario usuario;
    private Double saldoAtual;
    private String statusConta;
    private String nomeInstituicao;

    public ContaBancaria() {
    }
    public ContaBancaria(Integer idConta, Usuario usuario, Double saldoAtual, String statusConta, String nomeInstituicao ) {
        this.idConta = idConta;
        this.usuario = usuario;
        this.saldoAtual = saldoAtual;
        this.statusConta = statusConta;
        this.nomeInstituicao = nomeInstituicao;
    }

    public void exibirSaldoAtual() {
        System.out.println("O método 'exibirSaldoAtual' foi executado com sucesso!");
    }
    public void exibirDadosConta() {
        System.out.println("O método 'exibirDadosConta' foi executado com sucesso!");
    }
    public Integer getIdConta() {
        return idConta;
    }
    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Double getSaldoAtual() {
        return saldoAtual;
    }
    public void setSaldoAtual(Double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
    public String getStatusConta() {
        return statusConta;
    }
    public void setStatusConta(String statusConta) {
        this.statusConta = statusConta;
    }
    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
}

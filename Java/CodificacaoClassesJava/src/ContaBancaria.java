public class ContaBancaria {

    private Integer idConta;
    private Usuario usuario;
    private Double saldoAtual;
    private String statusConta;
    private String nomeInstituicao;

    public ContaBancaria() {
        this.saldoAtual = 0.0;
        this.statusConta = "ATIVA";
    }

    public void ativarConta(){
        this.statusConta = "ATIVA";
    }
    public void desativarConta(){
        this.statusConta = "INATIVA";
    }

    public ContaBancaria(Integer idConta, Usuario usuario, Double saldoAtual, String nomeInstituicao) {
        this.idConta = idConta;
        this.usuario = usuario;
        this.nomeInstituicao = nomeInstituicao;
        this.statusConta = "ATIVA";
        //Se o saldo não foi informado, OU, se o saldo informado é negativo, ENTÃO, adotamos saldoAtual = 0. Caso contrario, utilizamos o saldo recebido;
        if(saldoAtual == null || saldoAtual < 0.0){
            this.saldoAtual = 0.0;
        }else {
            this.saldoAtual = saldoAtual;
        }
    }
    public boolean creditar(Double valor) {
        //Se a conta não estiver ativa, retorne false.
        if (!"ATIVA".equalsIgnoreCase(this.statusConta)){
            return false;
        //se o valor for igual a null ou(||) menor ou igual a zero, retorne false.
        }if(valor == null || valor <= 0){
            return false;
        //acrescenta o valor ao saldoAtual.
        }else {
            this.saldoAtual += valor;
            return true;
        }
    }
    public boolean debitar(Double valor) {
        if (!"ATIVA".equalsIgnoreCase(this.statusConta)) {
            return false;
        }
        if (valor == null || valor <= 0) {
            return false;
        }
        if (valor > this.saldoAtual) {
            return false;
        }
        this.saldoAtual -= valor;
        return true;
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
    //setSaldoAtual já foi definido em creditar() e debitar()
    public Double getSaldoAtual() {
        return saldoAtual;
    }
    //setStatusConta já foi definico em ativarConta() e desativarConta()
    public String getStatusConta() {
        return statusConta;
    }
    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
}

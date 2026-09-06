public class Endereco {

    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco() {
    }
    public Endereco(String logradouro, String numero, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    public String formatarEndereco(){
        return logradouro+
                "," +numero+
                " - " +cidade+
                "/"+estado+
                " - CEP:"+cep;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCidade() {
        return cidade;}
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {
    private Integer idUsuario;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private LocalDateTime dataCadastro;

    public Usuario() {
    }
    public Usuario(Integer idUsuario, String nome, String cpf, LocalDate dataNascimento, LocalDateTime dataCadastro, Endereco endereco) {
        this.idUsuario = idUsuario;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public void exibirDadosUsuario() {
        System.out.println("O método 'exibirDadosUsuario' foi executado com sucesso!");
    }

    public LocalDateTime getDataCadastro() {return dataCadastro;}
    public void setDataCadastro(LocalDateTime dataCadastro){this.dataCadastro = dataCadastro;}
    public Integer getIdUsuario() {return idUsuario;}
    public void setIdUsuario(Integer idUsuario) {this.idUsuario = idUsuario;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public LocalDate getDataNascimento() {return dataNascimento;}
    public void setDataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}
    public Endereco getEndereco() {return endereco;}
    public void setEndereco(Endereco endereco) {this.endereco = endereco;}
}




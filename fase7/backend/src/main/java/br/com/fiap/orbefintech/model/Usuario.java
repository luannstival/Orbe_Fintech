package br.com.fiap.orbefintech.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "T_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nmUsuario;
    private String nrCpf;
    private String dsEmail;
    private String dsSenha;
    private LocalDate dtNascimento;

    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }
    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getNrCpf() {
        return nrCpf;
    }
    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public String getDsEmail() {
        return dsEmail;
    }
    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }
    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }
    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
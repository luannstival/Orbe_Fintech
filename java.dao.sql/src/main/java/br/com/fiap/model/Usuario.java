package br.com.fiap.model;

import java.time.LocalDate;

public class Usuario {
    private Integer idUsuario;
    private String nmUsuario;
    private String nrCpf;
    private String dsEmail;
    private String dsSenha;
    private LocalDate dtNascimento;

    public Usuario() {
    }

    public Usuario(String nmUsuario, String nrCpf, String dsEmail, String dsSenha, LocalDate dtNascimento) {
        this.nmUsuario = nmUsuario;
        this.nrCpf = nrCpf;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
        this.dtNascimento = dtNascimento;
    }

    public Usuario(Integer idUsuario, String nmUsuario, String nrCpf, String dsEmail, String dsSenha, LocalDate dtNascimento) {
        this.idUsuario = idUsuario;
        this.nmUsuario = nmUsuario;
        this.nrCpf = nrCpf;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
        this.dtNascimento = dtNascimento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
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
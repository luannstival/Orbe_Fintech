package br.com.fiap.model;

import java.time.LocalDate;

public class Investimento {
    private Integer idInvestimento;
    private Integer idUsuario;
    private String nmInvestimento;
    private String tpInvestimento;
    private double vlInvestido;
    private Double vlAtual;
    private LocalDate dtInvestimento;

    public Investimento() {
    }

    public Investimento(Integer idUsuario, String nmInvestimento, String tpInvestimento, double vlInvestido, Double vlAtual, LocalDate dtInvestimento) {
        this.idUsuario = idUsuario;
        this.nmInvestimento = nmInvestimento;
        this.tpInvestimento = tpInvestimento;
        this.vlInvestido = vlInvestido;
        this.vlAtual = vlAtual;
        this.dtInvestimento = dtInvestimento;
    }

    public Investimento(Integer idInvestimento, Integer idUsuario, String nmInvestimento, String tpInvestimento, double vlInvestido, Double vlAtual, LocalDate dtInvestimento) {
        this.idInvestimento = idInvestimento;
        this.idUsuario = idUsuario;
        this.nmInvestimento = nmInvestimento;
        this.tpInvestimento = tpInvestimento;
        this.vlInvestido = vlInvestido;
        this.vlAtual = vlAtual;
        this.dtInvestimento = dtInvestimento;
    }

    public Integer getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(Integer idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmInvestimento() {
        return nmInvestimento;
    }

    public void setNmInvestimento(String nmInvestimento) {
        this.nmInvestimento = nmInvestimento;
    }

    public String getTpInvestimento() {
        return tpInvestimento;
    }

    public void setTpInvestimento(String tpInvestimento) {
        this.tpInvestimento = tpInvestimento;
    }

    public double getVlInvestido() {
        return vlInvestido;
    }

    public void setVlInvestido(double vlInvestido) {
        this.vlInvestido = vlInvestido;
    }

    public Double getVlAtual() {
        return vlAtual;
    }

    public void setVlAtual(Double vlAtual) {
        this.vlAtual = vlAtual;
    }

    public LocalDate getDtInvestimento() {
        return dtInvestimento;
    }

    public void setDtInvestimento(LocalDate dtInvestimento) {
        this.dtInvestimento = dtInvestimento;
    }
}

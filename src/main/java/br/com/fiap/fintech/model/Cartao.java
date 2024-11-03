package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Cartao {

    private int idCartao;
    private int numeroCartao;
    private LocalDate dataValidade;
    private String status;
    private double valorLimite;
    private double valorGasto;
    private double valorDisponivel;

    private ContaBancaria contaBancaria;

    public Cartao(int idCartao, int numeroCartao, LocalDate dataVencimento, String status, double valorLimite, double valorGasto, double valorDisponivel ,ContaBancaria contaBancaria) {
        this.idCartao = idCartao;
        this.numeroCartao = numeroCartao;
        this.dataValidade = dataVencimento;
        this.status = status;
        this.valorLimite = valorLimite;
        this.valorGasto = valorGasto;
        this.valorDisponivel = valorDisponivel;
        this.contaBancaria = contaBancaria;
    }

    public Cartao() {}

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }

    public double getValorDisponivel() {
        return valorDisponivel;
    }

    public void setValorDisponivel(double valorDisponivel) {
        this.valorDisponivel = valorDisponivel;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }
}

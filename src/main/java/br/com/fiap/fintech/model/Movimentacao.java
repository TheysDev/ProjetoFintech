package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Movimentacao {

    private int idMovimentacao;
    private double valorMovimentacao;
    private LocalDate dataMovimentacao;
    private LocalDate dataCriacaoMovimentacao;
    private LocalDate dataAtualizacaoMovimentacao;

    private ContaBancaria contaBancaria;
    private Alocacao alocacao;

    public Movimentacao(int idMovimentacao, double valorMovimentacao, LocalDate dataMovimentacao, LocalDate dataCriacaoMovimentacao, ContaBancaria contaBancaria, Alocacao alocacao) {
        this.idMovimentacao = idMovimentacao;
        this.valorMovimentacao = valorMovimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.dataCriacaoMovimentacao = dataCriacaoMovimentacao;

        this.contaBancaria = contaBancaria;
        this.alocacao = alocacao;
    }

    public Movimentacao() {}

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public double getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(double valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public LocalDate getDataCriacaoMovimentacao() {
        return dataCriacaoMovimentacao;
    }

    public void setDataCriacaoMovimentacao(LocalDate dataCriacaoMovimentacao) {
        this.dataCriacaoMovimentacao = dataCriacaoMovimentacao;
    }

    public LocalDate getDataAtualizacaoMovimentacao() {
        return dataAtualizacaoMovimentacao;
    }

    public void setDataAtualizacaoMovimentacao(LocalDate dataAtualizacaoMovimentacao) {
        this.dataAtualizacaoMovimentacao = dataAtualizacaoMovimentacao;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public Alocacao getAlocacao() {
        return alocacao;
    }

    public void setAlocacao(Alocacao alocacao) {
        this.alocacao = alocacao;
    }
}

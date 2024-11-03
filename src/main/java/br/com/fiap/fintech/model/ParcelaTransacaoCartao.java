package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class ParcelaTransacaoCartao {

    private int idParcelaTransacaoCartao;
    private int numeroParcelas;
    private double valorParcela;
    private LocalDate dataCriacaoParcelaTransacaoCartao;
    private LocalDate dataAtualizacaoParcelaTransacaoCartao;

    private TransacaoCartao transacaoCartao;

    public ParcelaTransacaoCartao(int idParcelaTransacaoCartao, int numeroParcelas, double valorParcela, LocalDate dataCriacaoParcelaTransacaoCartao, LocalDate dataAtualizacaoParcelaTransacaoCartao, TransacaoCartao transacaoCartao) {
        this.idParcelaTransacaoCartao = idParcelaTransacaoCartao;
        this.numeroParcelas = numeroParcelas;
        this.valorParcela = valorParcela;
        this.dataCriacaoParcelaTransacaoCartao = dataCriacaoParcelaTransacaoCartao;
        this.dataAtualizacaoParcelaTransacaoCartao = dataAtualizacaoParcelaTransacaoCartao;
        this.transacaoCartao = transacaoCartao;
    }

    public ParcelaTransacaoCartao() {}

    public int getIdParcelaTransacaoCartao() {
        return idParcelaTransacaoCartao;
    }

    public void setIdParcelaTransacaoCartao(int idParcelaTransacaoCartao) {
        this.idParcelaTransacaoCartao = idParcelaTransacaoCartao;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public LocalDate getDataCriacaoParcelaTransacaoCartao() {
        return dataCriacaoParcelaTransacaoCartao;
    }

    public void setDataCriacaoParcelaTransacaoCartao(LocalDate dataCriacaoParcelaTransacaoCartao) {
        this.dataCriacaoParcelaTransacaoCartao = dataCriacaoParcelaTransacaoCartao;
    }

    public LocalDate getDataAtualizacaoParcelaTransacaoCartao() {
        return dataAtualizacaoParcelaTransacaoCartao;
    }

    public void setDataAtualizacaoParcelaTransacaoCartao(LocalDate dataAtualizacaoParcelaTransacaoCartao) {
        this.dataAtualizacaoParcelaTransacaoCartao = dataAtualizacaoParcelaTransacaoCartao;
    }

    public TransacaoCartao getTransacaoCartao() {
        return transacaoCartao;
    }

    public void setTransacaoCartao(TransacaoCartao transacaoCartao) {
        this.transacaoCartao = transacaoCartao;
    }
}

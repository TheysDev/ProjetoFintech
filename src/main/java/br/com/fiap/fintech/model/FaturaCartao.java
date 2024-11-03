package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class FaturaCartao {

    private int idFaturaCartao;
    private LocalDate dataMesReferencia;
    private double valorTotal;
    private LocalDate dataVencimentoFatura;
    private String status;
    private LocalDate dataPagamento;


    private Cartao cartao;

    public FaturaCartao(int idFaturaCartao, LocalDate dataMesReferencia, double valorTotal, LocalDate dataVencimentoFatura, String status, Cartao cartao) {
        this.idFaturaCartao = idFaturaCartao;
        this.dataMesReferencia = dataMesReferencia;
        this.valorTotal = valorTotal;
        this.dataVencimentoFatura = dataVencimentoFatura;
        this.status = status;
        this.cartao = cartao;
    }

    public FaturaCartao(){}

    public int getIdFaturaCartao() {
        return idFaturaCartao;
    }

    public void setIdFaturaCartao(int idFaturaCartao) {
        this.idFaturaCartao = idFaturaCartao;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataVencimentoFatura() {
        return dataVencimentoFatura;
    }

    public void setDataVencimentoFatura(LocalDate dataVencimentoFatura) {
        this.dataVencimentoFatura = dataVencimentoFatura;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataMesReferencia() {
        return dataMesReferencia;
    }

    public void setDataMesReferencia(LocalDate dataMesReferencia) {
        this.dataMesReferencia = dataMesReferencia;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}

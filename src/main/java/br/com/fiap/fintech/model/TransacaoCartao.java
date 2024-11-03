package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class TransacaoCartao {

    private int idTransacaoCartao;
    private double valorTotal;
    private LocalDate dataTransacao;
    private String tipoTransacao;
    private int quantidadeParcelas;
    private String descricaoTransacao;
    private LocalDate dataCriacaoTransacao;
    private LocalDate dataAtualizacaoTransacao;

    private Cartao cartao;

    public TransacaoCartao(int idTransacaoCartao, double valorTotal, LocalDate dataTransacao, String tipoTransacao, int quantidadeParcelas,
    String descricaoTransacao, LocalDate dataCriacaoTransacao, Cartao cartao) {

        this.idTransacaoCartao = idTransacaoCartao;
        this.valorTotal = valorTotal;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.quantidadeParcelas = quantidadeParcelas;
        this.descricaoTransacao = descricaoTransacao;
        this.dataCriacaoTransacao = dataCriacaoTransacao;
        this.cartao = cartao;
    }

    public TransacaoCartao(){}


    public int getIdTransacaoCartao() {
        return idTransacaoCartao;
    }

    public void setIdTransacaoCartao(int idTransacaoCartao) {
        this.idTransacaoCartao = idTransacaoCartao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getDescricaoTransacao() {
        return descricaoTransacao;
    }

    public void setDescricaoTransacao(String descricaoTransacao) {
        this.descricaoTransacao = descricaoTransacao;
    }

    public LocalDate getDataCriacaoTransacao() {
        return dataCriacaoTransacao;
    }

    public void setDataCriacaoTransacao(LocalDate dataCriacaoTransacao) {
        this.dataCriacaoTransacao = dataCriacaoTransacao;
    }

    public LocalDate getDataAtualizacaoTransacao() {
        return dataAtualizacaoTransacao;
    }

    public void setDataAtualizacaoTransacao(LocalDate dataAtualizacaoTransacao) {
        this.dataAtualizacaoTransacao = dataAtualizacaoTransacao;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}

package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class MovimentacaoCarteira {

    private int idMovimentacaoCarteira;
    private String tipoMovimentacao;
    private double valorMovimentacao;
    private LocalDate dataMovimentacao;
    private LocalDate dataCriacaoMovimentacao;
    private LocalDate dataAtualizacaoMovimentacao;

    private ContaBancaria contaBancaria;
    private Carteira carteira;

    public MovimentacaoCarteira(int idMovimentacaoCarteira, String tipoMovimentacao, double valorMovimentacao, LocalDate dataMovimentacao,
                                LocalDate dataCriacaoMovimentacao, LocalDate dataAtualizacaoMovimentacao, ContaBancaria contaBancaria, Carteira carteira) {

        this.idMovimentacaoCarteira = idMovimentacaoCarteira;
        this.tipoMovimentacao = tipoMovimentacao;
        this.valorMovimentacao = valorMovimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.dataCriacaoMovimentacao = dataCriacaoMovimentacao;
        this.dataAtualizacaoMovimentacao = dataAtualizacaoMovimentacao;
        this.contaBancaria = contaBancaria;
        this.carteira = carteira;
    }

    public MovimentacaoCarteira() {}

    public int getIdMovimentacaoCarteira() {
        return idMovimentacaoCarteira;
    }

    public void setIdMovimentacaoCarteira(int idMovimentacaoCarteira) {
        this.idMovimentacaoCarteira = idMovimentacaoCarteira;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public LocalDate getDataAtualizacaoMovimentacao() {
        return dataAtualizacaoMovimentacao;
    }

    public void setDataAtualizacaoMovimentacao(LocalDate dataAtualizacaoMovimentacao) {
        this.dataAtualizacaoMovimentacao = dataAtualizacaoMovimentacao;
    }

    public LocalDate getDataCriacaoMovimentacao() {
        return dataCriacaoMovimentacao;
    }

    public void setDataCriacaoMovimentacao(LocalDate dataCriacaoMovimentacao) {
        this.dataCriacaoMovimentacao = dataCriacaoMovimentacao;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public double getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(double valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}

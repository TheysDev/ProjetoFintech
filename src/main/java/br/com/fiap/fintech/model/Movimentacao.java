package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Movimentacao {

    private int idMovimentacao;
    private double valorMovimentacao;
    private LocalDate dataMovimentacao;
    private String tipoMovimentacao;
    private LocalDate dataCriacaoMovimentacao;
    private LocalDate dataAtualizacaoMovimentacao;

    private ContaBancaria contaBancaria;
    private Alocacao alocacao;

    public Movimentacao(int idMovimentacao, double valorMovimentacao, LocalDate dataMovimentacao, String tipoMovimentacao, LocalDate dataCriacaoMovimentacao, ContaBancaria contaBancaria, Alocacao alocacao) {
        this.idMovimentacao = idMovimentacao;
        this.valorMovimentacao = valorMovimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataCriacaoMovimentacao = dataCriacaoMovimentacao;
        this.contaBancaria = contaBancaria;
        this.alocacao = alocacao;
    }

    public Movimentacao(String descricaoAlocacao, LocalDate dataMovimentacao, String numeroConta, double valorMovimentacao){
        this.alocacao = new Alocacao(descricaoAlocacao);
        this.dataMovimentacao = dataMovimentacao;
        this.contaBancaria = new ContaBancaria(numeroConta);
        this.valorMovimentacao = valorMovimentacao;
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

    public LocalDate getDataMovimentacao() {;
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public LocalDate getDataCriacaoMovimentacao() {
        dataCriacaoMovimentacao = LocalDate.now();
        return dataCriacaoMovimentacao;
    }

    public LocalDate getDataAtualizacaoMovimentacao() {
        dataAtualizacaoMovimentacao = LocalDate.now();
        return dataAtualizacaoMovimentacao;
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

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getIdAlocacao() {
        return alocacao.getIdAlocacao();
    }

    public int getIdConta() {
        return contaBancaria.getIdConta();
    }
}

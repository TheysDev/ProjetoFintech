package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class MovimentacaoContaBancaria {

    private int idMovContaBancaria;
    private String descricaoMovContaBancaria;
    private double valorMovContaBancaria;
    private LocalDate dataMovContaBancaria;
    private LocalDate dataCricaoMovContaBancaria;
    private  LocalDate dataAtualizacaoMovContaBancaria;

    private ContaBancaria contaBancaria;
    private MovimentacaoCarteira movimentacaoCarteira;

    public MovimentacaoContaBancaria(int idMovContaBancaria, String descricaoMovContaBancaria, double valorMoviContaBancaria, LocalDate dataMovContaBancaria,
                                     LocalDate dataCricaoMovContaBancaria, ContaBancaria contaBancaria, MovimentacaoCarteira movimentacaoCarteira) {

        this.idMovContaBancaria = idMovContaBancaria;
        this.descricaoMovContaBancaria = descricaoMovContaBancaria;
        this.valorMovContaBancaria = valorMoviContaBancaria;
        this.dataMovContaBancaria = dataMovContaBancaria;
        this.dataCricaoMovContaBancaria = dataCricaoMovContaBancaria;
        this.contaBancaria = contaBancaria;
        this.movimentacaoCarteira = movimentacaoCarteira;
    }

    public MovimentacaoContaBancaria(){}

    public int getIdMovContaBancaria() {
        return idMovContaBancaria;
    }

    public void setIdMovContaBancaria(int idMovContaBancaria) {
        this.idMovContaBancaria = idMovContaBancaria;
    }

    public MovimentacaoCarteira getMovimentacaoCarteira() {
        return movimentacaoCarteira;
    }

    public void setMovimentacaoCarteira(MovimentacaoCarteira movimentacaoCarteira) {
        this.movimentacaoCarteira = movimentacaoCarteira;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public LocalDate getDataAtualizacaoMovContaBancaria() {
        return dataAtualizacaoMovContaBancaria;
    }

    public void setDataAtualizacaoMovContaBancaria(LocalDate dataAtualizacaoMovContaBancaria) {
        this.dataAtualizacaoMovContaBancaria = dataAtualizacaoMovContaBancaria;
    }

    public LocalDate getDataCricaoMovContaBancaria() {
        return dataCricaoMovContaBancaria;
    }

    public void setDataCricaoMovContaBancaria(LocalDate dataCricaoMovContaBancaria) {
        this.dataCricaoMovContaBancaria = dataCricaoMovContaBancaria;
    }

    public LocalDate getDataMovContaBancaria() {
        return dataMovContaBancaria;
    }

    public void setDataMovContaBancaria(LocalDate dataMovContaBancaria) {
        this.dataMovContaBancaria = dataMovContaBancaria;
    }

    public double getValorMovContaBancaria() {
        return valorMovContaBancaria;
    }

    public void setValorMovContaBancaria(double valorMovContaBancaria) {
        this.valorMovContaBancaria = valorMovContaBancaria;
    }

    public String getDescricaoMovContaBancaria() {
        return descricaoMovContaBancaria;
    }

    public void setDescricaoMovContaBancaria(String descricaoMovContaBancaria) {
        this.descricaoMovContaBancaria = descricaoMovContaBancaria;
    }
}

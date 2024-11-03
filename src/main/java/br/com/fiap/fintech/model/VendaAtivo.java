package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class VendaAtivo {

    private int idVendaAtivo;
    private double quantidadeVendida;
    private double valorUnitario;
    private LocalDate dataCriacaoVenda;
    private LocalDate dataAtualizacaoVenda;

    private MovimentacaoContaBancaria movimentacaoContaBancaria;
    private MovimentacaoCarteira movimentacaoCarteira;
    private Ativo ativo;

    public VendaAtivo(int idVendaAtivo, double quantidadeVendida, double valorUnitario, LocalDate dataCriacaoVenda, MovimentacaoContaBancaria movimentacaoContaBancaria
                       , MovimentacaoCarteira movimentacaoCarteira, Ativo ativo) {

        this.idVendaAtivo = idVendaAtivo;
        this.quantidadeVendida = quantidadeVendida;
        this.valorUnitario = valorUnitario;
        this.dataCriacaoVenda = dataCriacaoVenda;
        this.movimentacaoContaBancaria = movimentacaoContaBancaria;
        this.movimentacaoCarteira = movimentacaoCarteira;
        this.ativo = ativo;
    }

    public VendaAtivo() {}

    public int getIdVendaAtivo() {
        return idVendaAtivo;
    }

    public void setIdVendaAtivo(int idVendaAtivo) {
        this.idVendaAtivo = idVendaAtivo;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public MovimentacaoCarteira getMovimentacaoCarteira() {
        return movimentacaoCarteira;
    }

    public void setMovimentacaoCarteira(MovimentacaoCarteira movimentacaoCarteira) {
        this.movimentacaoCarteira = movimentacaoCarteira;
    }

    public MovimentacaoContaBancaria getMovimentacaoContaBancaria() {
        return movimentacaoContaBancaria;
    }

    public void setMovimentacaoContaBancaria(MovimentacaoContaBancaria movimentacaoContaBancaria) {
        this.movimentacaoContaBancaria = movimentacaoContaBancaria;
    }

    public LocalDate getDataAtualizacaoVenda() {
        return dataAtualizacaoVenda;
    }

    public void setDataAtualizacaoVenda(LocalDate dataAtualizacaoVenda) {
        this.dataAtualizacaoVenda = dataAtualizacaoVenda;
    }

    public LocalDate getDataCriacaoVenda() {
        return dataCriacaoVenda;
    }

    public void setDataCriacaoVenda(LocalDate dataCriacaoVenda) {
        this.dataCriacaoVenda = dataCriacaoVenda;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(double quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
}

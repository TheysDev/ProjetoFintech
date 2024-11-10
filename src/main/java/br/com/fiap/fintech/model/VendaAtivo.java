package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class VendaAtivo {

    private int idVendaAtivo;
    private double quantidadeVendida;
    private double valorUnitario;
    private LocalDate dataCriacaoVenda;
    private LocalDate dataAtualizacaoVenda;


    private Ativo ativo;

    public VendaAtivo(int idVendaAtivo, double quantidadeVendida, double valorUnitario, LocalDate dataCriacaoVenda, Ativo ativo) {

        this.idVendaAtivo = idVendaAtivo;
        this.quantidadeVendida = quantidadeVendida;
        this.valorUnitario = valorUnitario;
        this.dataCriacaoVenda = dataCriacaoVenda;
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

package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class CompraAtivo {

    private int idCompraAtivo;
    private double quantidadeAtivo;
    private double valorUnitarioAtivo;
    private LocalDate dataCriacaoCompraAtivo;
    private LocalDate dataAtualizacaoCompraAtivo;

    private Ativo ativo;


    public CompraAtivo(int idCompraAtivo,double quantidadeAtivo, double valorUnitarioAtivo, LocalDate dataCriacaoCompraAtivo, Ativo ativo) {

        this.idCompraAtivo = idCompraAtivo;
        this.quantidadeAtivo = quantidadeAtivo;
        this.valorUnitarioAtivo = valorUnitarioAtivo;
        this.dataCriacaoCompraAtivo = dataCriacaoCompraAtivo;
        this.ativo = ativo;

    }


}

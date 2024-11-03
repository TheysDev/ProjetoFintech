package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class HistoricoPrecoAtivo {

    private int idHistoricoPrecoAtivo;
    private LocalDate dataAtualizacao;
    private double valorAtivo;
    private LocalDate dataCriacaoHistorico;

    private Ativo ativo;

    public HistoricoPrecoAtivo(int idHistoricoPrecoAtivo, LocalDate dataAtualizacao, double valorAtivo, LocalDate dataCriacaoHistorico, Ativo ativo) {
        this.idHistoricoPrecoAtivo = idHistoricoPrecoAtivo;
        this.dataAtualizacao = dataAtualizacao;
        this.valorAtivo = valorAtivo;
        this.dataCriacaoHistorico = dataCriacaoHistorico;
        this.ativo = ativo;
    }

    public HistoricoPrecoAtivo() {}

    public int getIdHistoricoPrecoAtivo() {
        return idHistoricoPrecoAtivo;
    }

    public void setIdHistoricoPrecoAtivo(int idHistoricoPrecoAtivo) {
        this.idHistoricoPrecoAtivo = idHistoricoPrecoAtivo;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataCriacaoHistorico() {
        return dataCriacaoHistorico;
    }

    public void setDataCriacaoHistorico(LocalDate dataCriacaoHistorico) {
        this.dataCriacaoHistorico = dataCriacaoHistorico;
    }

    public double getValorAtivo() {
        return valorAtivo;
    }

    public void setValorAtivo(double valorAtivo) {
        this.valorAtivo = valorAtivo;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}

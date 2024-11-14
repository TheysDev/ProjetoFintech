package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Investimento {

    private int idInvest;
    private double valorInvest;
    private LocalDate dtCriadoEm;
    private LocalDate dtAtualizadoEm;
    private String tipoInvest;

    private Ativo ativo;

    public Investimento(int idInvest, double ValorInvest, LocalDate dtCriadoEm, String tipoInvest, Ativo ativo) {
        this.idInvest = idInvest;
        this.valorInvest = ValorInvest;
        this.dtCriadoEm = dtCriadoEm;
        this.tipoInvest = tipoInvest;
        this.ativo = ativo;
    }

    public Investimento() {}

    public int getIdInvest() {
        return idInvest;
    }

    public void setIdInvest(int idInvest) {
        this.idInvest = idInvest;
    }

    public double getValorInvest() {
        return valorInvest;
    }

    public void setValorInvest(double valorInvest) {
        this.valorInvest = valorInvest;
    }

    public LocalDate getDtCriadoEm() {
        return dtCriadoEm;
    }

    public void setDtCriadoEm(LocalDate dtCriadoEm) {
        this.dtCriadoEm = dtCriadoEm;
    }

    public LocalDate getDtAtualizadoEm() {
        return dtAtualizadoEm;
    }

    public void setDtAtualizadoEm(LocalDate dtAtualizadoEm) {
        this.dtAtualizadoEm = dtAtualizadoEm;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public String getNomeAtivo() {
        return ativo.getNomeAtivo();
    }

    public int getIdAtivo() {
        return ativo.getIdAtivo();
    }

    public String getTipoInvest() {
        return tipoInvest;
    }

    public void setTipoInvest(String tipoInvest) {
        this.tipoInvest = tipoInvest;
    }
}
package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Investimento {

    private int idTransacao;
    private int idMovBanc;
    private int idMovCart;
    private double nrQuantidade;
    private double nrValorUnit;
    private LocalDate dtCriadoEm;
    private LocalDate dtAtualizadoEm;
    private int idAtivo;

    public Investimento(int idTransacao, int idMovBanc, int idMovCart, double nrQuantidade, double nrValorUnit, LocalDate dtCriadoEm, LocalDate dtAtualizadoEm, int idAtivo) {
        this.idTransacao = idTransacao;
        this.idMovBanc = idMovBanc;
        this.idMovCart = idMovCart;
        this.nrQuantidade = nrQuantidade;
        this.nrValorUnit = nrValorUnit;
        this.dtCriadoEm = dtCriadoEm;
        this.dtAtualizadoEm = dtAtualizadoEm;
        this.idAtivo = idAtivo;
    }

    public Investimento() {}

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getIdMovBanc() {
        return idMovBanc;
    }

    public void setIdMovBanc(int idMovBanc) {
        this.idMovBanc = idMovBanc;
    }

    public int getIdMovCart() {
        return idMovCart;
    }

    public void setIdMovCart(int idMovCart) {
        this.idMovCart = idMovCart;
    }

    public double getNrQuantidade() {
        return nrQuantidade;
    }

    public void setNrQuantidade(double nrQuantidade) {
        this.nrQuantidade = nrQuantidade;
    }

    public double getNrValorUnit() {
        return nrValorUnit;
    }

    public void setNrValorUnit(double nrValorUnit) {
        this.nrValorUnit = nrValorUnit;
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

    public int getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(int idAtivo) {
        this.idAtivo = idAtivo;
    }
}
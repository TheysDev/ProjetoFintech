package br.com.fiap.fintech.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarteiraAtivo {

    private int idCarteiraAtivo;
    private double quantidadeAtivo;
    private double valorMedioAtivo;
    private LocalDate dataUltimaAtualizacao;

    private Carteira carteira;
    private Ativo ativo;

    public CarteiraAtivo(int idCarteiraAtivo, double quantidadeAtivo, double valorMedioAtivo, LocalDate dataUltimaAtualizacao, Carteira carteira, Ativo ativo) {
        this.idCarteiraAtivo = idCarteiraAtivo;
        this.quantidadeAtivo = quantidadeAtivo;
        this.valorMedioAtivo = valorMedioAtivo;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.carteira = carteira;
        this.ativo = ativo;
    }

    public CarteiraAtivo() {}

    public int getIdCarteiraAtivo() {
        return idCarteiraAtivo;
    }

    public void setIdCarteiraAtivo(int idCarteiraAtivo) {
        this.idCarteiraAtivo = idCarteiraAtivo;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public LocalDate getDataUltimaAtualizacao() {
        dataUltimaAtualizacao = LocalDate.now();
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public double getValorMedioAtivo() {
        return valorMedioAtivo;
    }

    public void setValorMedioAtivo(double valorMedioAtivo) {
        this.valorMedioAtivo = valorMedioAtivo;
    }

    public double getQuantidadeAtivo() {

        return quantidadeAtivo;
    }

    public void setQuantidadeAtivo(double quantidadeAtivo) {
        this.quantidadeAtivo = quantidadeAtivo;
    }

    public int getIdCarteira(){
        return carteira.getIdCarteira();
    }

    public int getIdAtivo(){
        return ativo.getIdAtivo();
    }
}


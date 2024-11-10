package br.com.fiap.fintech.model;

public class Alocacao {

    private int idAlocacao;
    private String descricaoAlocacao;
    private double saldoAlocacao;

    public Alocacao(int idAlocacao, String descricaoAlocacao) {
        this.idAlocacao = idAlocacao;
        this.descricaoAlocacao = descricaoAlocacao;
    }

    public Alocacao(String descricaoAlocacao){
        this.descricaoAlocacao = descricaoAlocacao;
    }

    public Alocacao(){}

    public int getIdAlocacao() {
        return idAlocacao;
    }

    public void setIdAlocacao(int idAlocacao) {
        this.idAlocacao = idAlocacao;
    }

    public String getDescricaoAlocacao() {
        return descricaoAlocacao;
    }

    public void setDescricaoAlocacao(String descricaoAlocacao) {
        this.descricaoAlocacao = descricaoAlocacao;
    }

    public double getSaldoAlocacao() {
        return saldoAlocacao;
    }

    public void setSaldoAlocacao(double saldoAlocacao) {
        this.saldoAlocacao = saldoAlocacao;
    }
}

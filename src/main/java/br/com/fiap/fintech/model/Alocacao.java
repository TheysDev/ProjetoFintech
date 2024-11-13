package br.com.fiap.fintech.model;

public class Alocacao {

    private int idAlocacao;
    private String descricaoAlocacao;
    private String tipoAlocacao;
    private double saldoAlocacao;

    public Alocacao(int idAlocacao, String descricaoAlocacao, String tipoAlocacao) {
        this.idAlocacao = idAlocacao;
        this.descricaoAlocacao = descricaoAlocacao;
        this.tipoAlocacao = tipoAlocacao;
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

    public String getTipoAlocacao() {
        return tipoAlocacao;
    }

    public void setTipoAlocacao(String tipoAlocacao) {
        this.tipoAlocacao = tipoAlocacao;
    }
}

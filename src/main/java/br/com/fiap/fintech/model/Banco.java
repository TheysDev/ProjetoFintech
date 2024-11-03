package br.com.fiap.fintech.model;

public class Banco {

    private String nomeBanco;
    private String numeroBanco;

    public Banco(String nomeBanco, String numeroBanco) {
        this.nomeBanco = nomeBanco;
        this.numeroBanco = numeroBanco;
    }

    public Banco() {}

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getNumeroBanco() {
        return numeroBanco;
    }

    public void setNumeroBanco(String numeroBanco) {
        this.numeroBanco = numeroBanco;
    }
}

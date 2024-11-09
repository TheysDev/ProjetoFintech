package br.com.fiap.fintech.model;

public class Carteira {

    private int idCarteira;
    private String nomeCarteira;
    private double saldoCarteira;

    private Usuario usuario;

    public Carteira(int idCarteira, String nomeCarteira, double saldoCarteira, Usuario usuario) {
        this.idCarteira = idCarteira;
        this.nomeCarteira = nomeCarteira;
        this.saldoCarteira = saldoCarteira;
        //this.usuario = usuario;
    }

    public Carteira() {}

    public int getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(int idCarteira) {
        this.idCarteira = idCarteira;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getSaldoCarteira() {
        return saldoCarteira;
    }

    public void setSaldoCarteira(double saldoCarteira) {
        this.saldoCarteira = saldoCarteira;
    }

    public String getNomeCarteira() {
        return nomeCarteira;
    }

    public void setNomeCarteira(String nomeCarteira) {
        this.nomeCarteira = nomeCarteira;
    }

    public int getIdUsuario() {
        return usuario.getIdUsuario();
    }
}

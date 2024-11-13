package br.com.fiap.fintech.model;

public class ContaBancaria {

    private int idConta;
    private String numeroConta;
    private String agencia;
    private double saldo;
    private String status;

    private Banco banco;
    private Usuario usuario;

    public ContaBancaria(int idConta, String numeroConta, String agencia, double saldo, Banco banco, Usuario usuario, String status) {
        this.idConta = idConta;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.banco = banco;
        this.usuario = usuario;
        this.status = status;
    }

    public ContaBancaria() {}

    public ContaBancaria(int idConta, String numeroConta, String agencia, double saldo, Banco banco) {
        this.idConta = idConta;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.banco = banco;
    }

    public ContaBancaria(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdUsuario() {
        return usuario.getIdUsuario();
    }

    public String getNumeroBanco() {
        return banco.getNumeroBanco();
    }

    public String getNomeBanco() {
        return banco.getNomeBanco();
    }

}

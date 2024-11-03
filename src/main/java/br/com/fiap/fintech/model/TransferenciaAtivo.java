package br.com.fiap.fintech.model;

public class TransferenciaAtivo {

    private int idTransferenciaAtivo;
    private double quantidadeAtivo;

    private MovimentacaoCarteira movimentacaoCarteira;
    private Ativo ativo;
    private Carteira carteira;

    public TransferenciaAtivo(int idTransferenciaAtivo, double quantidadeAtivo, MovimentacaoCarteira movimentacaoCarteira, Ativo ativo, Carteira carteira) {
        this.idTransferenciaAtivo = idTransferenciaAtivo;
        this.quantidadeAtivo = quantidadeAtivo;
        this.movimentacaoCarteira = movimentacaoCarteira;
        this.ativo = ativo;
        this.carteira = carteira;
    }

    public TransferenciaAtivo() {}

    public int getIdTransferenciaAtivo() {
        return idTransferenciaAtivo;
    }

    public void setIdTransferenciaAtivo(int idTransferenciaAtivo) {
        this.idTransferenciaAtivo = idTransferenciaAtivo;
    }

    public double getQuantidadeAtivo() {
        return quantidadeAtivo;
    }

    public void setQuantidadeAtivo(double quantidadeAtivo) {
        this.quantidadeAtivo = quantidadeAtivo;
    }

    public MovimentacaoCarteira getMovimentacaoCarteira() {
        return movimentacaoCarteira;
    }

    public void setMovimentacaoCarteira(MovimentacaoCarteira movimentacaoCarteira) {
        this.movimentacaoCarteira = movimentacaoCarteira;
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
}

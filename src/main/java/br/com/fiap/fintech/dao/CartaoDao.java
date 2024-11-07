package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.Cartao;

import java.util.List;

public interface CartaoDao {

    void cadastrarCartao(Cartao cartao);
    void alterarCartao(Cartao cartao);
    void excluirCartao(Cartao cartao);
    List<Cartao> listarCartao();
    Cartao buscarCartaoPorId(Integer id);
    void calcularValorDisponivel(double valorLimite, double valorGasto);
    void alterarStatusCartao(Cartao cartao);
}

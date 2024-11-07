package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.ParcelaTransacaoCartao;

public interface ParcelaTransacaoCartaoDao {

    void inserir(ParcelaTransacaoCartao parcelaTransacaoCartao);
    void excluir(ParcelaTransacaoCartao parcelaTransacaoCartao);
    ParcelaTransacaoCartao buscarPorId(int id);
}

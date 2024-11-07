package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.TransacaoCartao;

import java.util.List;

public interface TransacaoCartaoDao {

    void inserir(TransacaoCartao transacaoCartao);
    void excluir(TransacaoCartao transacaoCartao);
    void editar(TransacaoCartao transacaoCartao);
    List<TransacaoCartao> listar();
}

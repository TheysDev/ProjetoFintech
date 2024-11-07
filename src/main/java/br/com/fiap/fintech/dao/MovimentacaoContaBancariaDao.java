package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.MovimentacaoContaBancaria;

import java.util.List;

public interface MovimentacaoContaBancariaDao {

    void inserir(MovimentacaoContaBancaria movimentacao);
    void alterar(MovimentacaoContaBancaria movimentacao);
    void excluir(MovimentacaoContaBancaria movimentacao);
    List<MovimentacaoContaBancaria> listar();
}

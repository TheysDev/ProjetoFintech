package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.Movimentacao;

import java.util.List;

public interface MovimentacaoDao {

    void inserir(Movimentacao movimentacao);
    void alterar(Movimentacao movimentacao);
    void excluir(Movimentacao movimentacao);
    List<Movimentacao> listar();
}

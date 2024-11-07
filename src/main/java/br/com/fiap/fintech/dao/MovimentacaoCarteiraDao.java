package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.MovimentacaoCarteira;

import java.util.List;

public interface MovimentacaoCarteiraDao {

    void inserir(MovimentacaoCarteira movimentacaoCarteira);
    void alterar(MovimentacaoCarteira movimentacaoCarteira);
    void excluir(MovimentacaoCarteira movimentacaoCarteira);
    List<MovimentacaoCarteira> listar();
}

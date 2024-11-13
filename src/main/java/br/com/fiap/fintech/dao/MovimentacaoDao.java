package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.model.Movimentacao;

import java.sql.SQLException;
import java.util.List;

public interface MovimentacaoDao {

    void inserir(Movimentacao movimentacao) throws SQLException;
    void alterar(Movimentacao movimentacao) throws SQLException;
    void excluir(Movimentacao movimentacao) throws SQLException, EntidadeNaoEcontradaException;
    List<Movimentacao> listarDespesas() throws SQLException;
    List<Movimentacao> listarReceitas() throws SQLException;
    Movimentacao buscarPorId(int id) throws SQLException, EntidadeNaoEcontradaException;
}

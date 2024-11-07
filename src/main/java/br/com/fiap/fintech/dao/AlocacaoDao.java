package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.model.Alocacao;

import java.sql.SQLException;
import java.util.List;

public interface AlocacaoDao {

    void cadastrar(Alocacao alocacao) throws SQLException;
    void alterar(Alocacao alocacao) throws SQLException, EntidadeNaoEcontradaException;
    void excluir(Alocacao alocacao) throws SQLException;
    void consultar(Alocacao alocacao);
    List<Alocacao> listar();
}

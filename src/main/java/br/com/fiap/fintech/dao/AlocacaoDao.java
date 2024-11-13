package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.model.Alocacao;

import java.sql.SQLException;
import java.util.List;

public interface AlocacaoDao {

    void cadastrar(Alocacao alocacao) throws SQLException;
    void alterar(Alocacao alocacao) throws SQLException, EntidadeNaoEcontradaException;
    void excluir(Alocacao alocacao) throws SQLException;
    Alocacao buscarId(int id) throws SQLException;
    List<Alocacao> listarAlocReceita() throws SQLException;
    List<Alocacao> listarAlocDespesa() throws SQLException;

}

package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.model.Ativo;

import java.sql.SQLException;
import java.util.List;

public interface AtivoDao {

    void cadastrar(Ativo ativo) throws SQLException;
    void alterar(Ativo ativo) throws SQLException;
    void excluir(Ativo ativo) throws SQLException, EntidadeNaoEcontradaException;
    Ativo buscar(int id) throws SQLException, EntidadeNaoEcontradaException;
    List<Ativo> listar();
}

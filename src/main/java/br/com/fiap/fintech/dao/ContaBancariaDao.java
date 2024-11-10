package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.model.ContaBancaria;
import java.sql.SQLException;
import java.util.List;

public interface ContaBancariaDao {

    void cadastrar(ContaBancaria conta) throws SQLException;
    void alterar(ContaBancaria conta) throws SQLException;
    void desativar(ContaBancaria conta) throws SQLException;
    List<ContaBancaria> listar(int idUsuarioLogado) throws SQLException;
    ContaBancaria buscar(int id) throws SQLException, EntidadeNaoEcontradaException;
}

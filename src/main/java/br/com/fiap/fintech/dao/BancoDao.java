package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.model.Banco;

import java.sql.SQLException;
import java.util.List;

public interface BancoDao {

    void cadastrarBanco(Banco banco) throws SQLException;
    void alterarBanco(Banco banco) throws SQLException;
    void excluirBanco(Banco banco) throws SQLException, EntidadeNaoEcontradaException;
    Banco buscarBanco(String nrBanco) throws SQLException, EntidadeNaoEcontradaException;
    List<Banco> ListarBancos() throws SQLException;
}

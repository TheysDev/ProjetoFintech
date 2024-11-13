package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.model.Investimento;

import java.sql.SQLException;
import java.util.List;

public class OracleInvestimentoDao implements InvestimentoDao {
    @Override
    public void inserir(Investimento investimento) throws SQLException {

    }

    @Override
    public void alterar(Investimento investimento) throws SQLException {

    }

    @Override
    public void excluir(Investimento investimento) throws SQLException, EntidadeNaoEcontradaException {

    }

    @Override
    public List<Investimento> listarInvestimentos() throws SQLException {
        return List.of();
    }
}

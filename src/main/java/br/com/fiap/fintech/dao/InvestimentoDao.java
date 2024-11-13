package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.model.Investimento;
import java.sql.SQLException;
import java.util.List;

public interface InvestimentoDao {
    void inserir(Investimento investimento) throws SQLException;
    void alterar(Investimento investimento) throws SQLException;
    void excluir(Investimento investimento) throws SQLException, EntidadeNaoEcontradaException;
    List<Investimento> listarInvestimentos() throws SQLException;
}

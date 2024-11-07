package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.AlocacaoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Alocacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OracleAlocacaoDao implements AlocacaoDao {

    public Connection conexao;
    private PreparedStatement stm = null;

    public OracleAlocacaoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void cadastrar(Alocacao alocacao) throws SQLException {
        stm = conexao.prepareStatement("INSERT INTO T_FIN_ALOCACAO (id_alocacao, ds_alocacao) VALUES (SQ_FIN_ALOCACAO.NEXTVAL,?)");
        stm.setString(1,alocacao.getDescricaoAlocacao());
        stm.executeUpdate();
    }

    @Override
    public void alterar(Alocacao alocacao) throws SQLException, EntidadeNaoEcontradaException {
        stm = conexao.prepareStatement("UPDATE T_FIN_ALOCACAO SET ds_alocacao = ? WHERE id_alocacao = ? ");
        stm.setString(1,alocacao.getDescricaoAlocacao());
        int linha = stm.executeUpdate();
        if (linha == 0) {
            throw new EntidadeNaoEcontradaException("Cadastro não encontrado para ser removido");
        }
    }

    @Override
    public void excluir(Alocacao alocacao) throws SQLException {
        stm = conexao.prepareStatement("DELETE FROM T_FIN_ALOCACAO where id_alocacao = ?");
        stm.setString(1,alocacao.getDescricaoAlocacao());
    }

    @Override
    public void consultar(Alocacao alocacao) {
    }

    @Override
    public List<Alocacao> listar() {
        return List.of();
    }
}

package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.AlocacaoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Alocacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleAlocacaoDao implements AlocacaoDao {

    public Connection conexao;
    private PreparedStatement stm = null;

    public OracleAlocacaoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void cadastrar(Alocacao alocacao) throws SQLException {
        stm = conexao.prepareStatement("INSERT INTO T_FIN_ALOCACAO (id_alocacao, ds_alocacao) VALUES (SQ_FIN_ALOCACAO.NEXTVAL, ?)");
        stm.setString(1, alocacao.getDescricaoAlocacao());
        stm.executeUpdate();

        try {
            stm.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void alterar(Alocacao alocacao) throws SQLException, EntidadeNaoEcontradaException {
        stm = conexao.prepareStatement("UPDATE T_FIN_ALOCACAO SET ds_alocacao = ? WHERE id_alocacao = ? ");
        stm.setString(1,alocacao.getDescricaoAlocacao());
        int linha = stm.executeUpdate();
        if (linha == 0) {
            throw new EntidadeNaoEcontradaException("Cadastro não encontrado para ser removido");
        }
        try {
            stm.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void excluir(Alocacao alocacao) throws SQLException {

        stm = conexao.prepareStatement("DELETE FROM T_FIN_ALOCACAO where id_alocacao = ?");
        stm.setInt(1, alocacao.getIdAlocacao());
        stm.executeUpdate();

        try {
            stm.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Alocacao buscarId(int id) throws SQLException {

           Alocacao alocacao = null;
           ResultSet rs = null;

           stm = conexao.prepareStatement("SELECT * FROM T_FIN_ALOCACAO WHERE id_alocacao = ?");
           stm.setInt(1, id);
           rs = stm.executeQuery();
           if (rs.next()) {
               int idAlocacao = rs.getInt("id_alocacao");
               String descricaoAlocacao = rs.getString("ds_alocacao");
               alocacao = new Alocacao(idAlocacao, descricaoAlocacao);
           }
            try {
            stm.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            }

            return alocacao;
    }

    @Override
    public List<Alocacao> listar() throws SQLException {

        List<Alocacao> lista = new ArrayList<Alocacao>();
        ResultSet rs = null;

        stm = conexao.prepareStatement("SELECT * FROM T_FIN_ALOCACAO");
        rs = stm.executeQuery();

        while (rs.next()) {
            int id_alocacao = rs.getInt("id_alocacao");
            String ds_alocacao = rs.getString("ds_alocacao");
            Alocacao alocacao = new Alocacao(id_alocacao, ds_alocacao);
            lista.add(alocacao);
        }
        try {
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}

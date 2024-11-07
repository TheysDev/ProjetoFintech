package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.AtivoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Ativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OracleAtivoDao implements AtivoDao {

    public Connection conexao;
    PreparedStatement stm = null;

    public OracleAtivoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void cadastrar(Ativo ativo) throws SQLException {
        stm = conexao.prepareStatement("INSERT INTO T_FIN_ATIVO (ID_ATIVO, NM_ATIVO, DS_TIPO_ATIVO) VALUES (SQ_FIN_ATIVO.NEXTVAL, ?, ?)");
        stm.setString(1, ativo.getNomeAtivo());
        stm.setString(2, ativo.getDescricaoTipoAtivo());
        stm.executeUpdate();
    }

    @Override
    public void alterar(Ativo ativo) throws SQLException {
        stm = conexao.prepareStatement("UPDATE T_FIN_ATIVO SET nm_ativo = ?, ds_tipo_ativo = ? WHERE id_ativo = ?");
        stm.setString(1, ativo.getNomeAtivo());
        stm.setString(2, ativo.getDescricaoTipoAtivo());
        stm.setInt(3,ativo.getIdAtivo());

    }

    @Override
    public void excluir(Ativo ativo) throws SQLException, EntidadeNaoEcontradaException {
        stm = conexao.prepareStatement("DELETE FROM T_FIN_ATIVO WHERE id_ativo = ?");
        stm.setInt(1,ativo.getIdAtivo());
        int linha = stm.executeUpdate();
        if (linha == 0) {
            throw new EntidadeNaoEcontradaException("Cadastro não encontrado para ser removido");
        }
    }

    @Override
    public Ativo buscar(int id) throws SQLException, EntidadeNaoEcontradaException {
        stm = conexao.prepareStatement("SELECT * FROM T_FIN_ATIVO WHERE id_ativo = ?");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Ativo não encontrado");
        String idAtivo = result.getString("nr_banco");
        String tipoAtivo = result.getString("nm_banco");
        return new Ativo(id, idAtivo, tipoAtivo);
    }

    @Override
    public List<Ativo> listar() {
        return List.of();
    }

}

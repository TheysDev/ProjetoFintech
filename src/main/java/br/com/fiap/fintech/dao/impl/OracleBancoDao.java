package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.BancoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleBancoDao implements BancoDao {

    private Connection conexao = null;
    private PreparedStatement stm = null;

    public OracleBancoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();

    }

    @Override
    public void cadastrarBanco(Banco banco) throws SQLException {
        stm = conexao.prepareStatement("INSERT INTO T_FIN_BANCO (nr_banco, nm_banco) VALUES (?, ?)");
        stm.setString(1, banco.getNumeroBanco());
        stm.setString(2, banco.getNomeBanco());
        stm.executeUpdate();
    }

    @Override
    public void alterarBanco(Banco banco) throws SQLException {
        stm = conexao.prepareStatement("UPDATE T_FIN_BANCO SET nm_banco = ?");
        stm.setString(1, banco.getNomeBanco());
        stm.executeUpdate();
    }

    @Override
    public void excluirBanco(Banco banco) throws SQLException, EntidadeNaoEcontradaException{
        stm = conexao.prepareStatement("DELETE FROM T_FIN_BANCO WHERE nr_banco = ?");
        stm.setString(1, banco.getNumeroBanco());
        int linha = stm.executeUpdate();
        if (linha == 0) {
            throw new EntidadeNaoEcontradaException("Cadastro não encontrado para ser removido");
        }
    }

    @Override
    public Banco buscarBanco(String nrBanco) throws SQLException, EntidadeNaoEcontradaException {

        stm = conexao.prepareStatement("SELECT * FROM T_FIN_BANCO WHERE nr_banco = ?");
        stm.setString(1, nrBanco);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Banco não encontrado");
        String nr_banco = result.getString("nr_banco");
        String nomeBanco = result.getString("nm_banco");
        return new Banco(nomeBanco,nr_banco);
    }

    @Override
    public List<Banco> ListarBancos() throws SQLException {

        List<Banco> lista = new ArrayList<>();
        ResultSet rs = null;

        try {
            stm = conexao.prepareStatement("SELECT * FROM T_FIN_BANCO");
            rs = stm.executeQuery();

            while (rs.next()) {
                String nomeBanco = rs.getString("nm_banco");
                String nrBanco = rs.getString("nr_banco");
                Banco banco = new Banco(nomeBanco,nrBanco);
                lista.add(banco);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stm.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}

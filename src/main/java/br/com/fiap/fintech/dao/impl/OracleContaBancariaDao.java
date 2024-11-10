package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.BancoDao;
import br.com.fiap.fintech.dao.ContaBancariaDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Banco;
import br.com.fiap.fintech.model.ContaBancaria;
import br.com.fiap.fintech.model.Usuario;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleContaBancariaDao implements ContaBancariaDao {

    private PreparedStatement stm = null;
    private Connection conexao = null;

    public OracleContaBancariaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void cadastrar(ContaBancaria conta) throws SQLException {

        stm = conexao.prepareStatement("INSERT INTO T_FIN_CONTA_BANCARIA (id_conta, nr_banco, id_usuario, nr_conta, nr_agencia, nr_saldo, ds_status_conta)" +
                "VALUES (SQ_FIN_CONTA_BANCARIA.NEXTVAL, ?, ?, ?, ?, ?,)");
        stm.setString(1, conta.getNumeroBanco());
        stm.setInt(2, conta.getIdUsuario());
        stm.setString(3, conta.getNumeroConta());
        stm.setString(4, conta.getAgencia());
        stm.setDouble(5, conta.getSaldo());
        stm.setString(6, String.valueOf(conta.isStatus()));
        stm.executeUpdate();

        try {
            stm.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void alterar(ContaBancaria conta) throws SQLException {

        stm = conexao.prepareStatement("UPDATE T_FIN_CONTA_BANCARIA SET (nr_banco = ?, id_usuario = ?, nr_conta = ?, nr_agencia = ?, nr_saldo = ? WHERE id_conta = ?)");
        stm.setString(1, conta.getNumeroBanco());
        stm.setInt(2, conta.getIdUsuario());
        stm.setString(3, conta.getNumeroConta());
        stm.setString(4, conta.getAgencia());
        stm.setDouble(5, conta.getSaldo());
        stm.setInt(6, conta.getIdConta());
        stm.executeUpdate();

        try {
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void desativar(ContaBancaria conta) throws SQLException {

        stm = conexao.prepareStatement("UPDATE T_FIN_CONTA_BANCARIA SET ds_status = ?");
        stm.setString(1, String.valueOf(conta.isStatus()));
        stm.executeUpdate();

        try {
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<ContaBancaria> listar(int idUsuarioLogado) throws SQLException {

        List<ContaBancaria> lista = new ArrayList<>();
        ResultSet rs = null;


        String sql = "SELECT T_FIN_CONTA_BANCARIA.id_conta, T_FIN_CONTA_BANCARIA.nr_conta, T_FIN_CONTA_BANCARIA.nr_agencia, T_FIN_CONTA_BANCARIA.nr_saldo, T_FIN_CONTA_BANCARIA.nr_banco, T_FIN_BANCO.nm_banco " +
                "FROM T_FIN_CONTA_BANCARIA " +
                "INNER JOIN T_FIN_BANCO ON T_FIN_CONTA_BANCARIA.nr_banco = T_FIN_BANCO.nr_banco " +
                "WHERE T_FIN_CONTA_BANCARIA.ds_status_conta = 'Ativo' AND T_FIN_CONTA_BANCARIA.id_usuario = ?";

        stm = conexao.prepareStatement(sql);
        stm.setInt(1, idUsuarioLogado);
        rs = stm.executeQuery();

        while (rs.next()) {
            int idConta = rs.getInt("id_conta");
            String numeroConta = rs.getString("nr_conta");
            String agencia = rs.getString("nr_agencia");
            double saldo = rs.getDouble("nr_saldo");
            String numeroBanco = rs.getString("nr_banco");
            String nomeBanco = rs.getString("nm_banco");

            ContaBancaria conta = new ContaBancaria(idConta, numeroConta, agencia, saldo, numeroBanco, nomeBanco);
            lista.add(conta);
        }
        try {
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public ContaBancaria buscar(int id) throws SQLException, EntidadeNaoEcontradaException {
        stm = conexao.prepareStatement("SELECT * FROM T_FIN_CONTA_BANCARIA WHERE id_conta = ?");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Conta Bancaria não encontrada");

        int idConta = result.getInt("id_conta");
        String numeroBanco = result.getString("nr_banco");
        String numeroConta = result.getString("nr_conta");
        String agencia = result.getString("nr_agencia");
        double saldo = result.getDouble("nr_saldo");

        BancoDao dao = DaoFactory.getBancoDao();
        Banco banco = dao.buscarBanco(numeroBanco);

        return new ContaBancaria(idConta, numeroConta, agencia, saldo, banco);
    }

}



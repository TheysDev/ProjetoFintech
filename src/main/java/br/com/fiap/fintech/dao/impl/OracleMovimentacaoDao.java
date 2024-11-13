package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.AlocacaoDao;
import br.com.fiap.fintech.dao.ContaBancariaDao;
import br.com.fiap.fintech.dao.MovimentacaoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Alocacao;
import br.com.fiap.fintech.model.Banco;
import br.com.fiap.fintech.model.ContaBancaria;
import br.com.fiap.fintech.model.Movimentacao;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OracleMovimentacaoDao implements MovimentacaoDao {

    private Connection conexao = null;
    private PreparedStatement stm = null;

    public OracleMovimentacaoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Movimentacao movimentacao) throws SQLException {

        stm = conexao.prepareStatement("INSERT INTO T_FIN_MOVIMENTACAO (id_movimentacao, id_conta, id_alocacao, nr_valor_total, dt_movimentacao, dt_criada_em, ds_tipo_mov)" +
                "VALUES (SQ_FIN_MOVIMENTACAO.NEXTVAL, ?, ?, ?, ?, ?, ?)");

        stm.setInt(1, movimentacao.getIdConta());
        stm.setInt(2, movimentacao.getIdAlocacao());
        stm.setDouble(3, movimentacao.getValorMovimentacao());
        stm.setDate(4, Date.valueOf(movimentacao.getDataMovimentacao()));
        stm.setDate(5, Date.valueOf(movimentacao.getDataCriacaoMovimentacao()));
        stm.setString(6, movimentacao.getTipoMovimentacao());
        stm.executeUpdate();

        try {
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void alterar(Movimentacao movimentacao) throws SQLException {

        stm = conexao.prepareStatement("UPDATE T_FIN_MOVIMENTACAO SET id_conta = ?, id_alocacao = ?, nr_valor_total = ?, dt_movimentacao = ?, dt_atualizada_em = ?, ds_tipo_mov = ?" +
                "WHERE id_movimentacao = ?");

        stm.setInt(1, movimentacao.getIdConta());
        stm.setInt(2, movimentacao.getIdAlocacao());
        stm.setDouble(3, movimentacao.getValorMovimentacao());
        stm.setDate(4, Date.valueOf(movimentacao.getDataMovimentacao()));
        stm.setDate(5, Date.valueOf(movimentacao.getDataAtualizacaoMovimentacao()));
        stm.setString(6, movimentacao.getTipoMovimentacao());
        stm.setInt(7, movimentacao.getIdMovimentacao());
        stm.executeUpdate();

        try {
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void excluir(Movimentacao movimentacao) throws SQLException, EntidadeNaoEcontradaException {

        stm = conexao.prepareStatement("DELETE FROM T_FIN_MOVIMENTACAO WHERE id_movimentacao = ?");
        stm.setInt(1,movimentacao.getIdMovimentacao());
        int linha = stm.executeUpdate();
        if (linha == 0) {
            throw new EntidadeNaoEcontradaException("Cadastro não encontrado para ser removido");
        }
        try {
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Movimentacao> listarDespesas() throws SQLException {


        List<Movimentacao> lista = new ArrayList<Movimentacao>();
        ResultSet rs = null;

        stm = conexao.prepareStatement("SELECT T_FIN_ALOCACAO.ds_alocacao, T_FIN_MOVIMENTACAO.dt_movimentacao, T_FIN_CONTA_BANCARIA.nr_conta, T_FIN_MOVIMENTACAO.nr_valor_total, T_FIN_MOVIMENTACAO.id_movimentacao " +
                "FROM T_FIN_MOVIMENTACAO INNER JOIN T_FIN_ALOCACAO ON T_FIN_ALOCACAO.id_alocacao = T_FIN_MOVIMENTACAO.id_alocacao INNER JOIN T_FIN_CONTA_BANCARIA ON T_FIN_CONTA_BANCARIA.id_conta = T_FIN_MOVIMENTACAO.id_conta " +
                "WHERE ds_tipo_mov = 'DESPESA'");
        rs = stm.executeQuery();

        while (rs.next()) {
            String nomeAlocacao = rs.getString("ds_alocacao");
            String dataMov = rs.getString("dt_movimentacao").split(" ")[0];
            String numeroConta = rs.getString("nr_conta");
            double valor = rs.getDouble("nr_valor_total");
            int idMov = rs.getInt("id_movimentacao");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dataMov, formatter);

            Movimentacao mov = new Movimentacao(idMov,nomeAlocacao, date, numeroConta, valor);
            lista.add(mov);

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
    public Movimentacao buscarPorId(int id) throws SQLException, EntidadeNaoEcontradaException {


        stm = conexao.prepareStatement("SELECT * FROM T_FIN_MOVIMENTACAO WHERE id_movimentacao = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Despesa não encontrada");
        int idMov = result.getInt("id_movimentacao");
        int idConta = result.getInt("id_conta");
        int idAlocacao = result.getInt("id_alocacao");
        double valor = result.getDouble("nr_valor_total");
        String dataMov = result.getString("dt_movimentacao").split(" ")[0];
        String tipoMov = result.getString("ds_tipo_mov");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dataMov, formatter);

        AlocacaoDao alocacaodao = DaoFactory.getAlocacaoDao();
        Alocacao alocacao = alocacaodao.buscarId(idAlocacao);

        ContaBancariaDao contabancariaDao = DaoFactory.getContaBancariaDao();
        ContaBancaria contaBancaria = contabancariaDao.buscar(idConta);

        return new Movimentacao(idMov, valor, date, tipoMov, contaBancaria, alocacao);

    }


}

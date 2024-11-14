package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.AtivoDao;
import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Ativo;
import br.com.fiap.fintech.model.Investimento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class OracleInvestimentoDao implements InvestimentoDao {

    private Connection conexao = null;
    private PreparedStatement stm = null;

    public OracleInvestimentoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }


    @Override
    public void cadastrar(Investimento investimento) throws SQLException {

        stm = conexao.prepareStatement("INSERT INTO T_FIN_INVESTIMENTO (id_invest, id_ativo, nr_valor, dt_criada_em, ds_tipo_inv) VALUES (SQ_FIN_INVESTIMENTO.NEXTVAL,?,?,?,?)");

        stm.setInt(1, investimento.getIdAtivo());
        stm.setDouble(2, investimento.getValorInvest());
        stm.setDate(3, Date.valueOf(investimento.getDtCriadoEm()));
        stm.setString(4,investimento.getTipoInvest());
        System.out.println(investimento.getTipoInvest());
        stm.executeUpdate();

        try {
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void alterar(Investimento investimento) throws SQLException {

    }

    @Override
    public void excluir(Investimento investimento) throws SQLException, EntidadeNaoEcontradaException {

    }

    @Override
    public List<Investimento> listarInvestimentos() throws SQLException, EntidadeNaoEcontradaException {

        List<Investimento> lista = new ArrayList<Investimento>();
        ResultSet rs = null;

        stm = conexao.prepareStatement("SELECT * FROM T_FIN_INVESTIMENTO");
        rs = stm.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id_invest");
            int idAtivo = rs.getInt("id_ativo");
            double valorInvest = rs.getDouble("nr_valor");
            LocalDate dtCriadoEm = rs.getDate("dt_criada_em").toLocalDate();
            String tipoInvest = rs.getString("ds_tipo_inv");

            AtivoDao ativoDao = DaoFactory.getAtivoDao();
            Ativo ativo = ativoDao.buscar(idAtivo);
            System.out.println("Investimento: " + tipoInvest + " - Ativo: " + ativo.getNomeAtivo());
            Investimento investimento = new Investimento(id, valorInvest, dtCriadoEm, tipoInvest, ativo );
            lista.add(investimento);
        }
        return lista;
    }

    @Override
    public Investimento buscarInvestimentoPorId(Integer id) throws SQLException {

        return null;
    }
}

package br.com.fiap.fintech.dao.impl;


import br.com.fiap.fintech.dao.CarteiraAtivoDao;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Carteira;
import br.com.fiap.fintech.model.CarteiraAtivo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OracleCarteiraAtivoDao implements CarteiraAtivoDao{

    private Connection conexao = null;
    private PreparedStatement stm = null;

    public OracleCarteiraAtivoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(CarteiraAtivo carteiraAtivo) throws SQLException {
        stm = conexao.prepareStatement("INSERT INTO T_FIN_CARTEIRA_ATIVO (id_carteira_ativo, id_carteira, id_ativo, nr_quantidade_total, nr_valor_medio_compra, dt_ultima_atualizacao) " +
                                        "VALUES (SQ_FIN_CARTEIRA_ATIVO.nextval,?,?,?,?,?)");

        stm.setInt(1,carteiraAtivo.getIdCarteira());
        stm.setInt(2,carteiraAtivo.getIdAtivo());
        stm.setDouble(3, carteiraAtivo.getQuantidadeAtivo());
        stm.setDouble(4, carteiraAtivo.getValorMedioAtivo());
        stm.setDate(5, Date.valueOf(carteiraAtivo.getDataUltimaAtualizacao()));
        stm.executeUpdate();

    }

    @Override
    public void alterar(CarteiraAtivo carteiraAtivo) throws SQLException {
        stm = conexao.prepareStatement("UPDATE T_FIN_CARTEIRA_ATIVO SET id_carteira = ?, id_ativo = ?, nr_quantidade_total ?, nr_valor_medio_compra ?, dt_ultima_atualizacao = ? WHERE id_carteira_ativo = ?");
        stm.setInt(1,carteiraAtivo.getIdCarteira());
        stm.setInt(2,carteiraAtivo.getIdAtivo());
        stm.setDouble(3, carteiraAtivo.getQuantidadeAtivo());
        stm.setDouble(4, carteiraAtivo.getValorMedioAtivo());
        stm.setDate(5, Date.valueOf(carteiraAtivo.getDataUltimaAtualizacao()));
        stm.setInt(6, carteiraAtivo.getIdCarteiraAtivo());
        stm.executeUpdate();
    }

    @Override
    public void excluir(CarteiraAtivo carteiraAtivo) {

    }

    @Override
    public List<CarteiraAtivo> listar() {
        return List.of();
    }
}




package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.CarteiraDao;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Carteira;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OracleCarteiraDao implements CarteiraDao {

    private Connection conexao = null;
    private PreparedStatement stm = null;

    public OracleCarteiraDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void cadastrar(Carteira carteira) throws SQLException {
        stm = conexao.prepareStatement("INSERT INTO T_FIN_CARTEIRA (id_carteira, id_usuario, nm_carteira, nr_saldo_total) VALUES (SQ_FIN_CARTEIRA.NEXTVAL, ?, ?, ?)");
        stm.setInt(1,carteira.getIdUsuario());
        stm.setString(2,carteira.getNomeCarteira());
        stm.setDouble(3,carteira.getSaldoCarteira());
        stm.executeUpdate();
        stm.close();
    }

    @Override
    public void alterar(Carteira carteira) {

    }

    @Override
    public void excluir(Carteira carteira) {

    }

    @Override
    public Carteira buscarIdCarteira(int id) {
        return null;
    }

    @Override
    public List<Carteira> listarCarteira() {
        return List.of();
    }
}

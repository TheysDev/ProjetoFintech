package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.Carteira;

import java.sql.SQLException;
import java.util.List;

public interface CarteiraDao {

    void cadastrar(Carteira carteira) throws SQLException;
    void alterar(Carteira carteira);
    void excluir(Carteira carteira);
    Carteira buscarIdCarteira(int id);
    List<Carteira> listarCarteira();
}

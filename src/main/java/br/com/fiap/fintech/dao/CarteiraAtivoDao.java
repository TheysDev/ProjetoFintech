package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.CarteiraAtivo;

import java.sql.SQLException;
import java.util.List;

public interface CarteiraAtivoDao {

    void inserir(CarteiraAtivo carteiraAtivo) throws SQLException;
    void alterar(CarteiraAtivo carteiraAtivo) throws SQLException;
    void excluir(CarteiraAtivo carteiraAtivo);
    List<CarteiraAtivo> listar();
}

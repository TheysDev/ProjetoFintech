package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.model.Usuario;

import java.sql.SQLException;

public interface UsuarioDao {

    void cadastrar(Usuario usuario) throws SQLException;
    void alterar(Usuario usuario) throws SQLException;
    void desativar(Usuario usuario) throws SQLException;
    boolean validarLogin(Usuario usuario) throws Exception;
    Usuario buscarId(int id) throws SQLException, EntidadeNaoEcontradaException;
}

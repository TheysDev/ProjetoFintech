package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.UsuarioDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.util.CriptografiaUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleUsuarioDao implements UsuarioDao {

    Connection conexao = null;
    PreparedStatement stm = null;

    public OracleUsuarioDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void cadastrar(Usuario usuario) throws SQLException {
        System.out.println(conexao);
        stm = conexao.prepareStatement("INSERT INTO T_FIN_USUARIO (id_usuario, nm_usuario, nr_cpf, ds_email, nm_completo, ds_senha, ds_status) VALUES " +
                "(1, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, usuario.getNomeUsuario());
        stm.setString(2, usuario.getCpfUsuario());
        stm.setString(3, usuario.getEmailUsuario());
        stm.setString(4, usuario.getNomeCompletoUsuario());
        stm.setString(5, usuario.getSenhaUsuario());
        stm.setString(6, String.valueOf(usuario.getStatusUsuario()));
        stm.executeUpdate();
    }

    @Override
    public void alterar(Usuario usuario) throws SQLException {
        stm = conexao.prepareStatement("UPDATE T_FIN_USUARIO SET nm_usuario = ?, nr_cpf = ?, ds_email = ?, nm_completo = ?, ds_senha = ?");
        stm.setString(1, usuario.getNomeUsuario());
        stm.setString(2, usuario.getCpfUsuario());
        stm.setString(3, usuario.getEmailUsuario());
        stm.setString(4, usuario.getNomeCompletoUsuario());
        stm.setString(5, usuario.getSenhaUsuario());
        stm.executeUpdate();

    }

    @Override
    public void desativar(Usuario usuario) throws SQLException {
        stm = conexao.prepareStatement("UPDATE T_FIN_USUARIO SET ds_status = ?");
        stm.setString(1, String.valueOf(usuario.getStatusUsuario()));
        stm.executeUpdate();


    }

    @Override
    public boolean validarLogin(Usuario usuario) throws Exception {

        ResultSet rs = null;
        stm = conexao.prepareStatement("SELECT * FROM T_FIN_USUARIO WHERE ds_email = ? AND ds_senha = ?");

        stm.setString(1, usuario.getEmailUsuario());
        stm.setString(2, CriptografiaUtils.criptografar(usuario.getSenhaUsuario()));

        rs = stm.executeQuery();

        if (rs.next()) {
            usuario.setIdUsuario(rs.getInt("id_usuario"));
            return true;
        }

        try {
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Usuario buscarId(int id) throws SQLException, EntidadeNaoEcontradaException {
        stm = conexao.prepareStatement("SELECT id_usuario, nm_usuario FROM T_FIN_USUARIO WHERE id_usuario = ?");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Usuario não encontrado");

        int idUsuario = result.getInt("id_usuario");
        String nomeUsuario = result.getString("nm_usuario");


        return new Usuario(idUsuario, nomeUsuario);
    }
}

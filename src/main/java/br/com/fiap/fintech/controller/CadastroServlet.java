package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.UsuarioDao;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.util.CriptografiaUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/cadastrar")
public class CadastroServlet extends HttpServlet {

    private UsuarioDao dao;

    public CadastroServlet()  {
        try {
            dao = DaoFactory.getUsuarioDao();
            System.out.println("dao ok");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String usuario = req.getParameter("usuario");
            String cpf = req.getParameter("cpf");
            String email = req.getParameter("email");
            String nome = req.getParameter("nome");
            String senha = req.getParameter("senha");

            String statusString = req.getParameter("status");
            boolean status = Boolean.parseBoolean(statusString);


            String senhaCrip = CriptografiaUtils.criptografar(senha);

            Usuario user = new Usuario(1, usuario, cpf, email, nome, senhaCrip, status);

            dao.cadastrar(user);


            req.setAttribute("mensagem", "Usuário cadastrado com sucesso!");
            req.getRequestDispatcher("cadastro.jsp").forward(req, resp);

        } catch (SQLException e) {

            e.printStackTrace();
            req.setAttribute("mensagem", "Erro ao cadastrar o usuário");
            req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
        } catch (Exception e) {

            throw new RuntimeException("Erro inesperado: " + e.getMessage(), e);
        }
    }
}


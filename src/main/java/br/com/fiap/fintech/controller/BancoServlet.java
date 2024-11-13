package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.BancoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Banco;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/banco")
public class BancoServlet extends HttpServlet {

    private BancoDao bancoDao;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            bancoDao = DaoFactory.getBancoDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "cadastrar":
                try {
                    cadastrarBanco(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "excluir":
                try {
                    excluirBanco(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void excluirBanco(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        String numeroBanco = req.getParameter("numeroBanco");

        Banco banco = bancoDao.buscarBanco(numeroBanco);
        bancoDao.excluirBanco(banco);

        req.getRequestDispatcher("gerenciador").forward(req, resp);
    }

    private void cadastrarBanco(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        String nome = req.getParameter("nome");
        String numero = req.getParameter("numero");

        Banco banco = new Banco(nome, numero);

        bancoDao.cadastrarBanco(banco);

        req.setAttribute("banco", banco);
        req.getRequestDispatcher("gerenciador").forward(req, resp);
    }
}

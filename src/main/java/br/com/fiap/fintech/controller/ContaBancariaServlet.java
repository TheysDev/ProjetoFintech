package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.ContaBancariaDao;
import br.com.fiap.fintech.factory.DaoFactory;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/contaBancaria")
public class ContaBancariaServlet extends HttpServlet {

    private ContaBancariaDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            dao = DaoFactory.getContaBancariaDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "cadastrar":
                cadastrar(req, resp);
                break;
            case "editar":
                editar(req, resp);
                break;
            case "excluir":
                excluir(req, resp);
        }
    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) {

        String numeroConta = req.getParameter("numeroConta");
        String numeroAgencia = req.getParameter("numeroAgencia");


    }


}

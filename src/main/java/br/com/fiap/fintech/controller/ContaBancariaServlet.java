package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.BancoDao;
import br.com.fiap.fintech.dao.ContaBancariaDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Banco;
import br.com.fiap.fintech.model.ContaBancaria;
import br.com.fiap.fintech.model.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/contaBancaria")
public class ContaBancariaServlet extends HttpServlet {

    private ContaBancariaDao dao;
    private BancoDao bancoDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            dao = DaoFactory.getContaBancariaDao();
            bancoDao = DaoFactory.getBancoDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "cadastrar":
                try {
                    cadastrar(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "editar":
                editar(req, resp);
                break;
            case "alterarStatus":
                try {
                    desativar(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
            case "ativar":
                try {
                    ativar(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void ativar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("idContaAtivar"));

        ContaBancaria contaBancaria= dao.buscar(id);
        contaBancaria.setStatus("Ativo");

        dao.alterarStatus(contaBancaria);
        req.setAttribute("contaBancaria", contaBancaria);

        req.getRequestDispatcher("gerenciador").forward(req, resp);
    }

    private void desativar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("idContaDesativar"));

        ContaBancaria contaBancaria= dao.buscar(id);
        contaBancaria.setStatus("Inativa");

        dao.alterarStatus(contaBancaria);
        req.setAttribute("contaBancaria", contaBancaria);

        req.getRequestDispatcher("gerenciador").forward(req, resp);

    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        String numeroConta = req.getParameter("numeroConta");
        String numeroAgencia = req.getParameter("numeroAgencia");
        double saldoConta = Double.parseDouble(req.getParameter("saldoConta"));
        String numeroBanco = req.getParameter("numeroBanco");
        String status = req.getParameter("status");

        try {
            Banco banco = bancoDao.buscarBanco(numeroBanco);
            ContaBancaria contaBancaria = new ContaBancaria(0, numeroConta, numeroAgencia, saldoConta, banco, usuario, status);
            dao.cadastrar(contaBancaria);
            req.setAttribute("contaBancaria", contaBancaria);
            req.getRequestDispatcher("gerenciador").forward(req, resp);


        } catch (SQLException | EntidadeNaoEcontradaException e) {
            throw new RuntimeException(e);

        }

    }
}

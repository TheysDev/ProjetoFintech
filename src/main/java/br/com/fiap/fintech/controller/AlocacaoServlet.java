package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.AlocacaoDao;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Alocacao;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/alocacao")
public class AlocacaoServlet extends HttpServlet {

    private AlocacaoDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            dao = DaoFactory.getAlocacaoDao();
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
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "excluir":
                try {
                    excluir(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        System.out.println("entrou na servlet certa");

        int id = Integer.parseInt(req.getParameter("idAlocacao"));

        System.out.println("id do alocacao: " + id);

        Alocacao alocacao = dao.buscarId(id);
        System.out.println(alocacao);

        dao.excluir(alocacao);

        req.setAttribute("msg", "Excluido com sucesso");
        req.getRequestDispatcher("movimentacao?acao=form-alocacao").forward(req, resp);
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        String descricao = req.getParameter("descricao");

        Alocacao alocacao = new Alocacao(0, descricao);

        dao.cadastrar(alocacao);

        req.setAttribute("alocacao", alocacao);

        req.getRequestDispatcher("movimentacao?acao=form-alocacao").forward(req, resp);


    }
}

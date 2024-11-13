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

        int id = Integer.parseInt(req.getParameter("idAlocacao"));

        Alocacao alocacao = dao.buscarId(id);

        dao.excluir(alocacao);

        req.getRequestDispatcher("gerenciador").forward(req, resp);
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {


        String descricao = req.getParameter("descricao");
        String tipoAlocacao = req.getParameter("tipoAlocacao");

        Alocacao alocacao = new Alocacao(0, descricao, tipoAlocacao);

        dao.cadastrar(alocacao);

        req.setAttribute("alocacao", alocacao);

        req.getRequestDispatcher("gerenciador").forward(req, resp);


    }
}

package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.AlocacaoDao;
import br.com.fiap.fintech.dao.AtivoDao;
import br.com.fiap.fintech.dao.ContaBancariaDao;
import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {

    private InvestimentoDao investDao;
    private AtivoDao ativoDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            investDao = DaoFactory.getInvestimentoDao();
            ativoDao = DaoFactory.getAtivoDao();
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
        }
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
    }


    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        double valor = Double.parseDouble(req.getParameter("valor").replace(',','.'));
        LocalDate data = LocalDate.parse(req.getParameter("data"));
        String tipoInvest = req.getParameter("tipoInvest");
        int idAtivo = Integer.parseInt(req.getParameter("ativo"));

        Ativo ativo = ativoDao.buscar(idAtivo);

        Investimento investimento = new Investimento(0, valor, data, tipoInvest, ativo);
        investDao.cadastrar(investimento);

        req.setAttribute("investimento", investimento);
        listar(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "form-investimento":
                try {
                    listar(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException, EntidadeNaoEcontradaException {

        List<Ativo> listaAtivo = ativoDao.listar();
        List<Investimento> listaInvest = investDao.listarInvestimentos();

        req.setAttribute("invest", listaInvest);
        req.setAttribute("ativo", listaAtivo);
        req.getRequestDispatcher("/investimentos.jsp").forward(req, resp);

    }
}
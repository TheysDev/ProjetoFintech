package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.AlocacaoDao;
import br.com.fiap.fintech.dao.ContaBancariaDao;
import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Alocacao;
import br.com.fiap.fintech.model.ContaBancaria;
import br.com.fiap.fintech.model.Investimento;
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
import java.time.LocalDate;
import java.util.List;

@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {

    private InvestimentoDao investDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            investDao = DaoFactory.getInvestimentoDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "cadastrarDespesas":
                try {
                    cadastrarDespesas(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "editarDespesas":
                editarDespesas(req, resp);
                break;
        }
    }

    private void editarDespesas(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void cadastrarDespesas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        String valor = req.getParameter("valor").replace(',','.');
        String dataDespesa = req.getParameter("dataDespesa");
        String idAlocacao = req.getParameter("alocacao");
        String idConta = req.getParameter("conta");
        String tipoMov = req.getParameter("tipoMov");

        double valorDespesa = Double.parseDouble(valor);
        LocalDate dataDespesaLocalDate = LocalDate.parse(dataDespesa);

        int id = Integer.parseInt(idConta);

        int idIntAlocacao = Integer.parseInt(idAlocacao);

        //Investimento investimento = new Investimento(0, valorDespesa, dataDespesaLocalDate, tipoMov, contaBancaria, alocacao);

        //movDao.inserir(investimento);

        listarDadosDespesas(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "form-receitas":
                listarDadosReceitas(req, resp);
                break;
            case "form-investi":
                try {
                    listarDadosDespesas(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void listarDadosReceitas(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void listarDadosDespesas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        //List<Alocacao> lista = alocDao.listar();

        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        int idUsuarioLogado = usuario.getIdUsuario();

        //List<ContaBancaria> listaConta = contaBancDao.listar(idUsuarioLogado);
        //List<Investimento> listarDespesas = investDao.listarDespesas();

        //req.setAttribute("alocacao", lista);
        //req.setAttribute("conta", listaConta);
        //req.setAttribute("despesas", listarDespesas);
        req.getRequestDispatcher("/despesas.jsp").forward(req, resp);

    }
}
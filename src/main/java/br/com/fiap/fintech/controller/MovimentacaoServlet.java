package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.AlocacaoDao;
import br.com.fiap.fintech.dao.ContaBancariaDao;
import br.com.fiap.fintech.dao.MovimentacaoDao;
import br.com.fiap.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Alocacao;
import br.com.fiap.fintech.model.ContaBancaria;
import br.com.fiap.fintech.model.Movimentacao;
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

@WebServlet("/movimentacao")
public class MovimentacaoServlet extends HttpServlet {

    private MovimentacaoDao movDao;
    private AlocacaoDao alocDao;
    private ContaBancariaDao contaBancDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            movDao = DaoFactory.getMovimentacaoDao();
            alocDao = DaoFactory.getAlocacaoDao();
            contaBancDao = DaoFactory.getContaBancariaDao();
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

    private void cadastrarDespesas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException {

        String valor = req.getParameter("valor");
        String dataDespesa = req.getParameter("dataDespesa");
        String idAlocacao = req.getParameter("alocacao");
        String idConta = req.getParameter("conta");
        String tipoMov = req.getParameter("tipoMov");

        double valorDespesa = Double.parseDouble(valor);
        LocalDate dataDespesaLocalDate = LocalDate.parse(dataDespesa);

        int id = Integer.parseInt(idConta);

        int idIntAlocacao = Integer.parseInt(idAlocacao);


        ContaBancaria contaBancaria = contaBancDao.buscar(id);

        Alocacao alocacao = alocDao.buscarId(idIntAlocacao);

        Movimentacao movimentacao = new Movimentacao(0, valorDespesa, dataDespesaLocalDate, tipoMov, contaBancaria, alocacao);

        movDao.inserir(movimentacao);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "listar":
                break;
            case "form-depesas":
                try {
                    listarDados(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void listarDados(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        List<Alocacao> lista = alocDao.listar();

        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        int idUsuarioLogado = usuario.getIdUsuario();

        List<ContaBancaria> listaConta = contaBancDao.listar(idUsuarioLogado);

        List<Movimentacao> listarDespesas = movDao.listarDespesas();

        req.setAttribute("alocacao", lista);
        req.setAttribute("conta", listaConta);
        req.setAttribute("despesas", listarDespesas);
        req.getRequestDispatcher("/despesas.jsp").forward(req, resp);

    }
}

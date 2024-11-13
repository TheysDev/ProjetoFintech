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
import org.jetbrains.annotations.NotNull;

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
            case "despesas":
                try {
                    despesas(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "editar-despesas":
                try {
                    editarDespesas(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }

            case "receitas":
                    receitas(req, resp);

                break;
            case "excluir":
                try {
                    excluirMov(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
        }
    }



    private void excluirMov(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {


        int id = Integer.parseInt(req.getParameter("id"));

        Movimentacao movimentacao = movDao.buscarPorId(id);

        movDao.excluir(movimentacao);

        listarDadosDespesas(req, resp);
    }

    private void receitas(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void editarDespesas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        Movimentacao movimentacao = dadosDespesas(req);
        movimentacao.setIdMovimentacao(Integer.parseInt(req.getParameter("idMov")));

        movDao.alterar(movimentacao);

        listarDadosDespesas(req, resp);

    }

    private void despesas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        Movimentacao movimentacao = dadosDespesas(req);

        movDao.inserir(movimentacao);

        listarDadosDespesas(req, resp);

    }

    @NotNull
    private Movimentacao dadosDespesas(HttpServletRequest req) throws SQLException, EntidadeNaoEcontradaException {

        String valor = req.getParameter("valor").replace(',','.');
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

        return new Movimentacao(0, valorDespesa, dataDespesaLocalDate, tipoMov, contaBancaria, alocacao);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "form-receitas":
                listarDadosReceitas(req, resp);
                break;
            case "form-despesas":
                try {
                    listarDadosDespesas(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "form-despesas-editar":
                int id = Integer.parseInt(req.getParameter("id"));
                try {
                    Movimentacao movimentacao = movDao.buscarPorId(id);
                    List<Movimentacao> listar = movDao.listarDespesas();
                    req.setAttribute("despesa", movimentacao);
                    req.setAttribute("listdespesa", listar);
                    dadosDespesa(req, resp);
                    req.getRequestDispatcher("/editar-despesa.jsp").forward(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void listarDadosReceitas(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void listarDadosDespesas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {


        dadosDespesa(req,resp);

        List<Movimentacao> listarDespesas = movDao.listarDespesas();
        req.setAttribute("despesas", listarDespesas);

        try {
            req.getRequestDispatcher("despesas.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro durante o forward: " + e.getMessage());
        }

    }

    private void dadosDespesa(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
//        HttpSession session = req.getSession();
//
//        Usuario usuario = (Usuario) session.getAttribute("usuario");
//
//        int idUsuarioLogado = usuario.getIdUsuario();

        List<Alocacao> lista = alocDao.listar();
        List<ContaBancaria> listaConta = contaBancDao.listar(1);

        req.setAttribute("alocacao", lista);
        req.setAttribute("conta", listaConta);

    }
}

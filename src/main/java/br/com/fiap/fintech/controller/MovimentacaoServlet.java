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
import java.util.ArrayList;
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
            case "editar-despesa":
                try {
                    editarDespesa(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "editar-receita":
                try {
                    editarReceita(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }

            case "cadastrarReceitas":
                try {
                    cadastrarReceitas(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "excluir-despesa":
                try {
                    excluirDespesas(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "excluir-receita":
                try {
                    excluirReceita(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }

        }
    }

    private void excluirReceita(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Movimentacao movimentacao = movDao.buscarPorId(id);

        movDao.excluir(movimentacao);

        listarDadosReceitas(req, resp);
    }

    private void excluirDespesas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Movimentacao movimentacao = movDao.buscarPorId(id);

        movDao.excluir(movimentacao);

        listarDadosDespesas(req, resp);
    }

    private void cadastrarReceitas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        Movimentacao movimentacao = dadosMov(req);

        movDao.inserir(movimentacao);

        listarDadosReceitas(req, resp);
    }

    private void editarReceita(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        Movimentacao movimentacao = dadosMov(req);
        movimentacao.setIdMovimentacao(Integer.parseInt(req.getParameter("idMov")));

        movDao.alterar(movimentacao);

        listarDadosReceitas(req, resp);

    }

    private void editarDespesa(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        Movimentacao movimentacao = dadosMov(req);
        movimentacao.setIdMovimentacao(Integer.parseInt(req.getParameter("idMov")));

        movDao.alterar(movimentacao);

        listarDadosDespesas(req, resp);

    }

    private void cadastrarDespesas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        Movimentacao movimentacao = dadosMov(req);

        movDao.inserir(movimentacao);

        listarDadosDespesas(req, resp);

    }

    @NotNull
    private Movimentacao dadosMov(HttpServletRequest req) throws SQLException, EntidadeNaoEcontradaException {

        String valor = req.getParameter("valor").replace(',', '.');
        String data = req.getParameter("data");
        String idAlocacao = req.getParameter("alocacao");
        String idConta = req.getParameter("conta");
        String tipoMov = req.getParameter("tipoMov");

        double valorDespesa = Double.parseDouble(valor);
        LocalDate dataDespesaLocalDate = LocalDate.parse(data);

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
                try {
                    listarDadosReceitas(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "form-receitas-editar":
                int idReceita = Integer.parseInt(req.getParameter("id"));
                try {
                    Movimentacao movimentacao = movDao.buscarPorId(idReceita);
                    List<Movimentacao> listar = movDao.listarReceitas();
                    req.setAttribute("receita", movimentacao);
                    req.setAttribute("listreceita", listar);
                    dadosUser(req, resp);
                    req.getRequestDispatcher("/editar-receitas.jsp").forward(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "form-despesas":
                try {
                    listarDadosDespesas(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
            case "form-despesas-editar":
                int idDespesa = Integer.parseInt(req.getParameter("id"));
                try {
                    Movimentacao movimentacao = movDao.buscarPorId(idDespesa);
                    List<Movimentacao> listar = movDao.listarDespesas();
                    req.setAttribute("despesa", movimentacao);
                    req.setAttribute("listdespesa", listar);
                    dadosUser(req, resp);
                    req.getRequestDispatcher("/editar-despesa.jsp").forward(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "dashboard":
                try {
                    dadosDashboard(req, resp);
                } catch (SQLException | EntidadeNaoEcontradaException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void dadosDashboard(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException, ServletException, IOException {

        dadosUser(req, resp);

        List<Movimentacao> listarReceitas = movDao.listarReceitas();
        List<Movimentacao> listarDespesas = movDao.listarDespesas();
        List<Movimentacao> listaCompleta = new ArrayList<>(listarDespesas);
        listaCompleta.addAll(listarReceitas);
        List<Alocacao> listaAloc = alocDao.listarAlocReceita();
        req.setAttribute("alocacao", listaAloc);
        req.setAttribute("movimentacao",listaCompleta);

        try {
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro durante o forward: " + e.getMessage());
        }

    }

    private void listarDadosReceitas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException {

        dadosUser(req, resp);

        List<Movimentacao> listarReceitas = movDao.listarReceitas();
        List<Alocacao> lista = alocDao.listarAlocReceita();
        req.setAttribute("alocacao", lista);
        req.setAttribute("receitas", listarReceitas);

        try {
            req.getRequestDispatcher("receitas.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro durante o forward: " + e.getMessage());
        }
    }

    private void listarDadosDespesas(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException, EntidadeNaoEcontradaException {

        dadosUser(req, resp);

        List<Movimentacao> listarDespesas = movDao.listarDespesas();
        List<Alocacao> lista = alocDao.listarAlocDespesa();
        req.setAttribute("alocacao", lista);
        req.setAttribute("despesas", listarDespesas);

        try {
            req.getRequestDispatcher("despesas.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro durante o forward: " + e.getMessage());
        }

    }

    private void dadosUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, EntidadeNaoEcontradaException {

        HttpSession session = req.getSession();

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        int idUsuarioLogado = usuario.getIdUsuario();

        List<ContaBancaria> listaConta = contaBancDao.listar(idUsuarioLogado);

        req.setAttribute("conta", listaConta);

    }
}

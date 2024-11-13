package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.*;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/gerenciador")
public class GerenciadorServlet extends HttpServlet {

    private ContaBancariaDao contaBancariaDao;
    private BancoDao bancoDao;
    private AlocacaoDao alocacaoDao;
    private AtivoDao ativoDao;
    private UsuarioDao usuarioDao;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            alocacaoDao = DaoFactory.getAlocacaoDao();
            bancoDao = DaoFactory.getBancoDao();
            contaBancariaDao = DaoFactory.getContaBancariaDao();
            ativoDao = DaoFactory.getAtivoDao();
            usuarioDao = DaoFactory.getUsuarioDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
//            HttpSession session = req.getSession();
//
//            Usuario usuario = (Usuario) session.getAttribute("usuario");
//
//            int idUsuarioLogado = usuario.getIdUsuario();

            List<ContaBancaria> listaConta = contaBancariaDao.listar(1);
            List<Alocacao> listaAlocacaoDespesa = alocacaoDao.listarAlocDespesa();
            List<Alocacao> listaAlocacaoReceita = alocacaoDao.listarAlocReceita();
            List<Alocacao> listaAlocacaoCompleta = new ArrayList<>();
            listaAlocacaoCompleta.addAll(listaAlocacaoDespesa);
            listaAlocacaoCompleta.addAll(listaAlocacaoReceita);
            List<Banco> listaBanco = bancoDao.ListarBancos();
            List<Ativo> listaAtivo = ativoDao.listar();

            req.setAttribute("conta", listaConta);
            req.setAttribute("alocacao", listaAlocacaoCompleta);
            req.setAttribute("banco", listaBanco);
            req.setAttribute("ativo", listaAtivo);

            req.getRequestDispatcher("gerenciar-conta.jsp").forward(req, resp);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entro no post");
        try{
//            HttpSession session = req.getSession();
//
//            Usuario usuario = (Usuario) session.getAttribute("usuario");
//
//            int idUsuarioLogado = usuario.getIdUsuario();

            List<ContaBancaria> listaConta = contaBancariaDao.listar(1);
            List<Alocacao> listaAlocacaoDespesa = alocacaoDao.listarAlocDespesa();
            List<Alocacao> listaAlocacaoReceita = alocacaoDao.listarAlocReceita();
            List<Alocacao> listaAlocacaoCompleta = new ArrayList<>();
            listaAlocacaoCompleta.addAll(listaAlocacaoDespesa);
            listaAlocacaoCompleta.addAll(listaAlocacaoReceita);
            List<Banco> listaBanco = bancoDao.ListarBancos();
            List<Ativo> listaAtivo = ativoDao.listar();

            req.setAttribute("conta", listaConta);
            req.setAttribute("alocacao", listaAlocacaoCompleta);
            req.setAttribute("banco", listaBanco);
            req.setAttribute("ativo", listaAtivo);

            req.getRequestDispatcher("gerenciar-conta.jsp").forward(req, resp);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

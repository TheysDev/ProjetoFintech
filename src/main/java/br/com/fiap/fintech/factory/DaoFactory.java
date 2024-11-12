package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.*;
import br.com.fiap.fintech.dao.impl.*;

import java.sql.SQLException;

public class DaoFactory {

    public static AlocacaoDao getAlocacaoDao() throws SQLException {
        return new OracleAlocacaoDao();
    }

    public static AtivoDao getAtivoDao() throws SQLException {
        return new OracleAtivoDao();
    }

    public static BancoDao getBancoDao() throws SQLException {
        return new OracleBancoDao();
    }


    public static UsuarioDao getUsuarioDao() throws SQLException {
        return new OracleUsuarioDao();
    }

    public static MovimentacaoDao getMovimentacaoDao() throws SQLException {
        return new OracleMovimentacaoDao();
    }

    public static ContaBancariaDao getContaBancariaDao() throws SQLException {
        return new OracleContaBancariaDao();
    }

    public static InvestimentoDao getInvestimentoDao() throws SQLException {
        return new OracleInvestimentoDao();
    }
}

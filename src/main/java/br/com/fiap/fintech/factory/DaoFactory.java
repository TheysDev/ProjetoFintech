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

    public static CarteiraAtivoDao getCarteiraAtivoDao() throws SQLException {
        return new OracleCarteiraAtivoDao();
    }

    public static CarteiraDao getCarteiraDao() throws SQLException {
        return new OracleCarteiraDao();
    }

    public static UsuarioDao getUsuarioDao() throws SQLException {
        return new OracleUsuarioDao();
    }
}

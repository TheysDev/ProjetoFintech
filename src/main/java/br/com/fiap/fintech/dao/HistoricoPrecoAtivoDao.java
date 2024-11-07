package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.HistoricoPrecoAtivo;
import java.util.List;

public interface HistoricoPrecoAtivoDao {

    void inserir(HistoricoPrecoAtivo historicoPrecoAtivo);
    List<HistoricoPrecoAtivo> listar();
}

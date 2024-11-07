package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.FaturaCartao;

import java.time.LocalDate;
import java.util.List;

public interface FaturaCartaoDao {

    void cadastrar(FaturaCartao faturaCartao);
    void alterar(FaturaCartao faturaCartao);
    void excluir(FaturaCartao faturaCartao);
    List<FaturaCartao> listar();
    FaturaCartao buscarPorMes(LocalDate dataMesReferencia);
}

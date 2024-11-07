package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.TransferenciaAtivo;

import java.util.List;

public interface TransferenciaAtivoDao {

    void inserir(TransferenciaAtivo transferenciaAtivo);
    void alterar(TransferenciaAtivo transferenciaAtivo);
    void excluir(TransferenciaAtivo transferenciaAtivo);
    List<TransferenciaAtivo> listar();
}

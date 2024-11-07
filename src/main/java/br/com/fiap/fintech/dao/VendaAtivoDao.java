package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.VendaAtivo;

import java.util.List;

public interface VendaAtivoDao {

    void cadastrar(VendaAtivo vendaAtivo);
    void alterar(VendaAtivo vendaAtivo);
    void excluir(VendaAtivo vendaAtivo);
    List<VendaAtivo> listar();
}

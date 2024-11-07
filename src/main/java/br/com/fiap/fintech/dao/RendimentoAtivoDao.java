package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.RendimentoAtivo;

import java.util.List;

public interface RendimentoAtivoDao {

    void inserir(RendimentoAtivo rendimentoAtivo);
    void alterar(RendimentoAtivo rendimentoAtivo);
    void excluir(RendimentoAtivo rendimentoAtivo);
    List<RendimentoAtivo> listar();
}

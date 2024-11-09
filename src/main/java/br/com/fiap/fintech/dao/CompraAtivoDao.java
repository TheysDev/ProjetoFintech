package br.com.fiap.fintech.dao;

import java.util.List;

public interface CompraAtivoDao {

    void cadastrar(CompraAtivoDao compra);
    void alterar(CompraAtivoDao compra);
    void excluir(CompraAtivoDao compra);
    List<CompraAtivoDao> listar();
}

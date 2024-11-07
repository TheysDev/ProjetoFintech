package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.ContaBancaria;
import java.util.List;

public interface ContaBancariaDao {

    void cadastrar(ContaBancaria conta);
    void alterar(ContaBancaria conta);
    void excluir(ContaBancaria conta);
    ContaBancaria consultarPorId(int id);
    List<ContaBancaria> listar();
}

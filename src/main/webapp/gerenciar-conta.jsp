<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastros</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="resources/css/despesas.css">
    <link rel="stylesheet" href="resources/css/estilos.css">
</head>

<body>

<%@include file="menu.jsp" %>

<%@include file="menuOff.jsp" %>


<div class="d-flex flex-column flex-lg-row flex-xl-row espaco-top ">

    <div class="d-flex flex-column align-items-center espaco tamanho largura ">
        <div class="titulo text-center d-none d-xl-block">
            <h4>Gerenciando Conta</h4>
        </div>
        <div class="d-flex flex-column flex-lg-row gap-2 w-100 justify-content-center">
            <div class="card card-custom align-items-center col-12 col-lg-4 scroll2">

                <div class="text-center">
                    <h5 class="cor-azul">Cadastrar Banco</h5>
                </div>
                <div>
                    <div class="d-flex flex-column gap-3">
                        <form action="banco?acao=cadastrar" method="post">
                            <div class="mt-3">
                                <label for="nomeBanco" class="form-label">
                                    <h6 class="negrito">Nome:</h6>
                                </label>
                                <input type="text" name="nome" class="form-control input-custom" id="nomeBanco"
                                       placeholder="Nubanck">
                            </div>
                            <div class="mt-3">
                                <label for="numBanco" class="form-label">
                                    <h6 class="negrito">Número:</h6>
                                </label>
                                <input type="text" name="numero" class="form-control input-custom" id="numBanco"
                                       placeholder="260">
                            </div>
                            <div class="d-flex gap-2">
                                <button type="submit" class="btn btn-sm btn-outline-primary btn-cadastro">Cadastrar
                                </button>
                                <button type="submit" class="btn btn-sm btn-outline-secondary btn-cadastro">Cancelar
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="text-center mt-5">
                    <h5 class="cor-azul">Cadastrar Conta Bancária</h5>
                </div>
                <div>
                    <div class="d-flex flex-column gap-3 ">
                        <form action="contaBancaria?acao=cadastrar" method="post">
                            <div class="mt-3">
                                <label for="numConta" class="form-label">
                                    <h6 class="negrito">Número da Conta:</h6>
                                </label>
                                <input type="text" name="numeroConta" class="form-control input-custom" id="numConta"
                                       placeholder="0000">
                            </div>
                            <div class="mt-3">
                                <label for="numAgencia" class="form-label">
                                    <h6 class="negrito">Número da Agência:</h6>
                                </label>
                                <input type="text" name="numeroAgencia" class="form-control input-custom"
                                       id="numAgencia"
                                       placeholder="1234">
                            </div>
                            <div class="mt-3 mb-2">
                                <label for="saldoConta" class="form-label">
                                    <h6 class="negrito">Saldo da Conta:</h6>
                                </label>
                                <input type="text" name="saldoConta" class="form-control input-custom" id="saldoConta"
                                       placeholder="R$ 5.000,00">
                            </div>
                            <div class="mt-3 ">
                                <label for="numBancoRemover" class="form-label">
                                    <h6 class="negrito">Número do Banco:</h6>
                                </label>
                                <input type="text" name="numeroBanco" class="form-control input-custom"
                                       placeholder="260">
                            </div>
                            <input type="hidden" name="status" value="Ativo">
                            <div class="d-flex gap-2">
                                <button type="submit" class="btn btn-sm btn-outline-primary btn-cadastro">Cadastrar
                                </button>
                                <button type="submit" class="btn btn-sm btn-outline-secondary btn-cadastro">Cancelar
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="text-center mt-5">
                    <h5 class="text-danger">Remover Banco</h5>
                </div>
                <div>
                    <div class="d-flex flex-column gap-3">
                        <form action="banco?acao=excluir" method="post">
                            <div class="mt-3 ">
                                <label for="numBancoRemover" class="form-label">
                                    <h6 class="negrito">Número do Banco:</h6>
                                </label>
                                <input type="text" name="numeroBanco" class="form-control input-custom"
                                       id="numBancoRemover" placeholder="260">
                            </div>
                            <div class="d-flex gap-2">
                                <button type="submit" class="btn btn-sm btn-outline-danger btn-cadastro">Remover
                                </button>
                                <button type="submit" class="btn btn-sm btn-outline-secondary btn-cadastro">Cancelar
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="text-center mt-5">
                    <h5 class="text-danger">Desativar Conta Bancária</h5>
                </div>
                <form action="contaBancaria?acao=desativar" method="post">
                    <div class="mb-4">
                        <div class=" mt-3 mb-4">
                            <div class="btn-group d-flex align-items-center">
                                <h6 class="negrito me-2">Conta:</h6>
                                <select name="idContaDesativar" class="form-control">
                                    <option value="" disabled selected>Selecione uma opção...</option>
                                    <c:forEach items="${conta}" var="c">
                                        <option value="${c.idConta}">${c.numeroConta} - ${c.nomeBanco}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="d-flex gap-2">
                            <button type="submit" class="btn btn-sm btn-outline-danger btn-cadastro">Desativar</button>
                            <button type="submit" class="btn btn-sm btn-outline-secondary btn-cadastro">Cancelar
                            </button>
                        </div>
                    </div>
                </form>
                <div class="text-center mt-5">
                    <h5 class="text-danger">Ativar Conta Bancária</h5>
                </div>
                <form>
                    <div class="mb-4">
                        <div class=" mt-3 mb-4">
                            <div class="btn-group d-flex align-items-center">
                                <h6 class="negrito me-2">Conta:</h6>
                                <select name="idContaAtivar" class="form-control">
                                    <option value="" disabled selected>Selecione uma opção...</option>
                                    <c:forEach items="${conta}" var="conta">
                                        <c:if test="${conta.status == 'Inativa'}">
                                            <option value="${conta.idConta}">${conta.numeroConta}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="d-flex gap-2">
                            <button type="submit" class="btn btn-sm btn-outline-danger btn-cadastro">Ativar</button>
                            <button type="submit" class="btn btn-sm btn-outline-secondary btn-cadastro">Cancelar
                            </button>
                        </div>
                    </div>
                </form>


            </div>
            <div class="card card-custom align-items-center col-12 col-lg-4 scroll2">

                <div class="text-center">
                    <h5 class="cor-azul">Cadastrar Ativo</h5>
                </div>
                <div>
                    <div class="d-flex flex-column gap-3">
                        <form>
                            <div class="mt-3">
                                <label for="nomeAtivo" class="form-label">
                                    <h6 class="negrito">Nome:</h6>
                                </label>
                                <input type="text" class="form-control input-custom" id="nomeAtivo"
                                       placeholder="CDB">
                            </div>
                            <div class="mt-3">
                                <label for="numDescricaoAtivo" class="form-label">
                                    <h6 class="negrito">Descrição:</h6>
                                </label>
                                <input type="text" class="form-control input-custom" id="numDescricaoAtivo"
                                       placeholder="Ação">
                            </div>
                        </form>
                        <div class="d-flex gap-2">
                            <button type="submit"
                                    class="btn btn-sm btn-outline-primary btn-cadastro">Cadastrar
                            </button>
                            <button type="submit"
                                    class="btn btn-sm btn-outline-secondary btn-cadastro">Cancelar
                            </button>
                        </div>
                    </div>
                </div>

                <div class="text-center mt-5">
                    <h5 class="cor-azul">Cadastrar Alocação</h5>
                </div>
                <div>
                    <div class="d-flex flex-column gap-3 ">
                        <form action="alocacao?acao=cadastrar" method="post">
                            <div class="mt-3">
                                <label for="nomeAlocação" class="form-label">
                                    <h6 class="negrito">Descrição:</h6>
                                </label>
                                <input type="text" class="form-control input-custom" name="descricao" id="nomeAlocação"
                                       placeholder="Aluguel">
                                <select name="tipoAlocacao" class="form-control">
                                    <option value="" disabled selected>Selecione uma opção...</option>
                                    <option value="DESPESA">Despesa</option>
                                    <option value="RECEITA">Receita</option>
                                </select>
                            </div>
                            <div class="d-flex gap-2">
                                <button type="submit" class="btn btn-sm btn-outline-secondary btn-cadastro">Cadastrar
                                </button>
                                <a href="gerenciador" class="btn btn-sm btn-outline-primary btn-cadastro">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="text-center mt-5 mb-2">
                    <h5 class="text-success">Editar Ativo</h5>
                </div>
                <div>
                    <div class="d-flex flex-column gap-3">
                        <form>

                            <div class="d-flex flex-column mt-1 mb-4">
                                <div class="btn-group d-flex align-items-center">

                                    <h6 class="negrito me-2">Ativo:</h6>

                                    <form action="">
                                        <select id="opcoes" name="opcoes" class="form-control">
                                            <option value="" disabled selected>Selecione uma opção...</option>
                                        </select>
                                    </form>
                                </div>
                            </div>

                            <div class="mt-3">
                                <label for="editarAtivo" class="form-label">
                                    <h6 class="negrito">Nome:</h6>
                                </label>
                                <input type="text" class="form-control input-custom" id="editarAtivo"
                                       placeholder="CDB">
                            </div>
                            <div class="mt-3">
                                <label for="numDescricaoAtivo" class="form-label">
                                    <h6 class="negrito">Descrição:</h6>
                                </label>
                                <input type="text" class="form-control input-custom" id="numDescricaoAtivo"
                                       placeholder="Ação">
                            </div>
                        </form>
                        <div class="d-flex gap-2">
                            <button type="submit"
                                    class="btn btn-sm btn-outline-success btn-cadastro">Confirmar
                            </button>
                            <button type="submit"
                                    class="btn btn-sm btn-outline-secondary btn-cadastro">Cancelar
                            </button>
                        </div>
                    </div>
                </div>

                <div class="text-center mt-5">
                    <h5 class="text-danger">Remover Alocação</h5>
                </div>
                <form action="alocacao?acao=excluir" method="post">
                    <div class="mb-4">
                        <div class="d-flex flex-column mt-1 mb-4">
                            <div class="btn-group d-flex align-items-center">
                                <h6 class="negrito me-2">Alocação:</h6>
                                <select name="idAlocacao" class="form-control">
                                    <option value="" disabled selected>Selecione uma opção...</option>
                                    <c:forEach items="${alocacao}" var="a">
                                        <option value="${a.idAlocacao}">${a.descricaoAlocacao}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="d-flex gap-2">
                            <button type="submit" class="btn btn-sm btn-outline-danger btn-cadastro">Remover</button>
                            <button type="submit" class="btn btn-sm btn-outline-secondary btn-cadastro">Cancelar
                            </button>
                        </div>
                    </div>
                </form>

            </div>
            <div class="card card-custom align-items-center col-12 col-lg-4 scroll2">

                <div class="text-center">
                    <h5 class="text-success">Editar Login</h5>
                </div>
                <div>
                    <div class="d-flex flex-column gap-3">
                        <form>
                            <div class="mt-3">
                                <label for="nomeCompleto" class="form-label">
                                    <h6 class="negrito">Nome Completo:</h6>
                                </label>
                                <input type="text" class="form-control input-custom" id="nomeCompleto"
                                       placeholder="Matheus da Silva">
                            </div>
                            <div class="mt-4">
                                <label for="numCPF" class="form-label">
                                    <h6 class="negrito">CPF:</h6>
                                </label>
                                <input type="text" class="form-control input-custom" id="numCPF"
                                       placeholder="000.000.000-00">
                            </div>
                            <div class="mt-4">
                                <label for="email" class="form-label">
                                    <h6 class="negrito">Email:</h6>
                                </label>
                                <input type="email" class="form-control input-custom" id="email"
                                       placeholder="exemplo@email.com">
                            </div>
                            <div class="mt-4">
                                <label for="usuario" class="form-label">
                                    <h6 class="negrito">Usuário:</h6>
                                </label>
                                <input type="text" class="form-control input-custom" id="usuario"
                                       placeholder="pessoa123">
                            </div>
                            <div class="mt-4">
                                <label for="senha" class="form-label">
                                    <h6 class="negrito">Senha:</h6>
                                </label>
                                <input type="password" class="form-control input-custom" id="senha"
                                       placeholder="senha123">
                            </div>
                            <div class="mt-4">
                                <label for="confirmaSenha" class="form-label">
                                    <h6 class="negrito">Confirmar Senha:</h6>
                                </label>
                                <input type="password" class="form-control input-custom" id="confirmaSenha"
                                       placeholder="senha123">
                            </div>
                        </form>
                        <div class="d-flex gap-2">
                            <button type="submit"
                                    class="btn btn-sm btn-outline-success btn-cadastro">Confirmar
                            </button>
                            <button type="submit"
                                    class="btn btn-sm btn-outline-secondary btn-cadastro">Cancelar
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</div>

</body>

</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Receitas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="resources/css/despesas.css">
    <link rel="stylesheet" href="resources/css/estilos.css">
</head>

<body>

<nav class="navbar bg-body-tertiary fixed-top d-block d-xl-none position-fixed top-0 borda-bottom">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <h4>Receitas</h4>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
             aria-labelledby="offcanvasNavbarLabel">
            <div class="offcanvas-header">
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <form class="d-flex flex-column aling-items-center offcanvas-body" role="search">
                <div>
                    <div class="d-flex justify-content-center">
                        <img src="resources/img/cash-controller-logo.png" alt="" class="logo-sidebar">
                    </div>
                    <li class="lista-sem-pontos">
                        <a href="dashboard.jsp" class="link-custom">
                            <h4>Dashboard</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="#" class="link-custom ativado">
                            <h4>Receitas</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="movimentacao?acao=form-despesas" class="link-custom">
                            <h4>Despesas</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="investimento?acao=form-investimento" class="link-custom">
                            <h4>Investimentos</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="gerenciador" class="link-custom">
                            <h4>Gerenciar Conta</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="login.jsp" class="link-sair">
                            <h4>Sair</h4>
                        </a>
                    </li>
                </div>
            </form>
        </div>
    </div>
    </div>
</nav>

<div class="offcanvas offcanvas-start show container card d-flex flex-column  align-items-center col-3 position-fixed start-0 sidebar-custom d-none d-xl-block "
     tabindex="-1" id="offcanvas" aria-labelledby="offcanvasLabel" data-bs-backdrop="false" data-bs-scroll="true">
    <div class="d-flex justify-content-center">
        <img src="resources/img/cash-controller-logo.png" alt="" class="logo-sidebar mt-4">
    </div>
    <li class="lista-sem-pontos mt-4">
        <a href="dashboard.jsp" class="fw-bold link-custom fs-5">Dashboard</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="#" class="fw-bold link-custom ativado fs-5">Receitas</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="movimentacao?acao=form-despesas" class="fw-bold link-custom fs-5">Despesas</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="investimento?acao=form-investimento" class="fw-bold link-custom fs-5">Investimentos</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="gerenciador" class="fw-bold link-custom fs-5">Gerenciar Conta</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="login.jsp" class="fw-bold link-sair fs-5 ">Sair</a>
    </li>
</div>

<div class="d-flex flex-column flex-lg-row flex-xl-row espaco-top ">

    <div class="d-flex flex-column align-items-center espaco tamanho largura ">
        <div class="titulo text-center d-none d-xl-block">
            <h4>Receitas</h4>
        </div>
        <div class="d-flex flex-column flex-lg-row gap-3 w-100 justify-content-center">
            <div class="card card-custom align-items-center card-menor col-12 col-lg-4 scroll2">

                <div class="text-center">
                    <h5 class="cor-azul">Cadastrar Nova Receita</h5>
                </div>
                <form action="movimentacao?acao=cadastrarReceitas" method="post">
                    <div>
                        <div class="d-flex flex-column gap-4 mt-4">
                            <div class="mt-2">
                                <label for="valor" class="form-label">
                                    <h6 class="negrito">Valor:</h6>
                                </label>
                                <input type="text" name="valor" class="form-control input-custom" id="valor"  placeholder="R$ 1.000,00">
                            </div>
                            <div class="mt-1">
                                <label for="data" class="form-label">
                                    <h6 class="negrito">Data:</h6>
                                </label>
                                <input type="date" name="data" class="form-control input-custom" id="data">
                            </div>
                            <div class="d-flex flex-column mt-2 mb-4">
                                <h6 class="negrito">Alocação:</h6>
                                <div class="btn-group">
                                    <select name="alocacao" id="id-alocacao" class="form-control">
                                        <option value="0">Selecione</option>
                                        <c:forEach items="${alocacao}" var="c">
                                            <option value="${c.idAlocacao}">${c.descricaoAlocacao}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="d-flex flex-column mt-4 mb-4">
                                    <h6 class="negrito">Conta Bancária:</h6>
                                    <select name="conta" id="id-conta" class="form-control">
                                        <option value="0">Selecione</option>
                                        <c:forEach items="${conta}" var="c">
                                            <option value="${c.idConta}">${c.numeroConta} - ${c.nomeBanco}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <input type="hidden" name="tipoMov" value="RECEITA">
                        </div>
                        <div class="d-flex mt-auto gap-4">
                            <button type="submit" class="btn btn-limpar ">Limpar</button>
                            <button type="submit" class="btn btn-criar ">Criar</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="d-flex flex-column align-items-center card card-custom card-maior col-12 col-lg-8">
                <h4 class="cor-azul">Histórico</h4>
                <div class="scroll">
                    <table class="table table-hover text-center ">
                        <thead>
                        <tr>
                            <th scope="col">Alocação</th>
                            <th scope="col">Data</th>
                            <th scope="col">Numero Conta.</th>
                            <th scope="col">Valor</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${receitas}" var="r">
                            <tr>
                                <td class="text-primary">${r.getDescricaoAlocacao()}</td>
                                <td class="text-center">
                                    <fmt:parseDate
                                            value="${r.dataMovimentacao}" pattern="yyyy-MM-dd" var="dataFmt"/>
                                    <fmt:formatDate value="${dataFmt}" pattern="dd/MM/yyyy"/>
                                </td>
                                <td>${r.getNumeroConta()}</td>
                                <td class="text-sucess">
                                    R$ <fmt:formatNumber
                                        value="${r.valorMovimentacao}"/>
                                </td>
                                <td class="text-danger">
                                    <form action="movimentacao?acao=form-receitas-editar" method="get">
                                        <input type="hidden" name="acao" value="form-receitas-editar">
                                        <input type="hidden" name="id" value="${r.idMovimentacao}">
                                        <input type="submit" value="Editar" class="btn btn-primary">
                                    </form>
                                </td>
                                <td>
                                    <form action="movimentacao?acao=excluir-receita" method="post">
                                        <input type="hidden" name="id" value="${r.idMovimentacao}"
                                               class="btn btn-danger">
                                        <input type="submit" name="excluir" value="Excluir" class="btn btn-danger">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</div>
</body>
</html>

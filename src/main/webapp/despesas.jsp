<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Despesas</title>
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
            <h4>Despesas</h4>
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
            <form class="d-flex flex-column aling-items-center mt-3 offcanvas-body" role="search">
                <div>
                    <div class="d-flex justify-content-center">
                        <img src="resources/img/cash-controller-logo.png" alt="" class="logo-sidebar mt-5">
                    </div>
                    <li class="lista-sem-pontos mt-5">
                        <a href="#" class="link-custom">
                            <h4>Dashboard</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="#" class="link-custom">
                            <h4>Receitas</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="movimentacao?acao=form-depesas" class="link-custom ativado">
                            <h4>Despesas</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="#" class="link-custom">
                            <h4>Investimentos</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="#" class="link-custom">
                            <h4>Cadastros</h4>
                        </a>
                    </li>
                    <li class="lista-sem-pontos mt-1">
                        <a href="#" class="link-sair">
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
        <a href="#" class="fw-bold link-custom fs-5">Dashboard</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="#" class="fw-bold link-custom fs-5">Receitas</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="movimentacao?acao=form-depesas" class="fw-bold link-custom ativado fs-5">Despesas</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="#" class="fw-bold link-custom fs-5">Investimentos</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="#" class="fw-bold link-custom fs-5">Cadastros</a>
    </li>
    <li class="lista-sem-pontos mt-1">
        <a href="#" class="fw-bold link-sair fs-5 ">Sair</a>
    </li>
</div>

<div class="d-flex flex-column flex-lg-row flex-xl-row espaco-top ">

    <div class="d-flex flex-column align-items-center espaco tamanho largura ">
        <div class="titulo text-center d-none d-xl-block">
            <h4>Controle de Despesas</h4>
        </div>
        <div class="d-flex flex-column flex-lg-row gap-3 w-100 justify-content-center">
            <div class="card card-custom align-items-center card-menor col-12 col-lg-4">

                <div class="text-center">
                    <h5 class="cor-azul">Cadastrar Nova Despesa</h5>
                </div>
                <div>
                    <form action="movimentacao?acao=cadastrarDespesas" method="post">
                        <div class="d-flex flex-column gap-4 mt-4">
                            <div class="mt-2">
                                <label for="valorDespesa" class="form-label">
                                    <h6>Valor:</h6>
                                </label>
                                <input type="text" name="valor" class="form-control input-custom" id="valorDespesa"
                                       placeholder="R$ 1.000,00">
                            </div>
                            <div class="mt-2 ">
                                <label for="dataDespesa" class="form-label">
                                    <h6>Data:</h6>
                                </label>
                                <input type="date" name="dataDespesa" class="form-control input-custom"
                                       id="dataDespesa">
                            </div>
                            <div class="d-flex flex-column mt-2 mb-4">
                                <h6>Alocação</h6>
                                <div class="btn-group">
                                    <select name="alocacao" id="id-alocacao" class="form-control">
                                        <option value="0">Selecione</option>
                                        <c:forEach items="${alocacao}" var="c">
                                            <option value="${c.idAlocacao}">${c.descricaoAlocacao}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="d-flex flex-column mt-2 mb-4">
                                    <h6>Conta Bancária:</h6>
                                    <div class="btn-group form-group">
                                        <select name="conta" id="id-conta" class="form-control">
                                            <option value="0">Selecione</option>
                                            <c:forEach items="${conta}" var="c">
                                                <option value="${c.idConta}">${c.numeroConta} - ${c.nomeBanco}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <input type="hidden" name="tipoMov" value="DESPESA">
                            </div>
                            <div class="d-flex mt-auto gap-4">
                                <button type="button" class="btn btn-limpar ">Limpar</button>
                                <button type="submit" class="btn btn-criar ">Criar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="d-flex flex-column align-items-center card card-custom card-maior col-12 col-lg-8">
                <h5 class="cor-azul">Historico de Despesas</h5>
                <div class="scroll">
                    <table class="table table-hover text-center ">
                        <thead>
                        <tr>
                            <th scope="col">Alocacao</th>
                            <th scope="col">Data</th>
                            <th scope="col">Numero Conta</th>
                            <th scope="col">Valor</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${despesas}" var="d">
                            <tr>
                                <td class="text-primary">${d.nomeAlocacao}</td>
                                <td class="text-center">
                                    <fmt:parseDate
                                        value="${d.dataMovimentacao}" pattern="yyyy-MM-dd" var="dataFmt"/>
                                    <fmt:formatDate value="${dataFmt}" pattern="dd/MM/yyyy"/>
                                       </td>
                                <td>123456</td>
                                <td class="text-danger">
                                    <fmt:formatNumber
                                            value = "${d.valorMovimentacao}"/>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Escolha uma ação</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Fechar"></button>
                                </div>
                                <div class="modal-body">
                                    Selecione a ação que deseja realizar.
                                </div>
                                <div class="modal-footer d-flex justify-content-center">
                                    <button type="button" class="btn btn-danger">Excluir</button>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#modalEditar">Editar
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="modalEditar" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Editando Despesa:</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <div class="mt-4">
                                            <label for="nome" class="form-label">
                                                <h6>Descrição:</h6>
                                            </label>
                                            <input type="text" class="form-control input-custom" id="nome"
                                                   placeholder="Aluguel">
                                        </div>
                                        <div>
                                            <div class="d-flex flex-column gap-4 mt-4">
                                                <div class="mt-2">
                                                    <label for="valor" class="form-label">
                                                        <h6>Valor:</h6>
                                                    </label>
                                                    <input type="text" class="form-control input-custom" id="valor"
                                                           placeholder="R$ 1.000,00">
                                                </div>
                                                <div class="mt-2 ">
                                                    <label for="data" class="form-label">
                                                        <h6>Data:</h6>
                                                    </label>
                                                    <input type="date" class="form-control input-custom" id="data">
                                                </div>
                                                <div class="d-flex flex-column mt-2 mb-4">
                                                    <h6>Conta Bancária:</h6>
                                                    <div class="btn-group">
                                                        <button type="button"
                                                                class="btn btn-secondary btn-selecionar1">Selecione
                                                        </button>
                                                        <button id="dropdownButton" type="button"
                                                                class="btn btn-secondary dropdown-toggle dropdown-toggle-split btn-selecionar2"
                                                                data-bs-toggle="dropdown" aria-expanded="false"
                                                                data-bs-reference="parent">
                                                            <span class="visually-hidden">Toggle Dropdown</span>
                                                        </button>
                                                        <ul class="dropdown-menu">
                                                            <li><a class="dropdown-item " href="#">Nubanck</a></li>
                                                            <li><a class="dropdown-item " href="#">Itau</a></li>
                                                            <li><a class="dropdown-item " href="#">Bradesco</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-bs-dismiss="modal">Cancelar
                                    </button>
                                    <button type="button" class="btn btn-primary">Salvar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="d-flex mt-auto gap-4">
                    <button type="button" class="btn btn-limpar fs-4 p-0"><i class="bi bi-arrow-left"></i></button>
                    <button type="button" class="btn btn-criar fs-4 p-0"><i class="bi bi-arrow-right"></i></button>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</div>
</body>
</html>
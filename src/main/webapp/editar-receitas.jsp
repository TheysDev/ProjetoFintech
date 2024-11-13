<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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

<%@include file="menu.jsp" %>

<%@include file="menuOff.jsp" %>

<div class="d-flex flex-column flex-lg-row flex-xl-row espaco-top ">

    <div class="d-flex flex-column align-items-center espaco tamanho largura ">
        <div class="titulo text-center d-none d-xl-block">
            <h4>Receitas</h4>
        </div>
        <div class="d-flex flex-column flex-lg-row gap-3 w-100 justify-content-center">
            <div class="card card-custom align-items-center card-menor col-12 col-lg-4 scroll2">

                <div class="text-center">
                    <h5 class="cor-azul">Editar Receita</h5>
                </div>
                <form action="movimentacao?acao=editar" method="post">
                    <div>
                        <div class="d-flex flex-column gap-4 mt-4">
                            <div class="mt-2">
                                <label for="valor" class="form-label">
                                    <h6 class="negrito">Valor:</h6>
                                </label>
                                <input type="text"  class="form-control input-custom" id="valor"  placeholder="R$ 1.000,00">
                            </div>
                            <div class="mt-1">
                                <label for="data" class="form-label">
                                    <h6 class="negrito">Data:</h6>
                                </label>
                                <input type="date" class="form-control input-custom" id="data">
                            </div>
                            <div class="d-flex flex-column mt-2 mb-4">
                                <h6>Alocação</h6>
                                <div class="btn-group">
                                    <select name="alocacao" id="id-alocacao" class="form-control">
                                        <c:forEach items="${alocacao}" var="c">
                                            <option value="${c.idAlocacao}">${c.descricaoAlocacao}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="d-flex flex-column mt-1 mb-4">
                                    <h6 class="negrito">Conta Bancária:</h6>
                                    <select name="conta" id="id-conta" class="form-control">
                                        <c:forEach items="${conta}" var="c">
                                            <option value="${c.idConta}">${c.numeroConta} - ${c.nomeBanco}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <input type="hidden" name="tipoMov" value="RECEITA">
                            <input type="hidden" name="idMov" value="${receita.idMovimentacao}">
                        </div>
                        <div class="d-flex mt-auto gap-4">
                            <a href="movimentacao?acao=form-receitas" class="btn btn-limpar ">Cancelar</a>
                            <button type="submit" class="btn btn-criar ">Editar</button>
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
                        <c:forEach items="${listreceita}" var="r">
                            <tr>
                                <td class="text-primary">${r.getDescricaoAlocacao()}</td>
                                <td class="text-center">
                                    <fmt:parseDate
                                            value="${r.dataMovimentacao}" pattern="yyyy-MM-dd" var="dataFmt"/>
                                    <fmt:formatDate value="${dataFmt}" pattern="dd/MM/yyyy"/>
                                </td>
                                <td>${r.getNumeroConta()}</td>
                                <td class="text-danger">
                                    R$ <fmt:formatNumber
                                        value="${r.valorMovimentacao}"/>
                                </td>
                                <td class="text-danger">
                                    <form action="movimentacao?acao=editar" method="get">
                                        <input type="hidden" name="acao" value="form-despesas-editar">
                                        <input type="hidden" name="id" value="${r.idMovimentacao}">
                                        <input type="submit" value="Editar" class="btn btn-primary">
                                    </form>
                                </td>
                                <td>
                                    <form action="movimentacao?acao=excluir" method="post">
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</div>

</body>

</html>

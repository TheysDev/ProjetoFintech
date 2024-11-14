<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Investimentos</title>
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
            <h4>Investimentos</h4>
        </div>
        <div class="d-flex flex-column flex-lg-row gap-3 w-100 justify-content-center">
            <div class="card card-custom align-items-center card-menor col-12 col-lg-4 scroll2">

                <div class="text-center">
                    <h5 class="cor-azul">Cadastrar Novo Investimento</h5>
                </div>
                <form action="investimento?acao=cadastrar" method="post">
                    <div>
                        <div class="d-flex flex-column gap-4 mt-4">
                            <div class="mt-2">
                                <label for="valor" class="form-label">
                                    <h6>Valor:</h6>
                                </label>
                                <input type="text" name="valor" class="form-control input-custom" id="valor"
                                       placeholder="R$ 1.000,00">
                            </div>
                            <div class="mt-2 ">
                                <label for="data" class="form-label">
                                    <h6>Data:</h6>
                                </label>
                                <input type="date" name="data" class="form-control input-custom" id="data">
                            </div>
                            <div class="d-flex flex-column mt-2 ">
                                <h6>Tipo:</h6>
                                <label>
                                    <select name="tipoInvest" class="form-control">
                                        <option value="" disabled selected>Selecione uma opção...</option>
                                        <option value="COMPRA">Compra</option>
                                        <option value="VENDA">Venda</option>
                                    </select>
                                </label>
                            </div>
                            <div class="d-flex flex-column mt-1 mb-4">
                                <h6>Ativo:</h6>
                                <label>
                                    <select name="ativo" class="form-control">
                                        <option value="" disabled selected>Selecione uma opção...</option>
                                        <c:forEach items="${ativo}" var="a">
                                            <option value="${a.idAtivo}">${a.nomeAtivo}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex mt-auto gap-4">
                        <button type="submit" class="btn btn-limpar ">Limpar</button>
                        <button type="submit" class="btn btn-criar ">Criar</button>
                    </div>
                </form>
            </div>
            <div class="d-flex flex-column align-items-center card card-custom card-maior col-12 col-lg-8">
                <h4 class="cor-azul">Histórico</h4>
                <div class="scroll">
                    <table class="table table-hover text-center ">
                        <thead>
                        <tr>
                            <th scope="col">Operação</th>
                            <th scope="col">Ativo</th>
                            <th scope="col">Data</th>
                            <th scope="col">Valor</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="tabela-despesas">
                        <tr>
                            <td>${invest.tipoInvest}</td>
                            <td>${ativo.nomeAtivo}</td>
                            <td class="text-center">
                                <fmt:parseDate
                                        value="${invest.dtCriadoEm}" pattern="yyyy-MM-dd" var="dataFmt"/>
                                <fmt:formatDate value="${dataFmt}" pattern="dd/MM/yyyy"/>
                            </td>
                            <c:if test="${invest.tipoInvest == 'COMPRA'}">
                                <td class="text-danger">
                                    R$<fmt:formatNumber value="${invest.valorInvest}"/>
                                </td>
                            </c:if>
                            <c:if test="${invest.tipoInvest == 'VENDA'}">
                                <td class="text-primary">
                                    R$<fmt:formatNumber value="${invest.valorInvest}"/>
                                </td>
                            </c:if>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div class="d-flex mt-auto gap-4">
                    <button type="submit" class="btn btn-limpar fs-4 p-0"><i class="bi bi-arrow-left"></i></button>
                    <button type="submit" class="btn btn-criar fs-4 p-0"><i class="bi bi-arrow-right"></i></button>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>

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

<%@include file="menu.jsp"%>

<%@include file="menuOff.jsp"%>

<div class="d-flex flex-column flex-lg-row flex-xl-row espaco-top ">

  <div class="d-flex flex-column align-items-center espaco tamanho largura ">
    <div class="titulo text-center d-none d-xl-block">
      <h4>Controle de Despesas</h4>
    </div>
    <div class="d-flex flex-column flex-lg-row gap-3 w-100 justify-content-center">
      <div class="card card-custom align-items-center card-menor col-12 col-lg-4 scroll2">

        <div class="text-center">
          <h5 class="cor-azul">Editar Despesa</h5>
        </div>
        <div>
          <form action="movimentacao?acao=editar-despesas" method="post">
            <div class="d-flex flex-column gap-4 mt-4">
              <div class="mt-2">
                <label for="valorDespesa" class="form-label">
                  <h6>Valor:</h6>
                </label>
                <fmt:formatNumber var="valorFmt" value="${despesa.valorMovimentacao}"/>
                <input type="text" name="valor" value="${valorFmt}" class="form-control input-custom" id="valorDespesa" placeholder="R$ 1.000,00">
              </div>
              <div class="mt-2">
                <label for="dataDespesa" class="form-label">
                  <h6>Data:</h6>
                </label>
                <input type="date" name="dataDespesa" value="${despesa.dataMovimentacao}" class="form-control input-custom" id="dataDespesa">
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
                <div class="d-flex flex-column mt-2 mb-4">
                  <h6>Conta Bancária:</h6>
                  <div class="btn-group form-group">
                    <select name="conta" id="id-conta" class="form-control">
                      <c:forEach items="${conta}" var="c">
                        <option value="${c.idConta}">${c.numeroConta} - ${c.nomeBanco}</option>
                      </c:forEach>
                    </select>
                  </div>
                </div>
                <input type="hidden" name="tipoMov" value="DESPESA">
                <input type="hidden" name="idMov" value="${despesa.idMovimentacao}">
              </div>
              <div class="d-flex mt-auto gap-4">
                <a href="movimentacao?acao=form-despesas" class="btn btn-limpar ">Cancelar</a>
                <button type="submit" class="btn btn-criar ">Editar</button>
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="d-flex flex-column align-items-center card card-custom card-maior col-12 col-lg-8 scroll2">
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
            <c:forEach items="${listdespesa}" var="d">
              <tr>
                <td class="text-primary">${d.getDescricaoAlocacao()}</td>
                <td class="text-center">
                  <fmt:parseDate
                          value="${d.dataMovimentacao}" pattern="yyyy-MM-dd" var="dataFmt"/>
                  <fmt:formatDate value="${dataFmt}" pattern="dd/MM/yyyy"/>
                </td>
                <td>${d.getNumeroConta()}</td>
                <td class="text-danger">
                  R$ <fmt:formatNumber
                        value="${d.valorMovimentacao}"/>
                </td>
                <td class="text-danger">
                  <c:url value="movimentacao" var="link">
                    <c:param name="acao" value="form-despesas-editar"/>
                    <c:param name="id" value="${d.idMovimentacao}"/>
                  </c:url>
                  <a href="${link}" class=" btn btn-primary">Editar</a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

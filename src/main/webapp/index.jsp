<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Bem vindo</title>
</head>
<body>
  <h1>BEM VINDO SEU LINDO</h1>

  <a href="movimentacao?acao=form-despesas" class="link-custom ativado">
      <h4>Despesas</h4>
  </a>
    <a href="movimentacao?acao=form-receitas" class="link-custom ativado">
    <h4>Receitas</h4>
    </a>

  <a href="investimento?acao=form-investimento" class="link-custom ativado">
      <h4>Investimentos</h4>
  </a>

  <a href="gerenciador" class="link-custom ativado">
      <h4>Gerenciar</h4>
  </a>
 </body>
</html>

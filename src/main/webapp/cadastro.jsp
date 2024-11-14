<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  <link rel="stylesheet" href="resources/css/login.css">
  <link rel="stylesheet" href="resources/css/estilos.css">

</head>
<body>
<div class="d-flex flex-column flex-lg-row flex-xl-row tela-principal">
  <div class=" d-block d-lg-none d-xl-none d-flex justify-content-center align-items-center col-12 tela-logo ">
    <img src="resources/img/cash-controller-logo.png" alt="CachController Logo" class="logo">
  </div>
  <div class="card  col-12 col-lg-3 col-xl-3 container">

    <h6 class="text-center mt-4">Cadastre-se:</h6>

    <form class="mt-3" action="cadastrar" method="post">
      <div class="mx-3 mb-2">
        <label for="nome" class="form-label negrito">Nome Completo:</label>
        <input type="text" class="form-control input-custom" name ="nome" id="nome" placeholder="Digite o seu nome">
      </div>
      <div class="mx-3 mb-2">
        <label for="cpf" class="form-label negrito">CPF:</label>
        <input type="text" class="form-control input-custom" name ="cpf" id="cpf" placeholder="000.000.000-00">
      </div>
      <div class="mx-3 mb-2">
        <label for="email" class="form-label negrito">Email:</label>
        <input type="email" class="form-control input-custom" name ="email" id="email" placeholder="exemplo@gmail.com">
      </div>
      <div class="mx-3 mb-2">
        <label for="usuario" class="form-label negrito">Usuário:</label>
        <input type="text" class="form-control input-custom" name ="usuario" id="usuario" placeholder="pessoa123">
      </div>
      <div class="mx-3 mb-4">
        <label for="senha" class="form-label negrito">Senha:</label>
        <input type="password" class="form-control input-custom" name ="senha" id="senha" placeholder="senha123">
      </div>

      <input type="hidden" name="status" value="Ativo">


      <div class="d-flex gap-2 mx-3">
      <input type="checkbox" class="form-check-input check-custom" id="termoUso">
      <label for="termoUso" class="form-check-label fonte-pequena">
        Ao confirmar você aceita os nosso <a href="#"> termos de uso</a>
        e <a href="#">política de privacidade.</a>
      </label>
    </div>
    <div class="d-flex justify-content-center mt-4">
      <button class="btn btn-primary btn-cadastrar">Cadastrar</button>
    </div>
      <c:if test="${not empty mensagem}">
        <div>${mensagem}</div>
      </c:if>
      <div class="text-center mt-3">
      <p class="fonte-pequena">
        Já possúi conta? <a href="login.jsp">Clique aqui para logar.</a>
      </p>
    </div>
    </form>
  </div>
  <div class="d-flex justify-content-center align-items-center col-9 d-lg-flex d-none tela-logo">
    <img src="resources/img/cash-controller-logo.png" alt="CachController Logo" class="logo">
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

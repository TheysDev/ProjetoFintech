<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href= resources/css/login.css>
    <link rel="stylesheet" href="resources/css/estilos.css">

</head>

<body>
<div class="d-flex flex-column flex-lg-row flex-xl-row  tela-principal justify-content-center">
    <div class=" d-block d-lg-none d-xl-none d-flex justify-content-center align-items-center col-12 tela-logo ">
        <img src="resources/img/cash-controller-logo.png" alt="CachController Logo" class="logo">
    </div>
    <div class="container card d-flex flex-column justifycontent-center aling-items-center col-12 col-lg-3 col-xl-3 mt-4 mt-lg-0 ">

        <div class="d-flex flex-column camada-login">
            <h3 class="text-center mb-4 mt-5">Bem vindo!</h3>

            <form action="login" method="post">

                <div class="mx-3 mb-2">
                    <label for="usuario" class="form-label negrito">Email:</label>
                    <input type="text" class="form-control input-custom" name="email" id="usuario" placeholder="Email">
                </div>
                <div class="mx-3 mb-4">
                    <label for="senha" class="form-label negrito">Senha:</label>
                    <input type="password" class="form-control input-custom" name="senha" id="senha" placeholder="Senha">
                </div>
                <c:if test="${empty usuario}">
                    <span class="navbar-text text-danger">
                        ${erro}
                    </span>
              </c:if>



            <div class="d-flex gap-2 mx-3">
                <input type="checkbox" class="form-check-input check-custom" id="termoUso">
                <label for="termoUso" class="form-check-label fonte-pequena">
                    Manter Login
                </label>
            </div>

            <div class="d-flex justify-content-center mt-4">
                <button class="btn btn-primary btn-cadastrar">Logar</button>
            </div>
            <div class="text-center mt-3">
                <p class="fonte-pequena">
                    Não possúi conta? <a href="cadastro.jsp">Cadastre-se aqui.</a>
                </p>


            </div>
        </div>
    </div>
    </form>
    <div class="d-flex justify-content-center align-items-center col-9 d-lg-flex d-none tela-logo">
        <img src="resources/img/cash-controller-logo.png" alt="CachController Logo" class="logo">
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>

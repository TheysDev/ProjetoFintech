<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  <link rel="stylesheet" href="./css/despesas.css">
  <link rel="stylesheet" href="./css/estilos.css">
  <!-- Importando a biblioteca Chart.js -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>

<body>
<nav class="navbar bg-body-tertiary fixed-top d-block d-xl-none position-fixed top-0 borda-bottom">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <h4>Dashboard</h4>
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
            <img src="./img/cash-controller-logo.png" alt="" class="logo-sidebar">
          </div>
          <li class="lista-sem-pontos">
            <a href="#" class="link-custom ativado">
              <h4>Dashboard</h4>
            </a>
          </li>
          <li class="lista-sem-pontos mt-1">
            <a href="./receitas.html" class="link-custom">
              <h4>Receitas</h4>
            </a>
          </li>
          <li class="lista-sem-pontos mt-1">
            <a href="./despesas.html" class="link-custom">
              <h4>Despesas</h4>
            </a>
          </li>
          <li class="lista-sem-pontos mt-1">
            <a href="./investimentos.html" class="link-custom">
              <h4>Investimentos</h4>
            </a>
          </li>
          <li class="lista-sem-pontos mt-1">
            <a href="./gerenciar-conta.html" class="link-custom">
              <h4>Gerenciar Conta</h4>
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
</nav>

<div class="offcanvas offcanvas-start show container card d-flex flex-column align-items-center col-3 position-fixed start-0 sidebar-custom d-none d-xl-block"
     tabindex="-1" id="offcanvas" aria-labelledby="offcanvasLabel" data-bs-backdrop="false" data-bs-scroll="true">
  <div class="d-flex justify-content-center">
    <img src="./img/cash-controller-logo.png" alt="" class="logo-sidebar mt-4">
  </div>
  <li class="lista-sem-pontos mt-4">
    <a href="#" class="fw-bold link-custom ativado fs-5">Dashboard</a>
  </li>
  <li class="lista-sem-pontos mt-1">
    <a href="./receitas.html" class="fw-bold link-custom fs-5">Receitas</a>
  </li>
  <li class="lista-sem-pontos mt-1">
    <a href="./despesas.html" class="fw-bold link-custom fs-5">Despesas</a>
  </li>
  <li class="lista-sem-pontos mt-1">
    <a href="./investimentos.html" class="fw-bold link-custom fs-5">Investimentos</a>
  </li>
  <li class="lista-sem-pontos mt-1">
    <a href="./gerenciar-conta.html" class="fw-bold link-custom fs-5">Gerenciar Conta</a>
  </li>
  <li class="lista-sem-pontos mt-1">
    <a href="#" class="fw-bold link-sair fs-5 ">Sair</a>
  </li>
</div>

<div class="d-flex flex-column flex-lg-row flex-xl-row espaco-top">
  <div class="d-flex flex-column align-items-center espaco tamanho largura">
    <div class="titulo text-center d-none d-xl-block">
      <h4>Dashboard</h4>
    </div>
    <div class="d-flex flex-column flex-lg-row gap-3 w-100 justify-content-center">
      <div class="card card-custom align-items-center card-menor col-12 col-lg-4 scroll2">
        <h5 class="cor-azul mb-2">Resumo Mensal</h5>
        <canvas id="resumo" width="100" height="100"></canvas>

        <h5 class="text-danger mt-5 mb-2">Despesa Geral</h5>
        <canvas id="despesas" width="300" height="200"></canvas>

      </div>
      <div class="d-flex flex-column align-items-center card card-custom card-maior col-12 col-lg-8 scroll2">
        <h5 class="cor-azul">Movimentações</h5>
        <div class="scroll">
          <table class="table table-hover text-center">
            <thead>
            <tr>
              <th scope="col">Nome</th>
              <th scope="col">Data</th>
              <th scope="col">Conta B.</th>
              <th scope="col">Valor</th>
              <th></th>
            </tr>
            </thead>
            <tbody id="tabela-despesas">
            <!-- conteúdo gerado pelo JS -->
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
</div>

<!-- Scripts do Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="./js/desepesas.js" type="module"></script>
<script src="./js/chart.js"></script>
</body>

</html>

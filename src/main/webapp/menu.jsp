<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
      <form class="d-flex flex-column aling-items-center offcanvas-body" role="search">
        <div>
          <div class="d-flex justify-content-center">
            <img src="resources/img/cash-controller-logo.png" alt="" class="logo-sidebar mt-5">
          </div>
          <li class="lista-sem-pontos">
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
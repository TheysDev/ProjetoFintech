<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Investimentos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  <link rel="stylesheet" href="./css/despesas.css">
  <link rel="stylesheet" href="./css/estilos.css">
</head>

<body>

<%@include file="menu.jsp"%>

<%@include file="menuOff.jsp"%>


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

        <form>

          <div>
            <div class="d-flex flex-column gap-4 mt-4">
              <form>
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
              </form>
              <div class="d-flex flex-column mt-2 ">
                <h6>Tipo:</h6>
                <form action="">
                  <select id="opcoes" name="opcoes">
                    <option value="" disabled selected>Selecione uma opção...</option>
                    <option value="opcao1">Compra</option>
                    <option value="opcao2">Venda</option>
                  </select>
                </form>
              </div>
              <div class="d-flex flex-column mt-1 mb-4">
                <h6>Ativo:</h6>
                <form action="">
                  <select id="opcoes" name="opcoes">
                    <option value="" disabled selected>Selecione uma opção...</option>
                    <option value="opcao1">AlfaTech</option>
                    <option value="opcao2">BlueWave Corp</option>
                    <option value="opcao3">GreenField Holdings</option>
                    <option value="opcao4">PowerGrowth</option>
                  </select>
                </form>
              </div>
            </div>
          </div>
        </form>
        <div class="d-flex mt-auto gap-4">
          <button type="submit" class="btn btn-limpar ">Limpar</button>
          <button type="submit" class="btn btn-criar ">Criar</button>
        </div>

      </div>
      <div class="d-flex flex-column align-items-center card card-custom card-maior col-12 col-lg-8">
        <h4 class="cor-azul">Histórico</h4>

        <div class="scroll">
          <table class="table table-hover text-center ">
            <thead>
            <tr>
              <th scope="col">Nome</th>
              <th scope="col">Tipo</th>
              <th scope="col">Data</th>
              <th scope="col">Conta B.</th>
              <th scope="col">Valor</th>
              <th></th>
            </tr>
            </thead>
            <tbody id="tabela-despesas">
            <!-- codigo gerado pelo js -->
            </tbody>
          </table>
          <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
               aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Escolha uma ação</h5>
                  <button type="submit" class="btn-close" data-bs-dismiss="modal"
                          aria-label="Fechar"></button>
                </div>
                <div class="modal-body">
                  Selecione a ação que deseja realizar.
                </div>
                <div class="modal-footer d-flex justify-content-center">
                  <button type="submit" class="btn btn-danger">Excluir</button>
                  <button type="submit" class="btn btn-primary" data-bs-toggle="modal"
                          data-bs-target="#modalEditar">Editar</button>
                </div>
              </div>
            </div>
          </div>
          <div class="modal fade" id="modalEditar" tabindex="-1" aria-labelledby="exampleModalLabel"
               aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="exampleModalLabel">Editando Investimento:</h1>
                  <button type="submit" class="btn-close" data-bs-dismiss="modal"
                          aria-label="Close"></button>
                </div>
                <div class="modal-body p-5">
                  <form>
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
                        <div class="d-flex flex-column mt-2 ">
                          <h6>Tipo:</h6>
                          <form action="">
                            <select id="opcoes" name="opcoes">
                              <option value="" disabled selected>Selecione uma opção...</option>
                              <option value="opcao1">Compra</option>
                              <option value="opcao2">Venda</option>
                            </select>
                          </form>
                        </div>
                        <div class="d-flex flex-column mt-1 mb-4">
                          <h6>Ativo:</h6>
                          <form action="">
                            <select id="opcoes" name="opcoes">
                              <option value="" disabled selected>Selecione uma opção...</option>
                              <option value="opcao1">AlfaTech</option>
                              <option value="opcao2">BlueWave Corp</option>
                              <option value="opcao3">GreenField Holdings</option>
                              <option value="opcao4">PowerGrowth</option>
                            </select>
                          </form>
                        </div>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="submit" class="btn btn-secondary"
                          data-bs-dismiss="modal">Cancelar</button>
                  <button type="submit" class="btn btn-primary">Salvar</button>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="d-flex mt-auto gap-4">
          <button type="submit" class="btn btn-limpar fs-4 p-0"><i class="bi bi-arrow-left"></i></button>
          <button type="submit" class="btn btn-criar fs-4 p-0"><i class="bi bi-arrow-right"></i></button>
        </div>

      </div>

    </div>

  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
          crossorigin="anonymous"></script>
  <script type="module" src="./js/desepesas.js"></script>
</div>

</body>

</html>
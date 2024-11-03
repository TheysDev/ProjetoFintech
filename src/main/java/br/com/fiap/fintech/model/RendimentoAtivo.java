package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class RendimentoAtivo {

    private int idRendimento;
    private double valorRendimento;
    private double porcentagemRendimento;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    private CarteiraAtivo carteiraAtivo;

    public RendimentoAtivo(int idRendimento, double valorRendimento, double porcentagemRendimento, LocalDate dataInicial, LocalDate dataFinal, CarteiraAtivo carteiraAtivo) {
        this.idRendimento = idRendimento;
        this.valorRendimento = valorRendimento;
        this.porcentagemRendimento = porcentagemRendimento;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.carteiraAtivo = carteiraAtivo;
    }

    public RendimentoAtivo() {}

    public int getIdRendimento() {
        return idRendimento;
    }

    public void setIdRendimento(int idRendimento) {
        this.idRendimento = idRendimento;
    }

    public CarteiraAtivo getCarteiraAtivo() {
        return carteiraAtivo;
    }

    public void setCarteiraAtivo(CarteiraAtivo carteiraAtivo) {
        this.carteiraAtivo = carteiraAtivo;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public double getPorcentagemRendimento() {
        return porcentagemRendimento;
    }

    public void setPorcentagemRendimento(double porcentagemRendimento) {
        this.porcentagemRendimento = porcentagemRendimento;
    }

    public double getValorRendimento() {
        return valorRendimento;
    }

    public void setValorRendimento(double valorRendimento) {
        this.valorRendimento = valorRendimento;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }
}

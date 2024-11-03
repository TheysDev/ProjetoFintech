package br.com.fiap.fintech.model;

public class Ativo {

    private int idAtivo;
    private String nomeAtivo;
    private String descricaoTipoAtivo;

    public Ativo(int idAtivo, String nomeAtivo, String descricaoTipoAtivo) {
        this.idAtivo = idAtivo;
        this.nomeAtivo = nomeAtivo;
        this.descricaoTipoAtivo = descricaoTipoAtivo;
    }
    public Ativo() {}

    public int getIdAtivo() {
        return idAtivo;
    }

    public void setIdAtivo(int idAtivo) {
        this.idAtivo = idAtivo;
    }

    public String getNomeAtivo() {
        return nomeAtivo;
    }

    public void setNomeAtivo(String nomeAtivo) {
        this.nomeAtivo = nomeAtivo;
    }

    public String getDescricaoTipoAtivo() {
        return descricaoTipoAtivo;
    }

    public void setDescricaoTipoAtivo(String descricaoTipoAtivo) {
        this.descricaoTipoAtivo = descricaoTipoAtivo;
    }
}

package br.com.fiap.fintech.model;

public class Usuario {

    private int idUsuario;
    private String nomeUsuario;
    private int cpfUsuario;
    private String emailUsuario;
    private String nomeCompletoUsuario;
    private String senhaUsuario;

    public Usuario(int idUsuario, String nomeUsuario, int cpfUsuario, String emailUsuario, String nomeCompletoUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.emailUsuario = emailUsuario;
        this.nomeCompletoUsuario = nomeCompletoUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public Usuario(){}

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(int cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getNomeCompletoUsuario() {
        return nomeCompletoUsuario;
    }

    public void setNomeCompletoUsuario(String nomeCompletoUsuario) {
        this.nomeCompletoUsuario = nomeCompletoUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}

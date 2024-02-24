package br.com.jeli.favoritegame.domain.usuario;

public class Usuario {
    private String id;
    private String nome;
    private String senha;
    private Boolean ativo;

    public Usuario(String id, String nome, String senha, Boolean ativo){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}

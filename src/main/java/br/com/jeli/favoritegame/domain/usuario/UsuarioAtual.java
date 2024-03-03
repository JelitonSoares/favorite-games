package br.com.jeli.favoritegame.domain.usuario;

public class UsuarioAtual {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdUsuarioAtual() {
        return this.usuario.getId();
    }

    public String getNomeUsuarioAtual() {
        return this.usuario.getNome();
    }
}

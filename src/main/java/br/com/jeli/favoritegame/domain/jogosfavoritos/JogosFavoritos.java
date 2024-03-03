package br.com.jeli.favoritegame.domain.jogosfavoritos;

import br.com.jeli.favoritegame.domain.usuario.Usuario;

import java.util.List;

public class JogosFavoritos {
    private Usuario usuario;

    private List<String> jogos;

    public JogosFavoritos(Usuario usuario, List<String> jogos) {
        this.usuario = usuario;
        this.jogos = jogos;
    }

    public String getIdUsuario() {
        return this.usuario.getId();
    }

    public String getNomeUsuario() {
        return this.usuario.getNome();
    }

    public void adicionarJogo(String jogo) {
        this.jogos.add(jogo);
    }

    public void adicionarJogo(String jogo, Integer indice) {
        this.jogos.add(indice, jogo);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<String> getJogos() {
        return jogos;
    }

}

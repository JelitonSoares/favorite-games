package br.com.jeli.favoritegame.domain.jogosfavoritos;

import br.com.jeli.favoritegame.ConnectionFactory;
import br.com.jeli.favoritegame.domain.DomainException;
import br.com.jeli.favoritegame.domain.usuario.UsuarioAtual;

import java.sql.Connection;
import java.util.List;

public class JogosFavoritosService {

    private ConnectionFactory connection;

    private UsuarioAtual atual;

    public JogosFavoritosService(UsuarioAtual atual) {
        this.connection = new ConnectionFactory();
        this.atual = atual;
    }

    public List<String> listar() {
        Connection conn = connection.getConnection();
        return new JogosFavoritosDAO(conn).listar(atual.getIdUsuarioAtual());
    }

    public void cadastrar(List<String> jogos) {
        Connection conn = connection.getConnection();
        new JogosFavoritosDAO(conn).cadastrar(atual.getIdUsuarioAtual(), jogos);
    }
    public void excluir() {
        Connection conn = connection.getConnection();
        new JogosFavoritosDAO(conn).excluir(atual.getIdUsuarioAtual());
    }

    public void atualizar(Integer posicao, String novoJogo) {
        Connection conn = connection.getConnection();
        switch (posicao) {
            case 1:
                new JogosFavoritosDAO(conn).atualizarJogo1(atual.getIdUsuarioAtual(), novoJogo);
                break;
            case 2:
                new JogosFavoritosDAO(conn).atualizarJogo2(atual.getIdUsuarioAtual(), novoJogo);
                break;
            case 3:
                new JogosFavoritosDAO(conn).atualizarJogo3(atual.getIdUsuarioAtual(), novoJogo);
                break;
            case 4:
                new JogosFavoritosDAO(conn).atualizarJogo4(atual.getIdUsuarioAtual(), novoJogo);
                break;
            case 5:
                new JogosFavoritosDAO(conn).atualizarJogo5(atual.getIdUsuarioAtual(), novoJogo);
                break;
            default:
                new DomainException("Selecione uma posição válida!!");
        }


    }



}

package br.com.jeli.favoritegame.domain.usuario;

import br.com.jeli.favoritegame.ConnectionFactory;
import br.com.jeli.favoritegame.domain.DomainException;

import java.sql.Connection;

public class UsuarioService {

    private ConnectionFactory connection;

    private Usuario usuarioAtual;

    public UsuarioService() {
        connection = new ConnectionFactory();
    }

    public Boolean entrar(String id, String senha) {
        Usuario usuario = consultaUsuarioPorId(id);

        if(!senha.equals(usuario.getSenha())) {
            throw new DomainException("Senha Incorreta!!");
        }

        this.usuarioAtual = usuario;
        return true;
    }

    public void cadastrar(String id, String nome, String senha){
        if(id.length() != 5) {
            throw new DomainException("Seu ID deve conter 5 digitos");
        }

        if(senha.length() != 8) {
            throw new DomainException("Sua senha deve conter 8 digitos");
        }

        Usuario usuario = new Usuario(id, nome, senha, true);

        Connection conn = connection.getConnection();
        new UsuarioDAO(conn).cadastrar(usuario);
    }

    public Usuario consultaUsuarioPorId(String id) {
        Connection conn = connection.getConnection();
        Usuario usuario = new UsuarioDAO(conn).consulta(id);

        if(usuario == null) {
            throw new DomainException("Não existe usuairo cadastrado com esse ID!!");
        }

        return usuario;
    }

    public Usuario getUsuarioAtual() {
        return this.usuarioAtual;
    }
}

package br.com.jeli.favoritegame.domain.usuario;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO (Connection conn) {
        this.conn = conn;
    }

    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuario (id, nome, senha, ativo) VALUES (?, ?, ?, ?);";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getId());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getSenha());
            ps.setBoolean(4, usuario.getAtivo());

            ps.execute();
            ps.close();
            conn.close();
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Usuario consulta(String id){
        String sql = "SELECT * FROM usuario WHERE id = ?;";
        Usuario usuario = null;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String nome = rs.getString(2);
                String senha = rs.getString(3);
                Boolean ativo = rs.getBoolean(4);

                usuario = new Usuario(id, nome, senha, ativo);

            }

            ps.close();
            rs.close();
            conn.close();
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return usuario;
    }

}

package br.com.jeli.favoritegame.domain.jogosfavoritos;

import com.sun.jdi.request.ClassPrepareRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogosFavoritosDAO {
    private Connection conn;

    public JogosFavoritosDAO(Connection conn) {
        this.conn = conn;
    }

    public List<String> listar(String id) {
        String sql = "SELECT * FROM jogos_favoritos WHERE id = ?;";
        List<String> jogos = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String jogo1 = rs.getString(2);
                String jogo2 = rs.getString(3);
                String jogo3 = rs.getString(4);
                String jogo4 = rs.getString(5);
                String jogo5 = rs.getString(6);

                jogos.add(jogo1);
                jogos.add(jogo2);
                jogos.add(jogo3);
                jogos.add(jogo4);
                jogos.add(jogo5);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return jogos;
    }

    public void cadastrar(String id, List<String> jogos) {
        String sql = "INSERT INTO jogos_favoritos (id, jogo1, jogo2, jogo3, jogo4, jogo5) VALUES (?,?,?,?,?,?);";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, jogos.get(0));
            ps.setString(3, jogos.get(1));
            ps.setString(4, jogos.get(2));
            ps.setString(5, jogos.get(3));
            ps.setString(6, jogos.get(4));

            ps.execute();

            conn.close();
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void excluir(String id) {
        String sql = "DELETE FROM jogos_favoritos WHERE id = ?;";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ps.execute();
            ps.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void atualizarJogo1(String id, String novoJogo) {
        String sql = "UPDATE jogos_favoritos SET jogo1 = ? WHERE id = ?;";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, novoJogo);
            ps.setString(2, id);

            ps.execute();
            conn.close();
            ps.close();
        }catch (SQLException e ) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void atualizarJogo2(String id, String novoJogo) {
        String sql = "UPDATE jogos_favoritos SET jogo2 = ? WHERE id = ?;";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, novoJogo);
            ps.setString(2, id);

            ps.execute();
            conn.close();
            ps.close();
        }catch (SQLException e ) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void atualizarJogo3(String id, String novoJogo) {
        String sql = "UPDATE jogos_favoritos SET jogo3 = ? WHERE id = ?;";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, novoJogo);
            ps.setString(2, id);

            ps.execute();
            conn.close();
            ps.close();
        }catch (SQLException e ) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void atualizarJogo4(String id, String novoJogo) {
        String sql = "UPDATE jogos_favoritos SET jogo4 = ? WHERE id = ?;";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, novoJogo);
            ps.setString(2, id);

            ps.execute();
            conn.close();
            ps.close();
        }catch (SQLException e ) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void atualizarJogo5(String id, String novoJogo) {
        String sql = "UPDATE jogos_favoritos SET jogo5 = ? WHERE id = ?;";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, novoJogo);
            ps.setString(2, id);

            ps.execute();
            conn.close();
            ps.close();
        }catch (SQLException e ) {
            throw new RuntimeException(e.getMessage());
        }
    }

}

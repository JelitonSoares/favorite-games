package br.com.jeli.favoritegame;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try{
            return createDataSource().getConnection();
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/favorite_games");
        config.setUsername("root");
        config.setPassword("1808");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}

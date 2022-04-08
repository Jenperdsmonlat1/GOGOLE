package com.example.webbrowser.db;

import java.sql.*;

public class SQLiteHistory {

    private Connection connect() {
        String url = "jdbc:sqlite:db_webbrowser.db";
        Connection conn = null;

        String sql = """
                    CREATE TABLE IF NOT EXISTS historique(
                    recherche TEXT NOT NULL
                    );
                    """;
        try {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ouverture de la base de donnée.");
        }
        return conn;
    }

    public void insert(String recherche) {
        String sql = "INSERT INTO historique(recherche) VALUES(?)";

        try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, recherche);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur impossible d'insérer des données.");
        }
    }
}


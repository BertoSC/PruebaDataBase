package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {


    Connection con;
    {
        try {
             // está sobrecargado, hay versiones que pillan solo url, solo usario etc
            // carga los drivers de la url?
            // base de datos, user, contraseña
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Juego", "postgres","");
            showTabla(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
    public static void showTabla(Connection con) throws SQLException {
        String query = "select nombre, \"idDesarrollador\", precio, ventas, total from juego";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String nombreJuego = rs.getString("nombre");
                int idDesarrollador = rs.getInt("idDesarrollador");
                float precio = rs.getFloat("precio");
                int ventas = rs.getInt("ventas");
                int total = rs.getInt("total");
                System.out.println(nombreJuego + ", " + idDesarrollador + ", " + precio +
                        ", " + ventas + ", " + total);
            }
        } catch (SQLException e) {
            // Gestión de la excepción.
        }
    }
}
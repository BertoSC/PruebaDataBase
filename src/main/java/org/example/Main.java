package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Juego", "postgres", "");
            //showTabla(con);

            // Creación del Statement con ResultSet actualizable y desplazable
            var st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Ejecutar la consulta
            var rsJuego = st.executeQuery("select * from Juego");

            // Mover el cursor al primer registro si hay datos
            if (rsJuego.next()) {
                // Modificar el primer campo del registro actual
                rsJuego.updateString(1, "Pruebacambio");
                rsJuego.updateRow(); // Confirmar los cambios en la base de datos

                System.out.println("Registro actualizado correctamente.");
            } else {
                System.out.println("No hay registros en la tabla 'Juego'.");
            }

            // Imprimir todos los registros para verificar el cambio
            rsJuego.beforeFirst(); // Mover el cursor al principio para recorrer todos los registros
            while (rsJuego.next()) {
                System.out.println(rsJuego.getString(1) + " " + rsJuego.getString(2) + " " + rsJuego.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    /*
    Connection con;

        try {
             // está sobrecargado, hay versiones que pillan solo url, solo usario etc
            // carga los drivers de la url?
            // base de datos, user, contraseña
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Juego", "postgres","");
            showTabla(con);

            //pasos básicos
            // especificamos
            var st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            var rsJuego = st.executeQuery("select * from Juego");


            rsJuego.previous();

            rsJuego.updateString(1, "Pruebacambio");

            while (rsJuego.next()){
                System.out.println(rsJuego.getString(1)+ " "+ rsJuego.getString(2)+" "+ rsJuego.getString(3));
            }

            // comprobamos que tipos
 /*           try {
                if (con.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                    System.out.println("Soporta TYPE_SCROLL_INSENSITIVE");
                } else {
                    System.out.println("No soporta TYPE_SCROLL_INSENSITIVE");
                }
                if (con.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Soporta CONCUR_UPDATABLE");
                } else {
                    System.out.println("No soporta CONCUR_UPDATABLE");
                }
            } catch (SQLException ex) {
                System.out.println("Error al obtener metadatos: " + ex.getMessage());
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
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
     */





}}
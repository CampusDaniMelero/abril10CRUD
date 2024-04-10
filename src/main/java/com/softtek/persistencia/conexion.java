package com.softtek.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

public class conexion {
    protected Connection miConexion;

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        miConexion = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:5432/northwind", "postgres", "root");

    }

    public conexion() {

    }


    //Getters y Setters

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }

    public void cerrarConexion() throws SQLException {
        miConexion.close();
    }





}




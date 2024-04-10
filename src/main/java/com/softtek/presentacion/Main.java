package com.softtek.presentacion;

import com.softtek.persistencia.conexion;

import java.sql.SQLException;
//Apertura de conexion , pero hemos borrado los System.out.println

public class Main {
    public static void main(String[] args) {

        conexion conex = new conexion();

        try {
            conex.abrirConexion();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.toString());

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());

        }
    }
}

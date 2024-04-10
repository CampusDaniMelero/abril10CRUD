package com.softtek.presentacion;

import com.softtek.persistencia.AccesoProducto;

import java.sql.SQLException;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        AccesoProducto accesoProducto = new AccesoProducto();
        Scanner scanner = new Scanner(System.in);

        try {
            // Eliminar un producto existente
            System.out.println("Eliminar un producto existente:");
            accesoProducto.eliminarProducto();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

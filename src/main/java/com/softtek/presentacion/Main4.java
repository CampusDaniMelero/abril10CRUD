package com.softtek.presentacion;


import com.softtek.persistencia.AccesoProducto;

import java.sql.SQLException;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        AccesoProducto accesoProducto = new AccesoProducto();
        Scanner scanner = new Scanner(System.in);

        try {
            // Editar un producto existente
            System.out.println("Editar un producto existente:");
            accesoProducto.editarProducto();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

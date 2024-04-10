package com.softtek.presentacion;

import com.softtek.modelo.Producto;
import com.softtek.persistencia.AccesoProducto;

import java.sql.SQLException;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        AccesoProducto accesoProducto = new AccesoProducto();

        try {
            // Mostrar lista de productos existentes
            List<Producto> productos = accesoProducto.obtenerTodos();

            if (productos.isEmpty()) {
                System.out.println("No se encontraron productos.");
            } else {
                System.out.println("Lista de productos:");
                for (Producto producto : productos) {
                    System.out.println(producto);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

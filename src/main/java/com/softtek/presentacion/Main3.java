package com.softtek.presentacion;

import com.softtek.persistencia.AccesoProducto;
import com.softtek.modelo.Producto;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        AccesoProducto accesoProducto = new AccesoProducto();
        Scanner scanner = new Scanner(System.in);

        try {
            // Insertar un nuevo producto
            System.out.println("Insertar un nuevo producto:");
            accesoProducto.insertarProducto();

            // Mostrar todos los productos después de la inserción
            System.out.println("Productos después de la inserción:");
            List<Producto> productos = accesoProducto.obtenerTodos();
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.softtek.persistencia;

import com.softtek.modelo.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccesoProducto extends conexion {
        public void insertarProducto() throws ClassNotFoundException, SQLException {

            Scanner scanner = new Scanner(System.in);

            // Solicitar el ID del nuevo producto
            System.out.println("Ingrese el ID del nuevo producto:");
            int id = Integer.parseInt(scanner.nextLine());

            if (verificarIdExistente(id)) {
                System.out.println("El ID ingresado ya está en uso. Por favor, ingrese un ID diferente.");
                return; // Salir del método si el ID está en uso
            }

            // Solicitar los demás datos del producto
            System.out.println("Ingrese el nombre del producto:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el ID del proveedor:");
            int proveedorId = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el ID de la categoría:");
            int categoriaId = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese la cantidad por unidad:");
            String cantidadPorUnidad = scanner.nextLine();

            System.out.println("Ingrese el precio del producto:");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.println("Ingrese la cantidad en stock del producto:");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.println("Introduce la cantidad de cantidad por Unidad: ");

            System.out.println("Ingrese el nivel de reorden del producto:");
            int reOrderlevel = Integer.parseInt(scanner.nextLine());

            System.out.println("¿El producto está descontinuado? (1: Sí, 0: No)");
            int discontinued = Integer.parseInt(scanner.nextLine());

            // Insertar el nuevo producto en la base de datos
            String sql = "INSERT INTO products (product_id, product_name, supplier_id, category_id, quantity_per_unit, unit_price, units_in_stock, reorder_level, discontinued) VALUES (" +
                    id + ", '" + nombre + "', " + proveedorId + ", " + categoriaId + ", '" + cantidadPorUnidad + "', " + precio + ", " + cantidad + ", " + reOrderlevel + ", " + discontinued + ")";

            abrirConexion();
            Statement statement = miConexion.createStatement();

            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println(filasAfectadas + " fila(s) afectada(s) por la inserción.");

            statement.close();
            cerrarConexion();
        }

        // Los otros métodos de la clase AccesoProducto permanecen sin cambios

        // Verificar si el ID existe en la base de datos
        private boolean verificarIdExistente(int id) throws ClassNotFoundException, SQLException {
            Statement sentencia;
            ResultSet resultado;

            String sql = "SELECT product_id FROM products WHERE product_id = " + id;

            abrirConexion();
            sentencia = miConexion.createStatement();
            resultado = sentencia.executeQuery(sql);

            boolean idExistente = resultado.next();

            resultado.close();
            sentencia.close();
            cerrarConexion();

            return idExistente;
        }




    public void editarProducto() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el ID del producto a editar
        System.out.println("Ingrese el ID del producto a editar:");
        int id = Integer.parseInt(scanner.nextLine());

        if (!verificarIdExistente(id)) {
            System.out.println("El ID ingresado no existe. No se puede editar el producto.");
            return; // Salir del método si el ID no existe
        }

        // Solicitar los nuevos datos del producto
        System.out.println("Ingrese el nuevo nombre del producto:");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese el nuevo ID del proveedor:");
        int nuevoProveedorId = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese el nuevo ID de la categoría:");
        int nuevaCategoriaId = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese la nueva cantidad por unidad:");
        String nuevaCantidadPorUnidad = scanner.nextLine();

        System.out.println("Ingrese el nuevo precio del producto:");
        double nuevoPrecio = Double.parseDouble(scanner.nextLine());

        System.out.println("Ingrese la nueva cantidad en stock del producto:");
        int nuevaCantidad = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce la nueva cantidad de cantidad por Unidad: ");
        int nuevoReOrderlevel = Integer.parseInt(scanner.nextLine());

        System.out.println("¿El producto está descontinuado? (1: Sí, 0: No)");
        int nuevoDiscontinued = Integer.parseInt(scanner.nextLine());

        // Construir la consulta SQL de actualización
        String sql = "UPDATE products SET product_name = '" + nuevoNombre + "', supplier_id = " + nuevoProveedorId +
                ", category_id = " + nuevaCategoriaId + ", quantity_per_unit = '" + nuevaCantidadPorUnidad +
                "', unit_price = " + nuevoPrecio + ", units_in_stock = " + nuevaCantidad + ", reorder_level = " +
                nuevoReOrderlevel + ", discontinued = " + nuevoDiscontinued + " WHERE product_id = " + id;

        abrirConexion();
        Statement statement = miConexion.createStatement();

        int filasAfectadas = statement.executeUpdate(sql);
        if (filasAfectadas > 0) {
            System.out.println("El producto se ha actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el producto. Verifique los datos e inténtelo de nuevo.");
        }

        statement.close(); // Cerrar el statement después de la ejecución
        cerrarConexion(); // Cerrar la conexión después de todas las operaciones
    }

    public void eliminarProducto() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el ID del producto a eliminar
        System.out.println("Ingrese el ID del producto a eliminar:");
        int id = Integer.parseInt(scanner.nextLine());

        // Crear la sentencia SQL para eliminar el producto
        String sql = "DELETE FROM products WHERE product_id = " + id;

        abrirConexion();
        Statement statement = miConexion.createStatement();

        // Ejecutar la sentencia SQL
        int filasAfectadas = statement.executeUpdate(sql);
        System.out.println(filasAfectadas + " fila(s) afectada(s) por la eliminación.");

        // Cerrar el statement y la conexión
        statement.close();
        cerrarConexion();
    }

    public void buscarProducto() {
        System.out.println("Buscando producto");
    }

    public void listarProductos() {
        System.out.println("Listando productos");
    }

    public List<Producto> obtenerTodos() throws ClassNotFoundException, SQLException {
        Statement sentencia;
        ResultSet resultado;

        String sql = "Select product_id, product_name, supplier_id, category_id, quantity_per_unit, unit_price , units_in_stock , units_on_order, reorder_level, discontinued from products";

        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while (resultado.next()) {
            Producto producto = new Producto();
            producto.setIdProducto(resultado.getInt("product_id"));
            producto.setNombreProducto(resultado.getString("product_name"));
            producto.setProveedorId(resultado.getInt("supplier_id"));
            producto.setCategoriaId(resultado.getInt("category_id"));
            producto.setCantidadPorUnidad(resultado.getString("quantity_per_unit"));
            producto.setPrecioUnitario(resultado.getDouble("unit_price"));
            producto.setUnidadesStock(resultado.getInt("units_in_stock"));
            producto.setUnidadesEnPedido(resultado.getInt("units_on_order"));
            producto.setNivelReorden(resultado.getInt("reorder_level"));
            producto.setDiscontinuado(resultado.getInt("discontinued"));

            productos.add(producto);
        }

        resultado.close();
        sentencia.close();
        cerrarConexion();

        return productos;
    }


}

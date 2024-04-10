package com.softtek.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private int supplierId;
    private int categoriaId;
    private String cantidadPorUnidad;
    private double precioUnitario;
    private int unidadesStock;
    private int unidadesEnPedido;
    private int nivelReorden;
    private int discontinuado;

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", SupplierId=" + supplierId +
                ", categoriaId=" + categoriaId +
                ", cantidadPorUnidad='" + cantidadPorUnidad + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", unidadesStock=" + unidadesStock +
                ", unidadesEnPedido=" + unidadesEnPedido +
                ", nivelReorden=" + nivelReorden +
                ", discontinuado=" + discontinuado +
                '}';
    }

    public Producto() {
    }

    public void setId(int product_id) {
    }

    public void setNombre(String product_name) {
    }

    public void setProveedorId(int supplier_id) {
    }

    public void setCategoriaId(int category_id) {
    }

    public void setCantidadPorUnidad(String quantity_per_unit) {
    }

    public void setPrecioUnitario(double unit_price) {
    }

    public void setUnidadesStock(int units_in_stock) {
    }

    public void setUnidadesEnPedido(int units_on_order) {
    }

    public void setNivelReorden(int reorder_level) {
    }

    public void setDiscontinuado(int discontinued) {
    }

    public int getId() {
        return idProducto;
    }

    public String getNombre() {
        return nombreProducto;
    }

    public int getProveedorId() {
        return supplierId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public String getCantidadPorUnidad() {
        return cantidadPorUnidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getUnidadesStock() {
        return unidadesStock;
    }

    public int getUnidadesEnPedido() {
        return unidadesEnPedido;
    }

    public int getNivelReorden() {
        return nivelReorden;
    }

    public int getDiscontinuado() {
        return discontinuado;
    }

    public void setPrecio(double unit_price) {
    }

    public void setCantidad(int units_in_stock) {
    }
}

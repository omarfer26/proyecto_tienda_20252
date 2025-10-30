package com.ufps.prueba.dto;

public class VentaDetalleRequestDto {

    private Integer productoId;
    private Integer cantidad;
    private Double precioUnitario;

    // ===========================
    //     CONSTRUCTORES
    // ===========================
    public VentaDetalleRequestDto() {}

    public VentaDetalleRequestDto(Integer productoId, Integer cantidad, Double precioUnitario) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // ===========================
    //     GETTERS Y SETTERS
    // ===========================
    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
}

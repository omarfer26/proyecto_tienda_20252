package com.ufps.prueba.dto;

import java.util.List;

public class VentaRequestDto {

    private Integer clienteId;
    private Double total;
    private List<VentaDetalleRequestDto> detalles;

    public VentaRequestDto() {}

    public VentaRequestDto(Integer clienteId, Double total, List<VentaDetalleRequestDto> detalles) {
        this.clienteId = clienteId;
        this.total = total;
        this.detalles = detalles;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<VentaDetalleRequestDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<VentaDetalleRequestDto> detalles) {
        this.detalles = detalles;
    }
    
}

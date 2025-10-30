package com.ufps.prueba.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Double total;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoVenta> productoVentas = new ArrayList<>();

    public Venta() {}

    public Venta(Cliente cliente, Double total) {
        this.cliente = cliente;
        this.total = total;
    }

    public int getClienteId() {
        return id;
    }

    public void setClienteId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ProductoVenta> getProductoVentas() {
        return productoVentas;
    }

    public void setProductoVentas(List<ProductoVenta> productoVentas) {
        this.productoVentas = productoVentas;
    }
    
    public void addProductoVenta(ProductoVenta productoVenta) {
        productoVentas.add(productoVenta);
        productoVenta.setVenta(this);
    }

    public void removeProductoVenta(ProductoVenta productoVenta) {
        productoVentas.remove(productoVenta);
        productoVenta.setVenta(null);
    }

    public void calcularTotal() {
        this.total = productoVentas.stream()
                .mapToDouble(pv -> pv.getPrecio() * pv.getCantidad())
                .sum();
    }
}

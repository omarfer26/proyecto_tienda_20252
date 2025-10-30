package com.ufps.prueba.services;

import com.ufps.prueba.dto.VentaRequestDto;
import com.ufps.prueba.dto.VentaDetalleRequestDto;
import com.ufps.prueba.entities.Producto;
import com.ufps.prueba.entities.ProductoVenta;
import com.ufps.prueba.entities.Venta;
import com.ufps.prueba.repositories.ProductoRepository;
import com.ufps.prueba.repositories.VentaRepository;
import com.ufps.prueba.repositories.ProductoVentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoVentaRepository productoVentaRepository;

    public String crearVenta(VentaRequestDto request) {

        Venta venta = new Venta();
        venta.setClienteId(request.getClienteId());
        venta.setTotal(request.getTotal());
        venta.setProductoVentas(new ArrayList<>());

        List<VentaDetalleRequestDto> detalles = request.getDetalles();

        for (VentaDetalleRequestDto detalle : detalles) {
            Integer idProducto = detalle.getProductoId();

            if (!productoRepository.existsById(idProducto)) {
                throw new RuntimeException("Producto no encontrado: " + idProducto);
            }

            Producto producto = productoRepository.findById(idProducto).orElse(null);

            if (producto.getCantidad() < detalle.getCantidad()) {
                throw new RuntimeException("No hay suficientes existencias del producto: " + idProducto);
            }

            ProductoVenta productoVenta = new ProductoVenta();
            productoVenta.setProducto(producto);
            productoVenta.setVenta(venta);
            productoVenta.setCantidad(detalle.getCantidad());
            productoVenta.setPrecio(detalle.getPrecioUnitario());

            producto.setCantidad(producto.getCantidad() - detalle.getCantidad());
            productoRepository.save(producto);

            venta.getProductoVentas().add(productoVenta);
        }

        ventaRepository.save(venta);

        return "Venta finalizada correctamente";
    }
}

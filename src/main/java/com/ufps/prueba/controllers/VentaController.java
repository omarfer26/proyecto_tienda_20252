package com.ufps.prueba.controllers;

import com.ufps.prueba.dto.VentaRequestDto;
import com.ufps.prueba.services.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService = new VentaService();

    @PostMapping
    public ResponseEntity<String> crearVenta(@RequestBody VentaRequestDto request) {
        try {
            String mensaje = ventaService.crearVenta(request);
            return ResponseEntity.ok(mensaje);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

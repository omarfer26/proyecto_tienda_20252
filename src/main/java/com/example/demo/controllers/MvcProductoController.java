package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Producto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/productos")
@RequiredArgsConstructor
public class MvcProductoController {
	
	private final ProductoRepository productoRepo;
    private final CategoriaRepository categoriaRepo;
	
	@GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoRepo.findAll());
        return "productos/lista";
    }
	
	@GetMapping("/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaRepo.findAll());
        return "productos/form";
    }
	
	@GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Integer id, Model model) {
        Producto producto = productoRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));

        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaRepo.findAll());
        return "productos/form";
    }
	
	@PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoRepo.save(producto);
        return "redirect:/productos";
    }
	
	@GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoRepo.deleteById(id);
        return "redirect:/productos";
    }

}

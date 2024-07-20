package com.raul.apirest.apirest.Controllers;

import com.raul.apirest.apirest.Entities.Producto;
import com.raul.apirest.apirest.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos() {

        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {

        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {

        return productoRepository.save(producto);
    }

    @PutMapping
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productDetails) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));

        producto.setNombre(productDetails.getNombre());
        producto.setPrecio(productDetails.getPrecio());

        return productoRepository.save(producto);

    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));

        productoRepository.delete(producto);

        return "Producto eliminado con el ID: " + id;
    }
}
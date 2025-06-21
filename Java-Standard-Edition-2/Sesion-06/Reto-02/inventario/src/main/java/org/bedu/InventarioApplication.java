package org.bedu.inventario;

import org.bedu.inventario.model.*;
import org.bedu.inventario.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ProductoRepository productoRepo,
                                      MarcaRepository marcaRepo,
                                      CategoriaRepository categoriaRepo) {
        return args -> {
            // Crear marcas
            Marca apple = marcaRepo.save(new Marca(null, "Apple"));
            Marca samsung = marcaRepo.save(new Marca(null, "Samsung"));

            // Crear categorías
            Categoria tecnologia = categoriaRepo.save(new Categoria(null, "Tecnología"));
            Categoria electrodomesticos = categoriaRepo.save(new Categoria(null, "Electrodomésticos"));

            // Crear productos
            productoRepo.save(new Producto(null, "iPhone 15", "Smartphone", 15000, apple, tecnologia));
            productoRepo.save(new Producto(null, "iPad Pro", "Tablet", 12000, apple, tecnologia));
            productoRepo.save(new Producto(null, "Galaxy S23", "Smartphone", 14000, samsung, tecnologia));
            productoRepo.save(new Producto(null, "Smart TV", "Televisor", 20000, samsung, electrodomesticos));

            // Mostrar datos
            System.out.println("\n📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepo.findByMarca(marca).forEach(producto ->
                        System.out.println("   - " + producto.getNombre() + " ($" + producto.getPrecio() + ")"));
            });
        };
    }
}
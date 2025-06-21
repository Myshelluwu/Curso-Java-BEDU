package com.example.inventario.runner;

import com.example.inventario.model.Producto;
import com.example.inventario.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final ProductoRepository productoRepository;

    public DataInitializer(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Limpiar datos existentes
        productoRepository.deleteAll();

        // Guardar nuevos productos
        productoRepository.save(new Producto("Laptop Lenovo", "Laptop de 16GB RAM y 512GB SSD", 12500));
        productoRepository.save(new Producto("Mouse Logitech", "Mouse inalámbrico ergonómico", 350));
        productoRepository.save(new Producto("Teclado Mecánico", "Teclado mecánico con switches azules", 950));
        productoRepository.save(new Producto("Monitor Samsung", "Monitor curvo 27\" 4K", 3200));
        productoRepository.save(new Producto("mouse pad", "Alfombrilla grande para mouse", 150));

        // Consultas y resultados
        System.out.println("\n📦 Productos con precio mayor a 500:");
        productoRepository.findByPrecioGreaterThan(500).forEach(System.out::println);

        System.out.println("\n🔍 Productos que contienen 'lap':");
        productoRepository.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

        System.out.println("\n🎯 Productos con precio entre 400 y 1000:");
        productoRepository.findByPrecioBetween(400, 1000).forEach(System.out::println);

        System.out.println("\n📘 Productos cuyo nombre empieza con 'm':");
        productoRepository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
    }
}
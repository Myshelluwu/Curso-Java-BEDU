package org.bedu.inventario.repository;

import org.bedu.inventario.model.Marca;
import org.bedu.inventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByMarca(Marca marca);
}
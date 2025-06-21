package org.bedu.inventario.repository;

import org.bedu.inventario.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
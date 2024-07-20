package com.raul.apirest.apirest.Repositories;

import com.raul.apirest.apirest.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

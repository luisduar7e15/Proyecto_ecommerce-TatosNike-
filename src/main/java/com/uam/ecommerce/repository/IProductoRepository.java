package com.uam.ecommerce.repository;

import com.uam.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProductoRepository extends JpaRepository <Producto, UUID>
{
    @Query("select e from Producto e where e.display = true and e.cantidad > 0")
    List<Producto> getProductoDisplay();
}

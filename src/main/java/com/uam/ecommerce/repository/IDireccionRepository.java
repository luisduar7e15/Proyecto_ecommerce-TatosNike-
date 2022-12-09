package com.uam.ecommerce.repository;

import com.uam.ecommerce.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDireccionRepository extends JpaRepository <Direccion, Long> {
}

package com.uam.ecommerce.repository;

import com.uam.ecommerce.model.UsuarioWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioWeb, String>
{
    Optional<UsuarioWeb> findOneByEmail(String email);
}

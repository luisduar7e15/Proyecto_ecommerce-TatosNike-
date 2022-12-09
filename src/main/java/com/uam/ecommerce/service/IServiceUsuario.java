package com.uam.ecommerce.service;

import com.uam.ecommerce.model.UsuarioWeb;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceUsuario {

    public List<UsuarioWeb> listAll();

    public UsuarioWeb findById(String id);

    public UsuarioWeb saveUsuario(UsuarioWeb usuarioWeb);

    public void deleteUsuario (String id);
}

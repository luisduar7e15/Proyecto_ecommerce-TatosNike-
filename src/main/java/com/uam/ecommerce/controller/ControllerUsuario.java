package com.uam.ecommerce.controller;

import com.uam.ecommerce.model.UsuarioWeb;
import com.uam.ecommerce.service.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class ControllerUsuario {

    @Qualifier("serviceUsuario")
    @Autowired
    private IServiceUsuario service;

    @GetMapping("/list")
    public List<UsuarioWeb> getAll(){
        return service.listAll();
    }

    @PostMapping("/save")
    public UsuarioWeb saveUsuario(@RequestBody UsuarioWeb usuarioWeb){
        return service.saveUsuario(usuarioWeb);
    }

    @GetMapping({"/{id}"})
    public UsuarioWeb getUsuario(@PathVariable String id){
        return service.findById(id);
    }

    @DeleteMapping({"/delete/{id}"})
    public void deleteUsuario(@PathVariable String id){
        service.deleteUsuario(id);
    }

}

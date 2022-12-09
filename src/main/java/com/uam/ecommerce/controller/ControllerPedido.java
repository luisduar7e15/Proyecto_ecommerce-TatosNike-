package com.uam.ecommerce.controller;

import com.uam.ecommerce.model.Pedido;
import com.uam.ecommerce.service.IServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class ControllerPedido {
    @Qualifier("servicePedido")
    @Autowired
    private IServicePedido service;

    @GetMapping("/list")
    public List<Pedido> getAll(){
        return service.listAll();
    }

    @PostMapping("/save")
    public Pedido savePedido(@RequestBody Pedido pedido){
        return service.savePedido(pedido);
    }

    @GetMapping({"/{id}"})
    public Pedido getPedido(@PathVariable UUID id){
        return service.findById(id);
    }

    @DeleteMapping({"/delete/{id}"})
    public void deletePedido(@PathVariable UUID id){
        service.deletePedido(id);
    }
}

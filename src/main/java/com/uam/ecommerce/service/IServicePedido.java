package com.uam.ecommerce.service;

import com.uam.ecommerce.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IServicePedido {

    public List<Pedido> listAll();

    public Pedido findById(UUID id);

    public Pedido savePedido(Pedido pedido);

    public void deletePedido (UUID id);
}

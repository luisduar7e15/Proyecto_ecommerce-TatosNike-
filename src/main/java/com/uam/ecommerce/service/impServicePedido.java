package com.uam.ecommerce.service;

import com.uam.ecommerce.model.Detalle;
import com.uam.ecommerce.model.Pedido;
import com.uam.ecommerce.repository.IDetalleRepository;
import com.uam.ecommerce.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Component("servicePedido")
public class impServicePedido implements IServicePedido{

    @Autowired
    private IPedidoRepository repo;

    @Autowired
    private IDetalleRepository repoDet;

    @Override
    public List<Pedido> listAll() {
        return repo.findAll();
    }

    @Override
    public Pedido findById(UUID id) {
        return repo.findById(id).get();
    }


    @Override
    public Pedido savePedido(Pedido pedido) {
        Pedido o = new Pedido();
        o.setPago(pedido.getPago());
        o.setFecha(pedido.getFecha());
        o.setEstado(pedido.getEstado());
        o.setTotal(pedido.getTotal());
        List<Detalle> detalles = pedido.getDetalles();
        pedido.setDetalles(null);
        for (Detalle det : detalles){
            det.setPedido(o);
        }
        o.setDetalles(detalles);
        return repo.save(o);
    }
    @Override
    public void deletePedido(UUID id) {
        repo.deleteById(id);
    }
}

package com.uam.ecommerce.service;

import com.uam.ecommerce.model.Order;
import com.uam.ecommerce.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("serviceOrder")
public class impServiceOrder implements IServiceOrder{
    @Autowired
    private IOrderRepository repo;

    @Override
    public List<Order> listAll() {
        return repo.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return repo.save(order);
    }
}

package com.uam.ecommerce.controller;

import com.uam.ecommerce.model.Order;
import com.uam.ecommerce.service.IServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ControllerOrder {

    @Qualifier("serviceOrder")
    @Autowired
    private IServiceOrder service;

    @GetMapping("/list")
    public List<Order> getAll(){
       return service.listAll();
    }

    public Order saveOrder(@RequestBody Order order){
        return service.saveOrder(order);
    }
}

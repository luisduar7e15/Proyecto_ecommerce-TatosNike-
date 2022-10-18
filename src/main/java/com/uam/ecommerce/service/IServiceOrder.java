package com.uam.ecommerce.service;

import com.uam.ecommerce.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceOrder {

    public List<Order> listAll();
    public Order saveOrder(Order order);
}

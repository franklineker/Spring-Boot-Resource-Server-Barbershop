package com.drnavalhabarbershop.resourceserver.service;

import com.drnavalhabarbershop.resourceserver.domain.Order;
import com.drnavalhabarbershop.resourceserver.mapper.OrderMapper;
import com.drnavalhabarbershop.resourceserver.repository.OrderRepository;
import com.drnavalhabarbershop.resourceserver.web.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(OrderRequest request) {
        return orderRepository.save(OrderMapper.toOrder(request));
    }

    public Order findById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found."));
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order update(String id, OrderRequest request) {

        checkOrderExixts(id);

        Order order = OrderMapper.toOrder((request));
        order.setId(id);

        return orderRepository.save(order);
    }

    public Order delete(String id) {

        checkOrderExixts(id);
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException(("Order not found.")));

        orderRepository.deleteById(id);

        return order;
    }

    private void checkOrderExixts(String id) {
        if(orderRepository.findById(id).isEmpty()){
            throw new RuntimeException("Order not found.");
        }
    }
}

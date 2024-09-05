package com.neil.microservices.order.service;

import com.neil.microservices.order.client.InventoryClient;
import com.neil.microservices.order.dto.OrderRequest;
import com.neil.microservices.order.model.Order;
import com.neil.microservices.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class OrderService {

    @Autowired
    private InventoryClient inventoryClient;

    @Autowired
    private OrderRepository orderRepository;


    public void placeOrder(OrderRequest orderRequest){
        boolean productInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if(productInStock) {
            Order order = new Order();

            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
        }
        else{
            throw  new RuntimeException("Product with skuCode "+ orderRequest.skuCode()+" is not in stock");
        }
    }
}

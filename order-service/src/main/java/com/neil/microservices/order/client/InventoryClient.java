package com.neil.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "inventory", url = "http://localhost:8082")
public interface InventoryClient {
    @GetMapping(value = "/api/inventory")
    boolean isInStock(String skuCode, Integer quantity);
}

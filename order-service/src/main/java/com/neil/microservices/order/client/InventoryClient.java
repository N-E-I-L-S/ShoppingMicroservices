package com.neil.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("INVENTORY-SERVICE")
public interface InventoryClient {
    @GetMapping(value = "/api/inventory")
    boolean isInStock(@RequestParam  String skuCode,@RequestParam Integer quantity);
}

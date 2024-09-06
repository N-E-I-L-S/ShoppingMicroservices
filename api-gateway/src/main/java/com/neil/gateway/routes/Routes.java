package com.neil.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class Routes {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order_service", r -> r.path("/api/order/**")
//                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://ORDER-SERVICE"))
                .route("inventory-service", r -> r.path("/api/inventory/**")
//                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://INVENTORY-SERVICE"))
                .route("product-service", r -> r.path("/api/product/**")
//                        .filters(f -> f.stripPrefix(2))
                        .uri("lb://PRODUCT-SERVICE"))
                .build();
    }
}

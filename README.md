## Architecture Design
![alt text](https://github.com/N-E-I-L-S/ShoppingMicroservices/blob/master/Architecture_diagram.png)
This project demonstrates a microservices-based architecture built using Spring Boot along with Eureka Discovery Service, API Gateway, Docker, OpenFeign, and various services like Order Service, Product Service, Inventory Service, and Auth Service.

## Overview
This microservices architecture includes the following key components:
<ul>
<li>API Gateway: Acts as a reverse proxy, routing requests from clients to the appropriate microservices.</li>
<li>Eureka Discovery Server: Provides service registration and discovery for all microservices, enabling them to locate and communicate with one another.</li>
<li>Microservices: Each service (Order, Product, Inventory, Auth) handles a specific business domain.</li>
<li>OpenFeign: Enables declarative REST client communication between microservices.</li>
<li>Databases: Services use MySQL and MongoDB as their data stores, as indicated by the diagram.</li>
</ul>

## Architecture Components

<ol>
        <li>
            <strong>API Gateway</strong>
            <ul>
                <li>Centralized entry point for client requests.</li>
                <li>Routes incoming requests to the appropriate microservice.</li>
                <li>Used for load balancing and authorization checks.</li>
            </ul>
        </li>
        <li>
            <strong>Eureka Server (Discovery Service)</strong>
            <ul>
                <li>Service registry where microservices register themselves.</li>
                <li>Allows dynamic discovery of microservices at runtime, enabling service-to-service communication.</li>
            </ul>
        </li>
        <li>
            <strong>Order Service</strong>
            <ul>
                <li>Handles order-related operations.</li>
                <li>Communicates with the <strong>Inventory Service</strong> using <strong>OpenFeign</strong> to check stock before placing an order.</li>
                <li>Uses <strong>MySQL</strong> for data storage.</li>
            </ul>
        </li>
        <li>
            <strong>Product Service</strong>
            <ul>
                <li>Manages product information and catalog.</li>
                <li>Uses <strong>MongoDB</strong> for product data persistence.</li>
            </ul>
        </li>
        <li>
            <strong>Inventory Service</strong>
            <ul>
                <li>Responsible for managing inventory data.</li>
                <li>Interacts with the <strong>Order Service</strong> to update stock.</li>
                <li>Uses <strong>MySQL</strong> as its data store.</li>
            </ul>
        </li>
        <li>
            <strong>Auth Service</strong>
            <ul>
                <li>Provides authentication and authorization mechanisms.</li>
                <li>Integrates with other services for secured access using OAuth or JWT.</li>
                <li>Uses <strong>MySQL</strong> for user authentication data.</li>
            </ul>
        </li>
    </ol>

## Project Flow
    
<ul>
        <li><strong>Spring Boot</strong>: Java-based framework used for creating microservices.</li>
        <li><strong>Spring Cloud Netflix</strong>: Eureka, Feign, and Zuul for microservice communication, service discovery, and API routing.</li>
        <li><strong>Spring Data JPA</strong>: For persistence using MySQL in some services.</li>
        <li><strong>Spring Data MongoDB</strong>: For handling data in MongoDB in the Product Service.</li>
        <li><strong>Docker</strong>: Each service is containerized and deployed using Docker.</li>
        <li><strong>Feign</strong>: Declarative REST client used for inter-service communication.</li>
        <li><strong>MySQL</strong>: Used for Order, Inventory, and Auth services as the relational database.</li>
        <li><strong>MongoDB</strong>: Used for Product Service as the NoSQL database.</li>
</ul>

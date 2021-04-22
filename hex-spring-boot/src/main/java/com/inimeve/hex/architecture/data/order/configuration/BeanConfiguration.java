package com.inimeve.hex.architecture.data.order.configuration;

import com.inimeve.hex.architecture.Application;
import com.inimeve.hex.architecture.core.order.repository.OrderRepository;
import com.inimeve.hex.architecture.core.order.service.OrderService;
import com.inimeve.hex.architecture.data.order.mock.MockOrderRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }

    @Bean
    OrderRepository orderRepository() {
        return new MockOrderRepository();
    }
}

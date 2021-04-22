package com.inimeve.hex.architecture.data.order.mock;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.inimeve.hex.architecture.core.order.domain.Order;
import com.inimeve.hex.architecture.core.order.domain.Product;
import com.inimeve.hex.architecture.core.order.repository.OrderRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Component
// @Primary
public class MockOrderRepository implements OrderRepository {

    List<Order> orderMocks = Arrays.asList(
        new Order(UUID.randomUUID(), new Product(UUID.randomUUID(), new BigDecimal("10.9"), "Test Product 1")),
        new Order(UUID.randomUUID(), new Product(UUID.randomUUID(), new BigDecimal("30.3"), "Test Product 2"))
    );

    @Override
    public Optional<Order> findById(UUID id) {
        Order order = orderMocks.stream()
            .filter(o -> id.equals(o.getId()))
            .findAny()
            .orElse(null);
        return Optional.ofNullable(order);
    }

    @Override
    public void save(Order order) {
        this.orderMocks.add(order);
    }

    @Override
    public List<Order> getAll() {
        return this.orderMocks;
    }

}

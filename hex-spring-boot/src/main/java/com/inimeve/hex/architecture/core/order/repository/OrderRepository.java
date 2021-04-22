package com.inimeve.hex.architecture.core.order.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.inimeve.hex.architecture.core.order.domain.Order;

public interface OrderRepository {
    Optional<Order> findById(UUID id);

    void save(Order order);

    List<Order> getAll();
}

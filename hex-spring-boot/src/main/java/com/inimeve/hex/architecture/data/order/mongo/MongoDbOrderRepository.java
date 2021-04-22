// package com.inimeve.hex.architecture.data.order.mongo;

// import java.util.Optional;
// import java.util.UUID;

// import com.inimeve.hex.architecture.core.order.domain.Order;
// import com.inimeve.hex.architecture.core.order.repository.OrderRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Primary;
// import org.springframework.stereotype.Component;

// // @Component
// public class MongoDbOrderRepository implements OrderRepository {

//     private final SpringDataMongoOrderRepository orderRepository;

//     @Autowired
//     public MongoDbOrderRepository(final SpringDataMongoOrderRepository orderRepository) {
//         this.orderRepository = orderRepository;
//     }

//     @Override
//     public Optional<Order> findById(final UUID id) {
//         return orderRepository.findById(id);
//     }

//     @Override
//     public void save(final Order order) {
//         orderRepository.save(order);
//     }

// }

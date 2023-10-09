package com.drnavalhabarbershop.resourceserver.repository;

import com.drnavalhabarbershop.resourceserver.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
package com.example.demo.repository;

import com.example.demo.model.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Integer> {
}

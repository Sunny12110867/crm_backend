package com.sunny.crm.Repository;

import com.sunny.crm.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {
}

package com.sunny.crm.Repository;

import com.sunny.crm.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

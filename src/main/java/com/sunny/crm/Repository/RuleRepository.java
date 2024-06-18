package com.sunny.crm.Repository;

import com.sunny.crm.model.Rule;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface RuleRepository extends JpaRepository<Rule, Long> {
}

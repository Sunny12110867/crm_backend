package com.sunny.crm.Repository;

import com.sunny.crm.model.Campaign;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}

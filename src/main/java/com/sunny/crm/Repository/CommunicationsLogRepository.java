package com.sunny.crm.Repository;

import com.sunny.crm.model.CommunicationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunicationsLogRepository extends JpaRepository<CommunicationLog, Long> {

    List<CommunicationLog> findByCampaignId(Long campaignId);

}

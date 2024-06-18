package com.sunny.crm.service;

import com.sunny.crm.Repository.CommunicationsLogRepository;
import com.sunny.crm.model.CommunicationLog;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommunicationsLogService {

    @Autowired
    private CommunicationsLogRepository communicationsLogRepository;

    public List<CommunicationLog> getAllLogs() {
        return communicationsLogRepository.findAll();
    }

    public Optional<CommunicationLog> getLogById(Long id) {
        return communicationsLogRepository.findById(id);
    }

    public CommunicationLog saveLog(CommunicationLog log) {
        return communicationsLogRepository.save(log);
    }

    public void deleteLog(Long id) {
        communicationsLogRepository.deleteById(id);
    }

    public void updateStatus(Long id, String status) {
        if (id == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }

        Optional<CommunicationLog> logOpt = communicationsLogRepository.findById(id);
        if (logOpt.isPresent()) {
            CommunicationLog log = logOpt.get();
            log.setStatus(status);
            communicationsLogRepository.save(log);
        } else {
            throw new RuntimeException("Communication log not found with id: " + id);
        }
    }

    // New method to fetch logs by campaign ID
    public List<CommunicationLog> getLogsByCampaignId(Long campaignId) {
        return communicationsLogRepository.findByCampaignId(campaignId);
    }
}

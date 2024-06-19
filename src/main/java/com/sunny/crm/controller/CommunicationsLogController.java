package com.sunny.crm.controller;

import com.sunny.crm.model.CommunicationLog;
import com.sunny.crm.service.CommunicationsLogService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communications-logs")
@Transactional
@CrossOrigin(origins = "https://crmapplication-sunny12110867s-projects.vercel.app")
public class CommunicationsLogController {

    @Autowired
    private CommunicationsLogService communicationLogService;

    @GetMapping
    public List<CommunicationLog> getAllLogs() {
        return communicationLogService.getAllLogs();
    }

    @GetMapping("/{id}")
    public CommunicationLog getLogById(@PathVariable Long id) {
        return communicationLogService.getLogById(id)
                .orElseThrow(() -> new RuntimeException("Communication log not found with id: " + id));
    }

    @PostMapping
    public CommunicationLog addLog(@RequestBody CommunicationLog log) {
        return communicationLogService.saveLog(log);
    }

    @PutMapping("/{id}")
    public CommunicationLog updateLog(@PathVariable Long id, @RequestBody CommunicationLog log) {
        if (communicationLogService.getLogById(id).isEmpty()) {
            throw new RuntimeException("Communication log not found with id: " + id);
        }
        log.setId(id);
        return communicationLogService.saveLog(log);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        communicationLogService.deleteLog(id);
    }

    @GetMapping("/campaign/{id}/logs")
    public List<CommunicationLog> getLogsByCampaignId(@PathVariable Long id) {
        return communicationLogService.getLogsByCampaignId(id);
    }
}

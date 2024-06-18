package com.sunny.crm.controller;

import com.sunny.crm.model.CommunicationLog;
import com.sunny.crm.service.CommunicationsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping("/api/vendor")
@CrossOrigin(origins = "http://localhost:3000")
public class VendorController {

    @Autowired
    private CommunicationsLogService communicationsLogService;

    private final Random random = new Random();

    @PostMapping("/send")
    public CommunicationLog sendCampaign(@RequestBody CommunicationLog log) {
        String status = random.nextInt(100) < 90 ? "SENT" : "FAILED";
        log.setStatus(status);
        log.setSentAt(LocalDateTime.now());
        return communicationsLogService.saveLog(log);
    }

}

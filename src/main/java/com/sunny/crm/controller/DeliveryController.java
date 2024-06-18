package com.sunny.crm.controller;

import com.sunny.crm.model.CommunicationLog;
import com.sunny.crm.service.CommunicationsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
@CrossOrigin(origins = "https://crmapplication-sunny12110867s-projects.vercel.app/")
public class DeliveryController {

    @Autowired
    private CommunicationsLogService communicationsLogService;

    @PostMapping("/receipt/{id}")
    public void updateDeliveryStatus(@PathVariable Long id, @RequestBody String status) {
        if (id == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }
        communicationsLogService.updateStatus(id, status);
    }
}


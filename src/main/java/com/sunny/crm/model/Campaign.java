package com.sunny.crm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String rules;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "campaign")
    @JsonManagedReference
    private List<CommunicationLog> communicationLogs;


    public Campaign() {
        // Default constructor
    }

    public Campaign(Long id, String name, String description, String rules, LocalDateTime createdAt, LocalDateTime updatedAt, List<CommunicationLog> communicationLogs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rules = rules;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.communicationLogs = communicationLogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<CommunicationLog> getCommunicationLogs() {
        return communicationLogs;
    }

    public void setCommunicationLogs(List<CommunicationLog> communicationLogs) {
        this.communicationLogs = communicationLogs;
    }
}

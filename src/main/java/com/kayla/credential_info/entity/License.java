package com.kayla.credential_info.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licenseId;

    private String licenseNumber;
    private String licenseState;
    private String licenseBoard;

    @Column(name = "license_start")
    private LocalDate licenseStart;
    @Column(name = "license_end")
    private LocalDate licenseEnd;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    public License() {}

    public License(String licenseNumber, String licenseState, String licenseBoard, LocalDate licenseStart, LocalDate licenseEnd, Provider provider) {
        this.licenseNumber = licenseNumber;
        this.licenseState = licenseState;
        this.licenseBoard = licenseBoard;
        this.licenseStart = licenseStart;
        this.licenseEnd = licenseEnd;
        this.provider = provider;
    }
}

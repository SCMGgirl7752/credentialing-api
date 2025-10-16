package com.kayla.credential_info.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceId;

    private String insuranceCompany;
    private String insurancePolicyNumber;
    private String insuranceType;
    private Double insuranceAmountFull;
    private Double insuranceAmountAggregate;
    
    @Column(name = "insurance_start")
    private LocalDate insuranceStart;
    @Column(name = "insurance_end")
    private LocalDate insuranceEnd;

    @OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL)
    private Set<ProviderInsurance> providerInsurance = new HashSet<>();

    public Insurance() {}

    public Insurance(String insuranceCompany, String insurancePolicyNumber, String insuranceType, Double insuranceAmountFull,
    Double insuranceAmountAggregate, LocalDate insuranceStart, LocalDate insuranceEnd) {
        this.insuranceCompany = insuranceCompany;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.insuranceType = insuranceType;
        this.insuranceAmountFull = insuranceAmountFull;
        this.insuranceAmountAggregate = insuranceAmountAggregate;
        this.insuranceStart = insuranceStart;
        this.insuranceEnd = insuranceEnd;
    }
}

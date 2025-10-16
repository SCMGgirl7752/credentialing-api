package com.kayla.credential_info.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ProviderInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider providerId;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insuranceId;

    public ProviderInsurance() {}

    public ProviderInsurance(Provider providerId, Insurance insuranceId) {
        this.providerId = providerId;
        this.insuranceId = insuranceId;
    }
}

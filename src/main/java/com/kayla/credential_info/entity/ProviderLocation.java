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
public class ProviderLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider providerId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location locationId;

    public ProviderLocation() {}

    public ProviderLocation(Provider providerId, Location locationId) {
        this.providerId = providerId;
        this.locationId = locationId;
    }
}

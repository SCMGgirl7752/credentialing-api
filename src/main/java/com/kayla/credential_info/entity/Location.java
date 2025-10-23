package com.kayla.credential_info.entity;

import java.util.HashSet;
import java.util.Set;

import com.kayla.credential_info.dao.LocationData;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private String locationName;
    private String locationAddress;
    private String locationState;
    private String locationZip;
    private String locationWebsite;
    private String locationPhone;

    @OneToMany(mappedBy = "location", cascade=CascadeType.ALL)
    private Set<ProviderLocation> providerLocation = new HashSet<>();

    public Location() {}

    public Location(String locationName, String locationAddress, String locationState, String locationZip, String locationWebsite, String locationPhone) {
        this.locationName = locationName;
        this.locationAddress = locationAddress;
        this.locationState = locationState;
        this.locationZip = locationZip;
        this.locationWebsite = locationWebsite;
        this.locationPhone = locationPhone;
    }

    public Location(LocationData locationData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


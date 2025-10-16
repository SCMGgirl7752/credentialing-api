package com.kayla.credential_info.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    private String firstName;
    private String lastName;
    private Long npiNumber;
    private String cellNumber;
    private String taxonomyCode;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private Set<ProviderLocation> providerLocation = new HashSet<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private Set<ProviderInsurance> providerInsurance = new HashSet<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private Set<License> license = new HashSet<>();

    public Provider() {}

    public Provider(String firstName, String lastName, Long npiNumber, String cellNumber, String taxonomyCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.npiNumber = npiNumber;
        this.cellNumber = cellNumber;
        this.taxonomyCode = taxonomyCode;
    }
}

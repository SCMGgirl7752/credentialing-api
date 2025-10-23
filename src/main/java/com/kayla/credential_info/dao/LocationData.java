package com.kayla.credential_info.dao;

import java.util.HashSet;
import java.util.Set;

import com.kayla.credential_info.entity.Location;
import com.kayla.credential_info.entity.Provider;
import com.kayla.credential_info.entity.ProviderLocation;

import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: fix endpoints and finish with debugging

@Data
@NoArgsConstructor
public class LocationData {

    private Long locationId;
    private String locationName;
    private String locationAddress;
    private String locationState;
    private String locationZip;
    private String locationWebsite;
    private String locationPhone;
    private Set<ProviderLocationData> providerLocation = new HashSet<>();

    public LocationData(Location location){
        this.locationId = location.getLocationId();
        this.locationName = location.getLocationName();
        this.locationAddress = location.getLocationAddress();
        this.locationState = location.getLocationState();
        this.locationZip = location.getLocationZip();
        this.locationWebsite = location.getLocationWebsite();
        this.locationPhone = location.getLocationPhone();
        
        for (ProviderLocation pl : location.getProviderLocation()) {
            this.providerLocation.add(new ProviderLocationData(pl.getProviderId()));
        }
    }

    public LocationData(Long locationId, String locationName, String locationAddress, String locationState, String locationZip,
        String locationWebsite, String locationPhone) {
            this.locationId = locationId;
            this.locationName = locationName;
            this.locationAddress = locationAddress;
            this.locationState = locationState;
            this.locationZip = locationZip;
            this.locationWebsite = locationWebsite;
            this.locationPhone = locationPhone;
    }

    public Location toLocation() {
        Location location = new Location();
        location.setLocationId(this.locationId);
        location.setLocationName(this.locationName);
        location.setLocationAddress(this.locationAddress);
        location.setLocationState(this.locationState);
        location.setLocationZip(this.locationZip);
        location.setLocationWebsite(this.locationWebsite);
        location.setLocationPhone(this.locationPhone);

    for (ProviderLocationData pld : providerLocation) {
        location.getProviderLocation().add(pld.toProviderLocation());
    }
        return location;
    }

    @Data
    @NoArgsConstructor
    public class ProviderLocationData {
    private Long providerLocationId;
    private Long providerId;
    private String firstName;
    private String lastName;
    private Long npiNumber;

    public ProviderLocationData(Provider provider) {
        this.providerId = provider.getProviderId();

        this.providerId = provider.getProviderId();
        this.firstName = provider.getFirstName();
        this.lastName = provider.getLastName();
        this.npiNumber = provider.getNpiNumber();// optional
    }

    public ProviderLocation toProviderLocation() { // change this to ProviderLoacation? or to Provider?
        ProviderLocation pl = new ProviderLocation();
        pl.setProviderLocationId(this.providerLocationId);

    Provider provider = new Provider();
    provider.setProviderId(this.providerId);
    provider.setFirstName(this.firstName);
    provider.setLastName(this.lastName);
    provider.setNpiNumber(this.npiNumber);

    //pl.setProvider(provider);
    //return pl;

    //    Provider provider = new Provider();
    //    provider.setProviderId(this.providerId);
    //    pl.setProvider(provider);

        return pl;

    }
    }
}

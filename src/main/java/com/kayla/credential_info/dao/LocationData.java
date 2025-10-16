package com.kayla.credential_info.dao;

import java.util.HashSet;
import java.util.Set;
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

    public LocationData(ProviderLocation location){ //should these be with the location since I am pulling from there or should I link to the provider lcoation?
        this.locationId = providerLocation.getLocationId();
        this.locationName = location.getLocationName();
        this.locationAddress = location.getLocationAddress();
        this.locationState = location.getLocationState();
        this.locationZip = location.getLocationZip();
        this.locationWebsite = location.getLocationWebsite();
        this.locationPhone = location.getLocationPhone();
        
        for (ProviderLocation pl : location.getProviderLocation()) {
            this.providerLocation.add(new ProviderLocationData(pl));
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

    public ProviderLocation toLocation() {
        ProviderLocation location = new ProviderLocation();// check here for the same error of location or provider location
        location.setLocationId(this.locationId);
        location.setLocationName(this.locationName);// check if I need the "this." or not here
        location.setLocationAddress(this.locationAddress);
        location.setLocationState(this.locationState);
        location.setLocationZip(this.locationZip);
        location.setLocationWebsite(this.locationWebsite);
        location.setLocationPhone(this.locationPhone);

    for (ProviderLocationData pld : providerLocation) {
        location.getProviderLocation().add(pld.toProviderLocation());
    }
    //for (ProviderLocationData pld : this.providerLocation) {
    //    ProviderLocation pl = pld.toProviderLocation();
    //    pl.setLocation(location); // wire the relationship
    //    location.getProviderLocation().add(pl); // add to the list
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

    public ProviderLocationData(ProviderLocation pl) {
        this.providerLocationId = pl.getProviderLocationId();
        
        Provider provider = pl.getProvider();
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
    provider.setNpinNumber(this.npinNumber);

    //pl.setProvider(provider);
    //return pl;

    //    Provider provider = new Provider();
    //    provider.setProviderId(this.providerId);
    //    pl.setProvider(provider);

        return pl;

    }
}

package com.kayla.credential_info.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kayla.credential_info.dao.LocationDao;
import com.kayla.credential_info.dao.LocationData;
import com.kayla.credential_info.entity.ProviderLocation;

@Service
public class CredentialService {

    @Autowired
    private LocationDao locationDao;

    @Transactional(readOnly = false)
    public LocationData saveLocation(LocationData locationData) {
        ProviderLocation location = locationData.toLocation();
        Location dbLocation = locationDao.save(location);
        //System.out.println("Saving location: " + locationData);
        return new LocationData(dbLocation);
    }
// TODO: fix endpoints and finish with debugging


    public String processEntity(String entity) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        LocationData locationData = mapper.readValue(entity, LocationData.class);

        ProviderLocation location = new ProviderLocation(locationData); // assuming constructor exists
        locationDao.save(location);

        return "Location saved successfully!";
    } catch (Exception e) {
        e.printStackTrace();
        return "Failed to process location data.";
    }
}

    @Transactional(readOnly = true)
    public LocationData retrieveLocationById(Long locationId) {
        Location location = findLocationById(locationId);
        return new LocationData(location);
    }

    private Location findLocationById(Long locationId) {
        return locationDao.findByID(locationID).orElseThrow(()-> new NoSuchElementException("Location with ID=" + locationId + " was not found."));
    }

}

//TODO: Test with ARC and see if you can get and post data correctly.



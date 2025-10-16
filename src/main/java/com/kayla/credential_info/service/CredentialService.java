package com.kayla.credential_info.service;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.NoSuchElementException;

import com.kayla.credential_info.entity.Location;
import com.kayla.credential_info.entity.ProviderLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import com.kayla.credential_info.dao.LocationDao;
import com.kayla.credential_info.dao.LocationData;


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

    @Transactional(readOnly = true)
    public List<LocationData> retrieveAllLocations() {
        // TODO Auto-generated method stub
        List<Location> locationEntity = locationDao.findAll();
        List<LocationData> locationDtos = new LinkedList<>();

        for (Location location : locationEntity) {
            LocationData locationData = new LocationData(location);
            locationDtos.add(locationData);
        }

        return locationDtos;
    }

    @Transactional(readOnly = false)
    public void deleteLocation(Long locationId) {
        // TODO Auto-generated method stub
        Location location = findLocationById(locationId);
        locationDao.delete(location);
    }

}

//TODO: Test with ARC and see if you can get and post data correctly.



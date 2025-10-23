package com.kayla.credential_info.controller.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kayla.credential_info.dao.LocationData;
import com.kayla.credential_info.service.CredentialService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/credential_info")
@Slf4j

public class CredentialController {

    @Autowired
    private final CredentialService credentialService;

    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping("/location")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String postMethodName(@RequestBody String entity) {
        log.info("Received entity: {}", entity);
        credentialService.processEntity(entity);
        return entity;
    }
    
    @GetMapping("/location/{locationId}")
    public LocationData retrieveLocation(@PathVariable Long locationId){
        log.info("Retrieving location with ID={}", locationId);
        return credentialService.retrieveLocationById(locationId);
    }

    @PutMapping("/location/{locationId}")
    public LocationData updateLocation(@PathVariable Long locationId,
        @RequestBody LocationData locationData) {
        //locationData.setLocationId(locationId);
        //log.info("Updating location: {}", locationData);
        return credentialService.updateLocation(locationId, locationData);
    }

    public LocationData createLocation(LocationData locationData) {
        log.info("Creating location: {}", locationData);
        // Example usage of credentialService (replace with actual logic as needed)
        return credentialService.saveLocation(locationData);
        //return locationData;
    }

        public static Long getLocationId() {
        return null;
    }

    @GetMapping("/location")
    public List<LocationData> retrieveAllLocations() {
        log.info("Retrieving all locations");
        return credentialService.retrieveAllLocations();
    }

    @DeleteMapping("/location/{locationId}")
    public Map<String, String> deleteLocation(@PathVariable Long locationId) {
        log.info("Deleting location with ID={}.", locationId);
        credentialService.deleteLocation(locationId);
        
        return Map.of("message", "Location with ID=" + locationId + " was deleted successfully.");
    }

}